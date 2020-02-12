import java.util.*;

public class main {
}

class Solution1346 {
    public boolean checkIfExist(int[] arr) {
        Set set = new HashSet();
        for (int num : arr) {
            if (set.contains((float) num*2) || set.contains((float) num/2)) return true;
            set.add((float) num);
        }
        return false;
    }
}