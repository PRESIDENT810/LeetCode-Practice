import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String args[]) {
        Solution468 solu = new Solution468();
        System.out.print(solu.validIPAddress("1.1.1.01"));
    }
}

class Solution468 {
    public static boolean validIPv4Char(String seg){
        if (seg.length() != 1 && seg.charAt(0) == '0') return false;

        Set valid_set = new HashSet();

        valid_set.add('0');
        valid_set.add('1');
        valid_set.add('2');
        valid_set.add('3');
        valid_set.add('4');
        valid_set.add('5');
        valid_set.add('6');
        valid_set.add('7');
        valid_set.add('8');
        valid_set.add('9');

        for (int i = 0; i < seg.length(); i++) {
            if (!valid_set.contains(seg.charAt(i))) return false;
        }

        return true;
    }

    public static String IPv4(String IP) {
        int cnt = 0;
        String seg = "";
        try {
            while (IP.indexOf('.') != -1) {
                cnt++;
                int seg_pos = IP.indexOf('.');
                seg = IP.substring(0, seg_pos);
                if (cnt > 3 || seg.equals("") || !validIPv4Char(seg) || Integer.parseInt(seg) > 255 || Integer.parseInt(seg) < 0)
                    return "Neither";
                IP = IP.substring(seg_pos + 1);
            }
            if (cnt != 3 || IP.equals("") || !validIPv4Char(IP) || Integer.parseInt(IP) > 255 || Integer.parseInt(IP) < 0)
                return "Neither";

            return "IPv4";
        } catch (java.lang.NumberFormatException e) {
            return "Neither";
        }
    }

    public static boolean validIPv6Char(String seg) {
        Set valid_set = new HashSet();

        valid_set.add('0');
        valid_set.add('1');
        valid_set.add('2');
        valid_set.add('3');
        valid_set.add('4');
        valid_set.add('5');
        valid_set.add('6');
        valid_set.add('7');
        valid_set.add('8');
        valid_set.add('9');
        valid_set.add('a');
        valid_set.add('b');
        valid_set.add('c');
        valid_set.add('d');
        valid_set.add('e');
        valid_set.add('f');
        valid_set.add('A');
        valid_set.add('B');
        valid_set.add('C');
        valid_set.add('D');
        valid_set.add('E');
        valid_set.add('F');

        for (int i = 0; i < seg.length(); i++) {
            if (!valid_set.contains(seg.charAt(i))) return false;
        }

        return true;
    }

    public static String IPv6(String IP) {
        int cnt = 0;
        String seg = "";

        while (IP.indexOf(':') != -1) {
            cnt++;
            int seg_pos = IP.indexOf(':');
            seg = IP.substring(0, seg_pos);
            if (cnt > 7 || seg.equals("") || !validIPv6Char(seg) || seg.length()>4) return "Neither";
            IP = IP.substring(seg_pos + 1);
        }
        if (cnt != 7 || IP.equals("") || !validIPv6Char(IP) || IP.length()>4) return "Neither";

        return "IPv6";
    }

    public String validIPAddress(String IP) {
        if (IP.indexOf('.') != -1) return IPv4(IP);
        else if (IP.indexOf(':') != -1) return IPv6(IP);

        return "Neither";
    }

}