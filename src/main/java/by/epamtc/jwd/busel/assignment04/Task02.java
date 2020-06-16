package by.epamtc.jwd.busel.assignment04;

import java.util.Arrays;
import java.util.Scanner;

public class Task02 {
    private static int getPositiveEvenIntegerFromConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number > 0 && number % 2 == 0) {
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
        int initElement = 1;
        for (int i = 0; i < array.length; i++) {
            array[i][i] = initElement * (++initElement);
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
        int n = getPositiveEvenIntegerFromConsole();
        int[][] array = createSquareArray(n);
        printSquareArray(array);
    }
}
