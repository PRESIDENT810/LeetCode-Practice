public class main {
    public static void main(String args[]) {
        Solution14 solu = new Solution14();
        String[] strs = {"flower12", "flower1", "flower1"};
        System.out.print(solu.longestCommonPrefix(strs));
    }
}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        int strs_len = strs.length;
        if (strs_len == 0) return "";
        int last_pos = longestCommonIdx(strs, strs_len);
        return strs[0].substring(0, last_pos);
    }

    public int longestCommonIdx(String[] strs, int strs_len) {
        int idx = 0;
        if (strs_len == 0) return 0;

        try {
            while (true) {
                char crt_char = strs[0].charAt(idx);
                for (int i = 0; i < strs_len; i++) {
                    if (crt_char != strs[i].charAt(idx)) return idx;
                }
                idx++;
            }
        } catch (java.lang.StringIndexOutOfBoundsException e){
            return idx;
        }
    }
}
