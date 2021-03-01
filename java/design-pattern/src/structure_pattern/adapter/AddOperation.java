package structure_pattern.adapter;

/**
 * AddOperation
 */
public class AddOperation extends AbstractOperationTarget{

    public int operate(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
}