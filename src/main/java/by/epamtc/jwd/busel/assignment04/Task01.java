package by.epamtc.jwd.busel.assignment04;

import java.util.Arrays;
import java.util.Scanner;

public class Task01 {
    private static Scanner scanner = new Scanner(System.in);

    private static int receivePositiveEvenIntegerFromConsole() {
        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if ((number > 0) && ((number % 2) == 0)) {
                    return number;
                } else {
                    System.out.printf("Non-positive or/and even number" +
                            " \"%d\"\n", number);
                }
            } else {
                System.out.printf("Invalid input \"%s\"\n", scanner.next());
            }
        }
    }

    private static int[][] createSquareArray(int size) {
        int[][] array = new int[size][size];
        int initialElement = 1;
        for (int i = 0; i < array.length; i++) {
            boolean isAscending = ((i % 2) == 0);
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = isAscending ? initialElement++ : --initialElement;
            }
        }
        return array;
    }

    private static void printSquareArray(int[][] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] element : array) {
            stringBuilder.append(Arrays.toString(element)).append("\n");
        }
        System.out.println(new String(stringBuilder));
    }

    public static void main(String[] args) {
        System.out.println("Please, insert any positive even integer, which " +
                "will be \"N\"");
        int n = receivePositiveEvenIntegerFromConsole();
        int[][] array = createSquareArray(n);
        System.out.println(Arrays.deepToString(array));
        printSquareArray(array);
        scanner.close();
    }
}
