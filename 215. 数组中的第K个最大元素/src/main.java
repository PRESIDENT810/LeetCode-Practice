import java.util.*;

class main{
    public static void main(String args[]){
        int[] nums = {3,2,1,5,6,4};
        System.out.print(new Solution215().findKthLargest(nums, 2));
    }
}

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int num : nums){
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.poll();
    }
}