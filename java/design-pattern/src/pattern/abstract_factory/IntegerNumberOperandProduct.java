package pattern.abstract_factory;

/**
 * 숫자를 제공해주는 클래스
 */
public class IntegerNumberOperandProduct extends AbstractNumberOperandProduct{

    //
    public IntegerNumberOperandProduct(String value){
        super(value);
    }    

    //숫자를 전달해줌 
    @Override
    public double getNumber(){
        String value = getvalue();
        return (int)(Double.parseDouble(value));
    }
}