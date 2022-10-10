package dp;

import java.util.*;

public class subsetsumequaltoK {

    // recusive functions in below--;
    public static boolean f(int ind, int target, int arr[]) {
        if (target == 0)
            return true;
        if (ind == 0)
            return (arr[0] == target);

        boolean nottake = f(ind - 1, target, arr);
        boolean take = false;
        if (target >= arr[ind])
            ;
        take = f(ind - 1, target - arr[ind], arr);

        return nottake || take;

    }

    // memoriazations functions in below--;
    public static boolean f(int ind, int target, int arr[], int dp[][]) {
        if (target == 0)
            return true;
        if (ind == 0)
            return (arr[0] == target);
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        boolean nottake = f(ind - 1, target, arr, dp);
        boolean take = false;
        if (target >= arr[ind])
            take = f(ind - 1, target - arr[ind], arr, dp);
        dp[ind][target] = nottake || take ? 1 : 0;

        return nottake || take;

    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4 };
        int n = arr.length;
        int k = 5;
        // int target = k;
        // int[][] dp = new int[n][k + 1];
        // boolean[][] dp = new boolean[n][k + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // System.out.println((f((n - 1), target, arr, dp)));

        // tabulations functions in below--;
        // for (int i = 0; i < n - 1; i++) {
        // dp[i][0] = true;
        // if (arr[0] <= k)
        // dp[0][arr[0]] = true;
        // dp[0][arr[0]] = true;
        // }
        // for (int ind = 1; ind < n; ind++) {
        // for (int target = 1; target <= k; target++) {
        // boolean nottake = dp[ind - 1][target];
        // boolean take = false;
        // if (target >= arr[ind])
        // take = dp[ind - 1][target - arr[ind]];
        // dp[ind][target] = nottake || take;

        // }
        // }
        // System.out.println(dp[n - 1][k]);

        boolean[] prev = new boolean[k + 1];
        prev[0] = true;
        if (arr[0] <= k)
            prev[arr[0]] = true;
        for (int ind = 1; ind < n; ind++) {
            boolean cur[] = new boolean[k + 1];
            cur[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean nottake = prev[target];
                boolean take = false;
                if (target >= arr[ind])
                    take = prev[target - arr[ind]];
                cur[target] = nottake || take;

            }
            prev = cur;
        }
        System.out.println(prev[k]);
    }

}