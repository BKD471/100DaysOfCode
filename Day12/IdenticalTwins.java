package Day12;

import java.util.Arrays;

public class IdenticalTwins {
    private boolean checkIsoMorphic(String a, String b) {
        int[] freq = new int[127];
        Arrays.fill(freq, -1);

        int m = a.length(), n = b.length();
        if (m != n) return false;

        for (int i = 0; i < m; i++) {
            int index1 = a.charAt(i);
            int index2 = b.charAt(i);
            if (freq[index1] != -1 && freq[index1] != index2) return false;
            freq[index1] = index2;
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        return checkIsoMorphic(s, t) && checkIsoMorphic(t, s);
    }

    public static void main(String[] args) {
        String a = "foo";
        String b = "bar";
        IdenticalTwins isoMorphicStrings = new IdenticalTwins();
        boolean res = isoMorphicStrings.isIsomorphic(a, b);
        System.out.println(res);
    }
}
