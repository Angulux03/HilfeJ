import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse Computer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Computer {
    private int modus;

    // Mach das aus Zeile 20 hier hin und dann final, da es sich nicht ändert
    private int[][] gewinnMoeglichkeiten;

    public Computer(int modus) {
        this.modus = modus; // falls ihr schon enums verwendet, nutzt hier ein Enum 

        // Gewinnkombinationen für Modus 2
        gewinnMoeglichkeiten = new int[][] {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
            {1, 4, 7}, {2, 5, 8}, {3, 6, 9},
            {1, 5, 9}, {3, 5, 7}
        };
    }

    public int eingabeDesComputers(HashMap<Integer, Integer> spielfeld) {
        if (modus == 1) {
            return zufallsZug(spielfeld);
        } else {
            return strategieZug(spielfeld);
        } // falls ihr inline ifs verwendet kennt nutzt es
    }

    private int zufallsZug(HashMap<Integer, Integer> spielfeld) {
        ArrayList<Integer> freieFelder = new ArrayList<>(); // du könntest eine Feldklasse erstellen, die das Spielfeld kapselt
        for (int feld = 1; feld <= 9; feld++) {
            if (!spielfeld.containsKey(feld)) {
                freieFelder.add(feld);
            }
        }

        if (!freieFelder.isEmpty()) {
            Random rand = new Random();
            return freieFelder.get(rand.nextInt(freieFelder.size()));
        }

        return -1;
    }

    private int strategieZug(HashMap<Integer, Integer> spielfeld) {
        // 1. Gewinnen
        int feld = findeZug(spielfeld, 2);
        if (feld != 0) return feld;

        // 2. Blockieren
        feld = findeZug(spielfeld, 1);
        if (feld != 0) return feld;

        // 3. Mitte
        if (spielfeld.getOrDefault(5, 0) == 0) return 5;

        // 4. Ecken und Rest
        int[] bevorzugt = {1, 3, 7, 9, 2, 4, 6, 8};
        for (int pos : bevorzugt) { // wenn du überall lange variablen verwendest, dann auch für pos
            if (spielfeld.getOrDefault(pos, 0) == 0) return pos;
        }

        return -1;
    }

    private int findeZug(HashMap<Integer, Integer> spielfeld, int spieler) {
        for (int[] kombi : gewinnMoeglichkeiten) {
            int a = kombi[0], b = kombi[1], c = kombi[2];
            if (spielfeld.getOrDefault(a, 0) == spieler && spielfeld.getOrDefault(b, 0) == spieler && spielfeld.getOrDefault(c, 0) == 0)
                return c;
            if (spielfeld.getOrDefault(a, 0) == spieler && spielfeld.getOrDefault(c, 0) == spieler && spielfeld.getOrDefault(b, 0) == 0)
                return b;
            if (spielfeld.getOrDefault(b, 0) == spieler && spielfeld.getOrDefault(c, 0) == spieler && spielfeld.getOrDefault(a, 0) == 0)
                return a;
        } // use if else, variables for repetition
        return 0;
    }
}
