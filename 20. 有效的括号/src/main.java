public class main {
    public static void main(String args[]) {
        Solution20 solu = new Solution20();
        System.out.print(solu.isValid("}"));
    }
}

class Solution20 {
    public boolean isValid(String s) {
        try {
            int[] stack = new int[s.length()];
            int ptr = 0;

            for (int i = 0; i < s.length(); i++) {
                if (ptr > s.length()/2) return false;
                switch (s.charAt(i)) {
                    case '(':
                        stack[ptr++] = 1;
                        break;
                    case '[':
                        stack[ptr++] = 2;
                        break;
                    case '{':
                        stack[ptr++] = 3;
                        break;
                    case ')':
                        if (stack[--ptr] != 1) return false;
                        break;
                    case ']':
                        if (stack[--ptr] != 2) return false;
                        break;
                    case '}':
                        if (stack[--ptr] != 3) return false;
                        break;
                }
            }

            return ptr == 0;
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {return false;}
    }
}
