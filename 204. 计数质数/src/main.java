import java.util.*;

public class main {
    public static void main(String args[]){
        System.out.print(new Solution204().countPrimes(10000));
    }
}

class Solution204 {
    public boolean isPrime(int i, boolean[] Primes) {
        int mark = (int) Math.sqrt(i);
        for (int num=2; num<mark+1; num++){
            if (!Primes[num]) continue;
            if (i%num == 0) return false;
        }
        return true;
    }

    public boolean[] fill(int i, boolean[] Primes){
        int mark = (int) Math.sqrt(Primes.length)+1;
        int hole = i*2;
        while (hole < mark) {
            Primes[hole] = false;
            hole += i;
        }
        return Primes;
    }

    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] Primes = new boolean[n];
        for (int i=0; i<n; i++) Primes[i] = true;
        Primes[0] = false;
        Primes[1] = false;
        int ans = 0;

        for (int i=2; i<n; i++){
            if (!Primes[i]) continue;
            if (isPrime(i, Primes)) {Primes[i] = true; ans++; Primes = fill(i, Primes);}
        }
        return ans;
    }
}