package Day4;

public class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        int n = s.length();
        if (n <= 2) return s;
        StringBuilder res = new StringBuilder();

        int count = 1;
        char match = s.charAt(0);
        res.append(match);
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == match) count++;
            else {
                count = 1;
                match = ch;
            }

            if (count >= 3) {
                while (i + 1 < n && ch == s.charAt(i + 1)) i++;
                count = 1;

                if (i + 1 < n) {
                    match = s.charAt(i + 1);
                    res.append(match);
                    i += 1;
                }
                continue;
            }
            res.append(ch);
        }
        return res.toString();
    }
}
