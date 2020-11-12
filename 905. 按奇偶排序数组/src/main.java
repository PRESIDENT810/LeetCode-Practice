class main {
}

class Solution905 {
    public int[] sortArrayByParity(int[] A) {
        int ptr1 = 0;
        int ptr2 = A.length-1;
        while (ptr1 < ptr2){
            while (ptr1 < ptr2 && A[ptr1]%2 == 0) ptr1++;
            while (ptr1 < ptr2 && A[ptr2]%2 != 0) ptr2--;
            if (ptr1 < ptr2) swap(A, ptr1, ptr2);
        }
        return A;
    }

    public void swap(int[] A, int ptr1, int ptr2){
        int temp = A[ptr1];
        A[ptr1] = A[ptr2];
        A[ptr2] = temp;
    }
}