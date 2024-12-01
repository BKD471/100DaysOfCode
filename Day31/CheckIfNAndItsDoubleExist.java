package Day31;

import java.util.Map;
import java.util.HashMap;

public class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        if (n == 0) return false;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int index = 0; index < n; index++) hash.put(arr[index], index);

        for (int index = 0; index < n; index++) {
            int key = arr[index] * 2;
            if (hash.containsKey(key) && hash.get(key) != index) return true;
        }
        return false;
    }
}
