import java.util.HashMap;

/**
 * Durchführen einer Runde
 * 
 * @author Philip
 * @version V3 2025
 */
public class Runde {
    private HashMap<Integer, Integer> spielfeld;
    private Computer computer;
    private Spielerin spielerin;
    private SpielfeldAusgabe spielfeldAusgabe;
    private int beginner;

    public Runde(Computer computer) {
        this.computer = computer;
        this.spielfeld = new HashMap<>();
        this.spielfeldAusgabe = new SpielfeldAusgabe(spielfeld);
        this.spielerin = new Spielerin(spielfeldAusgabe);
        this.beginner = 1;
    }

    public int starteRunde() {
        vorbereiten();

        while (true) {
            if (spielfeld.size() == 9) {
                System.out.println("Alle Felder sind belegt. Unentschieden.");
                wechsleBeginner();
                return 0;
            }
            
            if (beginner == 1) {
                if (spielerinnenZug()) return 1;
                if (computerZug()) return 2;
            } else {
                if (computerZug()) return 2;
                if (spielerinnenZug()) return 1;
            }

        }
    }
    private void vorbereiten() {
        spielfeld.clear();
        spielfeldAusgabe.leeresSpielfeld();
    }

    private boolean spielerinnenZug() {
    int feld = spielerin.gueltigeEingabe(spielfeld);
    spielfeld.put(feld, 1);
    spielfeldAusgabe.ausgabeSpielfeld();

    if (rundeAuswerten(1)) {
        System.out.println("Sie haben diese Runde gewonnen!");
        wechsleBeginner();
        return true;
    }
    
    return false;
    }

    private boolean computerZug() {
    int feld = computer.eingabeDesComputers(spielfeld);
    spielfeld.put(feld, 2);
    System.out.println("Der Computer hat Feld " + feld + " gewählt.");
    spielfeldAusgabe.ausgabeSpielfeld();

    if (rundeAuswerten(2)) {
        System.out.println("Der Computer hat diese Runde gewonnen!");
        wechsleBeginner();
        return true;
    }

    return false;
    }
    

    private void wechsleBeginner() {
        if (beginner == 1) {
            beginner = 2;
        } else {
            beginner = 1;
        }
    }

    private boolean rundeAuswerten(int spieler) {
        int[][] gewinnMöglichkeiten = {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
            {1, 4, 7}, {2, 5, 8}, {3, 6, 9},
            {1, 5, 9}, {3, 5, 7}
        };

        for (int[] kombi : gewinnMöglichkeiten) {
            if (spielfeld.getOrDefault(kombi[0], 0) == spieler &&
                spielfeld.getOrDefault(kombi[1], 0) == spieler &&
                spielfeld.getOrDefault(kombi[2], 0) == spieler) {
                return true;
            }
        }
        return false;
    }
}