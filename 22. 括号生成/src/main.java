import java.util.*;

public class main {
    public static void main(String args[]) {
        new Solution22().generateParenthesis(2);
    }
}

class Solution22 {
    List<String> ans = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        int str = 1;
        recursion(1, 0, 2*n, str);
        return this.ans;
    }

    public String convert(int str){
        StringBuilder sb = new StringBuilder();
        while (str != 0){
            if ((str & 0x1) == 1) sb.append(')');
            else sb.append('(');
            str = str >> 1;
        }
        return new String(sb);
    }

    public void recursion(int l_cnt, int r_cnt, int depth, int str) {
        if (l_cnt+r_cnt == depth) {
            this.ans.add(convert(str));
            return;
        }

        if (l_cnt == depth / 2) {
            recursion(l_cnt, r_cnt+1, depth, str*2);
        } else if (l_cnt == r_cnt) {
            recursion(l_cnt+1, r_cnt, depth, str*2 + 1);
        } else {
            recursion(l_cnt, r_cnt+1, depth, str*2);
            recursion(l_cnt+1, r_cnt, depth, str*2 + 1);
        }
        return;
    }
}