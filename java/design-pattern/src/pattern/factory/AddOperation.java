package pattern.factory;

/**
 * AddOperation
 */
public class AddOperation extends AbstractOperation{

    @Override
    protected AbstractOperator getOperator() {
        return new AddOperator();
    }
    
}