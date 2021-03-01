package structure_pattern.decorator;

/**
 * AbstractDecoratorExapression
 */
public abstract class AbstractDecoratorExapression extends AbstractExpression{

    protected AbstractExpression expression;

    protected AbstractDecoratorExapression(){
        super();
    }

    public AbstractDecoratorExapression(AbstractExpression expression){
        this.expression = expression;
    }

    public void setExpression(AbstractExpression expression){
        this.expression = expression;
    }
    
}