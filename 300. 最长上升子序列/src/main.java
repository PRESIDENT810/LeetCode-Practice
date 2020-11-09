class main {
}

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] map = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            probe(nums, i, map);
        }
        int res = 1;
        for (int i=0; i<nums.length; i++){
            res = res > map[i] ? res : map[i];
        }
        return res;
    }

    public void probe(int[] nums, int idx, int[] map){
        if (idx == 0){
            map[idx] = 1;
            return;
        }
        int max = 1;
        for (int i=0; i<idx; i++){
            if (nums[i] < nums[idx]){
                max = Math.max(max, map[i]+1);
            }
        }
        map[idx] = max;
    }
}