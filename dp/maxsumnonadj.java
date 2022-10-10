package dp;

import java.util.*;

public class maxsumnonadj {
    // simple recursion functions below
    // static int f(int ind, int num[]) {
    // if (ind == 0)
    // return num[ind];
    // if (ind < 0)
    // return 0;
    // int pick = num[ind] + f(ind - 2, num);
    // int notpick = 0 + f(ind - 1, num);
    // return Math.max(pick, notpick);

    // }

    // memorizations in below function
    static int f(int ind, int num[], int dp[]) {
        if (ind == 0)
            return num[ind];
        if (ind < 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int pick = num[ind] + f(ind - 2, num, dp);
        int notpick = 0 + f(ind - 1, num, dp);
        return dp[ind] = Math.max(pick, notpick);

    }

    public static void main(String args[]) {
        int num[] = { 2, 1, 4, 9 };
        int n = 4;
        // int dp[] = new int[n];
        // Arrays.fill(dp, -1);
        // int x = f(n - 1, num, dp);
        // System.out.println(x);

        // space optimisations in below operations
        int prev = num[0];
        int prev2 = 0;
        for (int i = 0; i < n; i++) {
            int take = num[i];
            if (i > 1)
                take += prev2;
            int nottake = 0 + prev;
            int curi = Math.max(take, nottake);
            prev2 = prev;
            prev = curi;
        }
        System.out.println(prev);
    }

}
