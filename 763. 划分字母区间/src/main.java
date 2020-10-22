import java.util.*;

class main {
}

class Solution763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        char[] arr = S.toCharArray();
        int[] end_map = new int[26];

        // find the last occurence
        for (int i=0; i<arr.length; i++){
            end_map[(int) arr[i] - 97] = i;
        }

        int crt_L = 0, crt_R = 0;
        for (int i=0; i<arr.length; i++){
            if (i > crt_R){ // need to split interval since this char is not in current interval
                res.add(crt_R-crt_L+1);
                crt_L = i;
                crt_R = end_map[(int) arr[i] - 97];
            }
            else{ // extend current interval's end to this char's last occurence
                crt_R = crt_R > end_map[(int) arr[i] - 97] ? crt_R : end_map[(int) arr[i] - 97];
            }
        }
        res.add(crt_R-crt_L+1);
        return res;
    }
}