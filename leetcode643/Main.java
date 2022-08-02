package leetcode.leetcode643;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int curSum = 0;
        for(int i = 0; i < k; i++)   //统计第一个窗口的累加和
            curSum += nums[i];
        int maxSum = curSum;
        for(int i = k; i < n; i++){
            //nums[i - k]从左端滑出窗口的元素;nums[i]从右端新滑入窗口的元素
            curSum = curSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, curSum);
        }
        return 1.0 * maxSum / k;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,12,-5,-6,50,3};
        int k = 4;
        double ans = solution.findMaxAverage(nums, k);
        System.out.println(ans);
    }
}
