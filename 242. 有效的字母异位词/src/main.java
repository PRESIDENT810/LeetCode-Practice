public class main {
}

class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[100];
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        for (char c : arr1){
            map[(int) c-65] += 1;
        }
        for (char c : arr2){
            map[(int) c-65] -= 1;
        }
        for (int n : map){
            if (n != 0) return false;
        }
        return true;
    }
}