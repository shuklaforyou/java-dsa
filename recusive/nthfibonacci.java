import java.util.*;

class nthfibonacci {

    public static int fibb(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int small = fibb(n - 1) + fibb(n - 2);
        return small;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter nth fibonacci :-");
        int n = sc.nextInt();
        int result = fibb(n);
        System.out.println(result);
    }
}