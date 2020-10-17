import java.util.*;

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums){
            if (map.containsKey(n)){
                int cnt = map.get(n);
                map.put(n, cnt+1);
            }
            else{
                map.put(n, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int key: map.keySet()) {
            int value = map.get(key);
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }
        int i = 0;
        for (int key: pq){
            res[i] = key;
            i++;
        }
        return res;
    }
}