package Day11;

public class BathTubs {
    public int solve(int[] nums, int k) {
        int n=nums.length;
        int l=0,h=n-1;
        long count=0;
        while(l<n && h>=0){
            long value=(long)nums[l]*(long)nums[h];
            // A[l] can form rectangles with any of A[0..h]
            if(value<k){
                count=count+h+1;
                l++;
            }else h--;
        }
        return (int) (count%1000000007);
    }

    // 0 1 2 3 4
    // 1 2 3 4 5   k=10
    // l=0,h=4, product=5<10
    // 1X5, 1X4, 1X3, 1X2, 1X1  count=5  l++
    // l=1, h=4 product=10>=10 h--;
    // l=1, h=3 product=8<10
    // 2X1, 2X2, 2X3, 2X4 count=9 l++
    // l=2, h=3  product=12>=10 h--
    // l=2, h=2 product=9<10
    // 3X1, 3X2, 3X3 count=12 l++
    // l=3, h=2 product=12>=10 h--
    // l=3, h=1 product=8<10
    // 4X1, 4X2 count=14 l++
    // l=4, h=1 product=10>=10 h--
    // l=4, h=0 product=5<10
    // 5X1 count=15 l++
    // l=5, h=0



    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int k=10;
        BathTubs a=new BathTubs();
        int res=a.solve(nums,k);
        System.out.println(res);
    }
}
