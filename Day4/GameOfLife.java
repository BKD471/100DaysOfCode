package Day4;

public class GameOfLife {
    private void bfs(int[][] nums, int[][] res, int row, int col, int m, int n) {
        if (row < 0 || col < 0 || row >= m || col >= n) return;
        int liveCount = 0;
        // up
        if (row > 0 && nums[row - 1][col] == 1) liveCount++;
        // down
        if (row + 1 < m && nums[row + 1][col] == 1) liveCount++;
        // left
        if (col > 0 && nums[row][col - 1] == 1) liveCount++;
        //right
        if (col + 1 < n && nums[row][col + 1] == 1) liveCount++;
        // up-left
        if (row > 0 && col > 0 && nums[row - 1][col - 1] == 1) liveCount++;
        // down-right
        if (row + 1 < m && col + 1 < n && nums[row + 1][col + 1] == 1) liveCount++;
        // down-left
        if (row + 1 < m && col > 0 && nums[row + 1][col - 1] == 1) liveCount++;
        //up-right
        if (row > 0 && col + 1 < n && nums[row - 1][col + 1] == 1) liveCount++;
        if (nums[row][col] == 1 && (liveCount < 2 || liveCount > 3)) res[row][col] = 0;
        else if (liveCount == 3) res[row][col] = 1;
    }

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) System.arraycopy(board[i], 0, res[i], 0, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) bfs(board, res, i, j, rows, cols);
        }

        for (int i = 0; i < rows; i++) System.arraycopy(res[i], 0, board[i], 0, cols);
    }
}
