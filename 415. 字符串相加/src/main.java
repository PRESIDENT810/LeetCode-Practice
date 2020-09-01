class main {
    public static void main(String args[]){
        String res = new Solution415().addStrings("99", "9");
        System.out.print(res);
    }
}

class Solution415 {
    public String addStrings(String num1, String num2) {
        // switch so num1 is longer
        if (num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        StringBuilder sb = new StringBuilder();
        int digit1, digit2;
        int carry = 0;
        int digit = 0;
        int l1 = num1.length();
        int l2 = num2.length();
        for (int i=0; i<l1; i++){
            digit1 = (int) num1.charAt(l1-1-i) - 48;
            if (l2-1-i < 0) digit2 = 0;
            else digit2 = (int) num2.charAt(l2-1-i) - 48;
            digit = (digit1+digit2+carry)%10;
            carry = (digit1+digit2+carry)/10;
            sb.append((char) (digit+48));
        }
        if (carry != 0) sb.append("1");
        sb = sb.reverse();
        return sb.toString();
    }
}
