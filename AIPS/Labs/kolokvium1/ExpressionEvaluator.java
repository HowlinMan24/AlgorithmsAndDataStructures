package AIPS.Labs.kolokvium1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static void evaluateExpression(String expression) {
        // Vasiot kod tuka
        Stack<Integer> numbersStack = new Stack<>();
        Stack<Character> operatorsStack = new Stack<>();
        int number = 0;
        for (int i = 0; i < expression.length()-1; i++) {
            if (Character.isDigit(expression.charAt(i)) && Character.isDigit(expression.charAt(i + 1))) {
                number = number * 10 + Character.getNumericValue(expression.charAt(i));
            }else if(Character.isDigit(expression.charAt(i))){
                number = Character.getNumericValue(expression.charAt(i));
            }
            if (expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                operatorsStack.push(expression.charAt(i));
                numbersStack.push(number);
                number = 0;
            }
        }
        numbersStack.push(Character.getNumericValue(expression.charAt(expression.length() - 1)));
        System.out.println(numbersStack);
        System.out.println(operatorsStack);

        while (!numbersStack.isEmpty()) {
            int num1 = numbersStack.pop();
            int num2 = numbersStack.pop();
            char operator = operatorsStack.pop();
            if(operator == '*') {
                numbersStack.push(num1*num2);
            }else {
                if(operatorsStack.isEmpty()) {
                    numbersStack.push(num1+num2);
                    break;
                }
                if(operatorsStack.peek() == '+') {
                    numbersStack.push(num1+num2);
                }else {
                    int num3 = numbersStack.pop();
                    operatorsStack.pop();
                    numbersStack.push(num2*num3);
                    numbersStack.push(num1);
                    operatorsStack.push('+');
                }
            }
        }
        System.out.println(numbersStack.pop());
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(evaluateExpression(input.readLine()));
        evaluateExpression("10+100+1000+123*31");
    }

}