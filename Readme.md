## 3. 无重复字符的最长子串
- Case: very long String

不能使用递归（每次递归判断多一个字符的字符串），如果初始字符串太长的话会导致栈溢出

Standard answer:
```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
```  

## 7. 整数反转
- Case: -2147483648

Java整数只支持-2147483648 (-2^31) 到 2147483647 (2^31-1) 范围内的数字

如果遇到负数时乘-1处理, 遇到-2147483648会溢出, 因为**-2147483648是一个有效的java整数，但是2147483648并不是！（溢出）**, 

(**唯一java支持某个负数，但不支持其对应相反数（正数）的情况!**)
  
Note：使用long类型避免整数溢出情况!

## 27. 移除元素
除了把不同的数字向前移动，也可以把重复的数字向后移动


## 35. 搜索插入位置
执行二分搜索时，初始时tail应该是数组长度**而不是数组长度-1**
```java
        int head = 0;
        int tail = nums.length; // not "nums.length-1"
        int mid = (int) (head+tail)/2;;

```

## 38. 外观数列
It saves more time when appending string if you use StringBuilder, instead of string concentration
```java
        StringBuilder result = new StringBuilder();
        ...
        result.append(generate(cnt, last_digit));
```
this is much faster than
```java
        String result = new String();
        ...
        result = result+generate(cnt, last_digit);
```

## 53 最大字序和
常见极端情况:
- Array with only one element
- Empty array
- `Integer.MAX_VALUE/MIN_VALUE`

## 58. 最后一个单词的长度
Case: "a "

...fuck, I didn't expect space at the end

Case: " "

...fuck, I didn't expect only space either

Case: "   "

... fuck, fuck, fuck

Case: "a "

... fuck this shit

## 69. x 的平方根
**Use long datatype to avoid integer overflow issue**

Since the result keeps only integer part (left), when doing binary search, mid point should use left mid as well

### Gaussian Newton method:

To find the square root of target is equivalent to:

maximize f(x), where f'(x)=x^2-target

Then we can use Gaussian Newton to solve this optimization problem

x_{k+1} = x_{k} - f'(x)/f''(x)

where f'(x) = x^2-target, f''(x) = 2x 

iterate until we find one that is close enough

## 88. 合并两个有序数组 *
> 方法三 : 双指针 / 从后往前
直觉: 方法二已经取得了最优的时间复杂度O(n+m), 但需要使用额外空间。这是由于在从头改变nums1的值时，需要把nums1中的元素存放在其他位置。

> 如果我们从结尾开始改写 nums1 的值又会如何呢？**这里没有信息，因此不需要额外空间**。
这里的指针 p 用于追踪添加元素的位置。

This is so fuckin' brilliant


## 100. 相同的树 & 101. 对称二叉树

Visiting every node of a tree:
**Recursion: use DFS**
**Iteration: use BFS**

## 104. 二叉树的最大深度
Fuck trees, always beware of an empty tree (`Tree = []`)


## 136. 只出现一次的数字 *
- 如果我们对 0 和二进制位做 XOR 运算，得到的仍然是这个二进制位

    a⊕0=a
- 如果我们对相同的二进制位做 XOR 运算，返回的结果是 0

    a⊕a=0
- XOR 满足交换律和结合律

    a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
    
所以对数组中所有数字依次进行异或运算，出现两次的数字异或之后变为0，
只有唯一一个只出现一次的数字与0异或，结果仍然是这个数字

**常规算法无法解决问题时，记得考虑能否使用位运算解决问题!!!**


## 141. 环形链表
- 自己的解法：

思路：遍历链表，每次经过一个节点时，把这个节点与下一个断开，并在这个节点后面连一个“特殊节点”

如果有环：那么一路遍历到链表最后，会因为有环而遍历到之前已经遍历过的一个节点，而这个节点在之前的操作中已经把下一个连接成了“特殊节点”，所以一路遍历下去时如果遇到这个“特殊节点”，则说明出现环，反而遍历到前面的某个节点了，返回true

