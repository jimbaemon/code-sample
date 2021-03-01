package pattern.abstract_factory;

/**
 * 실질적 계산을 구현하는 메서드
 */
public abstract class AbstractOperationProduct {

    private AbstractNumberOperandProduct firstNumberOperandProduct;
    private AbstractNumberOperandProduct secondNumberOperandProduct;

    public void setFirstNumberOperandProduct(AbstractNumberOperandProduct firstNumberOperandProduct){
        this.firstNumberOperandProduct = firstNumberOperandProduct;
    }

    public void setSecondNumberOperandProduct(AbstractNumberOperandProduct secondNumberOperandProduct){
        this.secondNumberOperandProduct = secondNumberOperandProduct;
    }

    public double add(){
        double firstNumber = getFirstNumber();
        double secondNumber = getSecondNumber();

        return firstNumber + secondNumber;
    }

    public double divide(){
        double firstNumber = getFirstNumber();
        double secondNumber = getSecondNumber();

        return firstNumber / secondNumber;
    }

    public double multiply(){
        double firstNumber = getFirstNumber();
        double secondNumber = getSecondNumber();

        return firstNumber * secondNumber;
    }

    public double substract(){
        double firstNumber = getFirstNumber();
        double secondNumber = getSecondNumber();

        return firstNumber - secondNumber;
    }

    public abstract void print();

    protected final double getFirstNumber(){
        return firstNumberOperandProduct.getNumber();
    }

    protected final double getSecondNumber(){
        return secondNumberOperandProduct.getNumber();
    }
    
}