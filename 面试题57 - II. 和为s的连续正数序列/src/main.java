import java.util.*;

public class main {
    public static void main(String args[]) {
        new Solution_57().findContinuousSequence(9);
    }
}

class Solution_57 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new LinkedList<>();
        int width = 1;
        while (target > 0){
            target -= width-1;
            if (target%width == 0 && width != 1){
                int head = target/width;
                if (head == 0) continue;
                int[] seq = new int[width];
                for (int i=0; i<width; i++) seq[i] = i+head;
                list.add(seq);
            }
            width++;
        }
        Collections.reverse(list);
        int[][] ans = new int[list.size()][];
        return list.toArray(ans);
    }
}
