package array;

import java.util.*;

public class subarray {
    public static void PrintSub(int number[]) {
        ArrayList<ArrayList<Integer>> Final = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < number.length; i++) {
            for (int j = i; j < number.length; j++) {
                ArrayList<Integer> nar1 = new ArrayList<Integer>();
                for (int k = i; k <= j; k++) {
                    System.out.print(number[k] + " ");
                    nar1.add(number[k]);
                }
                Final.add(nar1);
                System.out.println();
            }
            System.out.println();
        }
        // 2D ArrayList Sort mathod
        Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> pList1, ArrayList<Integer> pList2) {
                return pList1.get(0).compareTo(pList2.get(0));
            }
        };
        // 2D ArrayList Sort mathod
        Collections.sort(Final, comparator);
        for (int i = 0; i <= Final.size() - 1; i++) {
            for (int j = 0; j <= Final.get(i).size() - 1; j++) {
                System.out.print(Final.get(i).get(j));
                System.out.print(",");
            }
            System.out.println();
        }

        // System.out.println(Final);

    }

    public static void main(String args[]) {
        int number[] = { 1, 7, 2 };
        PrintSub(number);
    }
}
