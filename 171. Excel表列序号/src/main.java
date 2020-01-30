public class main {
}

class Solution171 {
    public int titleToNumber(String s) {
        int ans = 0;
        int len = s.length();
        int base = 1;

        for (int i=0; i<len; i++){
            ans += base*(s.charAt(len-1-i)-'A'+1);
            base *= 26;
        }

        return ans;
    }
}