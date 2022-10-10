package dp;

import java.util.*;

import javax.sound.midi.Soundbank;

public class buysell2 {
    public static int f(int ind, int buy, int[] prices, int n, int[][] dp) {
        if (ind == n)
            return 0;
        if (dp[ind][buy] != -1)
            return dp[ind][buy];
        int Profit;
        if (buy == 1)
            Profit = Math.max((-prices[ind] + f(ind + 1, 0, prices, n, dp)), (0 + f(ind + 1, 1, prices, n, dp)));

        else {
            Profit = Math.max((prices[ind] + f(ind + 1, 1, prices, n, dp)), (0 + f(ind + 1, 0, prices, n, dp)));
        }
        return dp[ind][buy] = Profit;
    }

    public static void main(String args[]) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        int n = prices.length;
        int[][] dp = new int[n][2];
        // for (int[] row : dp)
        // Arrays.fill(row, -1);
        System.out.println(f(0, 1, prices, n, dp));

        int aheadnotbuy, aheadbuy, curbuy, curnotbuy;
        aheadnotbuy = aheadbuy = 0;

        // int[] dp = new int[2];
        // Arrays.fill(dp, 0);
        // // return f(0,1,prices,n,dp);
        // dp[0] = dp[1] = 0;

        // int Profit = 0;
        // for (int ind = n - 1; ind >= 0; ind--) {
        // int[] cur = new int[2];
        // for (int buy = 0; buy <= 1; buy++) {
        // if (buy == 0)
        // Profit = Math.max((-prices[ind] + dp[1]), (0 + dp[0]));

        // if (buy == 1) {
        // Profit = Math.max((prices[ind] + dp[0]), (0 + dp[1]));
        // }
        // cur[buy] = Profit;
        // }
        // dp = cur;
        // }
        // System.out.println(dp[0]);

        int Profit = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
        // int[] cur=new int[2];
        // for(int buy=0;buy<=1;buy++){
        // if(buy==0)
        curnotbuy = Math.max((-prices[ind] + aheadbuy), (0 + aheadnotbuy));

        // if (buy==1){
        curbuy = Math.max((prices[ind] + aheadnotbuy), (0 + aheadbuy));
        // }
        // cur[buy]=Profit;
        aheadbuy = curbuy;
        aheadnotbuy = curnotbuy;

        }
        System.out.println(aheadnotbuy);
    }
}
