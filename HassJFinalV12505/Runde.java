import java.util.HashMap;
/**
 * Durchführen einer Runde
 *
 * @Philip Hoppe / Tom Stegemann
 * @V2 1605
 */
public class Runde
{
    // Instanzvariabeln
    public HashMap<Integer, Integer> spielfeld;
    private Spiel spiel;
    private Modus2 modus2;
    private Modus1 modus1;
    private Spielerin spielerin;
    private SpielfeldAusgabe spielfeldAusgabe;
    private boolean x;
    private int beginner;
    /**
     * Konstruktor
     */
    public Runde(Spiel spiel)
    {
        this.spiel = spiel;
        // erzeuge die Hashmap (wer wo welches feld belegt)
        spielfeld = new HashMap<Integer, Integer>();
        // Initialisierung des restes der Instanzvariabeln
        x = false;
        beginner = 1;
        modus2 = new Modus2();
        modus1 = new Modus1();
        this.spiel = spiel;
        spielfeldAusgabe = new SpielfeldAusgabe(spielfeld);
        spielerin = new Spielerin(spielfeldAusgabe);
    }

    public HashMap<Integer, Integer> getSpielfeld(){
        return spielfeld;

    }

    /**
     * Runde nach Modus 1
     */
    public void starteRunde1()
    {
        // reset der HashMap
        spielfeld.clear();
        // erzeuge eine (Spielfeld.leeresSpielfeld)
        spielfeldAusgabe.leeresSpielfeld();
        // starte die Methode Runde
        runde1();
    }

    /**
     * Runde nach Modus 2
     */
    public void starteRunde2()
    {
        // reset der HashMap
        spielfeld.clear();
        // erzeuge eine (Spielfeld.leeresSpielfeld)
        spielfeldAusgabe.leeresSpielfeld();
        // starte die Methode Runde
        runde2();
    }

