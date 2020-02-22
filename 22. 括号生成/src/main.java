import java.util.*;

public class main {
    public static void main(String args[]) {
        new Solution22().generateParenthesis(2);
    }
}

class Solution22 {
    List<String> ans = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder str_builder = new StringBuilder("(");
        recursion(1, 0, 2*n, str_builder);
        return this.ans;
    }

    public void recursion(int l_cnt, int r_cnt, int depth, StringBuilder sb) {
        if (l_cnt+r_cnt == depth) {
            this.ans.add(new String(sb));
            return;
        }

        if (l_cnt == depth / 2) {
            recursion(l_cnt, r_cnt+1, depth, new StringBuilder(sb).append(')'));
        } else if (l_cnt == r_cnt) {
            recursion(l_cnt+1, r_cnt, depth, new StringBuilder(sb).append('('));
        } else {
            recursion(l_cnt, r_cnt+1, depth, new StringBuilder(sb).append(')'));
            recursion(l_cnt+1, r_cnt, depth, new StringBuilder(sb).append('('));
        }
        return;
    }
}