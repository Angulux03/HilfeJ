import java.util.Scanner;
/**
 * Einstellungen für das Spiel 
 * Stellt runden und Modus ein 
 * (int rundenAnzahl, int modus)
 *
 * @Johannes Spencker
 * @V1 1505
 */
public class Settings
{
    // instance variables - replace the example below with your own
    private int runden;
    private int modus;
    private Eingabe eingabe;
    /**
     * Konstruktor for Settings
     */
    public Settings(Eingabe eingabe) {
        this.eingabe = eingabe;
        runden = 0;
    }
    
    /**
     * Setter Runden 
     */
  
    // Diese Methode nutzt die Methode aus der Eingabe-Klasse
     //fordert spieler zu eingabe der Runden auf
        //scannt eingabe des Spielers
        //eingabe Prüfen (Eingabe.rundeECheck)
        //Rundenanzahl setzten
    public int setRunden() {
        this.runden = eingabe.rundenEingabepruefung(); // Scanner wird dort genutzt
        if (runden == -1) {
            return runden;
        }
        else {
            System.out.println("Rundenanzahl gesetzt: " + runden);
            return runden;
        }
    }

    public int getRunden() {
        return runden;
    }
    /**
     * Setter Modus 
     */
        //fordert spieler zu eingabe des Modus auf
        //scannt eingabe des Spielers
        //eingabe Prüfen (Eingabe.modusECheck)
        //Modus setzten
    public int setModus() {
        this.modus = eingabe.modusEingabepruefung();  // Scanner wird dort genutzt
        if (modus == -1) {
            return modus;
        }
        else {
            System.out.println("Ausgewählter Modus: " + modus);
            return modus; 
        }
        
    }

    public int getModus() {
        return modus;
    }
    }

