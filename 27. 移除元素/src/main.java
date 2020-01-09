public class main {
    public static void main(String args[]){

    }
}


class Solution27 {
    public int removeElement(int[] nums, int val) {
        int unique = 0;
        if (nums.length==0) return 0;

        for (int i=0; i<nums.length; i++){
            int num = nums[i];
            if (val != num) {
//                last = num;
                unique++;
                nums[unique-1] = num;
            }
        }

        return unique;
    }
}