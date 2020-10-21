import java.util.*;

class main {
    public static void main(String args[]){
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        new Solution56().merge(input);
    }
}

class Solution56 {
    public void sortIntervals(int[] left_ends, int[] right_ends){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<left_ends.length; i++){
            if (map.containsKey(left_ends[i]) && map.get(left_ends[i]) > right_ends[i]){
                continue;
            }
            map.put(left_ends[i], right_ends[i]);
        }
        Arrays.sort(left_ends);
        for (int i=0; i<left_ends.length; i++){
            right_ends[i] = map.get(left_ends[i]);
        }
    }

    public List<List<Integer>> getInterval(int[] left_ends, int[] right_ends){
        // need to sort these intervals;
        sortIntervals(left_ends, right_ends);

        List<List<Integer>> res = new LinkedList<>();
        int merged_L = left_ends[0];
        int merged_R = right_ends[0];
        for (int i=0; i<left_ends.length; i++){
            // see if current interval can merge with current result
            int crt_L = left_ends[i];
            int crt_R = right_ends[i];
            if (crt_L <= merged_R){ // these two can merge
                merged_R = crt_R > merged_R ? crt_R : merged_R; // change merged_R
            }
            else{ // these two cannot merge
                List<Integer> temp = new LinkedList<>();
                temp.add(merged_L);
                temp.add(merged_R);
                res.add(temp);
                merged_L = crt_L;
                merged_R = crt_R;
            }
        }
        List<Integer> temp = new LinkedList<>();
        temp.add(merged_L);
        temp.add(merged_R);
        res.add(temp);
        return res;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        int[] left_ends = new int[intervals.length];
        int[] right_ends = new int[intervals.length];
        for (int i=0; i<intervals.length; i++){
            left_ends[i] = intervals[i][0];
            right_ends[i] = intervals[i][1];
        }
        List<List<Integer>> lists = getInterval(left_ends, right_ends);
        int[][] res = new int[lists.size()][2];
        int idx = 0;
        for (List<Integer> list: lists){
            res[idx][0] = list.get(0);
            res[idx][1] = list.get(1);
            idx++;
        }
        return res;
    }
}

