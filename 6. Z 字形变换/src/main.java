import java.util.*;

public class main {
    public static void main(String args[]) {
        System.out.print(new Solution6().convert("A", 1));
    }
}

class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        // Otherwise Gap could be 0, and the loop never quits because always gap=0 < arr.length

        char[] arr = s.toCharArray();
        List<StringBuilder> res_rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            res_rows.add(new StringBuilder());

        int row = 0;
        int flag = 1;

        for (char c: arr){
            res_rows.get(row).append(c);
            if (row == numRows-1) flag = -1;
            if (row == 0) flag = 1;
            row += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder res_row: res_rows){
            res.append(new String(res_row));
        }

        return new String(res);
    }
}