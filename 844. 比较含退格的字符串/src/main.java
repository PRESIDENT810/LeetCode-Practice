import java.util.*;

class main {
    public static void main(String args[]){

    }
}

class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        char[] arr_S = S.toCharArray();
        char[] arr_T = T.toCharArray();
        Stack<Integer> stack_S = new Stack<>();
        Stack<Integer> stack_T = new Stack<>();
        for (char c: arr_S){
            if (c == '#'){
                if (stack_S.size() == 0) continue;
                stack_S.pop();
            }
            else stack_S.push((int) c);
        }
        for (char c: arr_T){
            if (c == '#'){
                if (stack_T.size() == 0) continue;
                stack_T.pop();
            }
            else stack_T.push((int) c);
        }
        if (stack_S.size() != stack_T.size()) return false;
        while (stack_S.size() != 0){
            int c1 = stack_S.pop();
            int c2 = stack_T.pop();
            if (c1 != c2) return false;
        }
        return true;
    }
}