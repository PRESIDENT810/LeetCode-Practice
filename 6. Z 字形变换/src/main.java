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
        StringBuilder res = new StringBuilder();

        int Gap = numRows * 2 - 2;
        int gap, idx1, idx2;

        for (int Row = 0; Row < numRows; Row++) {
            gap = Row * 2;
            for (int start = Row; start < arr.length; start += gap) {
                res.append(arr[start]);
                if (gap == Row * 2 || Row * 2 == 0) {
                    gap = Gap - Row * 2;
                    if (gap == 0) gap = Row * 2;
                }
                else gap = Row * 2;
            }
        }


        return new String(res);
    }
}