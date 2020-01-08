package structure_pattern.decorator;

import java.util.ArrayList;

/**
 * AbstractOperationExpression
 */
public abstract class AbstractOperationExpression extends AbstractExpression{

    protected ArrayList<AbstractExpression> operandList = new ArrayList<AbstractExpression>();

    public final void addOperandExpresion(AbstractExpression operandExpression){
        operandList.add(operandExpression);
    }
    
}