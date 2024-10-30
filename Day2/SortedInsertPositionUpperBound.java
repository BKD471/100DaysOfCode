package Day2;

/*
You are given a sorted array A of size N and a target value B.
Your task is to find the index (0-based indexing) of the target value in the array.

If the target value is present, return its index.
If the target value is not found, return the index of least element greater than equal to B.
If the target value is not found and least number greater than equal to target is also not present,
return the length of array (i.e. the position where target can be placed)
Your solution should have a time complexity of O(log(N)).

A = [1, 3, 5, 6]
B = 5
2

A = [1, 4, 9]
B = 3
1
* */

public class SortedInsertPositionUpperBound {
    public int searchInsert(int[] nums, int key) {
        int n=nums.length;
        if(n==0) return 0;

        // upper bound
        int l=0,h=n-1;
        int best=n;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==key) return mid;
            if(nums[mid]>key){
                best=mid;
                h=mid-1;
            }else l=mid+1;
        }
        return best;
    }
}
