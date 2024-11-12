package Day15;

public class InversionCount {
    private long merge(int[] nums, int l, int mid, int h) {
        int n1 = mid - l + 1;
        int n2 = h - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = nums[l + i];
        for (int i = 0; i < n2; i++) R[i] = nums[mid + 1 + i];

        int i = 0, j = 0, k = l;
        long invc = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) nums[k++] = L[i++];
            else {
                invc += (n1 - i);
                nums[k++] = R[j++];
            }
        }

        while (i < n1) nums[k++] = L[i++];
        while (j < n2) nums[k++] = R[j++];
        return invc;
    }

    // O(nlogn)
    private long inversionCount(int[] nums, int l, int h) {
        long invc = 0;
        if (l < h) {
            int mid = l + (h - l) / 2;
            invc += inversionCount(nums, l, mid);
            invc += inversionCount(nums, mid + 1, h);
            invc += merge(nums, l, mid, h);
        }
        return invc;
    }

    public int solve(int[] nums) {
        int n = nums.length;
        return (int) (inversionCount(nums, 0, n - 1) % 1000000007);
    }
}
