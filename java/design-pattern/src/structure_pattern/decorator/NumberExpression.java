package structure_pattern.decorator;

/**
 * NumberExpression
 */
public class NumberExpression extends AbstractExpression{

    private int value;

    public NumberExpression(int value){
        this.value = value;
    }

    public double operate(){
        return value;
    }
    
}