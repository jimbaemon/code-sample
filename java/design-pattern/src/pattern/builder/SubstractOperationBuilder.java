package pattern.builder;

/**
 * AddOperationBuilder
 */
public class SubstractOperationBuilder extends AbstractOperationBuilder {

    public SubstractOperationBuilder(int firstNumber, int secondNumber) {
        super(firstNumber, secondNumber);
    }

    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public void buildOperator() {
        result.append("-");

    }
    
}