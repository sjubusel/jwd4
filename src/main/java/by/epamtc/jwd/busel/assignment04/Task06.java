package by.epamtc.jwd.busel.assignment04;

import java.util.Arrays;
import java.util.Scanner;

public class Task06 {
    private static Scanner scanner = new Scanner(System.in);

    private static int receivePositiveEvenIntegerFromConsole() {
        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number > 2) {
                    return number;
                } else {
                    System.out.printf("Number \"%d\" is not greater than 2\n",
                            number);
                }
            } else {
                System.out.printf("Invalid input \"%s\"\n", scanner.next());
            }
        }
    }

    private static int[][] generateMagicSquare(int size) {
        int[][] magicSquare = new int[size][size];
        return ((size % 4) != 0)
               ? ((size % 2) != 0) ? generateOddMagicSquare(magicSquare)
                                   : generateSinglyEvenMagicSquare(magicSquare)
               : generateDoublyEvenMagicSquare(magicSquare);
    }

    private static int[][] generateOddMagicSquare(int[][] magicSquare) {
        return generateOddMagicSquareInSubsquare(magicSquare, 1, 0, 0,
                magicSquare.length);
    }

    private static int[][] generateOddMagicSquareInSubsquare(int[][] magicSquare,
            int initValue, int minRow, int minColumn, int size) {
        int row = minRow;
        int maxRow = minRow + size - 1;
        int column = minColumn + (size / 2);
        int maxColumn = minColumn + size - 1;
        int value = initValue;
        int maxValue = initValue + size * size - 1;
        magicSquare[row--][column++] = value;
        while (++value <= maxValue) {
            if (column > maxColumn) {
                column = minColumn;
            }
            if (row < minRow) {
                row = maxRow;
            }
            if (row > maxRow) {
                row = minRow;
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

    private static int[][] generateSinglyEvenMagicSquare(int[][] magicSquare) {
        int subSize = magicSquare.length / 2;
        generateOddMagicSquareInSubsquare(magicSquare, 1, 0, 0, subSize);
//        getOddMagicSquareInSubsquare(magicSquare, 2 * subSize * subSize + 1, 0, subSize, subSize);
//        getOddMagicSquareInSubsquare(magicSquare, subSize * subSize + 1, subSize, subSize, subSize);
//        getOddMagicSquareInSubsquare(magicSquare, 3 * subSize * subSize + 1, subSize, 0, subSize);
        int incrementBase = subSize * subSize;
        fillSubSquare(magicSquare, incrementBase, subSize, subSize);
        fillSubSquare(magicSquare, 2 * incrementBase, 0, subSize);
        fillSubSquare(magicSquare, 3 * incrementBase, subSize, 0);
        performLeftTransposition(magicSquare);
        performCentralTransposition(magicSquare);
        return magicSquare;
    }

    private static void fillSubSquare(int[][] magicSquare, int incrementBase,
            int rowOffset, int columnOffset) {
        int initSubSquareLength = magicSquare.length / 2;
        for (int i = 0; i < initSubSquareLength; i++) {
            for (int j = 0; j < initSubSquareLength; j++) {
                magicSquare[i + rowOffset][j + columnOffset] = incrementBase
                        + magicSquare[i][j];
            }
        }
    }

    private static void performLeftTransposition(int[][] magicSquare) {
        int subSize = magicSquare.length / 2;
        int column = 0;
        for (int row = 0; row < subSize; row++) {
            int temp = magicSquare[row][column];
            magicSquare[row][column] = magicSquare[row + subSize][column];
            magicSquare[row + subSize][column] = temp;
            if (row == 0) {
                column++;
            }
            if (row == (subSize - 2)) {
                column--;
            }
        }
    }

    private static void performCentralTransposition(int[][] magicSquare) {
        int subSize = magicSquare.length / 2;
        int centreOffset = (subSize - 3) / 2;
        int leftBoundary = subSize - centreOffset;
        int rightBoundary = subSize + centreOffset - 1;
        for (int row = 0; row < subSize; row++) {
            for (int column = leftBoundary; column <= rightBoundary; column++) {
                int temp = magicSquare[row][column];
                magicSquare[row][column] = magicSquare[row + subSize][column];
                magicSquare[row + subSize][column] = temp;
            }
        }
    }

    private static int[][] generateDoublyEvenMagicSquare(int[][] magicSquare) {
        int size = magicSquare.length;
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
        System.out.println("Please, insert any positive integer, which is" +
                "greater than 2.");
        int n = receivePositiveEvenIntegerFromConsole();
        int[][] magicSquare = generateMagicSquare(n);
        printSquareArray(magicSquare);
        scanner.close();
    }
}
