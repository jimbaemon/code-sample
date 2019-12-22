package pattern.abstract_factory;

/**
 * DoubleOperationFactroy
 */
public class DoubleOperationFactroy extends AbstractOperationFactory{

    @Override
    public AbstractOperationProduct createOperationProduct(){
        return new DoubleOperationProduct();
    }

    @Override
    public AbstractNumberOperandProduct createNumberOperandProduct(String value){
        return new DoubleNumberOperandProduct(value);
    }
    
}