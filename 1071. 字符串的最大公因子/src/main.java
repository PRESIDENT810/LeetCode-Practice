public class main {
    public static void main(String args[]){
        String str1 =  "ABCABC";
        String str2 = "ABC";
        System.out.print(new Solution1071().gcdOfStrings(str1, str2));
    }
}

class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int start1 = s1.length-1;
        int start2 = s2.length-1;
        int ptr1 = start1;
        int ptr2 = start2;

        while (ptr1 != 0 || ptr2 != 0) {
            if (s1[ptr1] != s2[ptr2]) return "";
            if (ptr2 == 0) {
                ptr2 = start2;
                ptr1--;
                start1 = ptr1;
                continue;
            }
            if (ptr1 == 0) {
                ptr1 = start1;
                ptr2--;
                start2 = ptr2;
                continue;
            }
            ptr1--;
            ptr2--;
        }
        return str1.substring(0, start1+1);
    }
}