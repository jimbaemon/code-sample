package basic.dependency;

/**
 * CoffeeBeans
 * 함수인자값 의존
 */
public class CoffeeBeans {
    private String countryOrigin = "Colombia";

    public CoffeeBeans(){
        super();
    }

    @Override
    public String toString(){
        return "CoffeBeans ["+this.countryOrigin+"]";
    }
    
}