public class main {
    public static void main(String args[]){
        Solution13 solu = new Solution13();
        System.out.println(solu.romanToInt("MCMXCIV"));
    }
}

class Solution13 {
    public int map(String character){
        switch (character){
            case "I": return 1;
            case "V": return 5;
            case "X": return 10;
            case "L": return 50;
            case "C": return 100;
            case "D": return 500;
            case "M": return 1000;
            case "~": return -1;
        }
//        System.out.print(character);
        return 0;
    }

    public int romanToInt(String s) {
        String last = "~";
        int result = 0;
        int idx = 0;

        while(idx != s.length()){
//            String pop = s.substring(s.length()-1);
            String pop = s.substring(s.length()-1-idx, s.length()-idx);
            if (map(last) > map(pop)){
                result -= map(pop);
//                s = s.substring(0, s.length()-1);
                idx ++;
                continue;
            }

            result += map(pop);
//            s = s.substring(0, s.length()-1);
            idx ++;
            last = pop;

        }

        return result;
    }
}