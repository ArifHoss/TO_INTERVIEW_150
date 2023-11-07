function isValidSudoku(board) {
    // Check each row
    for (let i = 0; i < 9; i++) {
        if (!isRowValid(board, i)) {
            return false;
        }
    }

    // Check each column
    for (let j = 0; j < 9; j++) {
        if (!isColumnValid(board, j)) {
            return false;
        }
    }

    // Check each 3x3 sub-grid
    for (let row = 0; row < 9; row += 3) {
        for (let col = 0; col < 9; col += 3) {
            if (!isSubgridValid(board, row, col)) {
                return false;
            }
        }
    }

    // If all checks pass
    return true;
}

function isRowValid(board, row) {
    const seen = new Set();
    for (let col = 0; col < 9; col++) {
        const value = board[row][col];
        if (value !== '.') {
            if (seen.has(value)) {
                return false;
            }
            seen.add(value);
        }
    }
    return true;
}

function isColumnValid(board, col) {
    const seen = new Set();
    for (let row = 0; row < 9; row++) {
        const value = board[row][col];
        if (value !== '.') {
            if (seen.has(value)) {
                return false;
            }
            seen.add(value);
        }
    }
    return true;
}

function isSubgridValid(board, startRow, startCol) {
    const seen = new Set();
    for (let row = startRow; row < startRow + 3; row++) {
        for (let col = startCol; col < startCol + 3; col++) {
            const value = board[row][col];
            if (value !== '.') {
                if (seen.has(value)) {
                    return false;
                }
                seen.add(value);
            }
        }
    }
    return true;
}
