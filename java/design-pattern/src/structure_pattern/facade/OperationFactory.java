package structure_pattern.facade;

/**
 * OperationFactory
 */
public class OperationFactory {

    public AbstractOperationProduct createOperationProduct(String operator){
        if(operator.equals("+")){
            return new AddOperationProduct();
        }
        else if(operator.equals("-")){
            return new SubstractOperationProduct();
        }
        else if(operator.equals("*")){
            return new MultiplyOperationProduct();
        }
        else if(operator.equals("/")){
            return new DivideOperationProduct();
        }        
        return null;
    }
}