    private void runde2(){
        x = true;
        if (beginner == 1) {
            while (x == true) {
                // eingabe anfordern und eingabe verarbeiten (Spielerin.eingabeSpielerin)
                int gewaehltesFeldSpielerin = -1;
                // Solange wiederholen, bis ein freies Feld gewählt wurde
                while (true) {
                    gewaehltesFeldSpielerin = spielerin.eingabeSpielerin();
                    if (spielfeld.containsKey(gewaehltesFeldSpielerin)) {
                        System.out.println("Dieses Feld ist bereits belegt.");
                    } 
                    else {
                        break; // Feld ist frei → aus der Schleife raus
                    }
                }
                // speichere die eingabe der Spielerin in der Hashmap
                spielfeld.put(gewaehltesFeldSpielerin, 1);
                // gebe das Spielfeld aus
                spielfeldAusgabe.ausgabeSpielfeld();
                // prüfe einen gewinner (Gewinner.rundeAuswerten)
                if (rundeAuswerten(spielfeld, 1) == true){
                    System.out.println("Sie haben diese Runde Gewonnen");
                    spiel.punktFuerSpieler();
                    //runde beenden
                    beginner = 2;
                    x = false;
                    break;
                }
                // Unentschieden überprüfen
                if (spielfeld.size() == 9) {
                    System.out.println (" Alle Felder sind belegt, es ist eine Unentschieden");
                    beginner = 2;
                    x = false;
                    break;
                }
                // führe eine Computer eingabe aus (ModusX.eingabeDesComputersX)
                int gewaehltesFeldComputer = modus2.eingabeDesComputers2(spielfeld);
                // speichere die eingabe des Computers in der Hashmap
                spielfeld.put(gewaehltesFeldComputer, 2);
                System.out.println("Der Computer hat : "+gewaehltesFeldComputer + " gewählt.");
                // gebe das Spielfeld aus
                spielfeldAusgabe.ausgabeSpielfeld();
                // prüfe einen gewinner (Gewinner.rundeAuswerten)
                if (rundeAuswerten(spielfeld, 2) == true){
                    System.out.println("Der Computer hat diese Runde Gewonnen");
                    spiel.punktFuerComputer();
                    //runde beenden
                    beginner = 2;
                    x = false;
                    break;
                } 
                // Unentschieden überprüfen 
                if (spielfeld.size() == 9) {
                    System.out.println (" Alle Felder sind belegt, es ist eine Unentschieden");
                    beginner = 2;
                    x = false;
                    break;
                }
            }
        }
        else if (beginner == 2) {
            while (x == true) {
                // führe eine Computer eingabe aus (ModusX.eingabeDesComputersX)
                int gewaehltesFeldComputer = modus2.eingabeDesComputers2(spielfeld);
                // speichere die eingabe des Computers in der Hashmap
                spielfeld.put(gewaehltesFeldComputer, 2);
                System.out.println("Der Computer hat : "+gewaehltesFeldComputer + " gewählt.");
                // gebe das Spielfeld aus
                spielfeldAusgabe.ausgabeSpielfeld();
                // prüfe einen gewinner (Gewinner.rundeAuswerten)
                if (rundeAuswerten(spielfeld, 2) == true){
                    System.out.println("Der Computer hat diese Runde Gewonnen");
                    spiel.punktFuerComputer();
                    //runde beenden
                    beginner = 1;
                    x = false;
                    break;
                }
                // unentschieden Überprüfen
                if (spielfeld.size() == 9) {
                    System.out.println (" Alle Felder sind belegt, es ist eine Unentschieden");
                    beginner = 2;
                    x = false;
                    break;
                }
                // eingabe anfordern und eingabe verarbeiten (Spielerin.eingabeSpielerin)
                int gewaehltesFeldSpielerin = -1;
                // Solange wiederholen, bis ein freies Feld gewählt wurde
                while (true) {
                    gewaehltesFeldSpielerin = spielerin.eingabeSpielerin();
                    if (spielfeld.containsKey(gewaehltesFeldSpielerin)) {
                        System.out.println("Dieses Feld ist bereits belegt.");
                    } 
                    else {
                        break; // Feld ist frei → aus der Schleife raus
                    }
                }
                // speichere die eingabe der Spielerin in der Hashmap
                spielfeld.put(gewaehltesFeldSpielerin, 1);
                // gebe das Spielfeld aus
                spielfeldAusgabe.ausgabeSpielfeld();
                // prüfe einen gewinner (Gewinner.rundeAuswerten)
                if (rundeAuswerten(spielfeld, 1) == true){
                    System.out.println("Sie haben diese Runde Gewonnen");
                    spiel.punktFuerSpieler();
                    //runde beenden
                    beginner = 1;
                    x = false;
                    break;
                }
                //unentschieden überprüfen 
                if (spielfeld.size() == 9) {
                    System.out.println (" Alle Felder sind belegt, es ist eine Unentschieden");
                    beginner = 2;
                    x = false;
                    break;
                }
            }
        }
        // gebe den Rundengewinner aus (rückmeldung an die Hasmap in Main mit den Punkten)
    }

