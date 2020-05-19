import java.util.PriorityQueue;

/**
 * Methode zum Divide
 */
public class DivideTopLevel  implements CrunchOperation {
    /**
     * Attribute
     */
    private float[] values;
    private int lastPosMin = -1;
    private int lastPosMax = -1;
    private int[] posMax;
    private int[] posMin;

    /**
     * Methode divide
     */
    public void divide() {

        posMax = new int[values.length / 2];
        posMin = new int[values.length / 2];
        initialisierung(posMax);
        initialisierung(posMin);
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

    /**
     * Methode zum Ausführen der divide Funktion
     */
    @Override
    public void crunch(float[] values) {
        setValues(values);
        divide();
    }

    /**
     * Methode zum Setzen des Values Arrays
     * @param values Array
     */
    public void setValues(float[] values) {
        this.values = values;
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

    private void initialisierung(int[] arr){
        for (int i=0; i<arr.length;i++){
            arr[i]=-1;
        }
    }
}
