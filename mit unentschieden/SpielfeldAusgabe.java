import java.util.HashMap;
/**
 * Gibt das Spielfeld in der Console aus
 *
 * @xxx
 * @V1 1505
 */
public class SpielfeldAusgabe
{
    private HashMap<Integer, Integer> spielfeld;
    /**
     * Constructor for objects of class Spielfeld
     */
    public SpielfeldAusgabe(HashMap<Integer, Integer> spielfeld){
    this.spielfeld = spielfeld;
    }

    /**
     * Leeres Spielfeld Ausgeben
     */
    public void leeresSpielfeld(){
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +  
                           "  Hier muss noch Spielstand hin  \n" +
                           "                                 \n" +
                           "       1     2     3             \n" + 
                           "    ___________________          \n" +
                           "    |     |     |     |          \n" +
                           " A  |  -  |  -  |  -  |          \n" +
                           "    |_____|_____|_____|          \n" +
                           "    |     |     |     |          \n" +
                           " B  |  -  |  -  |  -  |          \n" +
                           "    |_____|_____|_____|          \n" +
                           "    |     |     |     |          \n" +
                           " C  |  -  |  -  |  -  |          \n" +
                           "    |_____|_____|_____|          \n" +
                           "                                 \n");
             
                                            
        // System.out.println("Spielfeld \n Spielfeld zeile2")
    }
    
    /**
     * Aktuelles Spielfeld Ausgeben
     */
    public void ausgabeSpielfeld(){
        String a1 = " ";
        if(spielfeld.getOrDefault((1),0) == 1) {
            a1 = "X";
        }
        else if(spielfeld.getOrDefault((1),0) == 2){
            a1 = "O";
        }
        else{
            a1 = " ";
        }

        String a2 = " ";
        if(spielfeld.getOrDefault((2),0) == 1) {
            a2 = "X";
        }
        else if(spielfeld.getOrDefault((2),0) == 2){
            a2 = "O";
        }
        else{
            a2 = " ";
        }
        String a3 = " ";
        if(spielfeld.getOrDefault((3),0) == 1) {
            a3 = "X";
        }
        else if(spielfeld.getOrDefault((3),0) == 2){
            a3 = "O";
        }
        else{
            a3 = " ";
        }
        String b1 = " ";
        if(spielfeld.getOrDefault((4),0) == 1) {
            b1 = "X";
        }
        else if(spielfeld.getOrDefault((4),0) == 2){
            b1 = "O";
        }
        else{
            b1 = " ";
        }
        String b2 = " ";
        if(spielfeld.getOrDefault((5),0) == 1) {
            b2 = "X";
        }
        else if(spielfeld.getOrDefault((5),0) == 2){
            b2 = "O";
        }
        else{
            b2 = " ";
        }
        String b3 = " ";
        if(spielfeld.getOrDefault((6),0) == 1) {
            b3 = "X";
        }
        else if(spielfeld.getOrDefault((6),0) == 2){
            b3 = "O";
        }
        else{
            b3 = " ";
        }
        String c1 = " ";
        if(spielfeld.getOrDefault((7),0) == 1) {
            c1 = "X";
        }
        else if(spielfeld.getOrDefault((7),0)== 2){
            c1 = "O";
        }
        else{
            c1 = " ";
        }
        String c2 = " ";
        if(spielfeld.getOrDefault((8),0) == 1) {
            c2 = "X";
        }
        else if(spielfeld.getOrDefault((8),0) == 2){
            c2 = "O";
        }
        else{
            c2 = " ";
        }
        String c3 = " ";
        if(spielfeld.getOrDefault((9),0) == 1) {
            c3 = "X";
        }
        else if(spielfeld.getOrDefault((9),0) == 2){
            c3 = "O";
        }
        else{
            c3 = " ";
        }
        
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +  
                           "  Hier muss noch Spielstand hin  \n" +
                           "                                 \n" +
                           "       1     2     3             \n" + 
                           "    ___________________          \n" +
                           "    |     |     |     |          \n" +
                           " A  |  " + a1 + "  |  " + a2 + "  |  " + a3 + "  |          \n" +
                           "    |_____|_____|_____|          \n" +
                           "    |     |     |     |          \n" +
                           " B  |  " + b1 + "  |  " + b2 + "  |  " + b3 + "  |          \n" +
                           "    |_____|_____|_____|          \n" +
                           "    |     |     |     |          \n" +
                           " C  |  " + c1 + "  |  " + c2 + "  |  " + c3 + "  |          \n" +
                           "    |_____|_____|_____|          \n" +
                           "                                 \n");
        // System.out.printf()
        // entnehme die Werte aus der Hashmap welcher Spieler welches X wo gesetzt hat
    }
    
}
