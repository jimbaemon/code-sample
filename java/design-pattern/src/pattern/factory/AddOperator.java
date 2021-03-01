package pattern.factory;

/**
 * AddOperator
 */
public class AddOperator extends AbstractOperator{

    protected int getAnswer(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    @Override
    public String getDescription(){
        return "+";
    }
    
}