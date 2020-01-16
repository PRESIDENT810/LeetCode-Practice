import java.util.*;

public class main {
    public static void main(String args[]){
        int[] nums = {1,1};
        System.out.print(new Solution().findDisappearedNumbers(nums).toString());
    }
}


class Solution {
    public Set add_plus(Set set, int max, int current){
        for (int i=1; i<current-max; i++){
            set.add(i+max);
        }
        return set;
    }

    public Set add_minus(Set set, int min, int current){
        for (int i=1; i<min-current; i++){
            set.add(i+current);
        }
        return set;
    }

    public List<Integer> convert(Set set){
        List<Integer> ans = new LinkedList<>();
        set.forEach(e -> ans.add((Integer) e));

//        Iterator iter = set.iterator();
//        while(iter.hasNext()){
//            ans.add((Integer) iter.next());
//        }
        return ans;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0) return new LinkedList<>();

        int max = nums[0];
        int min = nums[0];
        int len = 0;
        Set set = new HashSet();

        for (int idx=0; idx<nums.length; idx++){
            int current_num = nums[idx];

            if (set.contains(current_num)) set.remove(current_num);
            else if (current_num >= max) {
                set = add_plus(set, max, current_num);
                max = current_num;
            }
            else if (current_num <= min) {
                set = add_minus(set, min, current_num);
                min = current_num;
            }
        }

        if (nums.length > max) add_plus(set, max, nums.length+1);
        if (1 < min) add_minus(set, min, 0);

        return convert(set);
    }
}
