package pattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Client
 */
public class Client {

    public static void main(String[] args) {
        int firstNumber = 100;
        int secondNumber = 20;

        List<AbstractOperationBuilder> operationBuilders = new ArrayList<>();
        AbstractOperationBuilder add = new AddOperationBuilder(firstNumber, secondNumber);
        AbstractOperationBuilder sub = new SubstractOperationBuilder(firstNumber, secondNumber);
        AbstractOperationBuilder mul = new MultiplyOperationBuilder(firstNumber, secondNumber);
        AbstractOperationBuilder div = new DivideOperationBuilder(firstNumber, secondNumber);
        operationBuilders.add(add);
        operationBuilders.add(sub);
        operationBuilders.add(mul);
        operationBuilders.add(div);

        for(AbstractOperationBuilder i : operationBuilders){
            OperationDirector operationDirector = new OperationDirector(i);
            operationDirector.construct();
        }
    }
}
