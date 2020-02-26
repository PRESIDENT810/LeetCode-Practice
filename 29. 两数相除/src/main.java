public class main {
    public static void main(String args[]){
        System.out.print(new Solution29().divide(Integer.MIN_VALUE,-1));
        //
    }
}

class Solution29 {
    public int divide(int dividend, int divisor) {
        int sign;
        if (dividend == 0) return 0;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) sign = 1;
        else sign = -1;
        long dvd = dividend;
        dvd = Math.abs(dvd);
        long dvs = divisor;
        dvs = Math.abs(dvs);

        long L = 0;
        long R = dvd+1;
        long mid = (L+R)/2;
        long res;

        while (true){
            if (mid*dvs > dvd) R = mid;
            else if (mid*dvs <= dvd && mid*dvs+dvs > dvd) {res =  mid*sign; break;}
            else L = mid;
            mid = (L+R)/2;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        else return (int) res;
    }
}