package structure_pattern.Composite;

public class Calculator{

    private AbstractExpression expression;

    public Calculator(){
        super();
    }

    public int calcuate(){
        return expression.operate();
    }

    public void setExpression(AbstractExpression expression){
        this.expression = expression;
    }
}