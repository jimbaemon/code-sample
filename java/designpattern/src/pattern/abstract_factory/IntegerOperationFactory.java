package pattern.abstract_factory;

/**
 * 클래스를 제공해주는 클래스
 */
public class IntegerOperationFactory extends AbstractOperationFactory{

    @Override
    public AbstractOperationProduct createOperationProduct() {
        return new IntegerOperationProduct();
    }

    @Override
    public AbstractNumberOperandProduct createNumberOperandProduct(String value) {
        return new IntegerNumberOperandProduct(value);
    }

        
    
}