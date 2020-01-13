public class main {
    public static void main(String args[]) {
        Solution38 solu = new Solution38();
        System.out.print(solu.countAndSay(5));
    }
}


class Solution38 {
    public String generate(int cnt, char digit){
        char[] result = new char[2];
        result[0] = (char) (cnt+48);
        result[1] = digit;

        return new String(result);
    }

    public String next(String str) {
        int cnt = 0;
        boolean start = true;
        char last_digit = '_';
        char crt_digit = '_';
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (start) {
                last_digit = str.charAt(i);
                cnt++;
                start = false;
                continue;
            } else {
                crt_digit = str.charAt(i);

                if (crt_digit == last_digit) cnt++;
                else {
                    result = result+generate(cnt, last_digit);
                    cnt = 1;
                    last_digit = crt_digit;
//                    start = true;
                }
            }
        }
        result = result+generate(cnt, last_digit);

        return result;
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";

        String last = countAndSay(n - 1);
        String crt = next(last);

        return crt;
    }
}