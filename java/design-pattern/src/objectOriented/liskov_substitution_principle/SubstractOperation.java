package objectOriented.liskov_substitution_principle;

/**
 * SubstractOperation
 */
public class SubstractOperation extends AbstractOperation{

    public int operate(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }

}