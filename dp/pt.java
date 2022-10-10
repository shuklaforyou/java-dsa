package dp;

import java.util.*;

import javax.xml.stream.events.StartDocument;

public class pt {
    public static void main(String args[]) {
        int[][] logs = { { 36, 3 }, { 1, 5 }, { 12, 8 }, { 25, 9 }, { 53, 11 }, { 29, 12 }, { 52, 14 } };
        int lenlog = logs.length;
        int lenlog2 = logs[0].length;

        int[] work2 = new int[lenlog];
        int work = 0;
        int maxval = 0;
        int prev = 0;
        // int ind = ;
        int prevind = logs[0][0];
        for (int i = 0; i < lenlog; i++) {
            // for(int j=0;j<lenlog2;j++){
            work = Math.abs(logs[i][1] - prev);
            work2[i] = work;
            if (work > maxval) {
                maxval = work;
                prevind = logs[i][0];

            }

            prev = logs[i][1];
            // }
        }

        for (int i = 1; i < work2.length; i++) {
            if (maxval == work2[i] && logs[i][0] < prevind) {
                prevind = logs[i][0];
            }

        }
        System.out.println(prevind);
    }
}