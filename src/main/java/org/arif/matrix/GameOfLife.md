# Game of Life

## Intuition
The Game of Life is a cellular automaton created by John Conway. It's a zero-player game, meaning its evolution is determined by its initial state. The challenge is to simulate this game given an initial state. My first thought is to iterate through each cell in the given grid, apply the rules of the Game of Life to determine each cell's next state, and update the grid accordingly.

## Approach
To solve this problem, I used a straightforward approach:
1. First, check if the input grid is valid.
2. Create a clone of the original grid to keep track of the initial states of each cell.
3. Iterate through each cell of the grid, using the cloned grid for reference.
4. For each cell, count the number of live neighbors.
5. Apply the Game of Life rules to determine the next state of each cell.
6. Update the original grid with the new states of the cells.

## Complexity
- **Time Complexity**: The time complexity is $$O(m \times n)$$, where $$m$$ is the number of rows and $$n$$ is the number of columns in the grid. This is because we need to iterate over each cell once to compute its next state.

- **Space Complexity**: The space complexity is $$O(m \times n)$$ due to the additional grid (cloned grid) used to store the original state of the cells. This cloned grid is necessary to ensure that the cell state updates are done based on the original states.
````
public class GameOfLife {
    public void updateBoardState(int[][] board) {
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
        GameOfLife gameLife = new GameOfLife();
        int[][] gameBoard = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameLife.updateBoardState(gameBoard);

        // Display the updated state of the game board
        for (int[] row : gameBoard) {
            for (int cellState : row) {
                System.out.print(cellState + " ");
            }
            System.out.println();
        }
    }
}

````