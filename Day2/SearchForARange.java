package Day2;

public class SearchForARange {
    private int findFirstOccurence(int[] nums,int key){
        int n=nums.length;
        int l=0,h=n-1;
        int best=-1;
        boolean isFound=false;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]>=key){
                if(!isFound && nums[mid]==key) isFound=true;
                best=mid;
                h=mid-1;
            }else l=mid+1;
        }
        return isFound?best:-1;
    }

    private int findSecondOccurence(int[] nums,int key){
        int n=nums.length;
        int l=0,h=n-1;
        int best=-1;
        boolean isFound=false;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]<=key){
                if(!isFound && nums[mid]==key) isFound=true;
                best=mid;
                l=mid+1;
            }else h=mid-1;
        }
        return isFound ? best:-1;
    }


    public int[] searchRange(final int[] nums, int key) {
        int n=nums.length;
        if(n==0) return new int[]{-1,-1};
        int first=findFirstOccurence(nums,key);
        int second=findSecondOccurence(nums,key);

        if(first==-1 || second==-1) return new int[]{-1,-1};
        return new int[]{first,second};
    }
}
