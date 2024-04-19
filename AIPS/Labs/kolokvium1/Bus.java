package AIPS.Labs.kolokvium1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // Vasiot kod tuka

        int sum = 0, max = 0, min = 0;
        boolean flag = false;
        // Max
        if (N == 1 && M == 0) {
            max = 100;
            flag = true;
        } else if (N == 1 && M > 0) {
            max = 100 + (M - 1) * 100;
            flag = true;
        } else if (N > 1 && M == 0) {
            max = N * 100;
            flag = true;
        } else {
            max = N * 100 + (M - 1) * 100;
            flag = true;
        }

        if (flag) {
            if (M == 0 || M == 1)
                min = N * 100;
            else if (M > N)
                min = M * 100;
            else if (M < N)
                min = N * 100;
            else
                min = 100 + (M - 1) * 100;
        }
        System.out.println(min);
        System.out.println(max);


    }

}
