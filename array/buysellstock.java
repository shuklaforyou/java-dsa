package array;

import java.util.*;

public class buysellstock {
    public static void Profit(int number[]) {
        int n = number.length;
        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 1; i < n; i++) {
            if (buyprice < number[i]) {
                int Profit = number[i] - buyprice;
                maxprofit = Math.max(maxprofit, Profit);
            } else {
                buyprice = number[i];
            }
        }
        System.out.println(maxprofit);
    }

    public static void main(String args[]) {
        int number[] = { 7, 1, 5, 3, 6, 4 };
        Profit(number);
    }

}
