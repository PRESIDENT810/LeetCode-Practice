import java.util.*;

public class main {
    public static void main(String args[]) {
        int[] arr = {1,2222};
        System.out.print(new Solution322().coinChange(arr, 2));
    }
}

class Solution322 {
    int[] map;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        this.map = new int[amount+1];

        int min = coins[0];
        for (int coin : coins) {
            if (coin > amount) continue;
            this.map[coin] = 1;
            if (coin < min) min = coin;
        }

        for (int i = min; i < this.map.length; i++) {
            int sub_amount = i;
            for (int coin : coins) {
                if (coin >= amount) continue;
                if (coin*2 <= sub_amount+1 && this.map[sub_amount - coin] != 0) {
                    int cnt = this.map[coin] + this.map[sub_amount - coin];
                    if (this.map[i] == 0 || this.map[i] > cnt) {
                        this.map[i] = cnt;
                    }
                }
            }
        }
        return this.map[amount] == 0 ? -1 : this.map[amount];
    }
}