package basic.association;

/**
 * EspressoMachine
 */
public class EspressoMachine {

    //기본 가격 설정
    private int price = 300000;

    //생성자
    public EspressoMachine(){
        super();
    }

    //커피제작
    public Espresso makeEspresso(){
        return new Espresso();
    }

    //가격 전달
    public int getPrice(){
        return price;
    }

    //가격 선택
    public void setPrice(int price){
        this.price = price;
    }
    
}