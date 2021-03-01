package basic.dependency;

/**
 * Barista
 */
public class Barista {

    private EspressoMachine espressoMachine;

    public Barista(){
        super();
    }

    public void setEspressoMachine(EspressoMachine espressoMachine){
        this.espressoMachine = espressoMachine;
    }

    //Espresso 타입의 리턴값에 의존된다
    public Espresso makeEspresso(){
        CoffeeBeans coffeeBeans = new CoffeeBeans();
        Espresso espresso = this.espressoMachine.makeEspresso(coffeeBeans);
        return espresso;
    }

    //Milk 타입의 지역변수값에 의존된다
    public CafeLatte makeCafeLatte(){
        CoffeeBeans coffeeBeans = new CoffeeBeans();
        Espresso espresso = this.espressoMachine.makeEspresso(coffeeBeans);
        Milk milk = new Milk();

        CafeLatte cafeLatte = new CafeLatte();

        cafeLatte.setEspresso(espresso);
        cafeLatte.setMilk(milk);

        return cafeLatte;
    }

    @Override
    public String toString(){
        return "Barista";
    }
}