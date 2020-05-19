/**
 * Klasse AverageTopLevel
 */
public class AverageTopLevel  implements CrunchOperation {
    /**
     * Attribute
     */
    private float[] values;

    /**
     * Methode average
     */
    public void average() {
        float summe = 0;
        for (int i = 0; i < values.length; i++) {
            summe = summe + values[i];
        }

        values[bestimmeMaximum(values)] = summe / values.length;
    }

    /**
     * Hilfsmethode zum Bestimmen des Maximums im Values Array
     * @param values Array
     * @return i index, an dem das Maximum im Array zu finden ist
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
     * Methode zum Ausführen der Average Funktion
     * @param values Array
     */
    @Override
    public void crunch(float[] values) {
        setValues(values);
        average();
    }

    /**
     * Set Methode zum Setzen des Values Arrays
     * @param values Array
     */
    public void setValues(float[] values) {
        this.values = values;
    }
}
