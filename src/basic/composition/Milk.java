package basic.composition;


public class Milk {
    private String name = "Milk";
    
    //여기서 super 는 object
    public Milk(){
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

    @Override
    public String toString(){
        return "Milk";
    }
}