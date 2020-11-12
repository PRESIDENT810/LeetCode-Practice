public class main {
}

class SolutionJZ03 {
    public int findRepeatNumber(int[] nums) {
        int crt;
        for (int i=0; i<nums.length; i++){
            if (nums[i] < 0) crt = nums[i]*-1;
            else crt = nums[i];
            if (nums[crt] < 0) return crt;
            else nums[crt] *= -1;
        }
        return 0;
    }
}
