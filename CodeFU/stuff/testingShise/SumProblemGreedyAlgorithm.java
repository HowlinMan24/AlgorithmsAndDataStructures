package CodeFU.stuff.testingShise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SumProblemGreedyAlgorithm {
    public static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static int minNumberCoins(int[] coins, int n, int sum, int[] numCoins) {
        Arrays.sort(coins);
        reverseArray(coins);
        System.out.println(Arrays.toString(coins));
        int totalCoins = 0, i = 0;
        /**
         * This algorithm works in a way that it takes the biggest number coins
         * it divides the sum tio see how many it can fit then it multiplies
         * that number with the value of the coins then it stores the value for
         * later use then it cycle through the rest of the coins
         * until the sum becomes 0 and then it finishes
         */
        while (sum > 0) {
            numCoins[i] = sum / coins[i];
            sum -= numCoins[i] * coins[i];
            totalCoins += numCoins[i];
            i++;
        }
        while (i < n) {
            numCoins[i] = 0;
            i++;
        }
        return totalCoins;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20};
        int n = 5;
        int sum = 79;
        int[] numberCoins = new int[n];
        System.out.println(minNumberCoins(coins, n, sum, numberCoins));
    }

}
