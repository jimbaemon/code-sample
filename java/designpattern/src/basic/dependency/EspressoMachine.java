package basic.dependency;

/**
 * EspressoMachine
 */
public class EspressoMachine {

    private int price = 300000;

    public EspressoMachine(){
        super();
    }

    //CoffeeBeans 타입의 함수 인자값이 의존된다
    public Espresso makeEspresso(CoffeeBeans coffeeBeans){
        System.out.println(coffeeBeans);

        return new Espresso();
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public String toString(){
        return "EspressoMachine";
    }
}