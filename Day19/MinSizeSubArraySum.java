package Day19;

public class MinSizeSubArraySum {
    public int minSubArrayLen(int k, int[] nums) {
        int n=nums.length;
        if(n==0) return 0;

        int sum=0;
        int minLength=Integer.MAX_VALUE;

        int l=0,h=0;
        while(h<n){
            sum+=nums[h];
            while(sum>=k){
                minLength=Math.min(minLength,h-l+1);
                sum-=nums[l++];
            }
            h++;
        }
        return minLength!=Integer.MAX_VALUE? minLength:0;
    }
}
