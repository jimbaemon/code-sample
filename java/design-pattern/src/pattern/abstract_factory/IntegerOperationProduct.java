package pattern.abstract_factory;

/**
 * 실제 실행 구현체 
 */
public class IntegerOperationProduct extends AbstractOperationProduct{

    public void print(){
        double firstNumber = getFirstNumber();
        double secondNumber = getSecondNumber();

        System.out.println((int)firstNumber + "+" + (int)secondNumber + "=" + (int)add());
        System.out.println((int)firstNumber + "-" + (int)secondNumber + "=" + (int)substract());
        System.out.println((int)firstNumber + "*" + (int)secondNumber + "=" + (int)multiply());
        System.out.println((int)firstNumber + "/" + (int)secondNumber + "=" + (int)divide());
    }
}