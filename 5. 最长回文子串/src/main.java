public class main {
    public static void main(String args[]) {
        System.out.print(new Solution5().longestPalindrome("ac"));
    }
}

class Solution5 {
    private int start, end;
    private int max = 0;
    private char[] arr;

    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        this.arr = s.toCharArray();
        for (int i=0; i<arr.length*2-1; i++) {
            double center = (double) i/2;
            bottom2top(center);
        }

        return s.substring(this.start, this.end+1);
    }

    public void bottom2top(double center){
        if (center%1 == 0){ // odd length Padlindrome
            int half = 0;
            while (arr[(int) (center-half)] == arr[(int) (center+half)]) {
                half++;
                if (center-half < 0 || center+half > this.arr.length-1) break;
            }
            if (2*half-1 > this.max){
                this.start = (int) (center-half+1);
                this.end = (int) (center+half-1);
                this.max = 2*half-1;
            }
        }
        else { // even Padlindrome
            int half = 1;
            while (arr[(int) (center+0.5-half)] == arr[(int) (center-0.5+half)]) {
                half++;
                if (center+0.5-half < 0 || center-0.5+half > this.arr.length-1) break;
            }
            if (2*(half-1) > this.max){
                this.start = (int) (center-half+0.5+1);
                this.end = (int) (center+half-0.5-1);
                this.max = 2*(half-1);
            }
        }
        return;
    }
}