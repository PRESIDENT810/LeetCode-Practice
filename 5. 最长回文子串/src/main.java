public class main {
    public static void main(String args[]) {
        System.out.print(new Solution5().longestPalindrome("cbbd"));
    }
}

class Solution5 {
    int start, end;
    int max = 0;
    char[] arr;

    public boolean recursion(int head, int tail) {
        if (head < 0 || tail < 0) return true;
        if (head > tail) return true;

        boolean res = recursion(head+1, tail-1) && (this.arr[head] == this.arr[tail] );

        if (res && tail-head > max ){
            this.start = head;
            this.end = tail;
            this.max = tail - head;
        }
        return res;
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        this.arr = s.toCharArray();
        boolean res;
        for (int i=0; i<arr.length; i++) res = recursion(0, i);
        for (int i=0; i<arr.length; i++) res = recursion(i, arr.length-1);

        return s.substring(this.start, this.end+1);
    }
}