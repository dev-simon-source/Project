import java.util.*;

/**
 * Dialog ist eine Klasse zum benutzen der Klassen StringQueue und PersonQueue durch manuelle Eingaben durch den Benutzer
 *
 */
public class Dialog {
    /**
     * Attribute
     */
    private Scanner input = new Scanner(System.in);
    
    /**
     * Konstanten für die Funktionen
     */
    private static final int ADD_LAST = 1;
    private static final int REMOVE_FIRST = 2;
    private static final int AUSGEBEN = 3;
    private static final int AUSGEBEN_NORMAL = 4;
    private static final int AUSGEBEN_LEXIKALISCH = 5;
    private static final int STRING_QUEUE = 1;
    private static final int PERSON_QUEUE = 2;
    private static final int ENDE = 0;

    /**
     * Konstanten Fehlermeldungen
     */
    private static final String FALSCHE_KLASSEN_ART = "Ungueltige Zahl eingegeben (Möglich 1 oder 2)";

    Queue queue;

    /**
     * Die Start-Methode wird von main aufgerufen
     * Fängt die Fehler ab und gibt sie aus
     */
    public void start() {
        int funktion = -1;
        int klassenArt = 0;
        System.out.print(
                STRING_QUEUE + " : StringQueue \n" +
                        PERSON_QUEUE + " : PersonQueue \n");
        klassenArt = input.nextInt();
        check(klassenArt == STRING_QUEUE || klassenArt == PERSON_QUEUE, FALSCHE_KLASSEN_ART);
        if (klassenArt == STRING_QUEUE) {
            queue = new StringQueue(10);
        } else {
            queue = new PersonQueue(10);
        }
        while (funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e);
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Einlese-Funktion zum Auswaehlen der naechsten Funktion.
     * Verfügbar ist:   addLast     (zum hinzufuegen deines elements an die letzte Stelle)
     * removeFirst (zum entfernen des ersten Elements mit Rückgabe einer Referenz)
     *
     * @return funktion Ein Integer der die naechste Funktion die durchgeführt wird bestimmt
     */
    private int einlesenFunktion() {
        int funktion;
        System.out.print(
                ADD_LAST + ": Objekt hinten anfuegen \n" +
                        REMOVE_FIRST + ": Entfernt das erste Element \n" +
                        AUSGEBEN + ": Die Queue ausgeben \n" +
                        ENDE + ": Beenden -> ");

        funktion = input.nextInt();
        return funktion;
    }

    /**
     * Ausführen-Funktion Führt die in einlesenFunktion ausgewaehlte Funktion durch
     *
     * @param funktion Integer der der ausgewaehlten Funktion entspricht und bestimmt
     */
    private void ausfuehrenFunktion(int funktion) {
        if (funktion == ENDE) {
            System.out.println("Programm Ende!\n");
            return;
        }
        switch (funktion) {
            case ADD_LAST:
                add();
                break;
            case REMOVE_FIRST:
                remove();
                break;
            case AUSGEBEN:
                ausgeben(ausgebenAuswahl());
                //print(queue);
                break;
            case ENDE:
                System.out.println("Programm Ende!\n");
                return;
            default:
                System.out.println("Falsche Funktion!\n");
                break;
        }
        System.out.println("\n-----------------------------------");
    }

    /**
     * Methode für die Ausgabe der Auswahlmöglichkeiten
     * @return auswahl als int
     */
    public int ausgebenAuswahl() {
        int auswahl;
        System.out.print(
                AUSGEBEN_NORMAL + ": In normaler Reihenfolge ausgeben \n" +
                        AUSGEBEN_LEXIKALISCH + ": Den lexikographisch kleinsten Namen ausgeben \n");

        auswahl = input.nextInt();
        return auswahl;
    }

    /**
     * Methode zum Ausgeben der Funktion
     * @param auswahl Auswahl als int
     */
    public void ausgeben(int auswahl){
        switch (auswahl){
            case AUSGEBEN_NORMAL:
                print(queue);
                break;
            case AUSGEBEN_LEXIKALISCH:
                printSmallest(queue);
                break;
            default:
                System.out.println("Auswahl ist nicht bekannt!");
        }

    }

    /**
     * Methode zum Ausgeben des kleinsten Elements
     */
    public void printSmallest(Queue q){
        PersonQueue p = (PersonQueue) q;
        String ausgabe = p.smallest();
        System.out.println(ausgabe);
    }


    /**
     * Methode print zum ausgeben der Warteschlange
     *
     * @param q die uebergebene Warteschlange
     */
    private void print(Queue q) {
        System.out.println(q.toString());

    }

    /**
     * Methode zum Hinzufügen
     */
    private void add() {
        Object object;
        System.out.print("Bitte String zum anhaengen angeben : \n");
        input.nextLine();
        object = input.nextLine();
        queue.addLast(object);
        System.out.print(queue.get(queue.size() - 1) + " wurde angehangen\n");
    }

    /**
     * Methode zum Löschen
     */
    private void remove() {
        System.out.print(queue.get(0).toString() + " wurde aus der Queue entfernt\n");
        queue.removeFirst();

    }

    /**
     * Methode zur Fehlerbehandlung. Ueberprueft Bedingung und gibt eine Nachricht aus.
     *
     * @param bedingung Die Bedingung die bei nicht erfuellung eine Nachricht ausgibt.
     * @param message   Nachricht die bei nicht erfuellung ausgegeben wird
     */
    public void check(boolean bedingung, String message) {
        if (!bedingung) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Methode main ruft start Methode auf
     */
    public static void main(String[] args) {
        new Dialog().start();
    }
}
