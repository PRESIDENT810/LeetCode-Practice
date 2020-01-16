import java.util.*;

public class main {
    public static void main(String args[]){
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.print(new Solution448().findDisappearedNumbers(nums).toString());
    }
}

class Solution448 {
    public List<Integer> add(List<Integer> ans, int last, int current) {
        for (int i = 1; i < current - last; i++) ans.add(i + last);

        return ans;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0) return new LinkedList<>();

        Arrays.sort(nums);
        List<Integer> ans = new LinkedList<>();

        int idx = 0;
        int last = 0;

        while (idx != nums.length) {
            int current = nums[idx];
            if (current != last + 1) ans = add(ans, last, current);
            last = current;
            idx++;
        }

        ans = add(ans, last, nums.length + 1);

        return ans;
    }
}