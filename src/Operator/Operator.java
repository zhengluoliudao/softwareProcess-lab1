package Operator;

public enum Operator {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

    private final String string;

    private Operator(String string) {
        this.string = string;
    }

    public static Operator getOp(String op) {
        switch(op){
            case "+":
                return ADD;
            case "-":
                return SUBTRACT;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return this.string;
    }
}
