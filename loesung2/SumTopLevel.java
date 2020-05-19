/**
 * SumTopLevel Klasse zum Berechnen der Sum Funktion
 */

public class SumTopLevel implements CrunchOperation {
    /**
     * Attribute
     */
    private float[] values;
    
    /**
     * Methode sum
     */
    public void sum(){
        float[] values = getValues();
        for (int i = 0; i < values.length - 1; i++) {
            values[i + 1] = values[i] + values[i + 1];
        }
    }
    
    /**
     * Methode zum Zurückgeben der Values
     * @return values als Float Array
     */
    public float[] getValues() {
        return values;
    }

    /**
     * Methode zum Setzen der Values
     * @param value als Float Array
     */
    public void setValues(float[] values) {
        this.values = values;
    }

    /**
     * Methode zum Ausführen der sum Methode
     */
    @Override
    public void crunch(float[] values) {
        setValues(values);
        sum();
    }
}
