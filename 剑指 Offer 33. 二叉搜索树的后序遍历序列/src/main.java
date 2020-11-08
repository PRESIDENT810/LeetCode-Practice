class main {
}

class Solution剑指33 {
    public boolean verifyPostorder(int[] postorder) {
        return recursion(postorder, 0, postorder.length-1);
    }

    public boolean recursion(int[] arr, int start, int end){
        // System.out.printf("Start: %d, end: %d\n", start, end);
        if (start >= end) return true;
        int L = start;
        int R = end-1;
        while (L < end && arr[L] <= arr[end]) L++;
        while (R >= start && arr[R] >= arr[end]) R--;
        // System.out.printf("L: %d, R: %d\n", L, R);
        if (L-1 != R) return false;
        return recursion(arr, start, R) && recursion(arr, L, end-1);
    }
}