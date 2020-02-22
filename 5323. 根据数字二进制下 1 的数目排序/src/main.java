public class main {
    public static void main(String args[]){
        int[] arr = {1025,512,256,128,64,32,31,8,4,2,1};
        new Solution5323().sortByBits(arr);
    }
}

class Solution5323 {
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            while (j != arr.length - i - 1) {
                if (large(arr[j], arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                j++;
            }
        }
        return arr;
    }

    public boolean large(int n1, int n2) {
        int cp1 = n1;
        int cp2 = n2;
        int cnt1 = 0;
        while (n1 != 0) {
            cnt1 += (n1 & 0x1);
            n1 = n1 >> 1;
        }
        int cnt2 = 0;
        while (n2 != 0) {
            cnt2 += (n2 & 0x1);
            n2 = n2 >> 1;
        }
        if (cnt1 == cnt2) return cp1 > cp2;
        return cnt1 > cnt2;
    }
}