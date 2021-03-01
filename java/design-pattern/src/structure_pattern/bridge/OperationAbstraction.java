package structure_pattern.bridge;

/**
 * OperationAbstraction
 */
public class OperationAbstraction {

    private IBaseOperationImplementor impl;

    public OperationAbstraction(IBaseOperationImplementor impl){
        this.impl = impl;
    }

    public int add(int firstNumber, int secondNumber){
        return this.impl.add(firstNumber, secondNumber);
    }
    public int substract(int firstNumber, int secondNumber){
        return this.impl.substract(firstNumber, secondNumber);
    }
    public int multiply(int firstNumber, int secondNumber){
        return this.impl.multiply(firstNumber, secondNumber);
    }
    public int divide(int firstNumber, int secondNumber){
        return this.impl.divide(firstNumber, secondNumber);
    }
}