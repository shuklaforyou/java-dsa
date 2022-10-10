package dp;

import java.util.*;

public class lcs {

    // longest commmen subsequnce and recursive in below funtion--;
    public static int f(int ind1, int ind2, String s, String t, int[][] dp) {
        if (ind1 < 0 || ind2 < 0)
            return 0;
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        if (s.charAt(ind1) == t.charAt(ind2))
            return 1 + f(ind1 - 1, ind2 - 1, s, t, dp);

        return dp[ind1][ind2] = Math.max(f(ind1 - 1, ind2, s, t, dp), f(ind1, ind2 - 1, s, t, dp));

    }

    public static void main(String args[]) {
        // Your code goes here\
        String s = "abcde";
        String t = "bdgek";

        // int n = s.length();
        // int n1 = t.length();
        // int[][] dp = new int[n][n1];
        // for (int[] row : dp)
        // Arrays.fill(row, -1);
        // System.out.println(f(n - 1, n1 - 1, s, t, dp));

        // int n = s.length();
        // int m = t.length();
        // int[][] dp = new int[n + 1][m + 1];
        // for (int[] row : dp)
        // Arrays.fill(row, 0);

        // for (int i = 0; i <= n; i++)
        // dp[i][0] = 0;
        // for (int i = 0; i <= m; i++)
        // dp[0][i] = 0;

        // for (int ind1 = 1; ind1 <= n; ind1++) {
        // for (int ind2 = 1; ind2 <= m; ind2++) {
        // if (s.charAt(ind1 - 1) == t.charAt(ind2 - 1))
        // dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
        // else
        // dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
        // }
        // }
        // // return f(n,nm,s,t,dp);
        // System.out.println(dp[n][m]);

        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];
        Arrays.fill(prev, 0);

        for (int i = 0; i <= m; i++)
            prev[i] = 0;

        for (int ind1 = 1; ind1 <= n; ind1++) {
            int[] cur = new int[m + 1];
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s.charAt(ind1 - 1) == t.charAt(ind2 - 1)) {
                    cur[ind2] = 1 + prev[ind2 - 1];
                } else
                    cur[ind2] = 0 + Math.max(prev[ind2], cur[ind2 - 1]);
            }
            prev = cur;
        }
        // return f(n,nm,s,t,dp);
        System.out.println(prev[m]);

        // print the lcs in below operations--;
        int len = prev[m];
        int i = n;
        int j = m;

        int index = len - 1;
        String str = "";
        for (int k = 1; k <= len; k++) {
            str += "$"; // dummy string
        }
        StringBuilder ss = new StringBuilder(s);
        StringBuilder str2 = new StringBuilder(str);
        while (i > 0 && j > 0) {
            if (ss.charAt(i - 1) == t.charAt(j - 1)) {
                str2.setCharAt(index, ss.charAt(i - 1));
                index--;
                i--;
                j--;
            } else if (ss.charAt(i - 1) > t.charAt(j - 1)) {
                i--;
            } else
                j--;
        }
        System.out.println(str2);
    }

}
