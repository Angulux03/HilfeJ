import java.util.Scanner;
/**
 * Prüfung der Eingabe der Spielerin
 *
 * @Johannes Spencker
 * @V1 1505
 */
public class Eingabe {
    private Scanner scanner;

    public Eingabe() {
        scanner = new Scanner(System.in);
    }
    
    /**
     *  Ausgabe des Hilfetextes
     */
    public void hilfetextAnzeigen() { // Welche Java Version nutzt ihr? Falls ihr Java 11 oder höher nutzt, könnt ihr auch Textblöcke verwenden
    System.out.println("##############################################################################################\n" + 
                       "Spielziel:\n" + 
                       "Tic Tac Toe ist ein einfaches Strategiespiel für zwei Spieler.\n" +
                       "Ziel ist es, drei eigene Symbole (X oder O) in einer horizontalen, vertikalen\n" +
                       "oder diagonalen Linie auf einem 3×3-Spielfeld zu platzieren.\n" +
                       "##############################################################################################\n" +
                       "Symbole:\n" +
                       "Die Spielerin spielt mit X.\n" +
                       "Der Computer spielt mit O.\n" +
                       "##############################################################################################\n" +
                       "Spielverlauf:\n" +
                       "Das Spiel beginnt mit einer leeren 3×3-Tabelle.\n" +
                       "Die Spielerin und der Computer setzen abwechselnd ihre Symbole auf freie Felder.\n" +
                       "Eine Runde endet, wenn:\n" +
                       "- ein Spieler drei gleiche Symbole in einer Reihe hat (Sieg), oder\n" +
                       "- alle neun Felder belegt sind (Unentschieden).\n" +
                       "Danach beginnt die nächste Runde. Der Startspieler wechselt jede Runde.\n" +
                       "##############################################################################################\n" +
                       "Steuerung:\n" +
                       "Die Spielerin wählt das Feld durch Eingabe der Zeile und Spalte, z. B.: 1 2\n" +
                       "für die Mitte oben rechts. (Zeilen und Spalten beginnen bei 0.)\n" +
                       "Zum Beenden des Spiels kann vor Beginn oder zwischen Runden der Befehl exit eingegeben werden.\n" +
                       "Die Rundenzahl wird zu Beginn des Spiels eingegeben.\n" +
                       "Wird keine gültige Zahl angegeben, wird automatisch mit 3 Runden gespielt.\n" +
                       "##############################################################################################\n" +
                       "Spielmodi:\n" +
                       "Beim Start kann zwischen zwei Modi gewählt werden:\n" + 
                       "Modus 1 – Zufällig: Der Computer wählt ein freies Feld per Zufall.\n" +
                       "Modus 2 – Strategisch: Der Computer versucht, zu gewinnen\n" +
                       "oder einen drohenden Sieg der Spielerin zu blockieren.\n" +
                       "##############################################################################################\n" +
                       "Tipp:\n" +
                       "Gib jederzeit hilfe oder ? ein, um diese Anleitung erneut anzuzeigen.\n" +
                       "\n" +
                       "Viel Spaß! ;D\n" +
                       "##############################################################################################\n");
    }
    
    /**
     * Prüfung ob die Anzahl der Runden korrekt angegeben wurde
     */
     public int rundenEingabepruefung() { // warum machst du aus ü ue?
        while (true) {
            System.out.print("Wie viele Runden sollen gespielt werden? ");
            String eingabe = scanner.nextLine();

            if (eingabe.equals("")) {
                return Spiel.defaultRunden;
            } else if (istHilfe(eingabe)) {
                hilfetextAnzeigen();
            } else if (istEnde(eingabe)) {
                beenden();
            } else {
                try {
                    int zahl = Integer.parseInt(eingabe);
                    if (zahl > 0) return zahl; 
                    else System.out.println("Bitte eine positive Zahl eingeben.");
                } catch (Exception e) { // Warum catchst du Exception? Besser NumberFormatException
                    System.out.println("Ungültige Eingabe. Bitte eine gültige Zahl eingeben.");
                }
            }
        }
    }

    /**
     * Fragt den Spielmodus ab (1 oder 2)
     */
    public int modusEingabepruefung() {
        while (true) {
            System.out.print("Wähle Spielmodus (1 = Zufall, 2 = Strategie): ");
            String eingabe = scanner.nextLine();

            if (istHilfe(eingabe)) {
                hilfetextAnzeigen();
            } else if (istEnde(eingabe)) {
                beenden();
            } else {
                try {
                    int modus = Integer.parseInt(eingabe);
                    if (modus == 1 || modus == 2) return modus;
                    else System.out.println("Ungültig – bitte 1 oder 2 eingeben.");
                } catch (Exception e) {
                    System.out.println("Ungültige Eingabe. Bitte 1 oder 2 eingeben.");
                }
            }
        }
    }
    public Scanner getScanner() {
        return scanner;
    }
    /**
     * Prüft ob ein Feldbezeichner gültig ist
     */
    public boolean feldEingabepruefung(String eingabe) {
        return eingabe.equalsIgnoreCase("A1") || eingabe.equalsIgnoreCase("A2") || eingabe.equalsIgnoreCase("A3") ||
               eingabe.equalsIgnoreCase("B1") || eingabe.equalsIgnoreCase("B2") || eingabe.equalsIgnoreCase("B3") ||
               eingabe.equalsIgnoreCase("C1") || eingabe.equalsIgnoreCase("C2") || eingabe.equalsIgnoreCase("C3"); // du könntest es kürzen mit eingabe.matches("(?i)[ABC][123]") oder nem ArrayList<String> für die Feldbezeichner und das mit ner schleife erstellen
    }

    /**
     * Prüft ob Eingabe als Hilfe erkannt wird
     */
    private boolean istHilfe(String text) {
        return text.equalsIgnoreCase("hilfe") || text.equals("?") || text.equalsIgnoreCase("help"); // du könntest es kürzen mit text.matches("(?i)hilfe|\\?|help") oder nem ArrayList<String> für die Hilfewörter 
    }

    /**
     * Prüft ob Eingabe als Spielende erkannt wird
     */
    private boolean istEnde(String text) {
        return text.equalsIgnoreCase("ende") || text.equalsIgnoreCase("end"); // wie oben
    }

    /**
     * Spiel beenden
     */
    private void beenden() {
        System.out.println("Spiel wird beendet.");
        System.exit(0);
    }
}
