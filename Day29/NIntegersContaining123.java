package Day29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NIntegersContaining123 {
    public ArrayList<Integer> solve(int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k == 1) {
            res.add(1);
            return res;
        }
        if (k == 2) {
            res.add(1);res.add(2);
            return res;
        }
        if (k == 3) {
            res.add(1);res.add(2);res.add(3);
            return res;
        }

        Queue<String> q = new LinkedList<>();
        q.offer("1");q.offer("2");q.offer("3");

        while (k-- > 0) {
            String key = !q.isEmpty() ? q.poll() : "";
            res.add((int) (Long.parseLong(key)));

            q.offer(key + "1");q.offer(key + "2");q.offer(key + "3");
        }
        return res;
    }

    public static void main(String[] args) {
        int k = 17;
        NIntegersContaining123 obj = new NIntegersContaining123();
        System.out.println(obj.solve(k));
    }
}
