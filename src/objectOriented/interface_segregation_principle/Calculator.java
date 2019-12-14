package objectOriented.interface_segregation_principle;

/**
 * Calculator
 */
public class Calculator implements IDisplayable{

    private AbstractOperation operation;
    
    public int calculate(int firstNumber, int secondNumber){
        return this.operation.operate(firstNumber, secondNumber);
    }

    public void setOperation(AbstractOperation operation){
        this.operation = operation;
    }

    @Override
    public void display(AbstractOperation operation, int firstNumber, int secondNumber){
        int answer = operation.operate(firstNumber, secondNumber);

        String operator = operation.getOperator();

        System.out.println(firstNumber + operator + secondNumber + "=" + answer);
    }
}