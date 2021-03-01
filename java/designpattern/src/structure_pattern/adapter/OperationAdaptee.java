package structure_pattern.adapter;

/**
 * 실제로는 사용될수 있는 호환성이 없지만 아답터를 사용해서 이용 가능하다
 */
public class OperationAdaptee {

    public static final int ADD_OPERATION = 1;
    public static final int SUBSTRACT_OPERATION = 2;
    public static final int MULTIPLY_OPERATION = 3;
    public static final int DIVIDE_OPERATION = 4;

    public OperationAdaptee(){
        super();
    }

    public int calculate(int operatorType, int firstNumber, int secondNumber){
        switch(operatorType){
            case ADD_OPERATION:
                return firstNumber + secondNumber;
            case SUBSTRACT_OPERATION:
                return firstNumber - secondNumber;
            case MULTIPLY_OPERATION:
                return firstNumber * secondNumber;
            case DIVIDE_OPERATION:
                return firstNumber / secondNumber;
        }

        return 0;
    }
    
}