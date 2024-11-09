package Day12;

import java.util.HashSet;
import java.util.Set;

public class MadSubArrays {
    private boolean checkSubArray(int[] nums, int l, int h) {
        Set<Integer> hash = new HashSet<>();
        for (int i = l; i <= h; i++) {
            if (hash.contains(nums[i])) return false;
            hash.add(nums[i]);
        }
        return true;
    }

    // O(n^3)
    public int solveBrute(int[] nums) {
        //[1,1,3]

        // 1            done
        // 1, 1
        // 1, 1, 3
        //    1         done
        //    1, 3      done
        //       3      done
        int n = nums.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkSubArray(nums, i, j)) count++;
            }
        }
        return (int) (count % 1000000007);
    }

    // O(n^2)
    public int solveBetter(int[] nums) {
        //[1,1,3]

        // 1            done
        // 1, 1
        // 1, 1, 3
        //    1         done
        //    1, 3      done
        //       3      done


        // [2,1,2]
        //  2            done
        //  2 1          done
        //  2 1 2
        //    1         done
        //    1 2       done
        //       2      done
        int n = nums.length;
        long count = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> hash = new HashSet<>();
            for (int j = i; j < n; j++) {
                int key = nums[j];
                if (hash.contains(key)) break;
                hash.add(key);
                count++;
            }
        }
        return (int) (count % 1000000007);
    }

    // O(n)
    public int solveBest(int[] nums) {
        // 1 2 3
//           1         ok
//           1 2       ok
//           1 2 3     ok
//             2       ok
//             2 3     ok
//               3     ok
//                               remarks
//           1     2    3
//           i,j                 count=1
//           i    j              count=1+2=3
//           i          j        count=3+3=6


//           1 1 3
//
//           1         ok
//           1 1
//           1 1 3
//             1       ok
//             1 3     ok
//               3     ok
//
//           1   1   3    remarks
//           ij           count=1
//           i   j        duplicates reduce windows  & count=1
//
//
//                i,j      count=1+1=2
//                i   j    count=2+2=4
//
//
//           1 3 1
//           1         ok
//           1 3       ok
//           1 3 1
//             3       ok
//             3 1     ok
//                1    ok
//
//           1  3  1     remarks
//           ij          count=1
//           i  j        count=1+2=3
//           i      j    duplicates so reduce widnow size
//              i   j    count=3+2=5


        int n = nums.length;
        long count = 0;

        int l = 0, h = 0;
        Set<Integer> hash = new HashSet<>();
        while (h < n) {
            int key = nums[h];
            while (hash.contains(key)) {
                hash.remove(nums[l]);
                l++;
            }
            hash.add(key);
            // count of sub arrays ending at h is (h-l+1)
            // 0 1
            // 1 2 3
            // l h
            //   1-0+1=2  => [2], [1, 2]
            count = count + (h - l + 1);
            h++;
        }
        return (int) (count % 1000000007);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        int[] nums1 = {2, 1, 2};
        MadSubArrays countSubArrays = new MadSubArrays();
        int res = countSubArrays.solveBest(nums);
        System.out.println(res);
    }
}
