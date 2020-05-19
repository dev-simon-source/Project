/**
 * NumberCruncherTopLevel Klasse
 */
public class NumberCruncherTopLevel {
    /**
     * Attribute
     */
    private float[] values;
    
    /**
     * Konstruktor
     * @param values als float Array
     */
    public NumberCruncherTopLevel(float[] values){
        setValues(values);
    }

    /**
     * Methode zum Ausführen der sum Methode
     */
    private void sum(){
        SumTopLevel sumTopLevel = new SumTopLevel();
        sumTopLevel.crunch(values);
    }

    /**
     * Methode zum Ausführen der swirl Methode
     */
    private void swirl(){
        SwirlTopLevel swirlTopLevel = new SwirlTopLevel();
        swirlTopLevel.crunch(values);
    }

    /**
     * Methode zum Ausführen der divide Methode
     */
    private void divide(){
        DivideTopLevel divideTopLevel = new DivideTopLevel();
        divideTopLevel.crunch(values);
    }

    /**
     * Methode zum Ausführen der subtract Methode
     */
    private void subtract(){
        SubtractTopLevel subtractTopLevel = new SubtractTopLevel();
        subtractTopLevel.crunch(values);
    }

    /**
     * Methode zum Ausführen der average Methode
     */
    private void average(){
        AverageTopLevel averageTopLevel = new AverageTopLevel();
        averageTopLevel.crunch(values);
    }

    /**
     * Methode zum Zurückgeben der values
     * @return values als Float Array
     */
    public float[] getValues() {
        return values;
    }

    /**
     * Methode zum Setzen der values
     * @param values values als Float Array
     */
    public void setValues(float[] values) {
        this.values = values;
    }
    
    /**
     * Methode zum  Ausführen der ausgewählten Operationen
     * @param operations Operationen als String Array
     */
    public void crunch(String[] operations){
        for (String funktion:operations) {
            ausführenOperation(funktion);
        }
    }

    /**
     * Methode zum ausführen der Operation
     * @param operation Operation, die ausgeführt werden soll
     */
    public void ausführenOperation(String operation) {
        operation = operation.toLowerCase();
        switch (operation){
            case "sum":
                sum();
                break;
            case "swirl":
                swirl();
                break;
            case "divide":
                divide();
                break;
            case "subtract":
                subtract();
                break;
            case "average":
                average();
                break;
            default:
                System.out.println("Funktion konnte nicht gefunden werden");
        }
    }
}
