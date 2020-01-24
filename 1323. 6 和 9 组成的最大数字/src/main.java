public class main {
    public static void main(String args[]){
        Solution1323 solu = new Solution1323();
        System.out.print(solu.maximum69Number(9669));
    }
}

class Solution1323 {
    public int maximum69Number(int num) {
        int digit = 0;
        int copy = num;
        int max6digit = -1;

        while (copy >= 10) {
            if (copy%10 == 6) max6digit = digit;
            copy /= 10;
            digit++;
        }
        if (copy%10 == 6) max6digit = digit;

        if (max6digit == -1) return num;
        return num+3*(int) Math.pow(10, max6digit);
    }
}