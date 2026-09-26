class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int row, int col, int index) {

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Character doesn't match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Last character matched
        if (index == word.length() - 1) {
            return true;
        }

        // Mark current cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Search in 4 directions
        boolean found =
                dfs(board, word, row - 1, col, index + 1) || // UP
                dfs(board, word, row + 1, col, index + 1) || // DOWN
                dfs(board, word, row, col - 1, index + 1) || // LEFT
                dfs(board, word, row, col + 1, index + 1);   // RIGHT

        // Backtracking
        board[row][col] = temp;

        return found;
    }
}