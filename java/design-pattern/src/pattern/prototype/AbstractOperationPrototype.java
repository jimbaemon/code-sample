package pattern.prototype;

/**
 * AbstractOperationPrototype
 */
public abstract class AbstractOperationPrototype {

    private int firstNumber;
    private int secondNumber;

    public AbstractOperationPrototype(){
        super();
    }

    public AbstractOperationPrototype(AbstractOperationPrototype operation){
        this.firstNumber = operation.firstNumber;
        this.secondNumber = operation.secondNumber;
    }

    public abstract AbstractOperationPrototype getClone();

    public int getFirstNumber(){
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber){
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber(){
        return secondNumber;
    }

    public void setSeconNumber(int secondNumber){
        this.secondNumber = secondNumber;
    }

    protected final void print(String result){
        System.out.println(result);
    }

    protected abstract int getAnswer(int firstNumber, int secondNumber);

    protected abstract String getOperator();

    public final void operate(){
        int firstNumber = getFirstNumber();
        int secondNubmer = getSecondNumber();

        String operator = getOperator();

        int answer = getAnswer(firstNumber, secondNumber);

        String result = firstNumber + operator + secondNubmer + "=" + answer;

        print(result);
    }
}