public class main {
    public static void main(String args[]){
        System.out.print(new Solution50().myPow(2,Integer.MIN_VALUE));
    }
}

class Solution50 {
    public double myPow(double x, int n) {
        boolean pos;
        if (n >= 0) pos = true;
        else pos = false;
        long power = n;
        if (pos) return recursion(x,power);
        else return 1/recursion(x,power*-1);
    }

        public double recursion(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double half = recursion(x, n/2);
        double residual;
        if (n%2 == 1) residual = x;
        else residual = 1;
        return half*half*residual;
    }
}