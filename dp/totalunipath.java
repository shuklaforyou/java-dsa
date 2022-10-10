package dp;

import java.net.SocketTimeoutException;
import java.util.*;

public class totalunipath {
    // recusive functions in below--
    public static int f(int i, int j) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        int up = f(i - 1, j);
        int left = f(i, j - 1);
        return up + left;
    }

    // memorizations functions in below --
    // public static int f(int i, int j, int dp[][]) {
    // if (i == 0 && j == 0)
    // return 1;
    // if (i < 0 || j < 0)
    // return 0;
    // if (dp[i][j] != -1)
    // return dp[i][j];
    // int up = f(i - 1, j, dp);
    // int left = f(i, j - 1, dp);
    // return dp[i][j] = up + left;
    // }

    public static void main(String args[]) {
        int n = 2;
        int m = 2;
        // int arr[][] = { { 2, 2 }, { 1, 1 } };
        // int dp[][] = new int[m][n];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // int x = f(m - 1, n - 1, dp);
        // System.out.println(x);

        // tabulations functions below---;
        // int dp[][] = new int[m][n];
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (i == 0 && j == 0)
        // dp[i][j] = 1;
        // else {
        // int up = 0;
        // int left = 0;
        // if (i > 0) {
        // up = dp[i - 1][j];
        // }
        // if (j > 0) {
        // left = dp[i][j - 1];
        // }
        // dp[i][j] = up + left;

        // }
        // }
        // }
        // System.out.println(dp[m - 1][n - 1]);

        // space optimizartions---;
        int prev[] = new int[n];
        for (int i = 0; i < m; i++) {
            int temp[] = new int[n];
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    temp[j] = 1;

                else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) {
                        up = prev[j];
                    }
                    if (j > 0) {
                        left = temp[j - 1];
                    }
                    temp[j] = up + left;

                }

            }
            prev = temp;
        }
        System.out.println(prev[n - 1]);

        // questions is not relebe this questions ;
        // int N = n * m - 2;
        // int r = m - 1;
        // double res = 1;
        // for (int i = 1; i <= r; i++) {
        // res = res * (N - r + i) / i;
        // }
        // System.out.println((int) res);

    }
}
