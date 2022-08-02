package leetcode.leetcode4;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] nums = new int[n1 + n2];
        boolean isOdd = true;
        int i = 0, j = 0;
        int k = 0;              //归并下标兼作已经归并的数量
        int pre = 0, cur = 0;   //记录归并完的前一个数和当前归并的数
        double ans = 0.0;

        if ((n1 + n2) % 2 == 0) isOdd = false;
        while (i < n1 || j < n2) {
            int x = i < n1 ? nums1[i] : 0x7fffffff;
            int y = j < n2 ? nums2[j] : 0x7fffffff;
            if (x <= y) {
                nums[k] = x;
                i++;
            } else {
                nums[k] = y;
                j++;
            }
            pre = cur;
            cur = nums[k];
            System.out.println("one = " + pre + " two = " + cur);
            k++;    //已经归并的数的个数
            if (isOdd && k == (n1 + n2 + 1) / 2) {
                ans = 1.0 * nums[k - 1];
                break;
            } else if (k == (n1 + n2) / 2 + 1) {
                ans = (pre + cur) / 2.0;
                break;
            }
        }
        return ans;
    }
}
