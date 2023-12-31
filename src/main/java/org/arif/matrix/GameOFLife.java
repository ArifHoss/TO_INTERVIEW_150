package org.arif.matrix;

import java.util.Arrays;

public class GameOFLife {
    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int totalRows = board.length;
        int totalColumns = board[0].length;

        // Directions to check for neighbors around a cell
        int[][] neighborDirections = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        // Clone of the original board to reference the original states
        int[][] clonedBoard = new int[totalRows][totalColumns];
        for (int row = 0; row < totalRows; row++) {
            System.arraycopy(board[row], 0, clonedBoard[row], 0, totalColumns);
        }

        // Iterate through each cell of the board
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                // Count live neighbors around the current cell
                int liveNeighborsCount = 0;
                for (int[] direction : neighborDirections) {
                    int neighborRow = row + direction[0];
                    int neighborColumn = column + direction[1];

                    // Check if the neighboring cell is within board limits and alive
                    if (neighborRow >= 0 && neighborRow < totalRows && neighborColumn >= 0 && neighborColumn < totalColumns && clonedBoard[neighborRow][neighborColumn] == 1) {
                        liveNeighborsCount++;
                    }
                }

                // Apply the rules of Game of Life to determine the cell's next state
                if (clonedBoard[row][column] == 1 && (liveNeighborsCount < 2 || liveNeighborsCount > 3)) {
                    board[row][column] = 0; // Cell dies
                } else if (clonedBoard[row][column] == 0 && liveNeighborsCount == 3) {
                    board[row][column] = 1; // Cell becomes alive
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        Arrays.stream(board).forEach(row -> System.out.println(Arrays.toString(row)));
        gameOfLife(board);
        System.out.println("===============");
        Arrays.stream(board).forEach(row -> System.out.println(Arrays.toString(row)));

    }
}
