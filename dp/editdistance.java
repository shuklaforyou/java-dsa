package dp;

import java.util.*;

public class editdistance {
    public static int f(int i, int j, String s, String t, int[][] dp) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        if (s.charAt(i) == t.charAt(j))
            return 0 + f(i - 1, j - 1, s, t, dp);
        else
            return Math.min(1 + f(i, j - 1, s, t, dp),
                    (Math.min(1 + f(i - 1, j, s, t, dp), 1 + f(i - 1, j - 1, s, t, dp))));
    }

    public static void main(String args[]) {
        String s = "horse";
        String t = "ros";
        int n = s.length();
        int m = t.length();
        // int[][] dp = new int[n][m];
        // for (int[] row : dp)
        // Arrays.fill(row, -1);
        // System.out.println(f(n - 1, m - 1, s, t, dp));

        // int[][] dp=new int[n+1][m+1];
        // for(int[] row:dp)
        // Arrays.fill(row,0);
        // return f(n,m,word1,word2,dp);

        // for(int i=0;i<=n;i++){
        // dp[i][0]=i;
        // }
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 0);
        for (int j = 0; j <= m; j++) {
            dp[j] = j;
        }
        for (int i = 1; i < n + 1; i++) {
            int[] cur = new int[m + 1];
            cur[0] = i;
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    cur[j] = 0 + dp[j - 1];
                else
                    cur[j] = Math.min(1 + cur[j - 1], (Math.min(1 + dp[j], 1 + dp[j - 1])));
            }
            dp = cur;
        }
        System.out.println(dp[m]);
    }
}
