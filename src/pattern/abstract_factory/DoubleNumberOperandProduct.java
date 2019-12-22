package pattern.abstract_factory;

/**
 * DoubleNumberOperandProduct
 */
public class DoubleNumberOperandProduct extends AbstractNumberOperandProduct{

    public DoubleNumberOperandProduct(String value){
        super(value);
    }

    @Override
    public double getNumber(){
        String value = getvalue();
        return Double.parseDouble(value);
    }
    
}