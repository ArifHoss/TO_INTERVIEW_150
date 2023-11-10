package org.arif.matrix;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        };
        int[][] matrix1 = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5},
        };


        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        System.out.println("MATRIX TWO");
        Arrays.stream(matrix1).forEach(row -> System.out.println(Arrays.toString(row)));
        setZeroes(matrix);
        setZeroes(matrix1);
        System.out.println("AFTER SET TO ZEROES");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        System.out.println("MATRIX TWO");
        Arrays.stream(matrix1).forEach(row -> System.out.println(Arrays.toString(row)));

    }

    public static void setZeroes(int[][] matrix) {

        Set<Integer> rowsToZero = new HashSet<>();
        Set<Integer> columnToZero = new HashSet<>();

        // First pass - identify zeros
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {

                if (matrix[row][column] == 0) {
                    rowsToZero.add(row);
                    columnToZero.add(column);
                }
            }
        }

        // Second pass - set zeros
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (rowsToZero.contains(row) || columnToZero.contains(column)) {
                    matrix[row][column] = 0;
                }
            }
        }

    }

    public static void setZeroes1(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        // Check if first row and column need to be set to zero

        for (int row = 0; row < rowLength; row++) {
            if (matrix[row][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int column = 0; column < columnLength; column++) {
            if (matrix[0][column] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Use first row and column as markers for rows and columns to be zeroed
        for (int row = 1; row < rowLength; row++) {
            for (int column = 1; column < columnLength; column++) {
                if (matrix[row][column] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }

        // Zeroing rows and columns based on markers
        for (int row = 1; row < rowLength; row++) {
            for (int column = 1; column < columnLength; column++) {
                if (matrix[row][0] == 0 || matrix[0][column] == 0) {
                    matrix[row][column] = 0;
                }
            }
        }

        // Zeroing first row and column if needed
        if (firstColZero) {
            for (int row = 0; row < rowLength; row++) {
                matrix[row][0] = 0;
            }
        }
        if (firstRowZero) {
            for (int column = 0; column < columnLength; column++) {
                matrix[0][column] = 0;
            }
        }
    }

}
