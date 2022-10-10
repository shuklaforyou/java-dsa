package dp;

import java.util.*;

public class buysell3 {
    public static int f(int ind, int buy, int cap, int[] prices, int n) {
        if (ind == n || cap == 0)
            return 0;
        int profit = 0;
        if (buy == 0) {
            profit = Math.max(-prices[ind] + f(ind + 1, 1, cap, prices, n), 0 + f(ind + 1, 0, cap, prices, n));
        }

        if (buy == 1) {
            profit = Math.max(prices[ind] + f(ind + 1, 0, cap - 1, prices, n), 0 + f(ind + 1, 1, cap, prices, n));
        }
        return profit;
    }

    public static int f(int ind, int buy, int cap, int[] prices, int n, int[][][] dp) {
        if (ind == n || cap == 0)
            return 0;
        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];
        int profit = 0;
        if (buy == 0) {
            profit = Math.max(-prices[ind] + f(ind + 1, 1, cap, prices, n, dp), 0 + f(ind + 1, 0, cap, prices, n, dp));
        }

        if (buy == 1) {
            profit = Math.max(prices[ind] + f(ind + 1, 0, cap - 1, prices, n, dp),
                    0 + f(ind + 1, 1, cap, prices, n, dp));
        }
        return dp[ind][buy][cap] = profit;
    }

    public static void main(String args[]) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        // for(int[][] row:dp)
        // for(int[] eow:row)
        // Arrays.fill(eow,-1);

        // System.out.println(f(0,0,2,prices,n,dp));
        for (int[][] row : dp)
            for (int[] eow : row)
                Arrays.fill(eow, 0);
        // return f(0,0,2,prices,n,dp);
        int profit = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 0) {
                        dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind + 1][1][cap], 0 + dp[ind + 1][0][cap]);
                    }

                    if (buy == 1) {
                        dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind + 1][0][cap - 1], 0 + dp[ind + 1][1][cap]);
                    }
                }
            }
        }
        System.out.println(dp[0][0][2]);

        int[][] dp = new int[2][3];
        int[][] cur = new int[2][3];
        for (int[] eow : dp)
            Arrays.fill(eow, 0);
        for (int[] eow : cur)
            Arrays.fill(eow, 0);

        // return f(0,0,2,prices,n,dp);
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 0) {
                        cur[buy][cap] = Math.max(-prices[ind] + dp[1][cap], 0 + dp[0][cap]);
                    }

                    if (buy == 1) {
                        cur[buy][cap] = Math.max(prices[ind] + dp[0][cap - 1], 0 + dp[1][cap]);
                    }
                }
            }
            dp = cur;
        }
        System.out.println(dp[0][2]);
    }
}
