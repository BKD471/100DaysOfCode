package Day34;

public class IsSubsequence {
    private boolean checkSubsequence(String s, String t, int i, int m, int j, int n) {
        if (i >= m) return true;
        if (j >= n) return false;

        if (s.charAt(i) == t.charAt(j)) return checkSubsequence(s, t, i + 1, m, j + 1, n);
        else return checkSubsequence(s, t, i, m, j + 1, n);
    }

    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) return false;
        return checkSubsequence(s, t, 0, m, 0, n);
    }
}
