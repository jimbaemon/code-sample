package structure_pattern.decorator;

/**
 * FracDecoratorExpression
 */
public class FracDecoratorExpression extends AbstractDecoratorExapression{

    public FracDecoratorExpression(){
        super();
    }

    public FracDecoratorExpression(AbstractExpression expression){
        super(expression);
    }

    public double operate(){
        return 1 / expression.operate();
    }
    
}