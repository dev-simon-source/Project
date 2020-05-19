/**
 * StringQueue Klasse
 */

public class StringQueue implements Queue {

    /**
     * Konstanten
     */
    private static final String MSG_QUEUE_VOLL = "Stringwarteschlange ist voll!";
    private static final String MSG_QUEUE_LEER = "Stringwarteschlange ist leer!";

    /**
     * Attribute
     */
    private String[] q;
    private int pos = 0;

    /**
     * Konstruktor der Klasse StringQueue
     * @param size gibt größe der PersonenQueue
     */
    public StringQueue(int size){
        q = new String[size];
    }

    /**
     * Methode, welche ein Objekt(String) ans Ende Anfügt
     * @param o
     */
    @Override
    public void addLast (Object o) {
        check(!full(),MSG_QUEUE_VOLL);
        q[pos] = (String) o;
        pos++;
    }

    /**
     * Methode, welche das erste Objekt (String) entfernt
     * @return gibt neue StringQueue zurück
     */
    @Override
    public Object removeFirst () {
        check(!empty(),MSG_QUEUE_LEER);
        for (int i = 0; i < pos-1 ; i++) {
            q[i] = q[i+1];
        }
        q[pos] = null;
        pos--;
        return q;
    }

    /**
     *Methode, welche ein Objekt (String) an der Stelle i zurück gibt
     * @param i Stelle des Objektes (String)
     * @return gibt Objekt (String) and der Stelle i zurück
     */

    @Override
    public Object get (int i) {
        return q[i];
    }

    /**
     * Methode, welche den Wert True zurück gibt, wenn die Queue leer ist
     * @return
     */
    @Override
    public boolean empty () {
        if (pos > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Methode, welche den Wert True zurück gibt, wenn die Queue voll ist
     * @return
     */
    @Override
    public boolean full () {
        int size = q.length - 2 ;
        if (q[size] != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode, welche die Größe der Warteschlange zurück gibt
     * @return
     */
    @Override
    public int size () {
        return pos;
    }

    /**
     * toString Methode
     * @return Ausgabe der StringQueue als String
     */
    public String toString(){
        StringBuilder list = new StringBuilder();
        for(int i = 0; i < pos; i++)
        {
            list.append(q[i] + "\n");
        }
        return list.toString();
    }

    /**
     * Methode zur Fehlerbehandlung. Ueberprueft Bedingung und gibt eine Exception aus.
     * @param   bedingung   Die Bedingung die bei nicht erfuellung eine Exception ausgibt.
     * @param   message     Nachricht die bei nicht erfuellung ausgegeben wird
     */
    private void check(boolean bedingung, String message) {
        if(!bedingung)
            throw new IllegalArgumentException(message);
    }
}
