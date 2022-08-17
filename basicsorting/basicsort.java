package basicsorting;

import java.util.*;

public class basicsort {
    public static void bubble(int number[]) {
        int n = number.length;
        for (int turns = 0; turns < n - 1; turns++) {
            for (int j = 0; j < n - 1 - turns; j++) {
                if (number[j] > number[j + 1]) {
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                }
            }
        }
        // Printarr(number);

    }

    public static void selected(int number[]) {
        for (int i = 0; i < number.length; i++) {
            int minpos = i;
            for (int j = i + 1; j < number.length; j++) {
                if (number[minpos] > number[j]) {
                    minpos = j;
                }
                int temp = number[minpos];
                number[minpos] = number[i];
                number[i] = temp;
            }
        }
        // Printarr(number);
    }

    public static void inserted(int number[]) {
        for (int i = 1; i < number.length; i++) {
            int curr = number[i];
            int prev = i - 1;
            while (prev >= 0 && number[prev] > curr) {
                number[prev + 1] = number[prev];
                prev--;
            }
            // insertions
            number[prev + 1] = curr;

        }
        // Printarr(number);
    }

    public static void Printarr(int number[]) {
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
    }

    public static void Count(int number[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < number.length; i++) {
            largest = Math.max(largest, number[i]);
        }
        int count[] = new int[largest + 1];
        for (int i = 0; i < number.length; i++) {
            count[number[i]]++;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                number[j] = i;
                j++;
                count[i]--;
            }
        }
        Printarr(number);
    }

    public static void main(String args[]) {
        // Integer number[] = { 5, 4, 1, 3, 2 };
        int number[] = { 5, 4, 1, 3, 2 };
        // selected(number);
        // inserted(number);
        // Arrays.sort(number, Collections.reverseOrder());
        // Arrays.sort(number, 0, 4, Collections.reverseOrder());
        // Arrays.sort(number, 0, 4, Collections.reverseOrder());
        Count(number);
        // Printarr(number);

    }
}
