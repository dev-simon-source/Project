import java.util.SplittableRandom;

/**
 * PersonQueue Klasse
 */

public class PersonQueue implements Queue {

    /**
     * Konstanten
     */
    private static final String MSG_QUEUE_VOLL = "Personenwarteschlange ist voll!";
    private static final String MSG_QUEUE_LEER = "Personenwarteschlange ist leer!";

    /**
     * Attribute
     */
    private Person[] p;
    private int pos = 0;

    /**
     * Konstruktor der Klasse PersonQueue
     * @param size gibt größe der PersonenQueue
     */
    public PersonQueue(int size) {
        p = new Person[size];
    }

    /**
     * Methode, welche ein Objekt (Person) ans Ende anfügt
     * @param o
     */
    @Override
    public void addLast(Object o) {
        check(!full(), MSG_QUEUE_VOLL);
        String name;
        String vorname;
        String completName[] = o.toString().split("\\s+");
        if (completName.length < 2) {
            name = completName[0];
            vorname = "(kein Vorname)";
        } else {
            name = completName[0];
            vorname = completName[1];
        }
        p[pos] = new Person(vorname, name);
        pos++;
    }

    /**
     * Methode, welche das erste Objekt (Person) entfernt
     * @return gibt neue PersonenQueue zurück
     */
    @Override
    public Object removeFirst() {
        check(!empty(), MSG_QUEUE_LEER);
        for (int i = 0; i < pos; i++) {
            p[i] = p[i + 1];
        }
        p[pos] = null;
        pos--;
        return p;
    }

    /**
     * Methode, welche ein Objekt (Person) an der Stelle i zurück gibt
     * @param i Stelle des Objektes (Person)
     * @return gibt Objekt (Person) and der Stelle i zurück
     */
    @Override
    public Object get(int i) {
        return p[i];
    }

    /**
     * Methode, welche den Wert True zurück gibt, wenn die Queue leer ist
     * @return false/true
     */
    @Override
    public boolean empty() {
        if (pos > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Methode, welche den Wert True zurück gibt, wenn die Queue voll ist
     * @return false/true
     */

    @Override
    public boolean full() {
        int size = p.length - 2;
        if (p[size] != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode, welche die Größe der Warteschlange zurück gibt
     * @return size Größe der Warteschlange
     */

    @Override
    public int size() {
        return pos;
    }

    /**
     * toString Methode
     * @return Ausgabe der Personenwarteschlange
     */
    public String toString() {
        return new InnerPersoneQueue().toString();
    }

    /**
     * Methode, welche den lexiographisch kleinsten Namen zurueckgibt
     * @return smallestName
     */
    public String smallest() {
        InnerPersoneQueue innerPersoneQueue = new InnerPersoneQueue();
        Person smallestPerson = p[0];
        Person actualPerson;
        String name;
        if (pos == 0) {
            return "";
        } else {
            while (innerPersoneQueue.hasNext()) {
                actualPerson = innerPersoneQueue.next();
                name = actualPerson.getName();
                if (name.compareTo(smallestPerson.getName()) < 0) {
                    smallestPerson = actualPerson;
                }
            }
        }
        return smallestPerson.toString();
    }

    /**
     * Methode zur Fehlerbehandlung. Ueberprueft Bedingung und gibt eine Exception aus.
     * @param bedingung Die Bedingung die bei nicht erfuellung eine Exception ausgibt.
     * @param message Nachricht die bei nicht erfuellung ausgegeben wird
     */
    private void check(boolean bedingung, String message) {
        if (!bedingung)
            throw new IllegalArgumentException(message);
    }

    /**
     * Innere Klasse, welche den PersonIterator implementiert
     */
    private class InnerPersoneQueue implements PersonIterator {
        
        /**
         * Attribute
         */
        private int personListIndex = 0;

        /**
         * Methode hasNext, welche prüft, 
         * ob es eine weitere Person in der Liste gibt
         * @return false/true
         */
        @Override
        public boolean hasNext() {
            if (get(personListIndex) != null) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Methode next, mit der auf die nächste Person zugegriffen werden kann
         * @return Person
         */
        @Override
        public Person next() {
            Person person = (Person) get(personListIndex++);
            return person;
        }

        /**
         * toString Methode
         * @return Liste aller Personen als String
         */
        @Override
        public String toString() {
            StringBuilder list = new StringBuilder();
            while (hasNext()) {
                Person person = next();
                list.append(person.toString() + "\n");
            }
            return list.toString();
        }
    }

    /**
     * Interface PersonIterator, welcher die Methoden vom Javaeigenen Iterator erbt
     */
    private interface PersonIterator extends java.util.Iterator<Person> {
    }
}
