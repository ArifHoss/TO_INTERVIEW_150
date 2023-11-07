package org.arif.matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    char[][] board;
    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        int length = board.length;

        for (int i = 0; i < length; i++) {
            if (!checkIfValid(i, 0, i, length - 1)) return false;
            if (!checkIfValid(0, i, length - 1, i)) return false;
        }
        for (int startRow = 0; startRow < length; startRow += 3) {
            for (int startColum = 0; startColum < length; startColum += 3) {
                if (!checkIfValid(startRow,startColum, startRow+2, startColum +2)) return false;
            }
        }
        return true;
    }

    private boolean checkIfValid(int startRow, int startColum, int endRow, int endColum) {
        int[] check = new int[9];
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColum; j <= endColum; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (check[c - '1'] >= 1) return false;
                    check[c - '1']++;
                }
            }
        }
        return true;
    }


    public boolean isValidSudoku1(char[][] board) {
        Set<String> seenNumbers = new HashSet<>();

        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 9; columnIndex++) {
                char currentNumber = board[rowIndex][columnIndex];
                if (currentNumber != '.') {
                    String rowCondition = currentNumber + " in row " + rowIndex;
                    String columnCondition = currentNumber + " in column " + columnIndex;
                    String blockCondition = currentNumber + " in block " + rowIndex / 3 + "-" + columnIndex / 3;

                    if (!seenNumbers.add(rowCondition) ||
                            !seenNumbers.add(columnCondition) ||
                            !seenNumbers.add(blockCondition)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
