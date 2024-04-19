package CodeFU.stuff.testingShise;

import java.util.Arrays;

public class CoinProblem {

    public static void main(String[] args) {
        int[] coins = new int[23];
        for (int i = 0; i < 23; i++) {
            coins[i] = i + 1;
    }
        int[] sum = new int[coins.length - 1];
        for (int i = 0; i < 20; i++) {
            sum[coins[i]] = 1;
        }
//        Arrays.stream(sum).forEach(System.out::println);

        for (int i = 0; i < 20; ++i)
        {
            if (sum[i] == 0)
            { continue; }
            for (int j = 0; j < 23; ++j)
            {
                if((sum[i+coins[j]]==0)||(sum[i+coins[j]]>sum[i]+1)) {
                    sum[i+coins[j]] = sum[i] + 1;
                }
            }
        }

    }



}
