public class main {
}

class Solution345 {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int ptr1 = 0;
        int ptr2 = arr.length - 1;
        while (ptr1 < ptr2) {
            while (!prime(arr[ptr1]) && ptr1 < ptr2) ptr1++;
            while (!prime(arr[ptr2]) && ptr1 < ptr2) ptr2--;
            // System.out.print(ptr1);
            swap(arr, ptr1, ptr2);
            ptr1++;
            ptr2--;
        }
        return String.valueOf(arr);
    }

    public boolean prime(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        return false;
    }

    public void swap(char[] arr, int ptr1, int ptr2) {
        char temp = arr[ptr1];
        arr[ptr1] = arr[ptr2];
        arr[ptr2] = temp;
    }
}