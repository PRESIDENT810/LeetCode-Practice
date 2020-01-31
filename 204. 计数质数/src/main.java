
public class main {
}

class Solution204 {
    public boolean isPrime(int n){
        if (n==3 || n==5 || n==7) return true;
        if (n==4 || n==6) return false;
        if (n%2 == 0 || n%3 == 0 || n%5 == 0) return false;

        for (int i=7; i<Math.sqrt(n)+1; i+=2){
            if (i%3 == 0 || i%5 == 0) continue;
            if (n%i == 0) return false;
        }
        return true;
    }

    public int countPrimes(int n) {
        if (n<=2) return 0;
        int ans = 1;
        for (int i=3; i<n; i+=2){
            if (isPrime(i)) ans++;
        }
        return ans;
    }
}