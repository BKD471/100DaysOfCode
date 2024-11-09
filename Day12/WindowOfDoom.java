package Day12;

public class WindowOfDoom {
    private boolean compareStrings(int[] targetFreq, int[] originalFreq) {
        for (int index = 0; index < 127; index++) {
            if (targetFreq[index] > originalFreq[index]) return false;
        }
        return true;
    }

    // O(n)
    public String minWindow(String a, String b) {
        int m = a.length(), n = b.length();
        if (n > m) return "";

        int[] targetFreq = new int[127];
        for (char ch : b.toCharArray()) {
            targetFreq[ch]++;
        }

        int[] originalFreq = new int[127];
        for (int i = 0; i < n; i++) {
            originalFreq[a.charAt(i)]++;
        }

        if (compareStrings(targetFreq, originalFreq)) return a.substring(0, n);

        int l = 0, h = n;
        int minLength = Integer.MAX_VALUE;
        int firstIndex = -1, lastIndex = -1;
        while (h < m) {
            int incomingCharIndex = a.charAt(h);
            originalFreq[incomingCharIndex]++;
            while (compareStrings(targetFreq, originalFreq)) {
                int length = h - l + 1;
                if (length < minLength) {
                    minLength = length;
                    firstIndex = l;
                    lastIndex = h;
                }
                int leavingCharIndex = a.charAt(l);
                originalFreq[leavingCharIndex]--;
                l++;
            }
            h++;
        }
        if (firstIndex == -1) return "";
        return a.substring(firstIndex, lastIndex + 1);
    }

    public static void main(String[] args) {
        String a = "ADOBECODEBANC";
        String b = "BANC";

        String c = "Aa91b";
        String d = "ab";
        WindowOfDoom windowString = new WindowOfDoom();
        String res = windowString.minWindow(c, d);
        System.out.println(res);
    }
}
