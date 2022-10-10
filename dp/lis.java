package dp;

import java.util.*;

public class lis {
    public static void main(String args[]) {
        int[] nums = { 7, 7, 7, 7, 7, 7, 7 };
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 2];
        for (int[] row : dp)
            Arrays.fill(row, 0);
        // return f(0,-1,nums,n,dp);

        for (int ind = n - 3; ind >= 0; ind--) {
            for (int previndx = n; previndx >= 0; previndx--) {
                int len = 0;
                len = 0 + dp[ind + 1][previndx];
                if (previndx == 0 || nums[ind] > nums[previndx - 1])
                    len = Math.max(len, 1 + dp[ind + 1][ind]);
                dp[ind][previndx] = len;
            }
        }
        for (int i = n; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
