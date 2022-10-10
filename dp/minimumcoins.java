package dp;

import java.util.*;

public class minimumcoins {
    public static int f(int ind, int t, int[] arr) {
        if (ind == 0)
            if (t % arr[ind] == 0)
                return t / arr[ind];
            else
                return 99999999;

        int nottake = 0 + f(ind - 1, t, arr);
        int take = 99999999;
        if (arr[ind] <= t)
            take = 1 + f(ind, t - arr[ind], arr);

        return Math.min(nottake, take);
    }

    public static int f(int ind, int t, int[] arr, int[][] dp) {
        if (ind == 0)
            if (t % arr[ind] == 0)
                return t / arr[ind];
            else
                return 99999999;
        if (dp[ind][t] != -1)
            return dp[ind][t];
        int nottake = 0 + f(ind - 1, t, arr);
        int take = 99999999;
        if (arr[ind] <= t)
            take = 1 + f(ind, t - arr[ind], arr);

        return dp[ind][t] = Math.min(nottake, take);
    }

    public static void main(String args[]) {
        int n = 3;
        int t = 7;
        int arr[] = { 1, 2, 3 };
        int[][] dp = new int[n][t + 1];
        // for (int[] row : dp)
        // Arrays.fill(row, -1);
        // System.out.println(f(n - 1, t, arr, dp));

        // for (int[] row : dp)
        // Arrays.fill(row, 0);
        // for (int i = 0; i <= t; i++) {
        // if (i % arr[0] == 0)
        // dp[0][i] = i / arr[0];
        // else
        // dp[0][i] = (int) Math.pow(10, 9);
        // }
        // for (int ind = 1; ind < n; ind++) {
        // for (int target = 0; target <= t; target++) {

        // int notTake = 0 + dp[ind - 1][target];
        // int take = (int) Math.pow(10, 9);
        // if (arr[ind] <= target)
        // take = 1 + dp[ind][target - arr[ind]];

        // dp[ind][target] = Math.min(notTake, take);
        // }
        // }

        // int ans = dp[n - 1][t];
        // if (ans >= (int) Math.pow(10, 9))
        // ans = -1;
        // System.out.println(ans);

        int[] prev = new int[t + 1];
        for (int i = 0; i <= t; i++) {
            if (i % arr[0] == 0)
                prev[i] = i / arr[0];
            else
                prev[i] = (int) Math.pow(10, 9);
        }
        for (int ind = 1; ind < n; ind++) {
            int[] curi = new int[t + 1];
            for (int target = 0; target <= t; target++) {

                int notTake = 0 + prev[target];
                int take = (int) Math.pow(10, 9);
                if (arr[ind] <= target)
                    take = 1 + curi[target - arr[ind]];

                curi[target] = Math.min(notTake, take);
            }
            prev = curi;
        }

        int ans = prev[t];
        if (ans >= (int) Math.pow(10, 9))
            ans = -1;
        System.out.println(ans);

    }
}