如果没环：那么一路遍历到最后都不会跑回到前面已经遍历过的节点上，所以不会遇到“特殊节点”，那么到结尾null的时候停止并返回false即可

那么怎么设置这个“特殊节点”呢？这个节点的作用就是说明它连接的上一个节点已经被遍历过了，因此这个“特殊节点”必须足够特殊，以便跟链表里的其它节点区分开，所以我直接把头节点当成这个特殊节点（头节点是肯定不会在后面出现的，所以肯定可以区分开）。

**缺点：破坏了链表结构...**

- Floyd判圈算法：

一个可以在有限状态机、迭代函数或者链表上判断是否存在环，求出该环的起点与长度的算法。

如果有限状态机、迭代函数或者链表上存在环，那么在某个环上以不同速度前进的2个指针必定会在某个时刻相遇。同时显然地，如果从同一个起点(即使这个起点不在某个环上)同时开始以不同速度前进的2个指针最终相遇，那么可以判定存在一个环，且可以求出2者相遇处所在的环的起点与长度。

思路

想象一下，两名运动员以不同的速度在环形赛道上跑步会发生什么？


通过**使用具有不同速度的快、慢两个指针遍历链表**，空间复杂度可以被降低至 
O(1)。慢指针每次移动一步，而快指针每次移动两步。

如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。

现在考虑一个环形链表，把慢指针和快指针想象成两个在环形赛道上跑步的运动员（分别称之为慢跑者与快跑者）。而快跑者最终一定会追上慢跑者。这是为什么呢？考虑下面这种情况（记作情况 A）- 假如快跑者只落后慢跑者一步，在下一次迭代中，它们就会分别跑了一步或两步并相遇。

其他情况又会怎样呢？例如，我们没有考虑快跑者在慢跑者之后两步或三步的情况。但其实不难想到，因为在下一次或者下下次迭代后，又会变成上面提到的情况 A。


## 155. 最小栈

- 一开始的思路：维护一个堆来存储所有放入栈的数字，获取最小值时返回堆顶部的数字即可

- 问题：虽然获取最小值的时间复杂度为常数，但是放入/取出元素时复杂度为对数

- 忽略的条件：取出元素时一定是按照入栈顺序取出，所以没有必要使用堆结构获取最小值（取出元素顺序不固定时才只能使用堆）

- 标准答案：额外维护一个链表来存储放入/取出每一层栈时栈内元素的最小值（而不是用来存储放入栈的元素）


## 448. 找到所有数组中消失的数字

- 原地修改

我们需要知道数组中存在的数字，由于数组的元素取值范围是 \[1, N\]，所以我们可以不使用额外的空间去解决它。
我们可以在输入数组本身以某种方式标记已访问过的数字，然后再找到缺失的数字。
算法：

遍历输入数组的每个元素一次。
我们将把 abs(nums\[i\])-1 索引位置的元素标记为负数。即 

nums\[abs(nums\[i\])−1\] *= −1 。

然后遍历数组，若当前数组元素 nums\[i\] 为负数，说明我们在数组中存在数字 i+1。

Note:

1. 由于数字范围为\[1, N\]， **数字范围与索引范围是一一映射的**，故可以**利用数组索引存储额外的关于已经遍历的数字的信息**
2. 要**利用数组索引存储额外信息**，又**不能丢失原有信息**（不能替换数组中其它元素），可以**将数组对应位置的数字乘-1来表示已经遍历的数字**

（由于数组中数字都大于0，所以乘-1不会丢失原有信息，负数则表示这个索引对应数字已被遍历）


## 167. 两数之和 II - 输入有序数组

有序数组时，考虑使用双指针

当两数之和大于目标时，右指针左移使两数之和减小；当两数之和小于目标时，左指针右移使两数之和增大；

**由于数组有序，所以使两数之和增加/减小只需将两个指针中的一个向一个方向移动即可**，

