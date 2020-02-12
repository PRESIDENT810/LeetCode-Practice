public class main {
    public static void main(String args[]) {
        System.out.print(new Solution263().isUgly(14));
    }
}

class Solution263 {
    public boolean alternative(int num) {
        for (int factor : new int[]{2, 3, 5}) {
            while (num % factor == 0) num /= factor;
        }
        return num == 1;
    }

    public boolean isUgly(int num) {
        if (num < 0) return false;
        if (num == 0) return false;
        if (num == 1) return true;
        if (num > Math.pow(2, 24)) return alternative(num);

        int[] arr = new int[num + 1];
        int base;

        for (int factor : new int[]{2, 3, 5}) {
            base = 0;
            while (base <= num) {
                arr[base] = -1;
                base += factor;
            }
        }

        for (int i = 7; i < num; i++) {
            if (arr[i] != 0) continue;
            base = i;
            while (base <= num) {
                arr[base] = 1;
                base += i;
            }
        }
        return arr[num] == -1;
    }
}