package objectOriented.interface_segregation_principle;

/**
 * DivideOperation
 */
public class DivideOperation extends AbstractOperation{

    public int operate(int firstNumber, int secondNumber){
        return firstNumber / secondNumber;
    }

    @Override
    public String getOperator(){
        return "/";
    }
    
}