package pattern.prototype;

/**
 * SubsttactOperationPrototype
 */
public class SubstractOperationPrototype extends AbstractOperationPrototype{

    public SubstractOperationPrototype(){
        super();
    }

    public SubstractOperationPrototype(AbstractOperationPrototype operation){
        super(operation);
    }

    @Override
    public AbstractOperationPrototype getClone(){
        return new SubstractOperationPrototype(this);
    }

    @Override
    protected int getAnswer(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }

    @Override
    protected String getOperator(){
        return "-";
    }
    
}