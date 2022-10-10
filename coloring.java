import java.util.*;

class coloring {
    public static int botsscore(Integer cells) {
        Integer count = 0;
        if (cells == 1 || cells == 2 || cells == 3) {
            return 1;
        }
        while (cells != 0) {

            if (cells >= 0) {
                cells = cells - 4;
                count = count + 1;

            } else {
                return count;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Integer testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            Integer cells = sc.nextInt();
            Integer score = botsscore(cells);
            System.out.println(score);
        }
    }
}