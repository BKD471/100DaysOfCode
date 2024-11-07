package Day10;

import java.util.HashMap;
import java.util.Map;

public class ScoobyDoo {
    public int solve(int[] nums) {
        int n=nums.length;

        Map<Integer,Integer> hash=new HashMap<>();
        int minDistance=Integer.MAX_VALUE;
        for(int index=0;index<n;index++){
            int value=nums[index];
            if(hash.containsKey(value)) minDistance=Math.min(minDistance,index-hash.get(value));
            else hash.put(value,index);
        }
        return minDistance!=Integer.MAX_VALUE ? minDistance:-1;
    }
}
