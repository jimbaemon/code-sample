package pattern.factory;

/**
 * AddOperator
 */
public class SubstractOperator extends AbstractOperator {

    protected int getAnswer(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }

    @Override
    public String getDescription(){
        return "-";
    }
    
}