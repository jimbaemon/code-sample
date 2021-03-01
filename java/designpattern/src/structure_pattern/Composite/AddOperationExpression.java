package structure_pattern.Composite;

/**
 * AddOperationExpression
 */
public class AddOperationExpression extends AbstractOperationExpression{

    @Override
    public int operate() {
        AbstractExpression firstOperandExpression = operandList.get(0);
        AbstractExpression secondOperandExpression = operandList.get(1);

        int firstResult = firstOperandExpression.operate();
        int secondResult = secondOperandExpression.operate();

        return firstResult + secondResult;
    }
    
}