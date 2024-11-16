package Day18;

public class ShortestSubArrayToBeRemovedToMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length;
        if(n==0) return 0;

        int rearPointer=n-1;
        while(rearPointer>=1 && arr[rearPointer]>=arr[rearPointer-1]) rearPointer--;
        if(rearPointer==0) return 0;

        int frontPointer=0;
        int minLength=rearPointer;
        while(frontPointer<rearPointer){
            while(rearPointer<n && arr[frontPointer]>arr[rearPointer]) rearPointer++;
            minLength=Math.min(minLength,rearPointer-frontPointer-1);
            frontPointer++;

            if(frontPointer<n && arr[frontPointer]<arr[frontPointer-1]) break;
        }
        return minLength;
    }
}
