package pattern.abstract_factory;

/**
 * 숫자를 제공해 주는 메서드
 */
public abstract class AbstractNumberOperandProduct {

    private String value;

    public AbstractNumberOperandProduct(String value){
        this.value = value;
    }

    public abstract double getNumber();

    protected final String getvalue(){
        return value;
    } 
}