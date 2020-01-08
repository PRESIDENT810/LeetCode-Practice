public class main {
    public static void main(String args[]){
        Solution9 solu = new Solution9();
        System.out.print(solu.isPalindrome(21120));
    }
}

class Solution9 {
    public boolean isPalindrome(int x) {
        if (x==0) return true;
        if (x<0 || x%10 == 0) return false;

        int original = x;
        int reverse = 0;

        while (x>=10){
            if (x == reverse || (int) x/10 == reverse) return true;
            reverse = reverse*10+x%10;
            x = (int) x/10;
        }
        reverse = reverse*10+x;
        return reverse==original;
    }
}
