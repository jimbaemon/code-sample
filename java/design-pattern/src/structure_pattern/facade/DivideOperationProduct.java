package structure_pattern.facade;

/**
 * DivideOperationProduct
 */
public class DivideOperationProduct extends AbstractOperationProduct{
    public void operate(int firstNumber, int secondNumber){
        int answer  = firstNumber / secondNumber;

        System.out.println(firstNumber + "/" + secondNumber + "=" + answer);
    }

    
}