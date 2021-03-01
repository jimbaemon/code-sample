package structure_pattern.decorator;

/**
 * Calculator
 */
public class Calculator {

    private AbstractExpression expression;

    public Calculator(){
        super();
    }

    public double calculate(){
        return expression.operate();
    }

    public void setExpression(AbstractExpression expression){
        this.expression = expression;
    }
}