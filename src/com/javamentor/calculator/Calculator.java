package com.javamentor.calculator;

public class Calculator {
    private Operand a;
    private Operand b;
    private String operator;

    public Calculator(String a, String b, String operator) {
        this.a = new Operand(a);
        this.b = new Operand(b);
        this.operator = operator;
        System.out.println(makeCalculation());
    }

    public Calculator(String[] args) {
        new Calculator(args[0], args[2], args[1]);
    }

    public String makeCalculation() {
        if (!a.typeEquals(b)) {
            throw new IllegalArgumentException("Операнды разного типа");
        }

        switch (operator) {
            case "+":
                return a.add(b);
            case "-":
                return a.subtract(b);
            case "*":
                return a.multiply(b);
            case "/":
                return a.divide(b);
            default:
                throw new IllegalArgumentException();
        }
    }

}
