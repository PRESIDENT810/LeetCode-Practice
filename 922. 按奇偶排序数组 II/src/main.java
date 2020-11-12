class main {
    public static void main(String args[]){
        int[] arr = {2,3,1,1,4,0,0,4,3,3};
        new Solution922().sortArrayByParityII(arr);
    }
}

class Solution922 {
    public int[] sortArrayByParityII(int[] A) {
        int ptr1 = 0;
        int ptr2 = 1;
        boolean L_odd = true;
        boolean R_odd = false;
        // ptr1 is even and ptr2 is odd
        while (ptr1 != A.length && ptr2 != A.length+1){
            while (ptr1 != A.length && A[ptr1]%2 == 0) ptr1 += 2;
            while (ptr2 != A.length+1 && A[ptr2]%2 != 0) ptr2 += 2;
            if (ptr1 == A.length || ptr2 == A.length+1) break;
            swap(A, ptr1, ptr2);
        }
        return A;
    }

    public void swap(int[] A, int ptr1, int ptr2){
        int temp = A[ptr1];
        A[ptr1] = A[ptr2];
        A[ptr2] = temp;
    }
}