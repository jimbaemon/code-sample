package pattern.factory;

/**
 * AddOperation
 */
public class SubstractOperation extends AbstractOperation {

    @Override
    protected AbstractOperator getOperator() {
        return new SubstractOperator();
    }
    
}