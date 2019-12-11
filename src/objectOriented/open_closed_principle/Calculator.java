package objectOriented.open_closed_principle;

/**
 * Caculator
 */
public class Calculator {

    //추상화된 부모클래스만 가져온다
    private AbstractOperation operation;

    public int caculate(int firstNumber, int secondNumber){
        return this.operation.operate(firstNumber, secondNumber);
    }

    public void setOperation(AbstractOperation operation){
        this.operation = operation;
    }
}