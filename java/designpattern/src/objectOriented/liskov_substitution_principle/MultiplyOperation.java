package objectOriented.liskov_substitution_principle;

/**
 * MultiplyOperation
 */
public class MultiplyOperation extends AbstractOperation{

    public int operate(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }

}