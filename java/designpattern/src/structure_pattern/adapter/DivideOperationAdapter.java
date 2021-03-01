package structure_pattern.adapter;

/**
 * DivideOperation
 */
public class DivideOperationAdapter extends AbstractOperationTarget{

    protected OperationAdaptee operationAdaptee;

    public DivideOperationAdapter(OperationAdaptee operationAdaptee){
        this.operationAdaptee = operationAdaptee;
    }

    //인터페이스와 동일한 기능을 하도록 연결(adapt) 하는 역활 수행
    public int operate(int firstNumber, int secondNumber){
        return operationAdaptee.calculate(OperationAdaptee.DIVIDE_OPERATION, firstNumber, secondNumber);
    }
}