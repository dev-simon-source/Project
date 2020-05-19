/**
 * Personenklasse
 * 
 * 
 */
public class Person {
    /**
     * Attribute
     */
    private String name;
    private String vorname;
    
    /**
     * Konstanten
     */
    private static final String NAME_LEER = "Der Name darf nicht leer sein!";
    private static final String VORNAME_LEER = "Der Vorname darf nicht leer sein!";
    
    /**
     * Konstruktor
     * @param vorname Vorname der Person
     * @param nachname Nachname der Person
     */
    public Person (String vorname, String name){
        setVorname(vorname);
        setName(name);
    }
    
    /**
     * Methode für die Ausgabe der Person
     */
    public void ausgeben() {
        System.out.print(name + ", " + vorname);
    }

    /**
     * Set Methode
     * @param name Nachname der Person
     */
    private void setName(String name) {
        checkArguments(name != null && !name.trim().isEmpty() && !vorname.equals(""), NAME_LEER);
        this.name = name;
    }

    /**
     * Set Methode
     * @param vorname Vorname der Person
     */
    private void setVorname(String vorname) {
        checkArguments(vorname != null && !vorname.trim().isEmpty() && !vorname.equals(""), VORNAME_LEER);
        this.vorname = vorname;
    }

    /**
     * Get Methode zum Zurückgeben des Nachnamens
     * @return name Nachname der Person
     */
    public String getName() {
        return name;
    }

    /**
     * Get Methode zum Zurückgeben des Vornamens
     * @return vorname Vorname der Person
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * toString Methode
     * @return Nachname und Vorname der Person
     */
    public String toString() {
        return name + ", " + vorname;
    }
    
    /**
     * Methode zum Prüfen der Argumente auf deren Gültigkeit
     * @param bedingung Bedingung des Arguments
     * @param msg Msg die ausgegeben werden soll
     */
    private static void checkArguments(boolean bedingung, String msg) {
        if(!bedingung) {
            throw new IllegalArgumentException(msg);
        }
    }
}
