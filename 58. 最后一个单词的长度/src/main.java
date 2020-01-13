public class main {
    public static void main(String args[]) {
        Solution58 solu = new Solution58();
        System.out.print(solu.lengthOfLastWord("a     "));
    }
}

class Solution58 {
    public int lengthOfLastWord(String s) {
        if (s.equals("") || s.equals(" ")) return 0;

        int end_idx = s.length() - 1;
        while (s.charAt(end_idx) == ' ') {
            end_idx--;
            if (end_idx == -1) return 0;
        }

        int space_pos = -1;
        for (int i = 0; i < end_idx; i++) {
            if (s.charAt(i) == ' ') space_pos = i;
        }

        return end_idx-space_pos;
    }
}
