import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
/**
 * Dialogklasse zum Testen des NumberCruncher
 *
 */
public class NumberCruncherDialog {
    
    /**
     * Konstanten
     */
    private static final int SUM = 1;
    private static final int SWIRL = 2;
    private static final int DIVIDE = 3;
    private static final int SUBTRACT = 4;
    private static final int AVERAGE = 5;
    private static final int END = 6;

    private static final String FUNC_SUM = "SUM";
    private static final String FUNC_SWIRL = "SWIRL";
    private static final String FUNC_DIVIDE = "DIVIDE";
    private static final String FUNC_SUBTRACT = "SUBTRACT";
    private static final String FUNC_AVERAGE = "AVERAGE";

    /**
     * Attribute
     */
    private NumberCruncherTopLevel nctl;
    private NumberCruncherAnonym nca;
    private float[] ValuesAnonym;
    private float[] ValuesTopLevel;

    private Scanner scanner;

    /**
     * Konstruktor
     */
    public NumberCruncherDialog() {
        scanner = new Scanner(System.in);
    }

    /**
     * Start Methode
     */
    public void start() {
        int funktion = -1;
        ValuesTopLevel = gebeZahlenEin();
        ValuesAnonym = gebeZahlenEin();
        nctl = new NumberCruncherTopLevel(ValuesTopLevel);
        nca  = new NumberCruncherAnonym(ValuesAnonym);
        while(funktion != END) {
            try {
                funktion = funktionEinlesen();
                funktionAusfuehren(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e);
                scanner.nextLine();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Methode zum Einlesen der Funktion
     * @return nächste Funktion als integer
     */
    public int funktionEinlesen() {
        System.out.println("-----------------------------------------------");
        System.out.println("Funktionen:\n" +
                           SUM + ": Sum\n" +
                           SWIRL + ": Swirl\n" +
                           DIVIDE + ": Divide\n" +
                           SUBTRACT + ": Subtract\n" +
                           AVERAGE + ": Average\n" +
                           END + ": End\n" +
                           "Nummer eingeben:");

        return scanner.nextInt();
    }

    /**
     * Methode zum Ausführen der Funktion
     * @param funktion Übergebene Funktion als integer
     */
    public void funktionAusfuehren(int funktion) {

        switch(funktion) {
            case SUM:
                testeSum();
            break;
            case SWIRL:
                testeSwirl();
            break;
            case DIVIDE:
                testDivide();
            break;
            case SUBTRACT:
                testeSubtract();
            break;
            case AVERAGE:
                testAverage();
            break;
            case END:
                System.out.println("Programm wurde beendet.");
            break;
            default:
                System.out.println("Falsche Funktion eingegeben!");
        }
    }

    /**
     * Methode zum Testen der Methode Sum
     */
    public void testeSum() {
        System.out.println("Anonyme Klasse");
        nca.ausführenOperation(FUNC_SUM);
        gebeValuesNachOperationAus(nca.getValues());

        System.out.println("Top Level Klasse");
        nctl.ausführenOperation(FUNC_SUM);
        gebeValuesNachOperationAus(nctl.getValues());
    }

    /**
     * Methode zum Testen der Methode Sum
     */
    public void testeSwirl() {
        System.out.println("Anonyme Klasse");
        nca.ausführenOperation(FUNC_SWIRL);
        gebeValuesNachOperationAus(nca.getValues());

        System.out.println("Top Level Klasse");
        nctl.ausführenOperation(FUNC_SWIRL);
        gebeValuesNachOperationAus(nctl.getValues());
    }

    /**
     * Methode zum Testen der Methode Sum
     */
    public void testDivide() {
        System.out.println("Anonyme Klasse");
        nca.ausführenOperation(FUNC_DIVIDE);
        gebeValuesNachOperationAus(nca.getValues());

        System.out.println("Top Level Klasse");
        nctl.ausführenOperation(FUNC_DIVIDE);
        gebeValuesNachOperationAus(nctl.getValues());
    }

    /**
     * Methode zum Testen der Methode Sum
     */
    public void testeSubtract() {
        System.out.println("Anonyme Klasse");
        nca.ausführenOperation(FUNC_SUBTRACT);
        gebeValuesNachOperationAus(nca.getValues());

        System.out.println("Top Level Klasse");
        nctl.ausführenOperation(FUNC_SUBTRACT);
        gebeValuesNachOperationAus(nctl.getValues());
    }

    /**
     * Methode zum Testen der Methode Sum
     */
    public void testAverage() {
        System.out.println("Anonyme Klasse");
        nca.ausführenOperation(FUNC_AVERAGE);
        gebeValuesNachOperationAus(nca.getValues());

        System.out.println("Top Level Klasse");
        nctl.ausführenOperation(FUNC_AVERAGE);
        gebeValuesNachOperationAus(nctl.getValues());
    }

    /**
     * Hilfsmethode für das Ausgeben der Values nach der jeweiligen Operation
     */
    private void gebeValuesNachOperationAus(float[] values) {
        System.out.println("-----------------------------------------------");
        float[] ausgValues = values;

        for(int i = 0; i < ausgValues.length; i++) {
            System.out.print( " | " + ausgValues[i]);
        }
        System.out.println(" |\n-----------------------------------------------\n");
    }

    private float[] gebeZahlenEin() {
        float[] Values = new float[5];
        
        System.out.println("Gebe 5 Zahlen ein:");

        for(int i = 0; i < Values.length; i++) {
            System.out.print(i+1 + ". Zahl: ");
            Values[i] = scanner.nextFloat();
        }

        return Values;
    }
    
    /**
     * Main Methode zum Starten des Dialogs
     */
    public static void main(String[] args) {
        new NumberCruncherDialog().start();
    }
}
