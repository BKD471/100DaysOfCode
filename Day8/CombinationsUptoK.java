package Day8;

import java.util.ArrayList;

public class CombinationsUptoK {
    // O(2^n) , for every n , there are two options, either fill it or not
    private void solve(int[] nums, ArrayList<ArrayList<Integer>> res, int index,
                       int k, ArrayList<Integer> temp) {
        if (index >= nums.length) {
            if (temp.size() == k) res.add(new ArrayList<>(temp));
            return;
        }
        // take
        temp.add(nums[index]);
        solve(nums, res, index + 1, k, temp);

        // dont take int
        temp.removeLast();
        solve(nums, res, index + 1, k, temp);
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i + 1;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        solve(nums, res, 0, k, new ArrayList<>());
        return res;
    }
}
