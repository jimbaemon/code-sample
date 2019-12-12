package objectOriented.liskov_substitution_principle;

/**
 * AbstractOperation
 */
public abstract class AbstractOperation {

    public abstract int operate(int firstNumber, int secondNumber);

    //피연사자값의 유효성을 검사하는 메서드를 선언
    public boolean isInvalidNumber(int firstNumber, int secondNumber){
        return false;
    }
}