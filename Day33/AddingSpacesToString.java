package Day33;

import java.util.HashSet;
import java.util.Set;

public class AddingSpacesToString {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        char[] characters = s.toCharArray();
        Set<Integer> hash = new HashSet<>();
        for (int v : spaces) hash.add(v);

        StringBuilder res = new StringBuilder();
        for (int index = 0; index < n; index++) {
            if (hash.contains(index)) res.append(" ").append(characters[index]);
            else res.append(characters[index]);
        }
        return res.toString();
    }
}
