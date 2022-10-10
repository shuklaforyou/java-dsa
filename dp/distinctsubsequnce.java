package dp;

import java.util.*;

public class distinctsubsequnce {
    static int prime = (int) (Math.pow(10, 9) + 7);

    public static int f(int i, int j, String s, String t) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;

        if (s.charAt(i) == t.charAt(j)) {
            return (f(i - 1, j - 1, s, t) + f(i - 1, j, s, t));
        } else {
            return f(i - 1, j, s, t);
        }

    }

    public static int f(int i, int j, String s, String t, int[][] dp) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = (f(i - 1, j - 1, s, t, dp) + f(i - 1, j, s, t, dp));
        } else {
            return dp[i][j] = f(i - 1, j, s, t, dp);
        }

    }

    public static void main(String args[]) {
        String s = "babgbag";
        String t = "bag";
        int n = s.length();
        int m = t.length();
        // int[][] dp=new int[n+1][m+1];
        // for(int[] row:dp)
        // Arrays.fill(row,0);
        int[] prev = new int[m + 1];
        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] cur = new int[m + 1];
            cur[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    cur[j] = (prev[j - 1] + prev[j]) % prime;
                } else {
                    cur[j] = prev[j];
                }
            }
            prev = cur;
        }
        System.out.println(prev[m]);
        ;
    }
}
