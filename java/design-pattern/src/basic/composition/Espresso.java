package basic.composition;


public class Espresso {
    private String name = "Espresso";
    
    //여기서 super 는 object
    public Espresso(){
        super();
    }

    //커피명을 반환
    public String getName(){
        return name;
    }

    //커피명을 지정
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Espresso";
    }
}