package bitmanu;

public class deectobin {
    public static void dec(int n) {
        int mynum = n;
        int pow = 0;
        int decnum = 0;
        while (n > 0) {
            int rem = n % 2;
            decnum = decnum + (rem * (int) Math.pow(10, pow));
            pow++;
            n = n / 2;
        }
        System.out.println("decimal of binary number of " + mynum + " = " + decnum);
    }

    public static void main(String args[]) {
        dec(7);
    }
}
