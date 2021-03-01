package structure_pattern.facade;

/**
 * AddOperationProduct
 */
public class AddOperationProduct extends AbstractOperationProduct{

    public void operate(int firstNumber, int secondNumber){
        int answer  = firstNumber + secondNumber;

        System.out.println(firstNumber + "+" + secondNumber + "=" + answer);
    }
}