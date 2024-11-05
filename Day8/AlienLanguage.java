package Day8;

public class AlienLanguage {
    // O(row)
    public int solve(int row, int k) {
        // 0
        // 01
        // 0110
        // 01101001
        // 0110100110010110

        if (row == 1 && k == 1) return 0;

        int rowLength = (int) Math.pow(2, row - 1);
        int mid = rowLength / 2;

        if (k <= mid) return solve(row - 1, k);
        return 1 - solve(row - 1, k - mid);
    }
}
