package Day12;

import java.util.HashSet;
import java.util.Set;

public class ColourfulNumber {
    private long productOfDigits(long num){
        long res=1;
        while(num>0){
            long r=num%10;
            res*=r;
            num/=10;
        }
        return res;
    }

    // tc - O(n^2)
    // sc - O(n)
    public int colorful(int n) {
        String str=String.valueOf(n);
        int size=str.length();

        Set<Long> hash=new HashSet<>();
        for(int i=0;i<size;i++){
            for(int j=i;j<size;j++){
                String substr=str.substring(i,j+1);
                long num=Long.parseLong(substr);
                long product=productOfDigits(num);
                if(hash.contains(product)) return 0;
                hash.add(product);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int num=2634;
        // 2 26 263 2634 6 63 634 3 34 4
        ColourfulNumber colourfulNumber=new ColourfulNumber();
        long res=colourfulNumber.colorful(num);
        System.out.println(res);
    }
}
