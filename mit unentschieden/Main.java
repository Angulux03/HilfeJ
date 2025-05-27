
/**
 * Main Klasse /Startet spiel
 */
public class Main
{
    // instance variables - replace the example below with your own
    Spiel spiel;

    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        // initialise instance variables
        spiel = new Spiel();
    } // warum nicht static void main(String[] args) { und dann Start() aufrufen?

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void Start()
    {
        // put your code here
        spiel.spiel();
    }
}
