public class main {
    public static void main(String args[]){
        System.out.print(new Solution67().addBinary("1010", "1011"));
    }
}

class Solution67 {
    public String addBinary(String a, String b) {
        // switch position so a is always longer than b
        if (a.length() < b.length()){
            String temp = b;
            b = a;
            a = temp;
        }

        StringBuilder result = new StringBuilder();

        int len_a = a.length();
        int len_b = b.length();

        int carry = 0;
        int digit_a = 0;
        int digit_b = 0;

        // now a is longer
        for (int i=0; i<len_a; i++){
            int idx_a = len_a-i-1;
            int idx_b = len_b-i-1;

            digit_a = a.charAt(idx_a)=='1' ? 1: 0;
            if (idx_b < 0) digit_b = 0;
            else digit_b = b.charAt(idx_b)=='1' ? 1: 0;


            switch (digit_a+digit_b+carry){
                case 0: result.append('0'); carry = 0; break;
                case 1: result.append('1'); carry = 0; break;
                case 2: result.append('0'); carry = 1; break;
                case 3: result.append('1'); carry = 1; break;
            }
        }

        if (carry == 1) result.append('1');

        result = result.reverse();

        return new String(result);
    }
}