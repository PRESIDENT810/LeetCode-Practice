public class main {
    public static void main(String args[]){
        System.out.print(new Solution168().convertToTitle(52));
    }
}

class Solution168 {
    public char map(int remainder) {
        return (char) (remainder+64); // 0-'Z' 1-'A' 2-'B'...25-'Y'
    }

    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        int remainder;

        while (n > 26) {
            remainder = n%26==0 ? 26: n%26;
            ans.append(map(remainder));
            n -= remainder;
            n = n/26;
        }
        ans.append(map(n));
        return new String(ans.reverse());
    }
}