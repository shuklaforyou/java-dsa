package dp;

import java.util.*;

public class frogjumpK {
    static int f(int ind, int height[], int dp[], int k) {
        if (ind == 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];

        int minstep = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int jump = f(ind - j, height, dp, k) + Math.abs(height[ind] - height[ind - j]);
                minstep = Math.min(jump, minstep);
            }
        }
        return dp[ind] = minstep;

    }

    public static void main(String args[]) {
        int k = 2;
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(f(n - 1, height, dp, k));
        // System.out.println(Arrays.toString(dp));

    }
}