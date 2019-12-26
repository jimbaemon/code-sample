package structure_pattern.bridge;

/**
 * IBaseOperationImplmentor
 */
public interface IBaseOperationImplementor {

    public abstract int add(int firstNumber, int secondNumber);
    
    public abstract int substract(int firstNumber, int secondNumber);

    public abstract int multiply(int firstNumber, int secondNumber);

    public abstract int divide(int firstNumber, int secondNumber);
}