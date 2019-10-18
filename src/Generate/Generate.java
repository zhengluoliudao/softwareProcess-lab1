package Generate;

import Operator.Operator;

import java.util.Random;

public class Generate {

    public static int generateNumber(){
        Random random = new Random();
        return random.nextInt(100);
    }

    public static Operator generateOperator() {
        Random random = new Random();
        return Operator.values()[random.nextInt(2)];
    }

    public static void main(String[] args) {
        System.out.println(generateOperator());
    }
}

