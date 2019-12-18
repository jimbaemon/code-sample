package pattern.factory;

/**
 * AddOperation
 */
public class MultiplyOperation extends AbstractOperation {

    @Override
    protected AbstractOperator getOperator() {
        return new MultiplyOperator();
    }
    
}