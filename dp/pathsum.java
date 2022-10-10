
package dp;

import java.util.*;

public class pathsum {
    // recusive functions below --;
    public static int f(int i, int j, int grid[][]) {
        if (i == 0 && j == 0)
            return grid[0][0];
        if (i < 0 || j < 0)
            return 999999999;

        int up = grid[i][j] + f(i - 1, j, grid);
        int left = grid[i][j] + f(i, j - 1, grid);

        return Math.min(up, left);

    }

    // memorizations functions in below--;
    public static int f(int i, int j, int grid[][], int[][] dp) {
        if (i == 0 && j == 0)
            return grid[0][0];
        if (i < 0 || j < 0)
            return 999999999;
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = grid[i][j] + f(i - 1, j, grid);
        int left = grid[i][j] + f(i, j - 1, grid);

        return dp[i][j] = Math.min(up, left);

    }

    public static void main(String args[]) {
        int grid[][] = { { 5, 9, 6 }, { 11, 5, 2 } };
        int n = grid.length;
        int m = grid[0].length;
        // int dp[][] = new int[n][m];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        // System.out.println(f(n - 1, m - 1, grid, dp));

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // if (i == 0 && j == 0)
        // dp[i][j] = grid[0][0];
        // else {
        // int up = grid[i][j];
        // if (i > 0)
        // up += dp[i - 1][j];
        // else
        // up += 999999999;
        // int left = grid[i][j];
        // if (j > 0)
        // left += dp[i][j - 1];
        // else
        // left += 999999999;
        // dp[i][j] = Math.min(up, left);
        // }
        // }
        // }
        // System.out.println(dp[n - 1][m - 1]);

        int prev[] = new int[m];
        for (int i = 0; i < n; i++) {
            int temp[] = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    temp[j] = grid[0][0];
                else {
                    int up = grid[i][j];
                    if (i > 0)
                        up += prev[j];
                    else
                        up += 999999999;
                    int left = grid[i][j];
                    if (j > 0)
                        left += temp[j - 1];
                    else
                        left += 999999999;
                    temp[j] = Math.min(up, left);
                }
            }
            prev = temp;
        }
        System.out.println(prev[m - 1]);

    }

}
