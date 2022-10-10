package dp;

import java.util.*;
//Ninja and his friends (DP-13)

public class ninjafriend {
    public static int f(int i, int j1, int j2, int r, int c, int grid[][], int dp[][][]) {
        if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c)
            return -9999999;
        if (i == r - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];

        }
        // explore paths all paths simultaneuosly
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        int maxi = 0;
        for (int dj1 = -1; dj1 <= +1; dj1++) {
            for (int dj2 = -1; dj2 <= +1; dj2++) {
                int value = 0;
                if (j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];
                value += f(i + 1, j1 + dj1, j2 + dj2, r, c, grid, dp);
                maxi = Math.max(maxi, value);

            }
        }
        return dp[i][j1][j2] = maxi;
    }

    public static void main(String args[]) {
        int n = 3;
        int m = 4;
        int grid[][] = { { 2, 3, 1, 2 }, { 3, 4, 2, 2 }, { 5, 6, 3, 5 } };
        // int dp[][][] = new int[r][c][c];
        // for (int[][] row : dp) {
        // for (int[] rowColumn : row) {
        // Arrays.fill(rowColumn, -1);
        // }
        // }
        // System.out.println(f(0, 0, c - 1, r, c, grid, dp));
        // int dp[][][] = new int[n][m][m];
        // for (int[][] row : dp) {
        // for (int[] rowColumn : row) {
        // Arrays.fill(rowColumn, 0);
        // }
        // }
        // for (int j1 = 0; j1 < m - 1; j1++) {
        // for (int j2 = 0; j2 < m - 1; j2++) {
        // if (j1 == j2) {
        // dp[n - 1][j1][j2] = grid[n - 1][j1];
        // } else
        // dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
        // }
        // }
        // for (int i = n - 2; i >= 0; i--) {
        // for (int j1 = 0; j1 < m; j1++) {
        // for (int j2 = 0; j2 < m; j2++) {
        // int maxi = 0;
        // for (int dj1 = -1; dj1 <= +1; dj1++) {
        // for (int dj2 = -1; dj2 <= +1; dj2++) {
        // int value = 0;
        // if (j1 == j2)
        // value = grid[i][j1];
        // else
        // value = grid[i][j1] + grid[i][j2];
        // if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m)
        // value += dp[i + 1][j1 + dj1][j2 + dj2];
        // else
        // value = -9999999;
        // maxi = Math.max(maxi, value);

        // }
        // }
        // dp[i][j1][j2] = maxi;
        // }

        // }
        // }
        // System.out.println(dp[0][0][m - 1]);

        // space optimizations in below--;
        int[][] front = new int[m][m];

        for (int j1 = 0; j1 < m - 1; j1++) {
            for (int j2 = 0; j2 < m - 1; j2++) {
                if (j1 == j2) {
                    front[j1][j2] = grid[n - 1][j1];
                } else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            int[][] curi = new int[m][m];

            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = 0;
                    for (int dj1 = -1; dj1 <= +1; dj1++) {
                        for (int dj2 = -1; dj2 <= +1; dj2++) {
                            int value = 0;
                            if (j1 == j2)
                                value = grid[i][j1];
                            else
                                value = grid[i][j1] + grid[i][j2];
                            if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m)
                                value += front[j1 + dj1][j2 + dj2];
                            else
                                value = -9999999;
                            maxi = Math.max(maxi, value);

                        }
                    }
                    curi[j1][j2] = maxi;
                }

            }
            front = curi;
        }
        System.out.println(front[0][m - 1]);

    }

}
