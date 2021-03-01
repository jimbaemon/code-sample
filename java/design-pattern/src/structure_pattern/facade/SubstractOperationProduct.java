package structure_pattern.facade;

/**
 * SubstractOperationProduct
 */
public class SubstractOperationProduct extends AbstractOperationProduct{

    public void operate(int firstNumber, int secondNumber){
        int answer  = firstNumber - secondNumber;

        System.out.println(firstNumber + "-" + secondNumber + "=" + answer);
    }
}