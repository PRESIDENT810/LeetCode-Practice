public class main {
}

class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;

        while (true) {
            if (numbers[start] + numbers[end] == target) return new int[]{start + 1, end + 1};
            else if (numbers[start] + numbers[end] > target) end--;
            else start++;
        }
    }
}