//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 5705 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();

        //先对数组进行排序
        Arrays.sort(nums);
        //找出a + b + c = 0
        //a = nums[i], b = nums[i + 1] ,c = nums[nums.length - 1];

        for(int i = 0 ;i < nums.length;i++) {
            //首先判断排序后的数组第一个数是否大于0，如果大于0，直接跳出，因为 = 0 不可能成立
            if(nums[i] > 0) {
                return res;//返回的是空
            }

            //对a进行去重
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //定义b 和 c 的值
            int left = i + 1;
            int right = nums.length - 1;
            //循环求和，当右大于左的时候，跳出循环
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum > 0) {
                    right--;
                }else if(sum < 0) {
                    left++;
                }else {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    //对b 和 c进行去重，放到这是因为要确保有一个数组能被找到。
                    while(right > left && nums[right] == nums[right- 1]) {
                        right--;
                    }
                    while(right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
