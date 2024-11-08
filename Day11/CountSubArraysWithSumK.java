package Day11;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithSumK {
    // tc - O(n^3)
    // find all sub arrays and calculate sum
    public int subarraySum(int[] nums, int target) {
        int n=nums.length;
        if(n==0) return 0;

        long count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                long sum=0L;
                for(int k=i;k<=j;k++) sum+=nums[k];
                if(sum==target) count++;
            }
        }

        return (int)count;
    }

    // using prefix sum, instead of using a separate loop to calculate sum
    // use prefix sum technique
    // tc - O(n^2)
    public int subarraySumPrefixSUmTechnique(int[] nums, int target) {
        int n=nums.length;
        if(n==0) return 0;

        long[] ps=new long[n];
        ps[0]=nums[0];
        for(int i=1;i<n;i++) ps[i]=ps[i-1]+nums[i];

        long count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                long sum=(i>0) ? ps[j]-ps[i-1]:ps[j];
                if(sum==target) count++;
            }
        }

        return (int)count;
    }

    // using hash
    // tc-> O(n)
    // sc -> O(n)
    public int subarraySumBest(int[] nums, int k) {
        int n=nums.length;
        if(n==0) return 0;

        Map<Long,Long> hash=new HashMap<>();
        long cumSum=0L;

        long count=0;
        for(long v:nums){
            cumSum+=v;
            if(cumSum==k){
                count++;
            }
            if(hash.containsKey(cumSum-k)){
                count+=hash.get(cumSum-k);
            }
            hash.put(cumSum,hash.getOrDefault(cumSum,0L)+1);
        }
        return (int)count;
    }
}
