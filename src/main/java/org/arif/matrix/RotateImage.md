# Intuition
To rotate the matrix by 90 degrees clockwise, I initially think of flipping the image over its main diagonal (transposing the matrix) and then flipping it horizontally (reversing each row). This approach ensures that the rotation is achieved without the need for extra space for another matrix.

# Approach
The solution consists of two main steps:
1. Transpose the matrix in-place by swapping `matrix[i][j]` with `matrix[j][i]` for all `i < j`.
2. Reverse each row in the transposed matrix by swapping the elements at the start and end of each row and moving inward.

# Complexity
- Time complexity:
  The time complexity is $$O(n^2)$$ since we need to access each element of the `n x n` matrix once when we transpose it and once more when we reverse each row.

- Space complexity:
  The space complexity is $$O(1)$$ as the rotation is done in-place without using any additional space proportional to the input size.

# Pseudo-Code # Mind-map

````
function rotateImage(matrix):
    n = length(matrix)

    // Transpose the matrix
    for i from 0 to n-1:
        for j from i+1 to n-1:
            // Swap elements at matrix[i][j] and matrix[j][i]
            temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp

    // Reverse each row
    for i from 0 to n-1:
        for j from 0 to n/2-1:
            // Swap elements at matrix[i][j] and matrix[i][n-j-1]
            temp = matrix[i][j]
            matrix[i][j] = matrix[i][n-j-1]
            matrix[i][n-j-1] = temp

````

# Code
```
class Solution {
    public void rotate(int[][] matrix) {
      int n = matrix.length;
    int temp;

    // Transpose the matrix
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    // Reverse each row
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n / 2; j++) {
            temp = matrix[i][j];
            matrix[i][j] = matrix[i][n - 1 - j];
            matrix[i][n - 1 - j] = temp;
        }
    }
    }
}
```