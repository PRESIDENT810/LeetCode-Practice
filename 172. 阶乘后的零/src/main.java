public class main {
}

class Solution127 {
    public int trailingZeroes(int n) {
        long base = 5;
        int zeroes = 0;
        while (n >= base) {
            zeroes += n/base;
            base*=5;
        }

        return zeroes;
    }
}