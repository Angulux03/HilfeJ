import java.util.Scanner;
/**
 * Prüfung der Eingabe der Spielerin
 *
 * @Johannes Spencker
 * @V1 1505
 */
public class Eingabe
{
    private Scanner scanner;
    
    /**
     * Konstruktor for Eingabe
     */
    public Eingabe() {
        scanner = new Scanner(System.in);
    }
    
    /**
     *  Ausgabe des Hilfetextes
     */
    public void hilfetextAnzeigen() {
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
     public int rundenEingabepruefung() {
        while (true) {
            System.out.print("Wie viele Runden sollen gespielt werden? ");
            String eingabe = scanner.nextLine();
            if (eingabe.equals("")) {
                return Spiel.defaultRunden;
            }
            //hilfe abfrage
            else if (eingabe.equals("hilfe") || eingabe.equals("Hilfe") || eingabe.equals("HILFE") ||
                eingabe.equals("help") || eingabe.equals("Help") || eingabe.equals("HELP") ||
                eingabe.equals("?")){
                hilfetextAnzeigen();
                break;
            }
            // Spiel beenden
            else if(eingabe.equals("ende") || eingabe.equals("Ende") || eingabe.equals("ENDE") ||
                    eingabe.equals("end") || eingabe.equals("END")) {
                System.out.println("Spiel wird beendet.");
                System.exit(0);
                    }
            else {
                try {
                    int zahl = Integer.parseInt(eingabe);
                    if (zahl > 0){
                        return zahl;
                    }
                    else{
                    System.out.println("Das war keine gültige Zahl. Bitte geben Sie eine gültige Zahl ein.");
                    }
                     //Zahl zurückgeben und Methode beenden
                } catch (Exception e) {
                    System.out.println("Das war keine gültige Zahl. Bitte geben Sie eine gültige Zahl ein.");
                }
            }
        }
        // fehlerwert der die Eingabeprüfung erneut startet
        return -1;
    }
    
    /**
     * Prüfung ob der Modus richtig eingegeben wurde
     */
        // Prüfe die Eingabe des Modus
         public int modusEingabepruefung() {
        while (true) {
            System.out.print("Wähle einen Spielmodus (1 = Zufall, 2 = Strategie): ");
            String eingabe = scanner.nextLine();
            if (eingabe.equals("hilfe") || eingabe.equals("Hilfe") || eingabe.equals("HILFE") ||
                eingabe.equals("help") || eingabe.equals("Help") || eingabe.equals("HELP") ||
                eingabe.equals("?")){
                hilfetextAnzeigen();
                break;
            }
            // Spiel beenden
            else if(eingabe.equals("ende") || eingabe.equals("Ende") || eingabe.equals("ENDE") ||
                    eingabe.equals("end") || eingabe.equals("END")) {
                System.out.println("Spiel wird beendet.");
                System.exit(0);
                    }
            else {
                try {
                    int modus = Integer.parseInt(eingabe);  // Eingabe in Zahl umwandeln
                    if (modus == 1 || modus == 2) {
                        return modus;  // gültig → zurückgeben
                    } else {
                        System.out.println("Es gibt modus 1 oder 2");
                    }
    
                } catch (Exception e) {
                    System.out.println("Ungültige Eingabe. Bitte gib 1 oder 2 ein.");
                }
            }


        }
        // exceptionwert beim hilfe text
        return -1;
    }
    
    /**
     * Prüfung ob das Feld richtig ausgewählt wurde
     */
    public boolean feldEingabepruefung(String eingabe) {
        // Prüfe die Eingabe des Felds
        return eingabe.equals("A1") || eingabe.equals("a1") || eingabe.equals("A2") || eingabe.equals("a2") ||
               eingabe.equals("A3") || eingabe.equals("a3") || eingabe.equals("B1") || eingabe.equals("b1") ||
               eingabe.equals("B2") || eingabe.equals("b2") || eingabe.equals("B3") || eingabe.equals("b3") ||
               eingabe.equals("C1") || eingabe.equals("c1") || eingabe.equals("C2") || eingabe.equals("c2") || 
               eingabe.equals("C3") || eingabe.equals("c3");
        }
}
