/**
 * SubtractTopLevel Klasse
 */
public class SubtractTopLevel  implements CrunchOperation {
    /**
     * Attribute
     */
    private float[] values;

    /**
     * Methode subtract
     */
    public void subtract() {
        for (int i = 0; i < values.length - 1; i++) {
            values[i + 1] = values[i] - values[i + 1];
        }
    }
    
    /**
     * Methode zum Testen subtract Methode
     * @param values Array
     */
    @Override
    public void crunch(float[] values) {
        setValues(values);
        subtract();
    }
    
    /**
     * Methode zum Setzen des Values Arrays
     * @param values Array
     */
    public void setValues(float[] values) {
        this.values = values;
    }

}
