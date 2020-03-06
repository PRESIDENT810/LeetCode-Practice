import java.util.*;

public class main {
    public static void main(String args[]) {
        new Solution_57().findContinuousSequence(9);
    }
}

class Solution_57 {
    public int[][] findContinuousSequence(int target) {
        int ptr1 = 1;
        int ptr2 = 1;
        List<int[]> list = new LinkedList<>();
        while (ptr1 <= target / 2 + 1) {
            int sum = (ptr1 + ptr2) * (ptr1 - ptr2 + 1) / 2;
            if (sum < target) ptr1++;
            else if (sum > target) ptr2++;
            else {
                int[] seq = new int[ptr1-ptr2+1];
                for (int i=0; i<ptr1-ptr2+1; i++) seq[i] = ptr2+i;
                list.add(seq);
                ptr1++;
            }
        }
        int[][] ans = new int[list.size()][];
        return list.toArray(ans);
    }
}
