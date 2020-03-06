import java.util.*;

public class main {
    public static void main(String args[]){
        new Solution_57().findContinuousSequence(10);
    }
}

class Solution_57 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new LinkedList<>();
        for (double i=0.5; i<target/2; i+=0.5){
            if (target%i == 0) {
                int[] seq = findSeq(i, target);
                if (seq != null) list.add(seq);
            }
        }
        int[][] ans = new int[list.size()][];
        return list.toArray(ans);
    }

    public int[] findSeq(double mid, int target){
        int width = (int) (target/mid);
        if (width%2 == 0 && mid%1 == 0) return null;
        double start = mid-width*0.5;
        if (start%1 != 0) start += 0.5;
        int[] seq = new int[width];
        if (start <= 0) return null;
        for (int i=0; i<width; i++) seq[i] = (int) start+i;
        return seq;
    }
}
