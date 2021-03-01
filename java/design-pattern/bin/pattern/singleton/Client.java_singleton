package pattern.singleton;

/**
 * Client
 */
public class Client {

    public static void main(String[] args) {
        OperationSingleton calculatorSingleton = OperationSingleton.getInstance();

        int firstNumber = 100;
        int secondNumber = 20;

        calculatorSingleton.operate(OperationSingleton.ADD_OPERATION, firstNumber, secondNumber);
        calculatorSingleton.operate(OperationSingleton.SUBSTRACT_OPERATION, firstNumber, secondNumber);
        calculatorSingleton.operate(OperationSingleton.MULTIPLY_OPERATION, firstNumber, secondNumber);
        calculatorSingleton.operate(OperationSingleton.DIVIDE_OPERATION, firstNumber, secondNumber);
    }
}