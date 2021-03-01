package structure_pattern.Composite;

import java.util.ArrayList;

/**
 * AbstractOperationExpression
 */
public abstract class AbstractOperationExpression extends AbstractExpression{

    protected ArrayList<AbstractExpression> operandList = new ArrayList<AbstractExpression>();

    public final void addOperandExpression(AbstractExpression operandExpression){
        operandList.add(operandExpression);
    }
    
}