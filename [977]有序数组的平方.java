//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
//
// Related Topics 数组 双指针 排序 👍 736 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        //因为平方之后负数可能会比正数的数值大，所以我们要先比较两个数的平方后大小
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];
        int index = res.length - 1;
        /*
        不能再原来数组上进行操作，因为数组会在运行过程中会变化的，所以要创建一个新的数组
        while (left < right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                nums[index++] = nums[right] * nums[right];
                right--;
            } else if (nums[left] * nums[left] >= nums[right] * nums[right]) {
                nums[index++] = nums[left] * nums[left];
                left++;
            }
        }
        return nums;
         */
        //如果没有等号这个条件，就会造成数组中间的数无法处理
        while (left <= right) {
            if(nums[left] * nums[left] < nums[right] * nums[right]) {
                //一定要从尾部开始赋值，如果从头开始的话，就会报错因为 -4 比 -1 小，但是平方数值大。
                res[index--] = nums[right] * nums[right];
                right--;
            }else {
                res[index--] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
