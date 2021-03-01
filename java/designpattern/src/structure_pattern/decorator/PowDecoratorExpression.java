package structure_pattern.decorator;

/**
 * PowDecoratorExpression
 */
public class PowDecoratorExpression extends AbstractDecoratorExapression{

    private int exponent = 2;

    public PowDecoratorExpression(){
        super();
    }

    public PowDecoratorExpression(AbstractExpression expression, int exponent){
        super(expression);

        this.exponent = exponent;
    }

    public double operate(){
        return Math.pow(this.expression.operate(), exponent);
    }
    
}