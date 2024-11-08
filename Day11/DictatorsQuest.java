package Day11;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class DictatorsQuest {
    public int[] solve(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (n == 0) return nums1;

        Map<Integer, Integer> hash = new TreeMap<>();
        for (int v : nums1) hash.put(v, hash.getOrDefault(v, 0) + 1);

        int[] res = new int[m];
        int index = 0;
        for (int v : nums2) {
            int count = hash.getOrDefault(v, 0);
            while (count-- > 0) res[index++] = v;
            hash.remove(v);
        }
        for (int v : hash.keySet()) {
            int count = hash.get(v);
            while (count-- > 0) res[index++] = v;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 4};
        int[] nums2 = {5, 4, 2};
        int[] nums3 = {5, 17, 100, 11};
        int[] nums4 = {1, 100};
        DictatorsQuest sortArrayInGivenOrder = new DictatorsQuest();
        int[] res = sortArrayInGivenOrder.solve(nums3, nums4);
        Arrays.stream(res).forEach(i -> System.out.print(i + " "));
    }
}
