public class main {
    public static void main(String args[]){
        System.out.print(new Solution190().reverseBits(-3));
    }
}

class Solution190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        int digit;

        for (int i=0; i<32; i++){
            ans = ans << 1;
            digit = n & 0b1;
            n = n >> 1;
            ans += digit;
        }
        return ans;
    }
}