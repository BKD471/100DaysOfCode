package Day26;

import java.util.LinkedList;
import java.util.Queue;

public class PastMistakes {
    public String solve(int k) {
        if (k == 1) return "11";
        if (k == 2) return "22";

        Queue<String> q = new LinkedList<>();
        q.offer("1");
        q.offer("2");

        String res = "";
        while (k-- > 0) {
            res = q.poll();
            q.offer(res + "1");
            q.offer(res + "2");
        }

        return res + new StringBuilder(res).reverse();
    }
}
