package AIPS.Labs.lab1;

import java.util.Arrays;
import java.util.Scanner;

public class PushZero {

    static void pushZerosToBeginning(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] == 0) {
                    for (int k = i; k < j; k++) {
                        int temp =arr[k];
                        arr[k]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int enteredNumer = input.nextInt();
            array[i] = enteredNumer;
        }
        pushZerosToBeginning(array, n);
        System.out.println("Transformiranata niza e:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
