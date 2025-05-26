import java.util.HashMap;
/**
 * Computerspieler nach Modus 2
 * Der COmputer vefolgt eine Strategie in dem er nach Prioritäten Folgende 
 * möglichkeiten überprüft und ausführt
 * 1. Gewinnen wenn möglich 
 * 2. Sieg des Spielers verhindern
 * 3. Mitte (B2 / 5) besetzen 
 * 4. In die Ecke setzen
 *
 * @Tom Stegemann
 * @V3 2505
 */
public class Modus2 {
    // Instanzvariable
    private int[][] gewinnMöglichkeiten2;
    /**
     * Konstruktor
     */
    public Modus2() {
        // erstellung einer Matrix mit alles Gewinnmöglichkeiten
        this.gewinnMöglichkeiten2 = new int[][] {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9},
            {1, 4, 7}, {2, 5, 8}, {3, 6, 9},
            {1, 5, 9}, {3, 5, 7}
        };
    }

    /**
     * Eingabe des Computers nach Modus 2
     */
    public int eingabeDesComputers2(HashMap<Integer, Integer> spielfeld) {
        // 1. Gewinnen wenn möglich 
        int angriff = eingabeDesComputers2Angriff(spielfeld);
        if (angriff != 0){
            return angriff;
        }
        // 2. Sieg des Spielers verhindern
        int abwehr = eingabeDesComputers2Abwehr(spielfeld);
        if (abwehr != 0){
            return abwehr;
        }
        // 3. Mitte (B2 / 5) besetzen
        if (spielfeld.getOrDefault(5, 0) == 0) {
        return 5;
        }
        // 4. Eckenbesetzen
        else if (spielfeld.getOrDefault(1, 0) == 0) {
        return 1;
        }
        else if (spielfeld.getOrDefault(3, 0) == 0) {
        return 3;
        }
        else if (spielfeld.getOrDefault(7, 0) == 0) {
        return 7;
        }
        else if (spielfeld.getOrDefault(9, 0) == 0) {
        return 9;
        }
        else if (spielfeld.getOrDefault(2, 0) == 0) {
        return 2;
        }
        else if (spielfeld.getOrDefault(6, 0) == 0) {
        return 6;
        }
        else if (spielfeld.getOrDefault(8, 0) == 0) {
        return 8;
        }
        else if (spielfeld.getOrDefault(4, 0) == 0) {
        return 4;
        }
        else {
        return 0; // error catch
        }
    }

    /**
     * Überprüfung von "2. Sieg des Spielers verhindern".
     */
    private int eingabeDesComputers2Abwehr(HashMap<Integer, Integer> spielfeld) {
        // überprüfung der Matrix, mit der HashMap(spielfeld), ob der spieler zwei Felder in einer der Gewinnmöglichkeiten belegt hat
        for (int[] möglichkeit : gewinnMöglichkeiten2) {
            int a = möglichkeit[0], b = möglichkeit[1], c = möglichkeit[2];
            if (spielfeld.getOrDefault(a, 0) == 1 && spielfeld.getOrDefault(b, 0) == 1 && spielfeld.getOrDefault(c, 0) == 0){
                // zurückgeben des Feldes was noch frei ist
                return c;
            }
            if (spielfeld.getOrDefault(a, 0) == 1 && spielfeld.getOrDefault(c, 0) == 1 && spielfeld.getOrDefault(b, 0) == 0){ 
                // zurückgeben des Feldes was noch frei ist
                return b;
            }
            if (spielfeld.getOrDefault(b, 0) == 1 && spielfeld.getOrDefault(c, 0) == 1 && spielfeld.getOrDefault(a, 0) == 0){ 
                // zurückgeben des Feldes was noch frei ist
                return a;
            }
        }
        return 0;
    }

    /**
     * Überprüfung von "1. Gewinnen wenn möglich ".
     */
    private int eingabeDesComputers2Angriff(HashMap<Integer, Integer> spielfeld) {
        // überprüfung der Matrix, mit der Hashmap(spielfeld), ob der computer zwei Felder einer gewinnmöglichkeit belegt hat
        for (int[] kombi : gewinnMöglichkeiten2) {
            int a = kombi[0], b = kombi[1], c = kombi[2];
            if (spielfeld.getOrDefault(a, 0) == 2 && spielfeld.getOrDefault(b, 0) == 2 && spielfeld.getOrDefault(c, 0) == 0){
                // zurückgeben des Feldes was noch frei ist
                return c;
            }
            if (spielfeld.getOrDefault(a, 0) == 2 && spielfeld.getOrDefault(c, 0) == 2 && spielfeld.getOrDefault(b, 0) == 0){ 
                // zurückgeben des Feldes was noch frei ist
                return b;
            }
            if (spielfeld.getOrDefault(b, 0) == 2 && spielfeld.getOrDefault(c, 0) == 2 && spielfeld.getOrDefault(a, 0) == 0){ 
                // zurückgeben des Feldes was noch frei ist
                return a;
            }
        }
        return 0;
    }
}