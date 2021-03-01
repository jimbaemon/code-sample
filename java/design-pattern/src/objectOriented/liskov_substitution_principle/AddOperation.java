package objectOriented.liskov_substitution_principle;

/**
 * AddOperation
 */
public class AddOperation extends AbstractOperation{

    public int operate(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
}