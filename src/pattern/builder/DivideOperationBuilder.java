package pattern.builder;

/**
 * AddOperationBuilder
 */
public class DivideOperationBuilder extends AbstractOperationBuilder {

    public DivideOperationBuilder(int firstNumber, int secondNumber) {
        super(firstNumber, secondNumber);
    }

    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }

    @Override
    public void buildOperator() {
        result.append("/");

    }
    
}