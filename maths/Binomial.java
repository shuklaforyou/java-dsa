class Binomial {
    static int fac(int p) {
        if (p == 1) {
            return 1;
        }
        int small = p * fac(p - 1);
        return small;
    }

    public static void main(String args[]) {
        int n = 5;
        int r = 2;
        int work1 = fac(r);
        int work = fac(n);
        int work2 = fac(n - r);
        int result = work / (work1 * work2);
        System.out.println(result);
    }
}