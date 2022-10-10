package p;

import java.util.*;

public class p1 {
    public static void main(String args[]) {
        int test = 3;
        int[] tastarr = { 2, 1, 7 };
        ArrayList<Integer> classroom = new ArrayList<Integer>();
        int count = 1;
        for (int i = 0; i <= test - 1; i++) {
            for (int j = 0; j < tastarr[i]; j++) {
                classroom.add(count);
            }
            count++;
        }
        for (int i = 0; i < classroom.size(); i++) {
            System.out.print(classroom.get(i) + " ");
        }
        System.out.println();
        int lenclass = classroom.size();
        int lenOp = 5;
        int oparr[] = { 1, 10, 3, 2, 5 };
        // System.out.println(classroom.size());
        for (int i : oparr) {
            int helper = i;
            if (i < classroom.size()) {
                System.out.println(classroom.get(i - 1));
            } else if (i > classroom.size()) {
                while (helper > classroom.size()) {
                    helper = helper - classroom.size();
                }
                System.out.println(classroom.get(helper - 1));
            } else if (i == lenclass) {
                System.out.println(classroom.get(lenclass - 1));
            }
        }

    }

}
