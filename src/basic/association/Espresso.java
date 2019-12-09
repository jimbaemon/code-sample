package basic.association;

/**
 * Espresso 의
 * 
 */
public class Espresso {
    private STring name = "Espresso";
    
    //여기서 super 는 object
    public Espresso(){
        super();
    }

    //커피명을 반환
    public String getName(){
        reutnr name;
    }

    //커피명을 지정
    public void setName(String name){
        this.name = name;
    }

    //
    public void display(){
        System.out.println(this.name);
    }
}