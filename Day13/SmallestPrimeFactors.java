package Day13;

import java.util.Arrays;

public class SmallestPrimeFactors {
    // O(nlog(log(n)))
    private int[] spf(int n){
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
}
