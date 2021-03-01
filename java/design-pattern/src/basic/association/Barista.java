package basic.association;

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

    public Espresso makEspresso(){
        return espressoMachine.makeEspresso();
    }
    
}