public class main {
}

class Solution338 {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;

        int base = 1;
        for (int i=1; i<=num; i++){
            if (i == base){
                res[base] = 1;
                base *= 2;
            }
            else res[i] = res[base/2]+res[i-base/2];
        }
        return res;
    }
}