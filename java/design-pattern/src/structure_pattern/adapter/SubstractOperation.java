package structure_pattern.adapter;

/**
 * SubstractOperation
 */
public class SubstractOperation extends AbstractOperationTarget{

    public int operate(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }

}