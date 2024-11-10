package Day13;

import java.util.Arrays;

public class AtomicFactors {
    // O(nlog(log(n)))
    private int[] getSpf(int n){
        boolean[] isPrime=new boolean[n+1];
        int[] res=new int[n+1];
        Arrays.fill(isPrime,true);
        Arrays.fill(res,-1);

        res[0]=0;res[1]=0;
        isPrime[0]=false;isPrime[1]=false;

        int limit=(int)Math.sqrt(n);
        for(int number=2;number<=limit;number++){

            if(isPrime[number]){
                res[number]=number;
                for(int multipleOfNumber=number*number;multipleOfNumber<=n;multipleOfNumber+=number){
                    if(res[multipleOfNumber]==-1) res[multipleOfNumber]=number;
                    isPrime[multipleOfNumber]=false;
                }
            }
        }
        for(int number=2;number<=n;number++){
            if(res[number]==-1) res[number]=number;
        }
        return  res;
    }
    public int[] solve(int[] nums) {
        int n=nums.length;
        if(n==0) return new int[]{};

        int spfArraySize=0;
        for(int v:nums) spfArraySize=Math.max(spfArraySize,v);
        int[] spf=getSpf(spfArraySize);

        int[] res=new int[n];
        // O(nlog(n))
        for(int i=0;i<n;i++){
            int key=nums[i];
            int numberOfFactors=1;
            // log(n)
            while(key>1){
                int smallestPrimeDivisor=spf[key];
                int numberOfTimesDivided=0;
                while(key%smallestPrimeDivisor==0){
                    numberOfTimesDivided++;
                    key/=smallestPrimeDivisor;
                }
                numberOfFactors*=(numberOfTimesDivided+1);
            }
            res[i]=numberOfFactors;
        }
        return res;
    }
}
