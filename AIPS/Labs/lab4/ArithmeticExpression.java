package AIPS.Labs.lab4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Stack;

//interface Stack<E> {
//
//    boolean isEmpty();
//
//    E peek();
//
//    void clear();
//
//    void push(E object);
//
//    E pop();
//
//    int size();
//
//}

class ArrayStack<E> extends Stack<E> {
    public E[] elements;
    public int depth;

    public ArrayStack(int maxDepth) {
        this.depth = 0;
        this.elements = (E[]) new Object[maxDepth];
    }

//    public boolean isEmpty() {
//        return (depth == 0);
//    }
//
//    public E peek() {
//        if (depth == 0)
//            throw new NoSuchElementException();
//        return elements[depth - 1];
//    }
//
//    public int size() {
//        return depth;
//    }
//
//    @Override
//    public void clear() {
//        for (int i = 0; i < depth; i++)
//            elements[i] = null;
//        depth = 0;
//    }
//
//    @Override
//    public void push(E object) {
//        elements[depth++] = object;
//    }
//
//    @Override
//    public E pop() {
//        if (depth == 0)
//            throw new NoSuchElementException();
//        E topMost = elements[--depth];
//        elements[depth] = null;
//        return topMost;
//    }

}

public class ArithmeticExpression {

    // funkcija za presmetuvanje na izrazot pocnuvajki
    // od indeks l, zavrsuvajki vo indeks r
    static int presmetaj(char c[], int l, int r) {
        Stack<Character> expression = new ArrayStack<Character>(r + 1);
        Stack<Integer> numbers = new ArrayStack<Integer>(r + 1);
        int a, b, sum = 0;
        for (int i = l; i < r + 1; i++) {
            if (Character.isDigit(c[i])) {
                numbers.push(Character.getNumericValue(c[i]));
            } else if (c[i] == '+' || c[i] == '-') {
                expression.push(c[i]);
            }
            if (c[i] == ')' && numbers.size() == 2) {
                b = numbers.pop();
                a = numbers.pop();
                if (expression.peek() == '+') {
                    if (expression.size() == 2) {
                        int temp = b + a;
                        expression.pop();
                        if (expression.peek() == '+') {
                            sum += temp;
                        } else {
                            sum -= temp;
                        }
                        expression.pop();
                    } else {
                        sum += b + a;
                        expression.pop();
                    }
                } else {
                    if (expression.size() == 2) {
                        int temp = b - a;
                        expression.pop();
                        if (expression.peek() == '+') {
                            sum += temp;
                        } else {
                            sum -= temp;
                        }
                        expression.pop();
                    } else {
                        sum += b - a;
                        expression.pop();
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

//        int rez = presmetaj(exp, 0, exp.length - 1);
//        System.out.println(rez);

        System.out.println(presmetaj(exp, 0, exp.length - 1));

        br.close();

    }

}

