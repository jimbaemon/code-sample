package pattern.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Client
 */
public class Client {

    public static void main(String[] args) {
        int firstNumber = 100;
        int secondNumber = 20;

        List<AbstractOperation> operation = new ArrayList<>();
        operation.add(new AddOperation());
        operation.add(new SubstractOperation());
        operation.add(new MultiplyOperation());
        operation.add(new DivideOperation());

        for(AbstractOperation i : operation){
            i.setFirstNumber(firstNumber);
            i.setSecondNumber(secondNumber);

            i.operate();
        }
    }
}