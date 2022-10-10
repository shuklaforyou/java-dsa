package dp;

import java.util.*;

public class numsubset {
    public static int f(int ind, int sum, int num[]) {
        if (sum == 0)
            return 1;
        if (ind == 0)
            return (num[0] == sum ? 1 : 0);

        int nottake = f(ind - 1, sum, num);
        int take = 0;
        if (num[ind] <= sum)
            take += f(ind - 1, sum - num[ind], num);
        return nottake + take;

    }

    public static int f(int ind, int sum, int num[], int[][] dp) {
        if (sum == 0)
            return 1;
        if (ind == 0)
            return (num[0] == sum ? 1 : 0);
        if (dp[ind][sum] != -1)
            return dp[ind][sum];
        int nottake = f(ind - 1, sum, num);
        int take = 0;
        if (num[ind] <= sum)
            take += f(ind - 1, sum - num[ind], num);
        return dp[ind][sum] = nottake + take;

    }

    public static void main(String args[]) {
        int num[] = { 1, 2, 2, 3 };
        int n = num.length;
        int sum = 3;
        int[][] dp = new int[n][sum + 1];
        // for (int[] row : dp)
        // Arrays.fill(row, -1);
        // System.out.println(f(n - 1, sum, num, dp));

        // for (int[] row : dp)
        // Arrays.fill(row, 0);
        // for (int i = 0; i < n; i++)
        // dp[i][0] = 1;

        // if (num[0] <= sum)
        // dp[0][num[0]] = 1;

        // for (int i = 1; i < n; i++) {
        // for (int tar = 0; tar <= sum; tar++) {
        // int nottake = dp[i - 1][tar];
        // int take = 0;
        // if (num[i] <= tar)
        // take += dp[i - 1][tar - num[i]];
        // dp[i][tar] = nottake + take;
        // }
        // }
        // System.out.println(dp[n - 1][sum]);

        int[] prev = new int[sum + 1];
        prev[0] = 1;

        if (num[0] <= sum)
            prev[num[0]] = 1;

        for (int i = 1; i < n; i++) {
            int[] curi = new int[sum + 1];
            for (int tar = 0; tar <= sum; tar++) {
                int nottake = prev[tar];
                int take = 0;
                if (num[i] <= tar)
                    take += prev[tar - num[i]];
                curi[tar] = nottake + take;
            }
            prev = curi;
        }
        System.out.println(prev[sum]);
    }
}
