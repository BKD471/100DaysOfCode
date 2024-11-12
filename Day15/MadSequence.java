package Day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MadSequence {

    /////////////////////////// Approach 1 ///////////////////////////////////

    private int[] countOfPrimeFactors;
    private  long countOfSubseq;

   // O(n)
    private int factorial(int n){
        if(n==0 || n==1) return 1;
        return n*factorial(n-1);
    }

    // O(size of max subsequence found)
    private boolean checkAllHasSameNumberOfPrimeFactors(List<Integer> temp){
        if(temp.isEmpty()) return false;
        for(int i=0;i<temp.size()-1;i++){
            int current=temp.get(i);
            int nextElement=temp.get(i+1);
            if(countOfPrimeFactors[current]!=countOfPrimeFactors[nextElement]) return false;
        }
        return true;
    }

    // O(2^k)  k-> size of factorial array | size of original input array
    private void calculateSubSeq(int[] factorials,int index,List<Integer> temp){
        if(index>=factorials.length){
            if(checkAllHasSameNumberOfPrimeFactors(temp)) this.countOfSubseq++;
            return;
        }

        // take;
        temp.add(factorials[index]);
        calculateSubSeq(factorials,index+1,temp);

        // dont take
        temp.removeLast();
        calculateSubSeq(factorials,index+1,temp);
    }

    // O(number*log(log(number)))
    private void calculateCountOfPrimeFactors(int number){
        boolean[] isPrime=new boolean[number+1];
        this.countOfPrimeFactors=new int[number+1];
        Arrays.fill(isPrime,true);

        isPrime[0]=false;isPrime[1]=false;

        for(int numbers=2;numbers<=number;numbers++){
            if(isPrime[numbers]){
                for(int multipleOfNumber=numbers;multipleOfNumber<=number;multipleOfNumber+=numbers){
                    this.countOfPrimeFactors[multipleOfNumber]++;
                    isPrime[multipleOfNumber]=false;
                }
            }
        }
    }

    // O(k*n + maxElement*log(log(maxElement)) + 2^k) ~ O(2^k)  exponential
    // needs improvement
    public int solveBrute(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;

        int[] factorials=new int[n];
        int maxElement=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
             // k-> size of input array
            // O(k*n)  n-> max number in array
            factorials[i]=factorial(nums[i]);
            maxElement=Math.max(maxElement,factorials[i]);
        }

        // O(maxElement*log(log(maxElement)))
        // calculate the  number of prime factors upto max element
        calculateCountOfPrimeFactors(maxElement);

        this.countOfSubseq=0;
        // O(2^k)  k-> size of factorial array | size of input array
        calculateSubSeq(factorials,0,new ArrayList<>());
        return (int)(countOfSubseq%1000000007);
    }


    /////////////////////////// APPROACH 2 ///////////////////////////////////////
    // O(nlog(log(n))
    private List<Integer> getPrimeNumbers(int number){
        boolean[] isPrime=new boolean[number+1];
        Arrays.fill(isPrime,true);

        isPrime[0]=false;isPrime[1]=false;
        for(int numbers=2;numbers*numbers<=number;numbers++){
            if(isPrime[numbers]){
                for(int multipleOfNumber=numbers*numbers;multipleOfNumber<=number;multipleOfNumber+=numbers){
                    isPrime[multipleOfNumber]=false;
                }
            }
        }

        List<Integer> res=new ArrayList<>();
        for(int numbers=2;numbers<=number;numbers++) if(isPrime[numbers]) res.add(numbers);
        return res;
    }

    // O(log(p)) -> max key found in array
    private int findIndexOfNumberLessThanKey(int[] nums,int index,int key){
        int n=nums.length;
        int l=index,h=n-1;

        int best=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]<key){
                best=mid;
                l=mid+1;
            }else h=mid-1;
        }
        return best;
    }

    // O(n*log(log(n)) + k*log(p))  k-> count of number of prime numbers
    // p -> max key possible
    public int solveBest(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;

        int maxElement=Integer.MIN_VALUE;
        for(int v:nums) maxElement=Math.max(maxElement,v);
        List<Integer> primeNumbersList=getPrimeNumbers(maxElement);

        long countOfSubSeqWithEqualPrimeFactors=0;
        Arrays.sort(nums);
        int index=0;
        while(index<n && nums[index]==1) index++;


        for (int key : primeNumbersList) {
            int indexOfNumbersLessThanKey = findIndexOfNumberLessThanKey(nums, index, key);
            if (indexOfNumbersLessThanKey == -1) continue;

            long countOfNumbersLessThanKey = indexOfNumbersLessThanKey - index + 1;
            index = indexOfNumbersLessThanKey + 1;
            countOfSubSeqWithEqualPrimeFactors += ((long) Math.pow(2, countOfNumbersLessThanKey)) - 1;
        }

        if(index<=n-1) countOfSubSeqWithEqualPrimeFactors+=(long)Math.pow(2,n-index)-1;
        return (int)(countOfSubSeqWithEqualPrimeFactors%1000000007);
    }

    public static void main(String[] args) {
        int[] nums={251,923,561,230,100,399,542,198,548,892,721,781,174,809,9,232,165,861,36,837,377,
                313,475,269,210,530,940,570,24,434,764,275,709,325,505,161,724,47,359,625,291,81,406,465,242,
                767,698,408,629,86,597,358,399,72,979,962,603,919,884,627,353,1,254,414,678,111,575,755,511,287,
                380,802,720,138,620,314,905,670,74,886,756,671,244,508,744,224,822,347,495,706,326,201,707,580,
                615,386,43,543,141,554};

        int[] nums1={2,3,2,3};
        int[] nums2={2};

        int[] nums3={182,873,357,902,11,977,568,916,647,643,155,755,314,399,263,410,975,85,109,823,144,435,24,851,
                367,639,589,411,534,82,965,716,955,674,970,966,651,539,235,650,534,390,406,200,141,669,611,469,
                107,720,292,251,508,316,454,875,307,44,638,194,478,956,910,434,630,
                233,752,634,124,987,284,658,377,690,858,871,712,821,340,819,542,984,422,50,652,876,277,959,272,268,
                505,751,224,768,537,206,1,289,840,477};
        System.out.println(nums3.length);
        MadSequence madSequence=new MadSequence();
        int res=madSequence.solveBest(nums3);
        System.out.println();
        System.out.println(res);
    }
}
