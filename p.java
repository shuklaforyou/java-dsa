import java.util.*;

class p {

    public static void main(String args[]) {
        String inStr;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter bracket:-");
        inStr = sc.nextLine();
        int n = inStr.length();
        int op = 0;
        int cls = 0;
        for (int i = 0; i <= n - 1; i++) {
            char x = inStr.charAt(i);
            if (x == '(') {
                op++;
            } else {
                cls++;
            }

        }

        if (op <= cls) {
            System.out.println(op);
        } else {
            System.out.println(cls);
        }
    }
}