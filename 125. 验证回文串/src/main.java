public class main {
    public static void main(String args[]){
    }
}

class Solution125 {
    public boolean valid(char c) {
        if ((int) c >= 97 && (int) c <= 122) return true;
        else if ((int) c >= 48 && (int) c <= 57) return true;
        return false;
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        s = s.toLowerCase();

        int head = 0;
        int tail = s.length() - 1;

        while (head != tail) {
            if (!valid(s.charAt(head))) {head++; continue;}
            if (!valid(s.charAt(tail))) {tail--; continue;}

            if (s.charAt(head) != s.charAt(tail)) return false;
            head++;
            tail--;
        }
        return true;
    }
}