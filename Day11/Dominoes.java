package Day11;

public class Dominoes {
    public int[] solve(int[] nums, int k) {

        int n = nums.length;
        if (n == 0 || k < 0) return new int[]{-1};

        int countOfZeros = 0;
        if (nums[0] == 0) countOfZeros++;

        int l = 0, h = 1;
        int maxLength = 0;
        int firstIndex = -1;
        int lastIndex = -1;
        while (h < n) {
            if (nums[h] == 0) countOfZeros++;
            while (countOfZeros > k) {
                if (nums[l] == 0) countOfZeros--;
                l++;
            }

            int length = h - l + 1;
            if (length > maxLength) {
                maxLength = length;
                firstIndex = l;
                lastIndex = h;
            }
            h++;
        }

        int[] res = new int[maxLength];
        int index = 0;
        for (int i = firstIndex; i <= lastIndex; i++) res[index++] = i;
        return res;
    }
}