    private void runde1(){
        x = true;
        if (beginner == 1) {
            while (x == true) {
                // eingabe anfordern und eingabe verarbeiten (Spielerin.eingabeSpielerin)
                int gewaehltesFeldSpielerin = -1;
                // Solange wiederholen, bis ein freies Feld gewählt wurde
                while (true) {
                    gewaehltesFeldSpielerin = spielerin.eingabeSpielerin();
                    if (spielfeld.containsKey(gewaehltesFeldSpielerin)) {
                        System.out.println("Dieses Feld ist bereits belegt.");
                    } 
                    else {
                        break; // Feld ist frei → aus der Schleife raus
                    }
                }
                // speichere die eingabe der Spielerin in der Hashmap
                spielfeld.put(gewaehltesFeldSpielerin, 1);
                // gebe das Spielfeld aus
                spielfeldAusgabe.ausgabeSpielfeld();
                // prüfe einen gewinner (Gewinner.rundeAuswerten)
                if (rundeAuswerten(spielfeld, 1) == true){
                    System.out.println("Sie haben diese Runde Gewonnen");
                    spiel.punktFuerSpieler();
                    //runde beenden
                    beginner = 2;
                    x = false;
                    break;
                }
                // unentschieden prüfen
                if (spielfeld.size() == 9) {
                    System.out.println (" Alle Felder sind belegt, es ist eine Unentschieden");
                    beginner = 2;
                    x = false;
                    break;
                }
                // führe eine Computer eingabe aus (ModusX.eingabeDesComputersX)
                int gewaehltesFeldComputer = modus1.eingabeDesComputers1(spielfeld);
                // speichere die eingabe des Computers in der Hashmap
                spielfeld.put(gewaehltesFeldComputer, 2);
                System.out.println("Der Computer hat : "+gewaehltesFeldComputer + " gewählt.");
                // gebe das Spielfeld aus
                spielfeldAusgabe.ausgabeSpielfeld();
                // prüfe einen gewinner (Gewinner.rundeAuswerten)
                if (rundeAuswerten(spielfeld, 2) == true){
                    System.out.println("Der Computer hat diese Runde Gewonnen");
                    spiel.punktFuerComputer();
                    //runde beenden
                    beginner = 2;
                    x = false;
                    break;
                }
                // Unentschieden prüfen
                if (spielfeld.size() == 9) {
                    System.out.println (" Alle Felder sind belegt, es ist eine Unentschieden");
                    beginner = 2;
                    x = false;
                    break;
                }
            }
        }
        else if (beginner == 2){
            while (x == true) {
                // führe eine Computer eingabe aus (ModusX.eingabeDesComputersX)
                int gewaehltesFeldComputer = modus1.eingabeDesComputers1(spielfeld);
                // speichere die eingabe des Computers in der Hashmap
                spielfeld.put(gewaehltesFeldComputer, 2);
                System.out.println("Der Computer hat : "+gewaehltesFeldComputer + " gewählt.");
                // gebe das Spielfeld aus
                spielfeldAusgabe.ausgabeSpielfeld();
                // prüfe einen gewinner (Gewinner.rundeAuswerten)
                if (rundeAuswerten(spielfeld, 2) == true){
                    System.out.println("Der Computer hat diese Runde Gewonnen");
                    spiel.punktFuerComputer();
                    //runde beenden
                    beginner = 1;
                    x = false;
                    break;
                }
                // Unentschieden überprüfen
                if (spielfeld.size() == 9) {
                    System.out.println (" Alle Felder sind belegt, es ist eine Unentschieden");
                    beginner = 2;
                    x = false;
                    break;
                }
                int gewaehltesFeldSpielerin = -1;
                // Solange wiederholen, bis ein freies Feld gewählt wurde
                while (true) {
                    gewaehltesFeldSpielerin = spielerin.eingabeSpielerin();
                    if (spielfeld.containsKey(gewaehltesFeldSpielerin)) {
                        System.out.println("Dieses Feld ist bereits belegt.");
                    } 
                    else {
                        break; // Feld ist frei → aus der Schleife raus
                    }
                }
                // speichere die eingabe der Spielerin in der Hashmap
                spielfeld.put(gewaehltesFeldSpielerin, 1);
                // gebe das Spielfeld aus
                spielfeldAusgabe.ausgabeSpielfeld();
                // prüfe einen gewinner (Gewinner.rundeAuswerten)
                if (rundeAuswerten(spielfeld, 1) == true){
                    System.out.println("Sie haben diese Runde Gewonnen");
                    spiel.punktFuerSpieler();
                    //runde beenden
                    beginner = 1;
                    x = false;
                    break;
                }
                // Unentschieden überprüfen 
                if (spielfeld.size() == 9) {
                    System.out.println (" Alle Felder sind belegt, es ist eine Unentschieden");
                    beginner = 2;
                    x = false;
                    break;
                }
            }
        }
        // gebe den Rundengewinner aus (rückmeldung an die Hasmap in Main mit den Punkten)
    }
    /**
     * Prüfung ob jemand gewonnen hat und
     * Auswertung des Rundengewinners 
     */
    public boolean rundeAuswerten(HashMap<Integer, Integer> spielfeld, int spieler)
    {
        // erstelle eine Matrix mit gewinnkombinationen
        int[][] gewinnMöglichkeiten = {
        {1, 2, 3}, 
        {4, 5, 6}, 
        {7, 8, 9}, 
        {1, 4, 7}, 
        {2, 5, 8}, 
        {3, 6, 9}, 
        {1, 5, 9}, 
        {3, 5, 7} };
        // prüfe ob jemand gewonnen hat
        for (int[] möglichkeit : gewinnMöglichkeiten) {
            if (spielfeld.getOrDefault(möglichkeit[0], 0) == spieler
             && spielfeld.getOrDefault(möglichkeit[1], 0) == spieler
             && spielfeld.getOrDefault(möglichkeit[2], 0) == spieler){
                return true;
            }
        }
        // gewinner festlegen und returnen
        // System.out.printf(ausgabe des gewinners der Runde)
        // erhöhe die Punktzahl
        return false;
    }
}