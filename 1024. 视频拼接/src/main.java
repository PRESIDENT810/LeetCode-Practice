import java.util.*;

class main {
}

class Solution1024 {
    public int videoStitching(int[][] clips, int T) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] clip: clips){
            int clip_start = clip[0];
            int clip_end = clip[1];
            for (int i=clip_start; i<clip_end+1; i++){
                if (!map.containsKey(i)) map.put(i, clip_end);
                else{
                    if (clip_end > map.get(i)) map.put(i, clip_end);
                }
            }
        }

        // if cannot cover 0, then return -1
        if (!map.containsKey(0)) return -1;
        // if cover 0, then start from 0
        int cnt = 0;
        int next = 0;
        int last = 0;
        while (next < T){
            next = map.get(next);
            if (next == last) return -1;
            last = next;
            cnt++;
        }

        return cnt;
    }
}