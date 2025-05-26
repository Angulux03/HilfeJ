
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spiel
{
    // instance variables - replace the example below with your own
    private int x;
    private int i;
    private Settings settings;
    private int runden;
    private int modus;
    private Runde runde;
    private int punkteSpieler;
    private int punkteComputer;
    public static int defaultRunden;
    /**
     * Constructor for objects of class Main
     */
    public Spiel()
    {
        // initialise instance variables
        Eingabe eingabe = new Eingabe();
        runde = new Runde(this);
        this.settings = new Settings(eingabe);
        runden = 0;
        modus = 0;
        i = 0;
        punkteSpieler = 0;
        punkteComputer = 0;
        defaultRunden = 3;
    }
    /**
     * Spiel
     */
    public void spiel()
    {
        // put your code here
        System.out.println("Willkommen");
        settingsRunden();
        settingsModus();
        while (i < runden){
            if (modus == 1) {
                runde.starteRunde1();
                i++;
            }
            else if (modus == 2) {
                runde.starteRunde2();
                i++;
            }
        }
        if (punkteSpieler > punkteComputer) {
            System.out.println("Sie haben dieses Spiel mit "+ punkteSpieler +":"+punkteComputer+" gewonnen!");
        }
        else if (punkteSpieler < punkteComputer) {
            System.out.println("Sie haben dieses Spiel mit "+ punkteSpieler +":"+punkteComputer+" gewonnen!");
        }
        else if (punkteSpieler == punkteComputer) {
            System.out.println("Dieses Spiel endete "+ punkteSpieler +":"+punkteComputer+" -> Unentschieden!");
        }
        
        System.out.println("vorbei");
        
    }
    /**
     * Settings festlegen
     */
    private void settingsRunden()
    {
        // put your code here
        runden = settings.setRunden();
        if (runden == -1) {
            runden = settings.setRunden();
        }
        //wenn enter dann 3 Runden 
    }
    private void settingsModus()
    {
        // put your code here
        modus = settings.setModus(); 
        if (modus == -1) {
            modus = settings.setModus();
        }
    }
    public void punktFuerComputer(){
        punkteComputer++;
    }
    public void punktFuerSpieler(){
        punkteSpieler++;
    }
}
