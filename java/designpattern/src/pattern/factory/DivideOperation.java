package pattern.factory;

/**
 * AddOperation
 */
public class DivideOperation extends AbstractOperation {

    @Override
    protected AbstractOperator getOperator() {
        return new DivideOperator();
    }
    
}