package objectOriented.interface_segregation_principle;


/**
 * Client
 */
public class Client {

    public static void main(String[] args) throws Exception{
        int firstNumber = 100;
        int secondNumber = 20;

        Calculator calculator = new Calculator();

        AbstractOperation operation = new AddOperation();

        CalcClient calcClient = new CalcClient();

        System.out.println(calcClient.request(calculator, operation, firstNumber, secondNumber));
    
        DisplayClient displayClient = new DisplayClient();

        displayClient.request(calculator, operation, firstNumber, secondNumber);
    }

}