package Day2;
/*
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors.
For corner elements, we need to consider only one neighbor.

NOTE:

It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time.
The array may contain duplicate elements.


A = [1, 2, 3, 4, 5]
5

A = [5, 17, 100, 11]
100
* */

public class FindPeakElement {
    public int solve(int[] nums) {
        int n=nums.length;
        if(n==0) return -1;

        int l=0,h=n-1;
        while(l<=h){
            int mid=l+(h-l)/2;

            if((mid==0 || nums[mid]>=nums[mid-1])
                    && (mid==n-1 || nums[mid]>=nums[mid+1])) return nums[mid];
            if(mid>0 && nums[mid]>=nums[mid-1]) l=mid+1;
            else h=mid-1;
        }
        return nums[n-1];
    }
}
