package dp;

import java.util.*;

public class wiildcard {
    static boolean isAllStars(String S1, int i) {

        // S1 is taken in 1-based indexing
        for (int j = 1; j <= i; j++) {
            if (S1.charAt(j - 1) != '*')
                return false;
        }
        return true;
    }

    // static boolean isAllStars(String S1, int i) {
    // for (int j = 1; j <= i; j++) {
    // if (S1.charAt(j - 1) != '*')
    // return false;
    // }
    // return true;
    // }

    static int f(String S1, String S2, int i, int j, int[][] dp) {
        if (i == 0 && j == 0)
            return 1;
        if (i == 0 && j > 0)
            return 0;
        if (j == 0 && i > 0)
            return isAllStars(S1, i) ? 1 : 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?')
            return dp[i][j] = f(S1, S2, i - 1, j - 1, dp);

        else {
            if (S1.charAt(i - 1) == '*')
                return (f(S1, S2, i - 1, j, dp) == 1 || f(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
            else
                return 0;
        }
    }

    public static void main(String args[]) {
        String pattern = "ab*cd";
        String text = "abdefcd";
        int n = pattern.length();
        int m = text.length();
        // int[][] dp = new int[n + 1][m + 1];
        // for (int[] row : dp)
        // Arrays.fill(row, -1);
        // if (f(pattern, text, n, m, dp) == 1)
        // System.out.println(true);
        // else
        // System.out.println(false);

        boolean[][] dp = new boolean[n + 1][m + 1];
        for (boolean[] row : dp)
            Arrays.fill(row, false);
        dp[0][0] = true;
        for (int j = 1; j <= m; j++)
            dp[0][j] = false;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = isAllStars(pattern, i);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(i - 1) == text.charAt(j - 1) || pattern.charAt(i - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];

                else {
                    if (pattern.charAt(i - 1) == '*')
                        dp[i][j] = (dp[i - 1][j] || dp[i][j - 1]);
                    else
                        dp[i][j] = false;
                }

            }
        }
        return dp[n][m];
    }
}
