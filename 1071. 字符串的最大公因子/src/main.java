public class main {
    public static void main(String args[]){
        String str1 =  "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.print(new Solution1071().gcdOfStrings(str1, str2));
    }
}

class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        char[] temp;
        if (str1.length() < str2.length()){
            temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 != s1.length){
            if (s1[ptr1] != s2[ptr2]) return "";
            ptr1++;
            ptr2++;
            if (ptr2 == s2.length) ptr2 = 0;
        }

        return str1.substring(0, GCD(s2.length, ptr2));
    }

    public int GCD(int n1, int n2){
        if (n2 == 0) return n1;
        while (true){
            if (n1 > n2){
                if (n1%n2 == 0) return n2;
                n1 %= n2;
                continue;
            }
            else{
                if (n2%n1 == 0) return n1;
                n2 %= n1;
                continue;
            }
        }
    }
}