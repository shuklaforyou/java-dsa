package dp;

import java.util.*;

public class unboundknapsack {
    public static int f(int ind, int w, int proft[], int[] value) {
        if (ind == 0)
            return ((int) w / proft[0]) * value[0];

        int nottake = 0 + f(ind - 1, w, proft, value);
        int take = 0;
        if (proft[ind] <= w)
            take = value[ind] + f(ind, w - proft[ind], proft, value);

        return Math.max(nottake, take);
    }

    public static int f(int ind, int w, int proft[], int[] value, int[][] dp) {
        if (ind == 0)
            return ((int) w / proft[0]) * value[0];
        if (dp[ind][w] != -1)
            return dp[ind][w];

        int nottake = 0 + f(ind - 1, w, proft, value);
        int take = 0;
        if (proft[ind] <= w)
            take = value[ind] + f(ind, w - proft[ind], proft, value);

        return dp[ind][w] = Math.max(nottake, take);
    }

    static int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {

        if (ind == 0) {
            return ((int) (W / wt[0])) * val[0];
        }

        if (dp[ind][W] != -1)
            return dp[ind][W];

        int notTaken = 0 + knapsackUtil(wt, val, ind - 1, W, dp);

        int taken = -99999999;
        if (wt[ind] <= W)
            taken = val[ind] + knapsackUtil(wt, val, ind, W - wt[ind], dp);

        return dp[ind][W] = Math.max(notTaken, taken);
    }

    public static void main(String args[]) {
        int n = 3;
        int w = 10;
        int proft[] = { 2, 4, 6 };
        int value[] = { 5, 11, 13 };
        int[][] dp = new int[n][w + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        // System.out.println(f(n - 1, w, proft, value, dp));
        // System.out.println(knapsackUtil(proft, value, n - 1, w, dp));

        // for (int[] row : dp)
        // Arrays.fill(row, 0);

        // for (int i = proft[0]; i <= w; i++) {
        // dp[0][i] = ((int) i / proft[0]) * value[0];
        // }

        // for (int ind = 1; ind < n; ind++) {
        // for (int j = 0; j <= w; j++) {
        // int nottake = 0 + dp[ind - 1][j];
        // int take = Integer.MIN_VALUE;
        // if (proft[ind] <= j)
        // take = value[ind] + dp[ind][j - proft[ind]];

        // dp[ind][j] = Math.max(nottake, take);
        // }
        // }
        // System.out.println(dp[n - 1][w]);

        int[] curi = new int[w + 1];
        for (int i = proft[0]; i <= w; i++) {
            curi[i] = ((int) i / proft[0]) * value[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= w; cap++) {

                int notTaken = curi[cap];

                int taken = Integer.MIN_VALUE;
                if (proft[ind] <= cap)
                    taken = value[ind] + curi[cap - proft[ind]];

                curi[cap] = Math.max(notTaken, taken);
            }
        }
        System.out.println(curi[w]);
    }
}
