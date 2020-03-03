public class main {
    public static void main(String args[]) {
        int[] arr1 = {0};
        int[] arr2 = {1};
        Solution88 solu = new Solution88();
        solu.merge(arr1, 0, arr2, 1);
    }
}

class Solution88 {
    public void merge(int[] A, int m, int[] B, int n) {
        int end = A.length - 1;
        while (end != -1) {
            if (m == 0) {
                A[end] = B[n - 1];
                n--;
                end--;
                continue;
            }
            if (n == 0) {
                A[end] = A[m - 1];
                m--;
                end--;
                continue;
            }

            if (A[m - 1] > B[n - 1]) {
                A[end] = A[m - 1];
                m--;
                end--;
            } else {
                A[end] = B[n - 1];
                n--;
                end--;
            }
        }
    }
}
