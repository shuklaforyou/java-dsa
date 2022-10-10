package dp;

import java.util.*;

import javax.swing.SortingFocusTraversalPolicy;

public class o1kanpsack {
    public static int f(int ind, int w, int[] weight, int[] val) {
        if (ind == 0) {
            if (weight[0] <= w)
                return val[0];
            else
                return 0;
        }
        int nottake = 0 + f(ind - 1, w, weight, val);
        int take = Integer.MIN_VALUE;
        if (weight[ind] <= w)
            take = val[ind] + f(ind - 1, w - weight[ind], weight, val);
        return Math.max(nottake, take);

    }

    public static int f(int ind, int w, int[] weight, int[] val, int[][] dp) {
        if (ind == 0) {
            if (weight[0] <= w)
                return val[0];
            else
                return 0;
        }
        if (dp[ind][w] != -1)
            return dp[ind][w];
        int nottake = 0 + f(ind - 1, w, weight, val, dp);
        int take = Integer.MIN_VALUE;
        if (weight[ind] <= w)
            take = val[ind] + f(ind - 1, w - weight[ind], weight, val, dp);
        return dp[ind][w] = Math.max(nottake, take);

    }

    public static void main(String args[]) {
        int weight[] = { 1, 2, 4, 5 };
        int val[] = { 5, 4, 8, 6 };
        int n = weight.length;
        int w = 5;
        // int[][] dp = new int[n][w + 1];
        // for (int[] row : dp)
        // Arrays.fill(row, -1);
        // System.out.println(f(n - 1, w, weight, val, dp));

        // for (int q = weight[0]; q <= w; q++) {
        // dp[0][q] = val[0];
        // }
        // for (int ind = 1; ind < n; ind++) {
        // for (int j = 0; j <= w; j++) {
        // int nottake = 0 + dp[ind - 1][j];
        // int take = -99999999;
        // if (weight[ind] <= j)
        // take = val[ind] + dp[ind - 1][j - weight[ind]];
        // dp[ind][j] = Math.max(nottake, take);
        // }
        // }
        // System.out.println(dp[n - 1][w]);

        // space optimize in below
        // int[] prev = new int[w + 1];
        // for (int q = weight[0]; q <= w; q++) {
        // prev[q] = val[0];
        // }
        // for (int ind = 1; ind < n; ind++) {
        // int[] curi = new int[w + 1];
        // for (int j = 0; j <= w; j++) {
        // int nottake = 0 + prev[j];
        // int take = -99999999;
        // if (weight[ind] <= j)
        // take = val[ind] + prev[j - weight[ind]];
        // curi[j] = Math.max(nottake, take);
        // }
        // prev = curi;
        // }
        // System.out.println(prev[w]);

        // super optimize in below---;
        int[] prev = new int[w + 1];
        for (int q = weight[0]; q <= w; q++) {
            prev[q] = val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int j = w; j >= 0; j--) {
                int nottake = 0 + prev[j];
                int take = -99999999;
                if (weight[ind] <= j)
                    take = val[ind] + prev[j - weight[ind]];
                prev[j] = Math.max(nottake, take);
            }
        }
        System.out.println(prev[w]);
    }
}
