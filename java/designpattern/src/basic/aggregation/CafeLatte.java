package basic.aggregation;


public class CafeLatte {
    
    private String name = "CafeLatte";
    
    //CafeLatte의 멤버변수로 선언
    private Espresso espresso;
    private Milk milk;

    //여기서 super 는 object
    public CafeLatte(){
        super();
    }

    //우유명을 반환
    public String getName(){
        return name;
    }

    //우유명을 지정
    public void setName(String name){
        this.name = name;
    }

    //CafeLatte의 멤버변수를 외부에서 설정하는 메소드를 제공/
    public void setEspresso(Espresso espresso) {
        this.espresso = espresso;
    }

    public void setMilk(Milk milk) {
        this.milk = milk;
    }

    public void display(){
        System.out.println(this.name + "(" + this.espresso + " + " + this.milk + ")");
    }

    @Override
    public String toString(){
        return "CafeLatte";
    }
}