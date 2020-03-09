import java.util.*;

public class main {
    public static void main(String args[]) {
        int[] arr = {1,2222};
        System.out.print(new Solution322().coinChange(arr, 2));
    }
}

class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] map;
        map = new int[amount+1];
        Arrays.fill(map, amount+1);

        int min = coins[0];
        for (int coin : coins) {
            if (coin > amount) continue;
            map[coin] = 1;
            if (coin < min) min = coin;
        }

        for (int i = min; i < map.length; i++) {
            int sub_amount = i;
            for (int coin : coins) {
                if (coin >= amount) continue;
                if (coin*2 <= sub_amount+1) {
                    map[i] = Math.min(map[coin] + map[sub_amount - coin], map[i]);
                }
            }
        }
        return map[amount] == amount+1 ? -1 : map[amount];
    }
}