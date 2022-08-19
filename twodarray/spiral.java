package twodarray;

public class spiral {
    public static void Printspiral(int matrix[][]) {
        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length - 1;
        int endcol = matrix[0].length - 1;
        while (startrow <= endrow && startcol <= endcol) {
            for (int j = startcol; j <= endcol; j++) {
                System.out.print(matrix[startrow][j] + " ");

            }
            for (int i = startrow + 1; i <= endrow; i++) {

                System.out.print(matrix[i][endcol] + " ");
            }
            for (int j = endcol - 1; j >= startcol; j--) {
                if (startrow == endrow) {
                    break;
                }
                System.out.print(matrix[endrow][j] + " ");
            }
            for (int i = endrow - 1; i >= startrow + 1; i--) {
                if (startrow == endrow) {
                    break;
                }
                System.out.print(matrix[i][startcol] + " ");
            }
            startcol++;
            startrow++;
            endcol--;
            endrow--;
        }
        System.out.println();
    }

    public static void diagonalsum(int matrix[][]) {
        int sum = 0;
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // if (i == j) {
        // sum += matrix[i][j];
        // } else if (i + j == matrix.length - 1) {
        // sum += matrix[i][j];
        // }
        // }
        // }
        // System.out.println(sum);

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            if (i != matrix.length - i - 1) {
                sum += matrix[i][matrix.length - i - 1];
            }
        }
        System.out.println(sum);

    }

    public static boolean statircase(int matrix[][], int key) {
        int row = 0, col = matrix.length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("key found at(" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("key not found");
        return false;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        // Printspiral(matrix);
        // diagonalsum(matrix);
        int key = 11;
        statircase(matrix, key);

    }
}
