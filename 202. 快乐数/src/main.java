public class main {
    public static void main(String args[]){
        System.out.print(new Solution202().isHappy(19));
    }
}

class Solution202 {
    public int replace(int n){
        int sum = 0;
        while (n >= 10) {
            sum += (n%10)*(n%10);
            n /= 10;
        }
        return sum+n*n;
    }

    public boolean isHappy(int n) {
        int fast = replace(n);
        int slow = n;

        while (fast != slow) {
            fast = replace(replace(fast));
            slow = replace(slow);
        }

        return fast == 1;
    }
}
