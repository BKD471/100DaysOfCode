package Day37;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Pair {
    Character ch;
    int size;

    public Pair(Character ch, int size) {
        this.ch = ch;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return size == pair.size && Objects.equals(ch, pair.ch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ch, size);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "ch=" + ch +
                ", size=" + size +
                '}';
    }
}

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

    // Approach2

    public int maximumLengthApproach2(String s) {
        int n = s.length();
        if (n < 3) return -1;

        Map<String, Integer> hash = new HashMap<>();
        for (int start = 0; start < n; start++) {
            StringBuilder temp = new StringBuilder();
            for (int end = start; end < n; end++) {
                if (temp.isEmpty() || temp.charAt(temp.length() - 1) == s.charAt(end)) {
                    temp.append(s.charAt(end));
                    hash.put(temp.toString(), hash.getOrDefault(temp.toString(), 0) + 1);
                } else break;
            }
        }

        int maxLength = -1;
        for (Map.Entry<String, Integer> value : hash.entrySet()) {
            String str = value.getKey();
            int count = value.getValue();
            if (count >= 3 && str.length() > maxLength) maxLength = str.length();
        }
        return maxLength;
    }

    // Approach 3
    public int maximumLengthApproach3(String s) {
        int n = s.length();
        if (n < 3) return -1;

        Map<Pair, Integer> hash = new HashMap<>();
        for (int start = 0; start < n; start++) {
            char ch = s.charAt(start);
            int strLength = 0;
            for (int end = start; end < n; end++) {
                if (ch == s.charAt(end)) {
                    strLength++;
                    Pair key = new Pair(ch, strLength);
                    hash.put(key, hash.getOrDefault(key, 0) + 1);
                } else break;
            }
        }

        int maxLength = -1;
        for (Map.Entry<Pair, Integer> value : hash.entrySet()) {
            Pair key = value.getKey();
            int count = value.getValue();
            int size = key.size;
            if (count >= 3 && size > maxLength) maxLength = size;
        }
        return maxLength;

    }

    // Approach4
    public int maximumLength(String s) {
        int n = s.length();
        if (n < 3) return -1;
        int[][] freq = new int[26][n + 1];

        int length = 0;
        char prev = s.charAt(0);

        for (int index = 0; index < n; index++) {
            char ch = s.charAt(index);
            if (ch == prev) freq[ch - 'a'][++length]++;
            else {
                length = 1;
                freq[ch - 'a'][length]++;
                prev = ch;
            }
        }

        int maxLength = -1;
        for (int row = 0; row < 26; row++) {
            int sum = 0;
            for (int size = n; size >= 1; size--) {
                sum += freq[row][size];
                if (sum >= 3) {
                    maxLength = Math.max(maxLength, size);
                    break;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "aaaa";

        FindLongestSpecialSubstringThatOcurrsThrice obj = new FindLongestSpecialSubstringThatOcurrsThrice();
        System.out.println(obj.maximumLengthApproach3(str));
    }
}
