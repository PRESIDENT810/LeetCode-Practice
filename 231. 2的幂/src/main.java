public class main {
    public static void main(String args[]) {
        System.out.print(new Solution231().isPowerOfTwo(9));
    }
}

class Solution231 {
    public boolean isPowerOfTwo(int n) {
        return (n & n - 1) == 0 && n > 0;
    }
}