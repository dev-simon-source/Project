/**
 * Queue Interface
 */
public interface Queue {
	void addLast (Object o);    // Objekt hinten anfuegen

	Object removeFirst ();    	// entferne das erste Element und gebe eine Referenz darauf zurueck

	Object get (int i);			// Das i-te Element zurueckgebe

	boolean empty ();			// Testen, ob schon Elemente eingefuegt wurden

	boolean full ();			// Testen, ob noch Elemente einfuegbar sind, d. h. ob das letzte Element schon einen Wert != null hat

	int size ();				// Anzahl eingefuegter Elemente
}
