public class main {
    public static void main(String args[]) {
        Solution58 solu = new Solution58();
        System.out.print(solu.lengthOfLastWord("     "));
    }
}

class Solution58 {
    public int lengthOfLastWord(String s) {
        if (s.equals("") || s.equals(" ")) return 0;
        while (s.charAt(s.length() - 1) == ' ') {
            s = s.substring(0, s.length() - 1);
            if (s.equals("")) return 0;
        }

        while (s.contains(" ")) {
            int space_pos = s.indexOf(" ");
            if (space_pos == s.length() - 1) break;
            s = s.substring(space_pos + 1);
        }
        return s.length();
    }
}
