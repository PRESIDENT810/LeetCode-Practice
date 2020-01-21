import java.util.*;

public class main {
}

class Solution119 {
    public LinkedList<Integer> next(LinkedList<Integer> last_row) {
        LinkedList<Integer> current_row = new LinkedList<>();

        current_row.add(1);
        for (int idx = 0; idx < last_row.size() - 1; idx++) {
            current_row.add(last_row.get(idx) + last_row.get(idx + 1));
        }
        current_row.add(1);

        return current_row;
    }

    public List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> last_row = new LinkedList<>();
        last_row.add(1);
        if (rowIndex == 0) return last_row;

        for (int i = 0; i < rowIndex; i++) {
            last_row = next(last_row);
        }

        return last_row;
    }
}
