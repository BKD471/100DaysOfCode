package Day13;

import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfDumbledore {

    // O(nlog(log(n)))
    public ArrayList<Integer> solve(int n) {
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;isPrime[1]=false;

        int limit=(int)Math.sqrt(n);
        for(int number=2;number<=limit;number++){
            if(isPrime[number]){
                for(int multipleOfNumber=number*number;multipleOfNumber<=n;multipleOfNumber+=number) isPrime[multipleOfNumber]=false;
            }
        }

        ArrayList<Integer> res=new ArrayList<>();
        for(int number=2;number<=n;number++){
            if(isPrime[number]) res.add(number);
        }
        return res;
    }
}
