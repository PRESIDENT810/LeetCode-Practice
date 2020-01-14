public class main {
    public static void main(String args[]){
        System.out.print(new Solution70().climbStairs(5));
    }
}

class Solution70 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        if (n==2) return 2;

        int[] dict = new int[n+1];
        dict[0] = 1;
        dict[1] = 1;
        dict[2] = 2;

        for (int i=3; i<n+1; i++){
            dict[i] = dict[i-1]+dict[i-2];
        }

        return dict[n];

    }
}
