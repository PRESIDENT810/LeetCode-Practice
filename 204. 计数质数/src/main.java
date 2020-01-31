import java.util.*;

public class main {
    public static void main(String args[]){
        System.out.print(new Solution204().countPrimes(10));
    }
}

class Solution204 {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] Primes = new boolean[n];
        int ans = 0;

        for (int i=2; i<n; i++){
            if (!Primes[i]) {
                ans++;
                for (int j=2; i*j<n; j++) Primes[i*j] = true;
            }
        }
        return ans;
    }
}