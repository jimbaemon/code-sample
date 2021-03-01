package pattern.prototype;

/**
 * AddOperationPrototype
 */
public class AddOperationPrototype extends AbstractOperationPrototype{

    public AddOperationPrototype(){
        super();
    }

    public AddOperationPrototype(AbstractOperationPrototype operation){
        super(operation);
    }

    @Override
    public AbstractOperationPrototype getClone(){
        return new AddOperationPrototype();
    }

    @Override
    protected int getAnswer(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    @Override
    protected String getOperator(){
        return "+";
    }
}