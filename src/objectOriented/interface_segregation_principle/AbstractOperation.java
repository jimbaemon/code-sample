package objectOriented.interface_segregation_principle;

/**
 * AbstractOperation
 */
public abstract class AbstractOperation {

    public abstract int operate(int firstNumber, int secondNumber);

    public abstract String getOperator();
    
}