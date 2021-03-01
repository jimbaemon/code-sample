package pattern.abstract_factory;

/**
 * 클래스를 전달하는 클래스
 */
public abstract class AbstractOperationFactory {


    public abstract AbstractOperationProduct createOperationProduct();


    public abstract AbstractNumberOperandProduct createNumberOperandProduct(String value);

    
}