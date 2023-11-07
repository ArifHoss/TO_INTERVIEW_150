package org.arif.matrix;

public class ValidSudoku1 {
    public static void main(String[] args) {
        ValidSudoku1 validSudoku1 = new ValidSudoku1();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean validSudoku = validSudoku1.isValidSudoku(board);
        System.out.println(validSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        // Check each row
        for (int row = 0; row < 9; row++) {
            if (!isRowValid(board, row)) {
                return false;
            }
        }

        // Check each column
        for (int colum = 0; colum < 9; colum++) {
            if (!isColumnValid(board, colum)) {
                return false;
            }
        }

        // Check each 3x3 sub-grid
        for (int row = 0; row < 9; row += 3) {
            for (int colum = 0; colum < 9; colum += 3) {
                if (!isSubgridValid(board, row, colum)) {
                    return false;
                }
            }
        }

        // If all checks pass
        return true;
    }

    private boolean isRowValid(char[][] board, int row) {
        boolean[] seen = new boolean[9];
        for (int col = 0; col < 9; col++) {
            if (board[row][col] != '.') {
                if (seen[board[row][col] - '1']) {
                    return false;
                }
                seen[board[row][col] - '1'] = true;
            }
        }
        return true;
    }

    private boolean isColumnValid(char[][] board, int col) {
        boolean[] seen = new boolean[9];
        for (int row = 0; row < 9; row++) {
            if (board[row][col] != '.') {
                if (seen[board[row][col] - '1']) {
                    return false;
                }
                seen[board[row][col] - '1'] = true;
            }
        }
        return true;
    }

    private boolean isSubgridValid(char[][] board, int startRow, int startCol) {
        boolean[] seen = new boolean[9];
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                if (board[row][col] != '.') {
                    if (seen[board[row][col] - '1']) {
                        return false;
                    }
                    seen[board[row][col] - '1'] = true;
                }
            }
        }
        return true;
    }
}

