package objectOriented.single_responsibility_principle;

/**
 * Caculator
 */
public class Calculator {
    
    //기능별로 연산 클래스를 구현하여 포함
    private AddOperation addOperation;
    private SubstractOperation substractOperation;
    private MultiplyOperation multiplyOperation;
    private DivideOperation divideOperation;

    public AddOperation getAddOperation() {
        return this.addOperation;
    }
    public void setAddOperation(AddOperation addOperation) {
        this.addOperation = addOperation;
    }

    public void setSubstractOperation(SubstractOperation substractOperation) {
    	this.substractOperation = substractOperation;
    }

    public void setMultiplyOperation(MultiplyOperation multiplyOperation) {
    	this.multiplyOperation = multiplyOperation;
    }

    public void setDivideOperation(DivideOperation divideOperation) {
        this.divideOperation = divideOperation;
    }

    //해당 함수는 길만 나눠주는 역활 Controller의 느낌
    public int caclulate(String operator, int firstNumber, int secondNumber){
        int answer = 0;

        //연산기능을 연산 클래스에 의존하여 처리
        if(operator.equals("+")){
            answer = this.addOperation.operate(firstNumber, secondNumber);
        }
        if(operator.equals("-")){
            answer = this.substractOperation.operate(firstNumber, secondNumber);
        }
        if(operator.equals("*")){
            answer = this.multiplyOperation.operate(firstNumber, secondNumber);
        }
        if(operator.equals("/")){
            answer = this.divideOperation.operate(firstNumber, secondNumber);
        }
        
        return answer;
    }

    
    
}