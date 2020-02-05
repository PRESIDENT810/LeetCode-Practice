import java.util.*;

public class main {
    public static void main(String args[]){
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> all_ans = new Solution15().threeSum(arr);
    }
}

class Solution15 {
    // TODO: 我他娘真是不会这个题
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> targets = new HashSet<>();
        List<List<Integer>> all_ans = new LinkedList<>();

        for (int num: nums){
            targets.add(-1*num);
        }

        for (Integer target: targets){

        }
        return all_ans;
    }
}
