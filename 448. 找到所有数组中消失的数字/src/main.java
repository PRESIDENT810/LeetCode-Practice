import java.util.*;

public class main {
    public static void main(String args[]){
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.print(new Solution448().findDisappearedNumbers(nums).toString());
    }
}

class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i=0; i<nums.length; i++){
            int num = nums[i];
            if (num < 0) num *= -1;
            if (nums[num-1] > 0) nums[num-1] *= -1;
        }

        List<Integer> ans = new LinkedList<>();
        for (int i=0; i<nums.length; i++) if (nums[i] > 0) ans.add(i+1);
        return ans;
    }
}