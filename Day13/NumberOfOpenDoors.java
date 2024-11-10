package Day13;

import java.util.Arrays;

public class NumberOfOpenDoors {

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
    public int solve(int n) {
        if(n==0) return 0;
        int[] spf=getSpf(n);

        int countOfOpenDoors=0;
        for(int number=1;number<=n;number++){
            // count number of factors for numbers/countOfOpenDoors
            // if odd then its opened
            if(number==1) {
                countOfOpenDoors++;
                continue;
            }

            int numberOfFactors=1;
            // log(n)
            int key=number;
            while(key>1){
                int smallestPrimeDivisor=spf[key];
                int numberOfTimesDivided=0;
                while(key%smallestPrimeDivisor==0){
                    numberOfTimesDivided++;
                    key/=smallestPrimeDivisor;
                }
                numberOfFactors*=(numberOfTimesDivided+1);
            }
            if((numberOfFactors&1)==1) countOfOpenDoors++;
        }
        return countOfOpenDoors;
    }

    public int solveBest(int n) {
        if(n==0) return 0;
        return (int)Math.sqrt(n);
    }
}
