package structure_pattern.facade;


/**
 * CalculatorFacade
 */
public class CalculatorFacade {

    public CalculatorFacade(){
        super();
    }

    public void calculate(String expression){
        ExpressionParser expressionParser = new ExpressionParser();
        expressionParser.parse(expression);

        String operatorToken = expressionParser.getOperatorToken();

        String firstNumberToken = expressionParser.getFirstNumberToken();
        String secondNumberToken = expressionParser.getSecondNumberToken();

        NumberOperand firstNumberOperand = new NumberOperand(firstNumberToken);
        NumberOperand secondNumberOperand = new NumberOperand(secondNumberToken);

        int firstNumber = firstNumberOperand.getNumber();
        int secondNumber = secondNumberOperand.getNumber();

        OperationFactory operationFactory = new OperationFactory();
        AbstractOperationProduct operationProduct = operationFactory.createOperationProduct(operatorToken);

        operationProduct.operate(firstNumber, secondNumber);
    }
}