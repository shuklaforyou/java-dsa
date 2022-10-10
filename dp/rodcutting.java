package dp;

import java.util.*;

public class rodcutting {
    public static int f(int ind, int n, int[] price) {
        if (ind == 0)
            return n * price[ind];

        int nottake = 0 + f(ind - 1, n, price);
        int take = Integer.MIN_VALUE;
        int roodlegth = ind + 1;
        if (roodlegth <= n)
            take = price[ind] + f(ind, n - roodlegth, price);

        return Math.max(nottake, take);

    }

    public static int f(int ind, int n, int[] price, int[][] dp) {
        if (ind == 0)
            return n * price[ind];
        if (dp[ind][n] != -1)
            return dp[ind][n];
        int nottake = 0 + f(ind - 1, n, price, dp);
        int take = Integer.MIN_VALUE;
        int roodlegth = ind + 1;
        if (roodlegth <= n)
            take = price[ind] + f(ind, n - roodlegth, price, dp);

        return dp[ind][n] = Math.max(nottake, take);

    }

    public static void main(String args[]) {
        int n = 5;
        int price[] = { 42, 68, 35, 1, 70 };
        // int[][] dp = new int[n][n + 1];
        // for (int[] row : dp)
        // Arrays.fill(row, -1);
        // System.out.println(f(n - 1, n, price, dp));

        // for (int[] row : dp)
        // Arrays.fill(row, -1);

        // for (int i = 0; i <= n; i++) {
        // dp[0][i] = i * price[0];
        // }
        // for (int ind = 1; ind < n; ind++) {
        // for (int j = 0; j <= n; j++) {
        // int nottake = 0 + dp[ind - 1][j];
        // int take = Integer.MIN_VALUE;
        // int roodlegth = ind + 1;
        // if (roodlegth <= j)
        // take = price[ind] + dp[ind][j - roodlegth];

        // dp[ind][j] = Math.max(nottake, take);
        // }
        // }
        // System.out.println(dp[n - 1][n]);

        int[] prev = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            prev[i] = i * price[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int j = 0; j <= n; j++) {
                int nottake = 0 + prev[j];
                int take = Integer.MIN_VALUE;
                int roodlegth = ind + 1;
                if (roodlegth <= j)
                    take = price[ind] + prev[j - roodlegth];

                prev[j] = Math.max(nottake, take);
            }
        }
        System.out.println(prev[n]);
    }
}
