package dp;
// fibonacimemorizations

public class fibm {
    public static int f(int n, int dp[]) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = f(n - 1, dp) + f(n - 2, dp);
    }

    public static void main(String args[]) {
        int n = 5;
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        int x = f(n, dp);
        System.out.println(x);
    }
}
