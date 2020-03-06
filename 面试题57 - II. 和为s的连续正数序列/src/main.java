import java.util.*;

public class main {
    public static void main(String args[]) {
        new Solution_57().findContinuousSequence(10);
    }
}

class Solution_57 {
    public int[][] findContinuousSequence(int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new LinkedList<>();
        for (int tail = 0; tail < target / 2 + 2; tail++) {
            int sum = (1 + tail) * tail / 2;
            if (map.containsKey(sum - target)) {
                int head = map.get(sum-target);
                list.add(generate(head, tail));
            }
            map.put(sum, tail);
        }
        int[][] ans = new int[list.size()][];
        return list.toArray(ans);
    }

    public int[] generate(int head, int tail) {
        int[] seq = new int[tail-head];
        for (int i=0; i<tail-head; i++) seq[i] = head+i+1;
        return seq;
    }
}
