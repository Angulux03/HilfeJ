import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Computerspieler nach Modus 1
 * Zufälliges freies Feld wählen
 *
 * @Tom Stegemann
 * @V1 1505
 */
public class Modus1
{
    /**
     * Konstruktor
     */
    public Modus1()
    {
        // parameterlos
    }

    /**
     * Eingabe Computer nach Modus 1
     */
    public int eingabeDesComputers1(HashMap<Integer, Integer> spielfeld){
        // Erstellen einer Arraylist mit den belegten Feldern
        ArrayList<Integer> belegteFelder = new ArrayList<>();
        // übertragen der Belegten Felder aus der HashMap in die Arraylist
        for (Integer key: spielfeld.keySet()){
            if (key != null){
                belegteFelder.add(key);
            }
            else {
                //error catch
                System.out.println("Fehler bei" + key);
            }
        }
        // Liste mit freien Feldern erstellen
        ArrayList<Integer> freieFelder = new ArrayList<>();
        // Eine Arraylist mit allen Freien feldern erstellen
        for (int feld = 1;feld <= 9; feld++) {
            if (!belegteFelder.contains(feld)) {
                freieFelder.add(feld);
            }
        }
        // Wählen einer zufälligen Zahl aus der Liste der freien Feldern
        if (!freieFelder.isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(freieFelder.size());
            return freieFelder.get(index);
        } 
        else {
            return -1; // kein freies Feld mehr
        }
    }
}

