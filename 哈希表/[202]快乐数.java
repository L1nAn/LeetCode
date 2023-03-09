//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」 定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果这个过程 结果为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 哈希表 数学 双指针 👍 1234 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * @param n
     * @return 1 首先判断数值是否有效，并且是否还存在于集合中，如果存在，就退出，说明之前已经处理过了。
     * 2 如果值有效，那么就添加set中 ，并且接下来继续处理
     */
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    //快乐数求和的方法
    private Integer getNextNumber(int n) {
        int res = 0;//定义结果变量，每次循环开始为0
        while (n > 0) { //每次循环求最后一个数，但必须大于0
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
