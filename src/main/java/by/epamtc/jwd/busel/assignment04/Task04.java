package by.epamtc.jwd.busel.assignment04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task04 {
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

    private static int[] generateArrayWithRandomIntValues(int size) {
        int[] array = new int[size];
        Random random = new Random(System.nanoTime());
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(size + 1) - size;
        }
        return array;
    }

    private static int[][] createTwoDimensionalArrayOnBasis(int[] srcArray) {
        int[][] array = new int[srcArray.length][srcArray.length];
        array[0] = srcArray;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = array[i - 1][j] * array[0][j];
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
        int n = getPositiveEvenIntegerFromConsole();
        int[] initArray = generateArrayWithRandomIntValues(n);
        int[][] array = createTwoDimensionalArrayOnBasis(initArray);
        printSquareArray(array);
    }
}
