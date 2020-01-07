## 3. 无重复字符的最长子串
- Case: very long String

Cannot use recursion (each recursion with 1 less character), since the String is so fuckin' long, using recursion leads to **stack overflow**
  

## 7. 整数反转
- Case: -2147483648

Java integer only support number from -2147483648 (-2^31) to 2147483647 (2^31-1).

If you want to times -1 when negative, doing this leads to an error, since **-2147483648 is a valid java integer but 2147483648 is not (overflow)**, 

(**The only case that java supports a negative number, but not its corresponding positive number !**)
  