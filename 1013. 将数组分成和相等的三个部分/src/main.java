public class main {
    public static void main(String argsp[]) {
        int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        new Solution1013().canThreePartsEqualSum(arr);
    }
}

class Solution1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) sum += num;
        if (sum%3 != 0) return false;
        int part = sum/3;

        int ptr1 = 0;
        int ptr2 = A.length-1;
        int sum1 = A[ptr1];
        int sum2 = A[ptr2];

        while (ptr1+1 < ptr2) {
            if (sum1 == part && sum2 == part) return true;
            if (sum1 != part) {
                ptr1++;
                sum1 += A[ptr1];
            }
            if (sum2 != part) {
                ptr2--;
                sum2 += A[ptr2];
            }
        }
        return false;
    }
}
