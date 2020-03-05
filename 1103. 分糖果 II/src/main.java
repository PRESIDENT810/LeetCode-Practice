public class main {
    public static void main(String args[]) {
        new Solution1103().distributeCandies(60, 4);
    }
}

class Solution1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int diff = 0;
        int sum;
        while (true) {
            sum = (1 + diff) * (num_people + 1 + num_people * diff) * num_people / 2;
            if (sum > candies) break;
            diff++;
        }
        int[] res = new int[num_people];
        int need;
        diff--;
        for (int i = 0; i < num_people; i++) {
            need = (i + 1) * (1 + diff) + num_people * diff * (diff + 1) / 2;
            res[i] = need;
            candies -= need;
        }
        int i = 0;
        int give = 1+(diff+1)*num_people;
        while (candies > 0){
            if (candies < give) {res[i] += candies; break;}
            res[i] += give;
            candies -= give;
            i++;
            give++;
        }
        return res;
    }
}