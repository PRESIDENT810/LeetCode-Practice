import java.util.*;

public class main {
}

class Solution169 {
    public int majorityElement(int[] nums) {
        Map map = new HashMap();

        for (int i:  nums){
            if (map.containsKey(i)) map.put(i, (int) map.get(i)+1);
            else map.put(i, 1);
        }

        int max = 0;
        int max_key = 0;
        int value;
        for (Object key: map.keySet()){
            value = (int) map.get(key);
            if (max < value ) {max = value; max_key = (int) key;}
        }
        return max_key;
    }
}
