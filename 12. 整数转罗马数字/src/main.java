import com.sun.net.httpserver.Headers;

import java.util.*;

public class main {
    public static void main(String args[]){
        Solution12 solu = new Solution12();
        System.out.print(solu.intToRoman(1994));
    }
}

class Solution12 {
    public String intToRoman(int num) {
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] characters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String Roman = "";

        for (int i=0; i<13; i++){
            int max = numbers[i];
            int cnt = (int) num/max;

            Roman = concat(Roman, cnt, characters[i]);

            num = num-max*cnt;
        }

        return Roman;
    }

    public String concat(String Roman, int cnt, String character){
        for (int i=0; i<cnt; i++){
            Roman = Roman.concat(character);
        }
        return Roman;
    }
}
