class main {
}

class Solution941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int summit_idx = -1;
        // find summit
        for (int i=1; i<A.length-1; i++){
            if (A[i] == A[i-1] || A[i] == A[i+1]) return false;
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                summit_idx = i;
                break;
            }
        }
        if (summit_idx == -1) return false;
        int L = summit_idx-1;
        while (L >= 0){
            if (A[L] >= A[L+1]) return false;
            L--;
        }
        int R = summit_idx+1;
        while (R < A.length){
            if (A[R] >= A[R-1]) return false;
            R++;
        }
        return true;
    }
}