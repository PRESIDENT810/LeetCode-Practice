class main {
    public static void main(String args[]){
        String s = "cc";
        System.out.print(new Solution_50().firstUniqChar(s));
    }
}

class Solution_50 {
    public char firstUniqChar(String s) {
        int[] occur = new int[26];
        int[] order = new int[26];
        for (int i=0; i<26; i++){
            occur[i] = -1;
        }
        char[] arr = s.toCharArray();

        for (int i=0; i<arr.length; i++){
            // -1: not occur; 0: occur once; 1: occur more than once
            if (occur[(int) arr[i] - 97] == -1) {
                occur[(int) arr[i] - 97] = 0;
                order[(int) arr[i] - 97] = i;
            }
            else if (occur[(int) arr[i] - 97] == 0) {
                occur[(int) arr[i] - 97] = 1;
            }
        }
        int min = arr.length+1;
        for (int i=0; i<26; i++){
            if (occur[i] == 0) min = min < order[i] ? min : order[i];
        }
        return min != arr.length+1 ? arr[min] : ' ';
    }
}