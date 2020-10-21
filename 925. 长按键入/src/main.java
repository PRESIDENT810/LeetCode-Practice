class main {
}

class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        int ptr1 = 0;
        int ptr2 = 0;
        char[] arr1 = name.toCharArray();
        char[] arr2 = typed.toCharArray();
        while (ptr1 != arr1.length){
            if (ptr2 == arr2.length) return false;
            if (arr1[ptr1] != arr2[ptr2]){
                if (ptr2 == 0) return false;
                if (arr2[ptr2] == arr2[ptr2-1]){
                    ptr2++;
                    continue;
                }
                return false;
            }
            ptr1++;
            ptr2++;
        }
        while (ptr2 != arr2.length){
            if (arr2[ptr2] != arr2[ptr2-1]) return false;
            ptr2++;
        }
        return true;
    }
}