import java.util.*;

public class main {
    public static void main(String argsp[]){
        new Solution17().letterCombinations("23");
    }
}

class Solution17 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new LinkedList<>();

        char[] arr = digits.toCharArray();
        StringBuilder[] sbs = new StringBuilder[1];
        List<String> ans = new LinkedList<>();
        sbs[0] = new StringBuilder("");

        for (int i=0; i<arr.length; i++){
            sbs = recursion(sbs, arr[i]);
        }

        for (StringBuilder sb: sbs) ans.add(new String(sb));
        return ans;
    }

    public StringBuilder[] recursion(StringBuilder[] sbs, char c){
        int choices;
        if (c == '7' || c == '9') choices = 4;
        else choices = 3;

        StringBuilder[] new_sbs = new StringBuilder[sbs.length*choices];
        for (int i=0; i<new_sbs.length; i++){
            new_sbs[i] = new StringBuilder(sbs[i%sbs.length]);
            new_sbs[i].append((char) (mapping(c)+i/sbs.length));
        }
        return new_sbs;
    }

    public char mapping(char c){
        if (c == '2') return 'a';
        if (c == '3') return 'd';
        if (c == '4') return 'g';
        if (c == '5') return 'j';
        if (c == '6') return 'm';
        if (c == '7') return 'p';
        if (c == '8') return 't';
        if (c == '9') return 'w';
        return '_';
    }
}
