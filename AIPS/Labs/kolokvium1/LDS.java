package AIPS.Labs.kolokvium1;

import java.util.Arrays;
import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {

        // Vasiot kod tuka

        int counter = 1, maxCounter = 1;

        for (int i = 0; i < a.length; i++) {
            int current = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (current > a[j] && a[j] > a[j + 1]) {
                    counter++;
                    current = a[j + 1];
                }
                if (counter > maxCounter) {
                    maxCounter = counter;
                }
            }
            counter = 1;
        }

        return maxCounter;

    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}

