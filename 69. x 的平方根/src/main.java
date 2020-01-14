public class main {
    public static void main(String args[]) {
        System.out.print((new Solution69().mySqrt(2147395599)));
    }
}

class Solution69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x <= 3) return 1;

        long head = 0;
        long tail = (head + x) / 2 + 1;
        long mid = (head + tail) / 2;

        while (tail - head > 1) {
            if (mid * mid > x) tail = mid;
            else if (mid * mid < x) head = mid;
            else return (int) mid;
            mid = (head + tail) / 2;
        }
        if (tail*tail == x) return (int) tail;
        return (int) head;
    }
}
