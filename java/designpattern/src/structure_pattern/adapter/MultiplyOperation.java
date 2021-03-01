package structure_pattern.adapter;

/**
 * MultiplyOperation
 */
public class MultiplyOperation extends AbstractOperationTarget{

    public int operate(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }

}