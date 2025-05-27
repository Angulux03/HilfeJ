
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spiel {
    private int punkteSpieler;
    private int punkteComputer;
    private int runden;
    private int modus;
    private int aktuelleRunde;
    private Eingabe eingabe;
    private Runde runde;
    private Computer computer;
    public static int defaultRunden = 3;

    public Spiel() {
        this.eingabe = new Eingabe();
        this.punkteSpieler = 0;
        this.punkteComputer = 0;
        this.aktuelleRunde = 0;
    }

    public void spiel() {
        System.out.println("Willkommen bei Tic Tac Toe!");

        this.runden = eingabe.rundenEingabepruefung();
        if (runden == -1) runden = defaultRunden;

        this.modus = eingabe.modusEingabepruefung();
        if (modus == -1) modus = 1;

        this.computer = new Computer(modus);
        this.runde = new Runde(computer);

        while (aktuelleRunde < runden) {
            int gewinner = runde.starteRunde();

            if (gewinner == 1) {
                punktFuerSpieler();
            } else if (gewinner == 2) {
                punktFuerComputer();
            } else if (gewinner == 0) {
                System.out.println("Dieses Spiel endet unentschieden.");
            }
            else {
                System.out.println("Fehler");
            }
            aktuelleRunde++;
        }

        spielauswertung();
    }

    private void spielauswertung() {
    System.out.println("\nSpiel beendet!");

    if (punkteSpieler > punkteComputer) {
        System.out.println("Sie haben das Spiel mit " + punkteSpieler + " : " + punkteComputer + " gewonnen!");
    } else if (punkteSpieler < punkteComputer) {
        System.out.println("Der Computer hat das Spiel mit " + punkteComputer + " : " + punkteSpieler + " gewonnen!");
    } else {
        System.out.println("Das Spiel endet " + punkteSpieler + " : " + punkteComputer + " – Unentschieden!");
    }
    }  

    public void punktFuerSpieler() {
        punkteSpieler++;
    }

    public void punktFuerComputer() {
        punkteComputer++;
    }
}
