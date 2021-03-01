package objectOriented.liskov_substitution_principle;

/**
 * DivideOperation
 */
public class DivideOperation extends AbstractOperation{

    public boolean isInvalidNumber(int firstNumber, int secondNumber){
        if(secondNumber == 0){
            return true;
        }

        return false;
    }

    public int operate(int firstNumber, int secondNumber){
        return firstNumber / secondNumber;
    }
}