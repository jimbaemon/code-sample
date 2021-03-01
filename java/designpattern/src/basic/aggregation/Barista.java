package basic.aggregation;

/**
 * Barista
 */
public class Barista {

    //Barista의 멤버변수인 EspressoMachine
    private EspressoMachine espressoMachine;

    public Barista(){
        super();
    }

    //EspressoMachine 인스턴스를 입력 받음
    public void setEspressoMachine(EspressoMachine espressoMachine) {
        this.espressoMachine = espressoMachine;
    }

    //이곳에서 집합(aggregation)관계인 우유와 에스프레소 카페라떼에 집어넣어줌
    public CafeLatte makeCafeLatte(){
        Espresso espresso = this.espressoMachine.makeEspresso(); // 에스프레소 생성
        Milk milk = new Milk(); // 우유 가져와서

        CafeLatte cafeLatte = new CafeLatte();

        cafeLatte.setEspresso(espresso); //에스프레소 붇고
        cafeLatte.setMilk(milk); // 우유 붇고

        return cafeLatte; //돌려줌
    }

    public Espresso makEspresso(){
        return espressoMachine.makeEspresso();
    }

    @Override
    public String toString(){
        return "Barista";
    }
    
}