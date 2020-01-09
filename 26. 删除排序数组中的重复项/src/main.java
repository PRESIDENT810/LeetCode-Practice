import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String args[]){
        Solution26 solu = new Solution26();
        int[] arr = {1,2,3,3,2,4,3,1};
        System.out.print(solu.removeDuplicates(arr));
    }
}

class Solution26 {
    public int removeDuplicates(int[] nums) {
        int unique = 0;
        if (nums.length==0) return 0;

        int last = nums[0]-1;

        for (int i=0; i<nums.length; i++){
            int num = nums[i];
            if (last != num) {
                last = num;
                unique++;
                nums[unique-1] = num;
            }
        }

        return unique;
    }
}