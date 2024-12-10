package Day37;

import java.util.HashSet;
import java.util.Set;

public class FindLongestSpecialSubstringThatOcurrsThrice {
    // Approach 1

    private boolean special(String str, int start, int end) {
        if (start == end) return true;
        char firstChar = str.charAt(start);
        for (int index = start + 1; index <= end; index++) {
            char currentChar = str.charAt(index);
            if (firstChar != currentChar) return false;
        }
        return true;
    }

    private String getSubstring(String str, int start, int end) {
        if (start == end) return "" + str.charAt(start);

        StringBuilder res = new StringBuilder();
        for (int index = start; index <= end; index++) res.append(str.charAt(index));
        return res.toString();
    }

    public int maximumLengthApproach1(String s) {
        int n = s.length();
        if (n < 3) return -1;

        // generate all special substrings
        Set<String> specialStringList = new HashSet<>();
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                if (special(s, start, end)) {
                    String specialString = getSubstring(s, start, end);
                    specialStringList.add(specialString);
                }
            }
        }

        int maxLength = 0;
        for (String str : specialStringList) {
            int windowSize = str.length();
            int count = 0;
            if (getSubstring(s, 0, windowSize - 1).equals(str)) count++;

            int l = 1, h = windowSize;
            while (h < n) {
                if (getSubstring(s, l, h).equals(str)) count++;
                l++;
                h++;
            }
            if (count >= 3) maxLength = Math.max(maxLength, windowSize);
        }
        return maxLength;
    }

    public static void main(String[] args) {

    }
}
