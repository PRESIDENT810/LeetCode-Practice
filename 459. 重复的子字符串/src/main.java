public class main {
    public static void main(String args[]) {
        new Solution459().repeatedSubstringPattern("abaababaab");
    }
}

class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2) return false;

        char[] arr = s.toCharArray();
        int ptr1 = 0;
        int ptr2 = 1;
        int flag = -1;

        while (ptr2 != arr.length) {
            while (arr[ptr1] != arr[ptr2]) {
                ptr2++;
                if (ptr2 == arr.length) return false;
            }
            flag = ptr2;
            while (arr[ptr1] == arr[ptr2]) {
                ptr1++;
                ptr2++;
                if (ptr1 == flag) ptr1 = 0;
                if (ptr2 == arr.length) return ptr1 == 0;
            }
            ptr1 = 0;
            ptr2 = flag+1;
        }
        return false;
    }
}
