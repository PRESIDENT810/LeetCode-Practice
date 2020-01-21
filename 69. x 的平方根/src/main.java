public class main {
    public static void main(String args[]) {
        System.out.print((new Newton().mySqrt(8)));
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

class Newton {
    public int mySqrt(int target) {
        if (target == 0) return 0;
        if (target < 2) return 1;

        long x = target/2;

        while (!(x*x <= target && (x+1)*(x+1) >= target)){
            x -= (x*x-target)/2/x+1;
        }

        if ((x+1)*(x+1) == target) return (int) x+1;
        return (int) x;
    }
}