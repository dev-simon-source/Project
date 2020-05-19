import java.util.Random;

/**
 * Implementierung der anonymen Variante
 */
public class NumberCruncherAnonym {
    /**
     * Attribute
     */
    private float[] values;
    private int lastPosMin = -1;
    private int lastPosMax = -1;
    private int[] posMax;
    private int[] posMin;

    /**
     * Konstruktor
     */
    public NumberCruncherAnonym(float[] values){
        setValues(values);
    }

    /**
     * Ausführen der Operation
     * @param operation, die ausgeführt werden soll
     */
    public void ausführenOperation(String operation) {

        NumberCruncher nc = new NumberCruncher(values) {

            public void sum() {
                float[] values = getValues();
                for (int i = 0; i < values.length - 1; i++) {
                    values[i + 1] = values[i] + values[i + 1];
                }
            }

            public void swirl() {
                int n = values.length;

                for (int i = 0; i <= n; i++) {
                    Random random = new Random();

                    float temp;
                    int zufallIndex = random.nextInt(n - 1);
                    int zufallIndex1 = random.nextInt(n - 1);

                    temp = values[zufallIndex];
                    values[zufallIndex] = values[zufallIndex1];
                    values[zufallIndex1] = temp;

                }
            }

            public void divide() {
                posMax = new int[values.length / 2];
                posMin = new int[values.length / 2];
                initialisierung(posMax);
                initialisierung(posMin);
                lastPosMax = -1;
                lastPosMin = -1;
                int laenge = values.length / 2;
                for (int i = 0; i < laenge; i++) {
                    posMax[i] = bestimmeNteMaximum(values, lastPosMax);
                    posMin[i] = bestimmeNteMinimum(values, lastPosMin);
                }
                for (int i = 0; i < posMax.length; i++) {
                    int maxPos = posMax[i];
                    int minPos = posMin[i];
                    values[maxPos] = values[maxPos] / values[minPos];
                }
            }

            public void subtract() {
                for (int i = 0; i < values.length - 1; i++) {
                    values[i + 1] = values[i] - values[i + 1];
                }
            }

            public void average() {
                float summe = 0;
                for (int i = 0; i < values.length; i++) {
                    summe = summe + values[i];
                }

                values[bestimmeMaximum(values)] = summe / values.length;
            }

        };

        operation = operation.toLowerCase();
        switch (operation){
            case "sum":
                nc.sum();
                break;
            case "swirl":
                nc.swirl();
                break;
            case "divide":
                nc.divide();
                break;
            case "subtract":
                nc.subtract();
                break;
            case "average":
                nc.average();
                break;
            default:
                System.out.println("Funktion konnte nicht gefunden werden");
        }
    }

    /**
     * getValues Methode zum Zurückgeben der Zahlen
     * @return values
     */
    public float[] getValues() {
        return values;
    }

    /**
     * Methode zum Setzen der Values
     * @param values Values werden als Float Array übergeben
     */
    public void setValues(float[] values) {
        this.values = values;
    }

    /**
     * Hilfsmethode zum Bestimmen des Maximums
     * @param values Values als Float Array
     * @return i index, an dem das Maximum steht
     */
    private int bestimmeMaximum(float[] values) {
        float maximum = Float.MIN_VALUE;

        for (int i = 0; i < values.length; i++) {
            if (values[i] > maximum) {
                maximum = values[i];
            }
            return i;
        }
        return 0;
    }

    /**
     * Methode zum finden der Postion der N kleinesten Zahl
     * @param values übergibt das array mit allen zahlen
     * @param lastPos übergibt die Postion der letzten kleinsten Zahl
     */
    private int bestimmeNteMinimum(float[] values, int lastPos) {
        float minimum = Float.MAX_VALUE;
        int posMin = -1;

        for (int i = 0; i < values.length; i++) {
            if (lastPos >= 0) {
                if (values[i] < minimum && values[lastPos] < values[i]) {
                    minimum = values[i];
                    posMin = i;
                }
            } else {
                if (values[i] < minimum) {
                    minimum = values[i];
                    posMin = i;
                }
            }
        }
        lastPosMin = posMin;
        return lastPosMin;
    }

    /**
     * Methode zum finden der Postion der N groessten Zahl
     * @param values übergibt das array mit allen zahlen
     * @param lastPos übergibt die Postion der letzten groessten Zahl
     */
    private int bestimmeNteMaximum(float[] values, int lastPos) {
        float maximum = Float.MIN_VALUE;
        int posMax = -1;

        for (int i = 0; i < values.length; i++) {
            if (lastPos >= 0) {
                if (values[i] > maximum && values[lastPos] > values[i]) {
                    maximum = values[i];
                    posMax = i;
                }
            } else {
                if (values[i] > maximum) {
                    maximum = values[i];
                    posMax = i;
                }
            }
        }
        lastPosMax = posMax;
        return lastPosMax;
    }

    /**
     * Methode zum Ausführen der ausgewählten Operationen
     * @param operations Operation als String Array
     */
    public void crunch(String[] operations){
        for (String funktion:operations ) {
            ausführenOperation(funktion);
        }
    }

    private void initialisierung(int[] arr){
        for (int i=0; i<arr.length;i++){
            arr[i]=-1;
        }
    }
}
