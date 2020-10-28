import java.util.*;

class main {
    public static void main(String args[]){
        int[] arr = {1,2,2,1,1,3};
        new Solution1207().uniqueOccurrences(arr);
    }
}

class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: arr){
            if (map.containsKey(n)) map.put(n, map.get(n)+1);
            else map.put(n, 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == map.size();
    }
}