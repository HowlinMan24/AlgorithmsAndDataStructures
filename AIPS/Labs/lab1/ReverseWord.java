package AIPS.Labs.lab1;

import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        int n = word.length();
        StringBuilder reverse = new StringBuilder();
        for (int i = 0; i < n; i++) {
            reverse.append(word.charAt(n - i - 1));
        }
        System.out.print(reverse);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i=0;i<n;i++) {
            String st = input.next();
            printReversed(st);
            n--;
        }
    }
}
