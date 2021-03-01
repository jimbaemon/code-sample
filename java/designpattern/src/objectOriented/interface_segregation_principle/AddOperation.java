package objectOriented.interface_segregation_principle;

/**
 * AddOperation
 */
public class AddOperation extends AbstractOperation{

    public int operate(int firstNumber, int secondNumber){
        int answer = firstNumber + secondNumber;

        return answer;
    }

    @Override
    public String getOperator(){
        return "+";
    }

    
}