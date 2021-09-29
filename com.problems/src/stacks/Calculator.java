package stacks;

import java.util.Stack;

/**
 * @author Neha.Sony
 */

public class Calculator {
    static Stack<String> operator = new Stack<String>();
    static Stack<Double> operands = new Stack<Double>();
    static Stack<String> braces = new Stack<String>();

    public static void main(String[] args) {
        int i = 0;
        String expressionDefinition = "((((3+5)*4))+3)";
        while (i < expressionDefinition.length()) {
            String s = String.valueOf(expressionDefinition.charAt(i));
            i++;
            switch (s) {
                case "(":
                    braces.push(s);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    operator.push(s);
                    break;
                case ")":
                    if (!operator.isEmpty()) {
                        String op = operator.pop();
                        double v = operands.pop();
                        switch (op) {
                            case "+":
                                v = operands.pop() + v;
                                break;
                            case "-":
                                v = operands.pop() - v;
                                break;
                            case "*":
                                v = operands.pop() * v;
                                break;
                            case "/":
                                v = operands.pop() / v;
                                break;
                        }
                        operands.push(v);
                        if (braces.size() > 0) {
                            braces.pop();
                        }
                    } else {
                        if(!s.equals(")"))
                        operands.push(Double.parseDouble(s));
                    }
                default:if(!s.equals(")"))
                    operands.push(Double.parseDouble(s));
            }

        }
        System.out.println(operands.pop());
    }
}


/*
* String s = String.valueOf(expressionDefinition.charAt(i));
            i++;
            if (s.equals("(")) braces.push(s) ;
            else if (s.equals("+")) operator.push(s);
            else if (s.equals("-")) operator.push(s);
            else if (s.equals("*")) operator.push(s);
            else if (s.equals("/")) operator.push(s);
            else if (s.equals(")")) {
                if (!operator.isEmpty()) {
                    String op = operator.pop();
                    double v = operands.pop();
                    if (op.equals("+")) v = operands.pop() + v;
                    else if (op.equals("-")) v = operands.pop() - v;
                    else if (op.equals("*")) v = operands.pop() * v;
                    else if (op.equals("/")) v = operands.pop() / v;
                    operands.push(v);
                }
                braces.pop();
            } else operands.push(Double.parseDouble(s));
* */