package objectOriented.liskov_substitution_principle;

/**
 * Caculator
 */
public class Calculator {

    //추상화된 부모클래스만 가져온다
    private AbstractOperation operation;

    public int caculate(int firstNumber, int secondNumber){

        //나누기 연산 기능은 0으로 나누면 안되는 조건에 따라 특별 처리
        // if(operation instanceof DivideOperation){
        //     if(secondNumber == 0){
        //         return -999;
        //     }
        // }

        //instaceof 연산자 대신 부모클래스의 메서드를 활용
        if(operation.isInvalidNumber(firstNumber, secondNumber)){
            return -999;
        }

        return this.operation.operate(firstNumber, secondNumber);
    }

    public void setOperation(AbstractOperation operation){
        this.operation = operation;
    }
}