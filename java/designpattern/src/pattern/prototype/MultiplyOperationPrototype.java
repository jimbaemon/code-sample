package pattern.prototype;

/**
 * SubsttactOperationPrototype
 */
public class MultiplyOperationPrototype extends AbstractOperationPrototype{

    public MultiplyOperationPrototype(){
        super();
    }

    public MultiplyOperationPrototype(AbstractOperationPrototype operation){
        super(operation);
    }

    @Override
    public AbstractOperationPrototype getClone(){
        return new MultiplyOperationPrototype(this);
    }

    @Override
    protected int getAnswer(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }

    @Override
    protected String getOperator(){
        return "*";
    }
    
}