package pattern.builder;

/**
 * OperationDirector
 */
public class OperationDirector {

    private AbstractOperationBuilder builder;

    //빌더를 생성자를 통해 주입
    public OperationDirector(AbstractOperationBuilder builder){
        this.builder = builder;
    }

    public void construct(){
        builder.buildFirstNumber();
        builder.buildOperator();
        builder.buildSecondNumber();
        builder.buildAnswer();

        StringBuffer result = builder.getResult();

        print(result);
    }

    private void print(StringBuffer result){
        System.out.println(result);
    }
}