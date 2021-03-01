package objectOriented.interface_segregation_principle;

/**
 * MultiplyOperation
 */
public class MultiplyOperation extends AbstractOperation{

    public int operate(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }

    @Override
    public String getOperator(){
        return "*";
    }
    
}