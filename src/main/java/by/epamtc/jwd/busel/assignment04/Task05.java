package by.epamtc.jwd.busel.assignment04;

import java.util.Arrays;
import java.util.Random;

public class Task05 {
    private static Random random = new Random(System.nanoTime());

    private static int[] generateOneDimensionalArray(int rowNUmber) {
        int[] array = new int[rowNUmber];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(201) - 100;
        }
        return array;
    }

    private static int[][] generateTwoDimensionalArray(int rowNumber,
            int columnNumber) {
        int[][] array = new int[rowNumber][columnNumber];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(201) - 100;
            }
        }
        return array;
    }

    private static int multiplyMatrixs(int[] multiplicand, int[] multiplier) {
        if (multiplicand.length != multiplier.length) {
            String errorMessage = String.format("Multiplication of %s and %s" +
                            " is impossible due to incompatible lengths.",
                    Arrays.toString(multiplicand), Arrays.toString(multiplier));
            throw new RuntimeException(errorMessage);
        }
        int product = 0;
        for (int i = 0; i < multiplicand.length; i++) {
            product += multiplicand[i] * multiplier[i];
        }
        return product;
    }

    private static int[] multiplyMatrixs(int[][] multiplicand,
            int[] multiplier) {
        if (multiplicand[0].length != multiplier.length) {
            String errorMessage = String.format("\nMultiplication of\n%s\nand\n%s\n" +
                            " is impossible due to incompatible lengths.",
                    Arrays.deepToString(multiplicand), Arrays.toString(multiplier));
            throw new RuntimeException(errorMessage);
        }
        int[] array = new int[multiplicand.length];
        for (int i = 0; i < multiplicand.length; i++) {
            for (int j = 0; j < multiplicand[i].length; j++) {
                array[i] += multiplicand[i][j] * multiplier[j];
            }
        }
        return array;
    }

    private static int[][] multiplyMatrixs(int[][] multiplicandMatrix,
            int[][] multiplierMatrix) {
        if (multiplicandMatrix[0].length != multiplierMatrix.length) {
            String errorMessage = String.format("\nMultiplication of\n%s\nand\n%s\n" +
                            " is impossible due to incompatible lengths.",
                    Arrays.deepToString(multiplicandMatrix), Arrays.toString(multiplierMatrix));
            throw new RuntimeException(errorMessage);
        }
        int[][] array = new int[multiplicandMatrix.length][multiplierMatrix[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                for (int k = 0; k < multiplicandMatrix[0].length; k++) {
                    array[i][j] = array[i][j] + multiplicandMatrix[i][k]
                            * multiplierMatrix[k][j];
                }
            }
        }
        return array;
    }

    private static void print(String product, String multiplicand,
            String multiplier) {
        System.out.printf("The product of multiplication of\n" +
                "%s\nand\n%s\nis\n%s.\n\n", multiplicand, multiplier, product);
    }

    public static void main(String[] args) {
        int[] multiplicand0 = generateOneDimensionalArray(4);
        int[] multiplier0 = generateOneDimensionalArray(4);
        int product0 = multiplyMatrixs(multiplicand0, multiplier0);
        print(String.valueOf(product0), Arrays.toString(multiplicand0),
                Arrays.toString(multiplier0));

        int[][] multiplicand1 = generateTwoDimensionalArray(4, 3);
        int[] multiplier1 = generateOneDimensionalArray(3);
        int[] product1 = multiplyMatrixs(multiplicand1, multiplier1);
        print(Arrays.toString(product1), Arrays.deepToString(multiplicand1),
                Arrays.toString(multiplier1));

        int[][] multiplicand2 = generateTwoDimensionalArray(4, 3);
        int[][] multiplier2 = generateTwoDimensionalArray(3, 3);
        int[][] product2 = multiplyMatrixs(multiplicand2, multiplier2);
        print(Arrays.deepToString(product2), Arrays.deepToString(multiplicand2),
                Arrays.deepToString(multiplier2));
    }
}
