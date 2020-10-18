class main{
    public static void main(String args[]){
        Solution541 solu = new Solution541();
        String res = solu.reverseStr("abcdefg", 2);
        System.out.print(res);
    }
}


class Solution541 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int groups = len/k;
        for (int group=0; group<groups+1; group++){
            if (group%2 != 0) continue;
            int start = group*k;
            int end = Math.min(len, k*(group+1));
            reverseGroup(arr, start, end);
        }
        return String.valueOf(arr);
    }

    public void reverseGroup(char[] arr, int start, int end){
        for (int i=start; i<(start+end)/2; i++){
            char temp = arr[i];
            arr[i] = arr[end-1-(i-start)];
            arr[end-1-(i-start)] = temp;
        }
    }
}