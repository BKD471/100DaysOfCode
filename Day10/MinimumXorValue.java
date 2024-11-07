package Day10;

import java.util.Arrays;

public class MinimumXorValue {
    public int findMinXor(int[] nums) {
        int n=nums.length;
        int res=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=1;i<n;i++){
            res=Math.min(res,nums[i]^nums[i-1]);
        }

        return res;
    }
}
