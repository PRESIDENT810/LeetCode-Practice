import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Solution66 solu = new Solution66();
        int[] arr = {4, 3, 2, 1};
        arr = solu.plusOne(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        return add_carry(digits, len - 1);
    }

    public static int[] add_carry(int[] digits, int pos) {
        if (pos == 0) {
            if (digits[0] == 9) {
                digits[0] = 0;
                int[] new_digits = new int[digits.length + 1];
                new_digits[0] = 1;
                for (int i = 0; i < digits.length; i++) new_digits[i + 1] = digits[i];
                return new_digits;
            }
            else{
                digits[0] = digits[0]+1;
                return digits;
            }
        }

        if (digits[pos] == 9) {
            digits[pos] = 0;
            pos--;
            digits = add_carry(digits, pos);
        } else digits[pos] = digits[pos] + 1;

        return digits;
    }
}