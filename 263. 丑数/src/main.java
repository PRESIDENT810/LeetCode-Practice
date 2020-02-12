public class main {
    public static void main(String args[]) {
        System.out.print(new Solution263().isUgly(14));
    }
}

class Solution263 {
    public boolean isUgly(int num) {
        if (num < 0) return false;
        if (num == 0) return false;
        if (num == 1) return true;

        for (int factor : new int[]{2, 3, 5}) {
            while (num % factor == 0) num /= factor;
        }
        return num == 1;
    }
}