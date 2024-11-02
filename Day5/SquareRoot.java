package Day5;

public class SquareRoot {
    public int sqrt(int key) {
        if (key == 0) return 0;
        int l = 1, h = key;
        int best = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (mid <= key / mid) {
                best = mid;
                l = mid + 1;
            } else h = mid - 1;
        }
        return best;
    }
}
