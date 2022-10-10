package dp;

import java.util.*;

public class coinschange2 {
    public static int f(int ind, int target, int[] arr) {
        if (ind == 0) {
            return (target % arr[0] == 0) ? 1 : 0;
        }
        int nottake = f(ind - 1, target, arr);
        int take = 0;
        if (arr[ind] <= target)
            take = f(ind, target - arr[ind], arr);

        return take + nottake;
    }

    public static int f(int ind, int target, int[] arr, int[][] dp) {
        if (ind == 0) {
            return (target % arr[0] == 0) ? 1 : 0;
        }
        if (dp[ind][target] != -1)
            return dp[ind][target];

        int nottake = f(ind - 1, target, arr);
        int take = 0;
        if (arr[ind] <= target)
            take = f(ind, target - arr[ind], arr);

        return dp[ind][target] = take + nottake;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int n = arr.length;
        int target = 4;
        int[][] dp = new int[n][target + 1];
        // for (int[] row : dp)
        // Arrays.fill(row, -1);
        // System.out.println(f(n - 1, target, arr, dp));

        // for (int[] row : dp)
        // Arrays.fill(row, 0);
        // for (int i = 0; i <= target; i++) {
        // if (i % arr[0] == 0)
        // dp[0][i] = 1;
        // }
        // for (int ind = 1; ind < n; ind++) {
        // for (int j = 0; j <= target; j++) {
        // int nottake = dp[ind - 1][j];
        // int take = 0;
        // if (arr[ind] <= j)
        // take = dp[ind][j - arr[ind]];

        // dp[ind][j] = take + nottake;

        // }
        // }
        // System.out.println(dp[n - 1][target]);

        long prev[] = new long[target + 1];
        Arrays.fill(prev, 0);
        for (int i = 0; i <= target; i++) {
            if (i % arr[0] == 0)
                prev[i] = 1;
        }
        for (int ind = 1; ind < n; ind++) {
            long curi[] = new long[target + 1];
            for (int j = 0; j <= target; j++) {
                long nottake = prev[j];
                long take = 0;
                if (arr[ind] <= j)
                    take = curi[j - arr[ind]];

                curi[j] = take + nottake;

            }
            prev = curi;
        }
        System.out.println(prev[target]);
    }
}