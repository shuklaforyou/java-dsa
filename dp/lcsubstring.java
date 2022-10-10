package dp;

public class lcsubstring {
    static int lcs(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int prev[] = new int[m + 1];
        int cur[] = new int[m + 1];

        // Base Case is covered as we have initialized the prev and cur to 0.

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    cur[ind2] = 1 + prev[ind2 - 1];
                else
                    cur[ind2] = 0 + Math.max(prev[ind2], cur[ind2 - 1]);
            }
            prev = cur;
        }

        return prev[m];
    }

    static int longestPalindromeSubsequence(String s) {
        String t = s;
        String ss = new StringBuilder(s).reverse().toString();
        return lcs(ss, t);
    }

    public static void main(String args[]) {

        String s = "bbabcbcab";

        System.out.print("The Length of Longest Palindromic Subsequence is ");
        System.out.println(longestPalindromeSubsequence(s));
    }
}
