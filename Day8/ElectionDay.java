package Day8;

public class ElectionDay {
    public int repeatedNumber(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;

        int firstMajority = Integer.MIN_VALUE, secondMajority = Integer.MIN_VALUE;
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (firstMajority == num) cnt1++;
            else if (secondMajority == num) cnt2++;
            else if (cnt1 == 0) {
                cnt1 = 1;
                firstMajority = num;
            } else if (cnt2 == 0) {
                cnt2 = 1;
                secondMajority = num;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        int threshold = n / 3;
        int c1 = 0, c2 = 0;
        for (int v : nums) {
            if (v == firstMajority) c1++;
            if (v == secondMajority) c2++;
        }


        if (c1 > threshold) return firstMajority;
        if (c2 > threshold) return secondMajority;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 5, 7};
        ElectionDay obj = new ElectionDay();
        System.out.println(obj.repeatedNumber(nums));
    }
}
