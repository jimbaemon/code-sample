package objectOriented.interface_segregation_principle;

/**
 * CalcClient
 */
public class CalcClient {

    public int request(Calculator calculator, AbstractOperation operation, int firstNumber, int secondNumber){
        calculator.setOperation(operation);

        int answer =  calculator.calculate(firstNumber, secondNumber);

        return answer;
    }
}