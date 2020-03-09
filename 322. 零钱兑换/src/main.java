import java.util.*;

public class main {
    public static void main(String args[]) {
        int[] arr = {357,239,73,52};
        System.out.print(new Solution322().coinChange(arr, 9832));
    }
}

class Solution322 {
    int[] map;
    Set<Integer> set = new HashSet<>();

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        this.map = new int[amount+1];

        int min = coins[0];
        for (int coin : coins) {
            if (coin > amount) continue;
            this.map[coin] = 1;
            this.set.add(coin);
            if (coin < min) min = coin;
        }
        boolean add = false;



        for (int i = min; i < this.map.length; i++) {
            int sub_amount = i;
            add = false;
            for (int available : this.set) {
                if (this.map[available] != 1) continue;
                if (available*2 <= sub_amount+1 && this.set.contains(sub_amount - available)) {
                    add = true;
                    int cnt = this.map[available] + this.map[sub_amount - available];
                    if (this.map[i] == 0 || this.map[i] > cnt) {
                        this.map[i] = cnt;
                    }
                }
            }
            if (add) this.set.add(sub_amount);
        }
        return this.map[amount] == 0 ? -1 : this.map[amount];
    }
}