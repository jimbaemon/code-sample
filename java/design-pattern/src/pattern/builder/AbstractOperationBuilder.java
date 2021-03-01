package pattern.builder;

/**
 * AbstractOperationBuilder
 */
public abstract class AbstractOperationBuilder {

    protected StringBuffer result = new StringBuffer();

    private int firstNumber;
    private int secondNumber;

    public AbstractOperationBuilder(int firstNumber, int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public abstract int operate(int firstNumber, int secondNumber);

    public abstract void buildOperator();

    public final void buildFirstNumber(){
        result.append(firstNumber);
    }

    public final void buildSecondNumber(){
        result.append(secondNumber);
    }

    public final void buildAnswer(){
        int answer = operate(firstNumber, secondNumber);

        result.append("=" + answer);
    }

    public final StringBuffer getResult(){
        return result;
    }
}