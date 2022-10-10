package dp;

import java.util.*;

// Q.Maximum Path Sum in the matrix

public class maxipathsum {
    // recursive function in below--;
    public static int f(int i, int j, int[][] matrix) {
        if (j < 0 || j >= matrix[0].length)
            return -9999999;
        if (i == 0)
            return matrix[0][j];

        int s = matrix[i][j] + f(i - 1, j, matrix);
        int ld = matrix[i][j] + f(i - 1, j - 1, matrix);
        int rd = matrix[i][j] + f(i - 1, j + 1, matrix);

        return Math.max(s, Math.max(ld, rd));
    }

    // memorizations functions in below--
    public static int f(int i, int j, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= matrix[0].length)
            return -9999999;
        if (i == 0)
            return matrix[0][j];
        if (dp[i][j] != -1)
            return dp[i][j];

        int s = matrix[i][j] + f(i - 1, j, matrix);
        int ld = matrix[i][j] + f(i - 1, j - 1, matrix);
        int rd = matrix[i][j] + f(i - 1, j + 1, matrix);

        return dp[i][j] = Math.max(s, Math.max(ld, rd));
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2, 2, 1 } };
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // int x = Integer.MIN_VALUE;
        // for (int j = 0; j < m - 1; j++) {
        // int y = f(n - 1, j, matrix, dp);
        // if (x < y)
        // x = y;

        // }
        // System.out.println(x);

        // tabulations functions in below--;
        for (int j = 0; j < m; j++)
            dp[0][j] = matrix[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int s = matrix[i][j] + dp[i - 1][j];

                int ld = matrix[i][j];
                if (j - 1 >= 0)
                    ld += dp[i - 1][j - 1];
                else
                    ld += -1e9;

                int rd = matrix[i][j];
                if (j + 1 < m)
                    rd += dp[i - 1][j + 1];
                else
                    rd += -1e9;

                dp[i][j] = Math.max(s, Math.max(ld, rd));
            }
        }
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
            // System.out.print(dp[n - 1][j] + " ");
        }
        System.out.println(maxi);

        int prev[] = new int[m];
        for (int j = 0; j < m; j++)
            prev[j] = matrix[0][j];
        for (int i = 1; i < n; i++) {
            int curi[] = new int[m];
            for (int j = 0; j < m; j++) {
                int s = matrix[i][j] + prev[j];

                int ld = matrix[i][j];
                if (j - 1 >= 0) {
                    ld += prev[j - 1];
                } else {
                    ld += -1e9;
                }

                int rd = matrix[i][j];
                if (j + 1 < m) {
                    rd += prev[j + 1];
                } else {
                    rd += -1e9;
                }

                curi[j] = Math.max(s, Math.max(ld, rd));
            }
            prev = curi;
        }
        int ma = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            ma = Math.max(ma, prev[j]);
            // System.out.print(prev[j]);
        }
        System.out.println(ma);
    }
}
