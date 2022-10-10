package dp;

import java.util.*;

public class triangle {
    // recusive functions in below--;
    public static int f(int i, int j, int[][] Triangle, int n) {
        if (i == n - 1)
            return Triangle[n - 1][j];

        int down = Triangle[i][j] + f(i + 1, j, Triangle, n);
        int dignol = Triangle[i][j] + f(i + 1, j + 1, Triangle, n);

        return Math.min(down, dignol);
    }

    // memorizations functions in below--;
    public static int f(int i, int j, int[][] Triangle, int n, int[][] dp) {
        if (i == n - 1)
            return Triangle[n - 1][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int down = Triangle[i][j] + f(i + 1, j, Triangle, n, dp);
        int dignol = Triangle[i][j] + f(i + 1, j + 1, Triangle, n, dp);

        return dp[i][j] = Math.min(down, dignol);
    }

    public static void main(String args[]) {
        int n = 4;
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // ArrayList<Integer> Triangle = new ArrayList<Integer>();
        int[][] Triangle = { { 1 }, { 2, 3 }, { 4, 5, 6 }, { 7, 8, 9, 10 } };

        // int x = f(0, 0, Triangle, n, dp);
        // System.out.println(x);

        // Tabulations functions in below--;
        // for (int j = 0; j < n; j++) {
        // dp[n - 1][j] = Triangle[n - 1][j];
        // }

        // for (int i = n - 2; i >= 0; i--) {
        // for (int j = i; j >= 0; j--) {
        // int d = Triangle[i][j] + dp[i + 1][j];
        // int dg = Triangle[i][j] + dp[i + 1][j + 1];
        // dp[i][j] = Math.min(d, dg);

        // }
        // }
        // System.out.println(dp[0][0]);

        // space optimisations in below--;
        int front[] = new int[n];
        for (int j = 0; j < n; j++) {
            front[j] = Triangle[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] curi = new int[n];
            for (int j = i; j >= 0; j--) {
                int d = Triangle[i][j] + front[j];
                int dg = Triangle[i][j] + front[j + 1];
                curi[j] = Math.min(d, dg);

            }
            front = curi;
        }
        System.out.println(front[0]);

    }
}
