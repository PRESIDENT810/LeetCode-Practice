import java.util.*;

public class main {
}

class Solution1346 {
    public boolean checkIfExist(int[] arr) {
        Set set = new HashSet();
        for (int num : arr) {
            if (set.contains(num*2) || set.contains(num/2)) return true;
            set.add(num);
        }
        return false;
    }
}