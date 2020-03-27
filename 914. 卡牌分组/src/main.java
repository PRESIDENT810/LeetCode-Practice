import java.util.*;

public class main {
}

class Solution914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck){
            if (!map.containsKey(num)) map.put(num, 1);
            else{
                map.put(num, map.get(num)+1);
            }
        }
        Integer X = null;
        for (int key : map.keySet()){
            if (X == null) X = map.get(key);
            else {
                X = GCD(X, map.get(key));
                if (X == 1) return false;
            }
        }
        return true;
    }

//    public int GCD(int n1, int n2){
//        if (n2 == 0) return n1;
//        while (true){
//            if (n1 > n2){
//                if (n1%n2 == 0) return n2;
//                n1 %= n2;
//                continue;
//            }
//            else{
//                if (n2%n1 == 0) return n1;
//                n2 %= n1;
//                continue;
//            }
//        }
//    }

    public int GCD (int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}