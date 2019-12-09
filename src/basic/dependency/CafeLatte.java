package basic.dependency;

/**
 * CafeLatte
 */
public class CafeLatte {

    private String name ="CafeLatte";

    private Espresso espresso;
    private Milk milk;

    public CafeLatte(){
        super();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEspresso(Espresso espresso){
        this.espresso = espresso;
    }

    public void setMilk(Milk milk){
        this.milk = milk;
    }

    public void display(){
        System.out.println(this.name + "(" + this.espresso + " + " +this.milk + ")");
    }

    @Override
    public String toString(){
        return "CafeLatte";
    }
}