package org.arif.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        List<Integer> spiralOrder = spiralOrder(matrix);
        System.out.println(spiralOrder);
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        List<Integer> spiralOrderList = new ArrayList<>();

        int startRow = 0;
        int endRow = matrix.length - 1;

        int startColum = 0;
        int endColum = matrix[0].length - 1;

        while (startRow <= endRow && startColum <= endColum) {
            for (int colum = startColum; colum <= endColum; colum++) {
                spiralOrderList.add(matrix[startRow][colum]);
            }
            startRow++;
            for (int row = startRow; row <= endRow; row++) {
                spiralOrderList.add(matrix[row][endColum]);
            }
            endColum--;

            if (startRow <= endRow) {
                for (int column = endColum; column >= startColum; column--) {
                    spiralOrderList.add(matrix[endRow][column]);
                }
            }
            endRow--;


            if (startColum <= endColum) {
                for (int row = endRow; row >= startRow; row--) {
                    spiralOrderList.add(matrix[row][startColum]);
                }
            }
            startColum++;
        }

        return spiralOrderList;
    }

}
