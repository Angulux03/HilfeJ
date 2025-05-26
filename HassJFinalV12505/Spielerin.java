import java.util.Scanner;
/**
 * Eingabe der Spielerin 
 *
 * @xxx
 * @V1 1505
 */
public class Spielerin
{
    // instance variables - replace the example below with your own
    private Scanner scanner;
    private Eingabe eingabe;
    private SpielfeldAusgabe spielfeldAusgabe;
    /**
     * Konstruktor für Spielerin
     */
    public Spielerin(SpielfeldAusgabe spielfeldAusgabe)
    {
        scanner = new Scanner(System.in);
        eingabe = new Eingabe();
        this.spielfeldAusgabe = spielfeldAusgabe;
    }

    /**
     * Eingabe der Spielerin
     */
    public int eingabeSpielerin() 
    {
        while (true) {
            // Spielerin um Eingabe bitten
            System.out.println("Bitte wählen sie ein Feld.");
            // Scanne die Eingabe der Spielerin
            String eingabeString = scanner.nextLine();
            //Hilfe anzeigen
            if (eingabeString.equals("hilfe") || eingabeString.equals("Hilfe") || eingabeString.equals("HILFE") ||
                eingabeString.equals("help") || eingabeString.equals("Help") || eingabeString.equals("HELP") ||
                eingabeString.equals("?")){
                    eingabe.hilfetextAnzeigen();
                    System.out.println("Weiter gehts!");
                    spielfeldAusgabe.ausgabeSpielfeld();
            }
            
            // Spiel beenden
            else if(eingabeString.equals("ende") || eingabeString.equals("Ende") || eingabeString.equals("ENDE") ||
                    eingabeString.equals("end") || eingabeString.equals("END")) {
                        System.out.println("Spiel wird beendet.");
                        System.exit(0);
                    }
            // Gültiges Feld prüfen und zurückgeben
            else if (eingabe.feldEingabepruefung(eingabeString)) {
                if (eingabeString.equals("A1") || eingabeString.equals("a1")) {
                    return 1;
                }
                    else if (eingabeString.equals("A2") || eingabeString.equals("a2")) {
                        return 2;
                }
                    else if (eingabeString.equals("A3") || eingabeString.equals("a3")) {
                        return 3;
                }
                    else if (eingabeString.equals("B1") || eingabeString.equals("b1")) {
                        return 4;
                }
                    else if (eingabeString.equals("B2") || eingabeString.equals("b2")) {
                        return 5;
                }
                    else if (eingabeString.equals("B3") || eingabeString.equals("b3")) {
                        return 6;
                }
                    else if (eingabeString.equals("C1") || eingabeString.equals("c1")) {
                        return 7;
                }
                    else if (eingabeString.equals("C2") || eingabeString.equals("c2")) {
                        return 8;
                }
                    else if (eingabeString.equals("C3") || eingabeString.equals("c3")) {
                        return 9;
                }
                    else{
                        return 0;
                }
            }
            // Ungueltige Eingabe
            else {
                System.out.println("Ihre Eingabe entpricht nicht der erwarteten Eingabe. \n \n" +
                "Bitte geben sie ein Feld mit dem Großen Anfangsbuchstaben (Zeile) und der Zahl (Spalte) ein. \n \n" +
                "Beispiel Feld in Zeile A und Spalte 1 --> Eingabe: A1\n \n"+
                "Bei weiteren Fragen, geben sie Hilfe ein");
                }
            // Wiederholte Eingabe
        }
    }
}
