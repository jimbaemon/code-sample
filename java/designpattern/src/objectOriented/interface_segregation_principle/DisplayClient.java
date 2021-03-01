package objectOriented.interface_segregation_principle;

/**
 * DisplayClient
 */
public class DisplayClient {

    public void request(IDisplayable displayable, AbstractOperation operation, int firstNumber, int secondNumber){
        displayable.newDisplay(operation, firstNumber, secondNumber);
    }
}