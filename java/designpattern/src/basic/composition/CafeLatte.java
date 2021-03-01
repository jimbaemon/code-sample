package basic.composition;


public class CafeLatte {
    
    private String name = "CafeLatte";
    
    //CafeLatte의 멤버변수로 선언
    private Espresso espresso = new Espresso();
    private Milk milk = new Milk();

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

    public void display(){
        System.out.println(this.name + "(" + this.espresso + " + " + this.milk + ")");
    }

    @Override
    public String toString(){
        return "CafeLatte";
    }
}