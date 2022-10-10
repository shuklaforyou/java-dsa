package dp;

import java.util.*;

public class lpsubseqnce {
    public static void main(String args[]) {
        String s = "bbabcbcab";
        StringBuilder t = new StringBuilder(s);
        t.reverse();
        // String t=sb;
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
        System.out.println(prev[m]);x
    }
}