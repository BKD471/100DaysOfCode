package Day2;

/*
Given a sorted array of integers A where every element appears twice except
for one element which appears once,
find and return this single element that appears only once.

Elements which are appearing twice are adjacent to each other.
NOTE: Users are expected to solve this in O(log(N)) time.

[1, 1, 7]
7

[2,2,3,3,5,6,6]
5

* */

public class SingleElementInSortedArray {
    public int solve(int[] nums) {
        int n=nums.length;
        if(n==0) return -1;
        if(n==1) return nums[0];

        int l=0,h=n-1;
        while(l<=h){
            int mid=l+(h-l)/2;

            if((mid==0 || nums[mid]!=nums[mid-1]) && (mid+1==n || nums[mid]!=nums[mid+1])) return nums[mid];
            // if current index is odd, and its second element the serach in next half
            // if current index is even, and its first element the serach in next half
            if((mid%2!=0 && mid>0 && nums[mid]==nums[mid-1]) || (mid%2==0 && mid+1<n && nums[mid]==nums[mid+1])) l=mid+1;
            else h=mid-1;
        }
        return -1;
    }
}
