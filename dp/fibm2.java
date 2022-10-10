package dp;
// fibonacitabulations

public class fibm2 {
    // public static int f(int n, int prev2, int prev) {
    // if (n <= 1) {
    // return n;
    // }
    // if (dp[n] != -1) {
    // return dp[n];
    // }
    // dp[n] = f(n - 1, dp) + f(n - 2, dp);
    // }

    public static void main(String args[]) {
        int n = 5;
        // int dp[] = new int[n + 1];
        // for (int i = 0; i <= n; i++) {
        // dp[i] = -1;
        // }
        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int curi = prev + prev2;
            prev2 = prev;
            prev = curi;
        }
        // int x = f(n, prev2,prev);
        System.out.println(prev);
    }
}
