import java.util.Random;

/**
 * SwirlTopLevel Klasse
 */
public class SwirlTopLevel  implements CrunchOperation {
    /**
     * Attribute
     */
    private float[] values;

    /**
     * Methode swirl
     */
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
    
    /**
     * Methode zum Testen der Swirl Funktion
     * @param values Array
     */
    @Override
    public void crunch(float[] values) {
        setValues(values);
        swirl();
    }

    /**
     * Methode zum Setzen des Values Arrays
     * @param values Array
     */
    public void setValues(float[] values) {
        this.values = values;
    }
}
