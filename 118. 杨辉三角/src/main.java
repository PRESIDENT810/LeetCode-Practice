import java.util.*;

public class main {
}

class Solution {
    public LinkedList<Integer> next(LinkedList<Integer> last_row) {
        LinkedList<Integer> current_row = new LinkedList<>();

        current_row.add(1);
        for (int idx = 0; idx < last_row.size() - 1; idx++) {
            current_row.add(last_row.get(idx) + last_row.get(idx + 1));
        }
        current_row.add(1);

        return current_row;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        if (numRows == 0) return ans;
        LinkedList<Integer> last_row = new LinkedList<>();
        last_row.add(1);

        for (int i = 0; i < numRows; i++) {
            ans.add(last_row);
            last_row = next(last_row);
        }

        ans.add(last_row);
        return ans;
    }
}
