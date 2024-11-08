package Day11;

import java.util.Arrays;
import java.util.PriorityQueue;


class IndexPairs {
    int i, j, diff;

    IndexPairs(int i, int j, int diff) {
        this.i = i;
        this.j = j;
        this.diff = diff;
    }
}


public class CloseFriends {
    // tc - O(m+n)
    // if for every pairs, absoluteDiff<=minDiff then O(m+n)XO(logP)
    // sc- O(p) for pq
    public int[] solve(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;

        int i = 0, j = n - 1;
        int minDIff = Integer.MAX_VALUE;


        PriorityQueue<IndexPairs> pq = new PriorityQueue<>((a, b) -> {
            if (a.diff < b.diff) return -1;
            else if (a.diff == b.diff) {
                if (a.i < b.i) return -1;
                if (a.i == b.i) return a.j - b.j;
            }
            return 0;
        });

        while (i < m && j >= 0) {
            int key = nums1[i] + nums2[j];
            int diff = key - k;
            int absoluteDiff = Math.abs(diff);
            if (absoluteDiff <= minDIff) {
                minDIff = absoluteDiff;
                pq.offer((new IndexPairs(i, j, absoluteDiff)));
            }
            if (diff > 0) j--;
            else i++;
        }
        if (pq.isEmpty()) return new int[]{-1, -1};
        IndexPairs pairs = pq.poll();
        int index1 = pairs.i;
        int index2 = pairs.j;
        return new int[]{nums1[index1], nums2[index2]};
    }

    // tc -> O(m+n)
    public int[] solveAnotherApproach(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;

        int i = 0, j = n - 1;
        int minDIff = Integer.MAX_VALUE;
        int index1 = Integer.MAX_VALUE, index2 = Integer.MAX_VALUE;

        while (i < m && j >= 0) {
            int key = nums1[i] + nums2[j];
            int diff = key - k;
            int absoluteDiff = Math.abs(diff);
            if (absoluteDiff < minDIff) {
                minDIff = absoluteDiff;
                index1 = i;
                index2 = j;
            }
            // check for the smallest index
            else if (absoluteDiff == minDIff && i == index1) index2 = j;
            if (diff > 0) j--;
            else i++;
        }

        return new int[]{nums1[index1], nums2[index2]};
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 10, 20};
        int[] nums2 = {1, 2, 30};
        int c = 13;
        CloseFriends sol = new CloseFriends();
        int[] res = sol.solve(nums1, nums2, c);

        Arrays.stream(res).forEach(System.out::println);
    }
}
