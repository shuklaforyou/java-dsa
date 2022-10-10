package dp;

import java.util.*;

public class ninjatraining {
    // memorizations functions in below;
    public static int f(int day, int last, int points[][], int dp[][]) {
        if (dp[day][last] != -1)
            return dp[day][last];

        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task <= 2; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);

                }
            }
            return dp[day][last] = maxi;
        }
        if (dp[day][last] != -1)
            return dp[day][last];
        int maxi = 0;
        for (int task = 0; task <= 2; task++) {
            if (task != last) {
                int point = points[day][task] + f(day - 1, last, points, dp);
                maxi = Math.max(maxi, point);

            }
        }
        return dp[day][last] = maxi;
    }

    public static void main(String args[]) {
        int n = 3;
        int points[][] = { { 1, 2, 5, }, { 3, 1, 1 }, { 3, 3, 3 } };
        // int dp[][] = new int[n][4];
        // for (int[] row : dp)
        // Arrays.fill(row, 0);

        // int x = f(n - 1, 3, points, dp);
        // System.out.println(x);

        // tabulations functions in below;----
        // dp[0][0] = Math.max(points[0][1], points[0][2]);
        // dp[0][1] = Math.max(points[0][0], points[0][2]);
        // dp[0][2] = Math.max(points[0][0], points[0][1]);
        // dp[0][3] = Math.max(points[0][0], Math.max(points[0][2], points[0][2]));
        // for (int day = 1; day < n; day++) {
        // for (int last = 0; last < 4; last++) {
        // dp[day][last] = 0;
        // for (int task = 0; task <= 2; task++) {
        // if (task != last) {
        // int point = points[day][task] + dp[day - 1][task];
        // dp[day][last] = Math.max(dp[day][last], point);

        // }
        // }
        // }
        // }
        // System.out.println(dp[n - 1][3]);

        // space optimices functions in below;----
        int dp[] = new int[4];
        Arrays.fill(dp, 0);
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][2], points[0][2]));
        for (int day = 1; day < n; day++) {
            int temp[] = new int[4];
            Arrays.fill(temp, 0);
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[task];
                        temp[last] = Math.max(temp[last], point);

                    }
                }

            }
            dp = temp;
        }
        System.out.println(dp[3]);

    }
}
