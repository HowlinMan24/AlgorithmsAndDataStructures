package CodeFU.stuff.testingShise;

import java.util.Scanner;

public class FractionalKnapsack {


    public static void sort(int[] profit, int[] weight) {
        for (int i = 0; i < profit.length; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (profit[i] / (float) weight[i] < profit[j] / (float) weight[j]) {
                    int tempProfit = profit[i];
                    profit[i] = profit[j];
                    profit[j] = tempProfit;
                    int tempWeight = weight[i];
                    weight[i] = weight[j];
                    weight[j] = tempWeight;
                }
            }
        }
    }

    public static float fractionalKnapsack(int[] profit, int[] weight, int knapsackCapacity) {
        sort(profit, weight);
        /**
         * first sort them in order of most to the least profit/weight proportion
         * and then try to fit as much as possible from most to the least
         */
        float totalProfit = 0;
        for (int i = 0; i < profit.length; i++) {
            if (knapsackCapacity > weight[i]) {
                totalProfit += profit[i];
                knapsackCapacity -= weight[i];
            } else {
                float partialTakeFromWeight = knapsackCapacity / (float) weight[i];
                totalProfit += partialTakeFromWeight * profit[i];
//                knapsackCapacity = 0;
                break;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profit = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }
        int capacity = sc.nextInt();
        System.out.println(fractionalKnapsack(profit, weight, capacity));
    }
}
