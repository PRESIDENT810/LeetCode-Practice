class main {
    public static void main(String args[]){
        char[] s = {'h','e','l','l','o'};
        new Solution344().reverseString(s);
    }
}

class Solution344 {
    public void reverseString(char[] s) {
        char temp;
        int len = s.length;
        for (int i=0; i<len/2; i++){
            s[i] = (char) ((int) s[len-i-1] ^ (int) s[i]);
            s[len-i-1] = (char) ((int) s[i] ^ (int) s[len-i-1] );
            s[i] = (char) ((int) s[i] ^ (int )s[len-i-1]);
        }
    }
}