左指针从左开始，故要减小只需要左移右指针；右指针从右开始，故要增大只需要右移左指针

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;

        while (true) {
            if (numbers[start] + numbers[end] == target) return new int[]{start + 1, end + 1};
            else if (numbers[start] + numbers[end] > target) end--;
            else start++;
        }
    }
}
```

## 168. Excel表列名称
莫名其妙一个题...卡的时候卡了一个多小时，最后随手一改过了

问题关键是**模26的时候，余0实际上要减掉26**...

因为在**满26的时候实际上是Z而不是进位**，所以模出0的时候需要特殊处理，即减去26取消进位
```java
class Solution168 {
    public char map(int remainder) {
        return (char) (remainder+64); // 0-'Z' 1-'A' 2-'B'...25-'Y'
    }

    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        int remainder;

        while (n > 26) {
            // 如果满26的话不是进位而是Z，所以把余数换成26
            // 这样转化为字符的时候不会出错，除的时候先减去余数也不会导致进位
            remainder = n%26==0 ? 26: n%26; 
            ans.append(map(remainder));
            n -= remainder;
            n = n/26;
        }
        ans.append(map(n));
        return new String(ans.reverse());
    }
}
``` 

## 169. 多数元素
Boyer-Moore 投票算法

- 原理：

我们假设这样一个场景，在一个游戏中，分了若干个队伍，有一个队伍的人数超过了半数。所有人的战力都相同，不同队伍的两个人遇到就是同归于尽，同一个队伍的人遇到当然互不伤害。

这样经过充分时间的游戏后，最后的结果是确定的，一定是超过半数的那个队伍留在了最后。

- 做法：

我们维护一个计数器，如果遇到一个我们目前的候选多数元素，就将计数器加一，
否则减一。只要计数器等于 0 ，我们就将nums中之前访问的数字全部忘记 ，
并把下一个数字当做候选的多数元素。


## 171. Excel表列序号
正着做就不需要考虑满26的边界情况了，Z的时候直接乘26即可

Note：做进制转换的时候不需要傻乎乎的用Math.pow()，用一个
int base = 1; 循环内 base *= 26; 可以大幅节省时间

```java
class Solution171 {
    public int titleToNumber(String s) {
        int ans = 0;
        int len = s.length();
        int base = 1; // 每一轮循环的base

        for (int i=0; i<len; i++){
            ans += base*(s.charAt(len-1-i)-'A'+1);
            base *= 26; // 进入下一轮循环时base*26，这样就不需要使用pow函数计算幂了
        }

        return ans;
    }
}
``` 


## 172. 阶乘后的零

一开始以为直接返回n/5即可（几个含因子5的数字就是几个0）

但是测试样例为30时有7个而不是6个0，原因是25含有两个5因子...
那就多计算一遍含有5的幂的数字有几个，再加上对应的幂大小即可
```java
class Solution {
    public int trailingZeroes(int n) {
        long base = 5;
        int zeroes = 0;
        while (n >= base) {
            zeroes += n/base;
            base*=5;
        }

        return zeroes;
    }
}
```

## 189. 旋转数组

- 反转

这个方法基于这个事实：当我们旋转数组k次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。

在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n−k 个元素，就能得到想要的结果。

```
假设 n=7 且 k=3 。

原始数组                  : 1 2 3 4 5 6 7
反转所有数字后             : 7 6 5 4 3 2 1
反转前 k 个数字后          : 5 6 7 4 3 2 1
反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
```

## 190. 颠倒二进制位

由于java不支持unsigned，所以如果除2来判断最后一位的话遇到负数会无法正确处理

所以需要**用 n & 0b1 的方式得到最后一位**

## 202. 快乐数

- Floyd判圈算法：

一个可以在有限状态机、迭代函数或者链表上判断是否存在环，求出该环的起点与长度的算法。

如果有限状态机、迭代函数或者链表上存在环，那么在某个环上以不同速度前进的2个指针必定会在某个时刻相遇。
同时显然地，**如果从同一个起点(即使这个起点不在某个环上)同时开始以不同速度前进的2个指针最终相遇，
那么可以判定存在一个环**，且可以求出2者相遇处所在的环的起点与长度。