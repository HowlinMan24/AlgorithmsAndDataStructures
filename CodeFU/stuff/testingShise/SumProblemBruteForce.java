package CodeFU.stuff.testingShise;

import java.util.Scanner;

public class SumProblemBruteForce {

    public static int minNumberCoins(int sum) {
        int totalCoins = Integer.MAX_VALUE;
        int numCoins = 0;
        int currentSum = 0;
        /**
         * This algorithm works in away that it takes all possible
         * sums for coins and then checks if it is the same as the sum
         * in the argument and then finds which combination of coins
         * would give the sum in the argument with the least coins
         */
        for (int num50 = 0; num50 <= (sum / 50); num50++) {
            for (int num10 = 0; num10 <= (sum / 10); num10++) {
                for (int num5 = 0; num5 <= (sum / 5); num5++) {
                    for (int num2 = 0; num2 <= (sum / 2); num2++) {
                        for (int num1 = 0; num1 <= (sum / 1); num1++) {
                            currentSum = 50 * num50 + 10 * num10 + 5 * num5 + 2 * num2 + num1;
                            if (currentSum == sum) {
                                numCoins = num50 + num10 + num5 + num2 + num1;
                                if (numCoins < totalCoins) {
                                    totalCoins = numCoins;
                                }
                            }
                        }
                    }
                }
            }
        }
        return totalCoins;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        System.out.println(minNumberCoins(sum));
    }

}
