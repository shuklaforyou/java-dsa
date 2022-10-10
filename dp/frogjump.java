package dp;

import java.util.*;

public class frogjump {
    // memorizations of code
    public static int f(int ind, int heights[], int dp[]) {
        if (ind == 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int left = f(ind - 1, heights, dp) + Math.abs(heights[ind] - heights[ind - 1]);

        int right = Integer.MAX_VALUE;
        if (ind > 1)
            right = f(ind - 2, heights, dp) + Math.abs(heights[ind] - heights[ind - 2]);
        return dp[ind] = Math.min(left, right);
    }

    public static void main(String args[]) {
        int n = 5;
        int height[] = { 30, 10, 60, 10, 60, 50 };
        // int x = f(n - 1, height, dp);
        // System.out.println(x);
        // tabulaions work of code

        // for (int i = 1; i <= n; i++) {
        // int fs = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
        // int ss = Integer.MAX_VALUE;
        // if (i > 1)
        // ss = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
        // dp[i] = Math.min(fs, ss);
        // }
        // System.out.println(dp[n - 1]);
        int prev2 = 0;
        int prev1 = 0;

        for (int i = 1; i < n; i++) {
            int fs = prev1 + Math.abs(height[i] - height[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1)
                ss = prev2 + Math.abs(height[i] - height[i - 2]);
            int curi = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = curi;
        }
        System.out.println(prev1);
    }
}
