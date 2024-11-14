package Day16;

public class ReversePairs {
    private long merge(int[] nums, int l, int mid, int h) {
        int n1 = mid - l + 1;
        int n2 = h - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = nums[l + i];
        for (int i = 0; i < n2; i++) R[i] = nums[mid + 1 + i];


        long invc = 0;
        int index1 = 0, index2 = 0;
        while (index1 < n1) {
            while (index2 < n2 && (long) L[index1] > 2 * (long) R[index2]) {
                invc += n1 - index1;
                index2++;
            }
            if (index2 >= n2) break;
            index1++;
        }


        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) nums[k++] = L[i++];
            else nums[k++] = R[j++];
        }


        while (i < n1) nums[k++] = L[i++];
        while (j < n2) nums[k++] = R[j++];
        return invc;
    }

    private long reversePairs(int[] nums, int l, int h) {
        long invc = 0;
        if (l < h) {
            int mid = l + (h - l) / 2;
            invc += reversePairs(nums, l, mid);
            invc += reversePairs(nums, mid + 1, h);
            invc += merge(nums, l, mid, h);
        }
        return invc;
    }

    public int reversePairs(int[] nums) {
        return (int) (reversePairs(nums, 0, nums.length - 1)%1000000007);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};
        int[] nums1 = {2000000000, 2000000000, -2000000000};
        ReversePairs reversePairs = new ReversePairs();
        int res = reversePairs.reversePairs(nums1);
        System.out.println(res);

    }
}
