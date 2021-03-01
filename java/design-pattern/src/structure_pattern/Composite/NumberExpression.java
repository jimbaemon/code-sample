package structure_pattern.Composite;

/**
 * NumberExpression
 */
public class NumberExpression extends AbstractExpression{

    private int value;

    public NumberExpression(int value){
        this.value = value;
    }

    @Override
    public int operate() {
        return value;
    }
}