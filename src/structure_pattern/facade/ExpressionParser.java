package structure_pattern.facade;

/**
 * ExpressionParser
 */
public class ExpressionParser {

    private final String[] operators = {"+", "-", "*", "/"};

    private String operatorToken;
    private String firstNumberToken;
    private String secondNumberToken;

    public ExpressionParser(){
        super();
    }

    public String getOperatorToken(){
        return operatorToken;
    }

    public String getFirstNumberToken(){
        return firstNumberToken;
    }

    public String getSecondNumberToken(){
        return secondNumberToken;
    }

    public void parse(String expression){
        int operatorIndex = -1;

        for(int i=0;i<operators.length;i++){
            operatorIndex = expression.indexOf(operators[i]);
            if(operatorIndex != -1){
                this.operatorToken = operators[i];
                break;
            }
        }   

        this.firstNumberToken = expression.substring(0, operatorIndex);
        this.secondNumberToken = expression.substring(operatorIndex + 1);
    }
}