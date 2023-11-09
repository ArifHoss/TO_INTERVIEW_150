package org.arif;

public class Main {
    public static void main(String[] args) {
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

        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);
    }

    private static boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            if (!isValidRow(row, board)) {
                return false;
            }
        }

        for (int colum = 0; colum < 9; colum++) {
            if (!isValidColum(colum, board)) {
                return false;
            }
        }

        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startColum = 0; startColum < 9; startColum += 3) {
                if (!isSubgridValid(startRow,startColum, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidRow(int row, char[][] board) {
        boolean[] seen = new boolean[9];
        for (int colum = 0; colum < 9; colum++) {
            if (board[colum][row] != '.') {
                if (seen[board[colum][row] - '1']) {
                    return false;
                }
                seen[board[colum][row] - '1'] = true;
            }
        }
        return true;
    }

    private static boolean isValidColum(int colum, char[][] board) {
        boolean[] seen = new boolean[9];
        for (int row = 0; row < 9; row++) {
            if (board[row][colum] != '.') {
                if (seen[board[row][colum] - '1']) {
                    return false;
                }
                seen[board[row][colum] - '1'] = true;
            }
        }

        return true;
    }

    private static boolean isSubgridValid(int startRow, int startColum, char[][] board) {
        boolean[] seen = new boolean[9];
        for (int row = startRow; row < startRow + 3; row++) {
            for (int colum = startColum; colum < startColum + 3; colum++) {
                if (board[row][colum] != '.') {
                    if (seen[board[row][colum] - '1']) {
                        return false;
                    }
                    seen[board[row][colum] - '1'] = true;
                }
            }
        }
        return true;
    }

}