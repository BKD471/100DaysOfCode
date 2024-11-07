package Day10;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithZeroSum {
    public int solve(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1 && nums[0]==0) return 1;

        Map<Long,Integer> hash=new HashMap<>();
        long cumSum=0L;
        for(int v:nums){
            cumSum+=v;
            if(cumSum==0) return 1;
            if(hash.containsKey(cumSum)) return 1;
            hash.put(cumSum,1);
        }
        return 0;
    }
}
