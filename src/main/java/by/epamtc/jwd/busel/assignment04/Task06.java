package by.epamtc.jwd.busel.assignment04;

import java.util.Arrays;
import java.util.Scanner;

public class Task06 {
    private static int getPositiveEvenIntegerFromConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.out.printf("Non-positive number \"%d\"\n", number);
                }
            } else {
                System.out.printf("Invalid input \"%s\"\n", scanner.next());
            }
        }
    }

    private static int[][] getMagicSquare(int size) {
        return ((size % 4) != 0)
               ? ((size % 2) != 0) ? getOddMagicSquare(size)
                                   : getSinglyEvenMagicSquare(size)
               : getDoublyEvenMagicSquare(size);
    }

    private static int[][] getOddMagicSquare(int size) {
        int[][] magicSquare = new int[size][size];
        int row = 0;
        int column = size / 2;
        int value = 1;
        magicSquare[row--][column++] = value;
        while (++value <= size * size) {
            if (column >= size) {
                column = 0;
            }
            if (row < 0) {
                row = size - 1;
            }
            if (row >= size) {
                row = 0;
            }
            magicSquare[row][column] = value;
            if (value % size != 0) {
                row--;
                column++;
            } else {
                row++;
            }
        }
        return magicSquare;
    }

    private static int[][] getSinglyEvenMagicSquare(int size) {
        int[][] magicSquare = new int[size][size];
        int subSize = size / 2;
        int row;
        int column;
        return magicSquare;
    }

    private static int[][] getDoublyEvenMagicSquare(int size) {
        int[][] magicSquare = new int[size][size];
        int row = 0;
        int column = 0;
        int value = 1;
        magicSquare[row--][column++] = value;
        boolean isClockwise = true;
        while (++value <= size * size) {
            if (row < 0) {
                row = size - 1;
            }
            if (row >= size) {
                row = 0;
            }
            magicSquare[row][column] = value;
            int remainder = value % (2 * size);
            if (remainder != 0) {
                if (remainder < (size / 2)) {
                    column = (isClockwise) ? ++column : --column;
                    row--;
                } else if (remainder == (size / 2)) {
                    column = isClockwise ? ++column : --column;
                } else if (remainder > (size / 2) && remainder < size) {
                    column = (isClockwise) ? ++column : --column;
                    row++;
                } else if (remainder == size) {
                    row++;
                } else if (remainder > size && remainder < (size * 3 / 2)) {
                    column = (isClockwise) ? --column : ++column;
                    row++;
                } else if (remainder == (size * 3 / 2)) {
                    column = isClockwise ? --column : ++column;
                } else if (remainder > (size * 3 / 2)) {
                    column = (isClockwise) ? --column : ++column;
                    row--;
                }
            } else {
                row++;
                column = isClockwise ? size - 1 : 0;
                isClockwise = !isClockwise;
            }
        }
        return magicSquare;
    }

    private static void printSquareArray(int[][] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] element : array) {
            stringBuilder.append(Arrays.toString(element)).append("\n");
        }
        System.out.println(new String(stringBuilder));
    }

    public static void main(String[] args) {
        System.out.println("Please, insert any positive integer, which " +
                "will be \"N\"");
        int n = getPositiveEvenIntegerFromConsole();
        int[][] magicSquare = getMagicSquare(n);
        printSquareArray(magicSquare);
    }
}
