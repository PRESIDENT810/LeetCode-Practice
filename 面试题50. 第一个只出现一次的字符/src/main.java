class main {
    public static void main(String args[]) {
        String s = "leetcode";
        System.out.print(new Solution_50().firstUniqChar(s));
    }
}

class Solution_50 {
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';

        int[] map = new int[27];
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            // 0: not occur; positive: occur once; negative: occur more than once
            if (map[(int) arr[i] - 97] == 0) {
                map[(int) arr[i] - 97] = i+1;
            } else if (map[(int) arr[i] - 97] > 0) {
                map[(int) arr[i] - 97] *= -1;
            }
        }
        int min = arr.length + 1;
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) min = min < map[i] ? min : map[i];
        }
        return min != arr.length + 1 ? arr[min-1] : ' ';
    }
}