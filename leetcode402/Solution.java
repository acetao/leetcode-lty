package leetcode.leetcode402;

import java.util.Scanner;

class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        char[] arr = num.toCharArray();
        int len = arr.length;
        int sum = 0, i = 0;
        // 输入num = "1432219", k = 3
        // 输出："1219"
        // 输入num = "10200", k = 1
        // 输出：200
        // 输入num="10", k = 2
        // 输出：0
        // 输入num="112", k = 1
        // 输出：死循环
        while (sum < k) {
            for (i = 0; i < len - 1; i++) { //从头开始搜索
                if (arr[i] > arr[i + 1]) {  //比较：前面数字大于后面数字
                    for (int j = i; j < len - 1; j++) { //将索引位置为j的数字删除
                        arr[j] = arr[j + 1];    //删除方法：后面的数字依次前移一位
                    }
                    sum++;  //统计已删除数字个数
                    len--;  //字符串长度减一
                    break;  //每删除一个数字，从头开始搜索和比较
                }
            }
        }
        i = 0;
        // 输入num="10", k = 1
        // 输出：0
        while (i < len && arr[i] == '0') i++; //删除前导无用的0
        //String(char[] value, int offset, int count)
        if(i >= len)return "0";
        else return new String(arr, i, len - i);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.next();
        int k = scanner.nextInt();
        Solution solution = new Solution();
        String s = solution.removeKdigits(num, k);
        System.out.println(s);

        scanner.close();
    }
}

/**
 * 给你一个以字符串表示的非负整数num 和一个整数 k ，
 * 移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * <p>
 * 示例 2 ：
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * <p>
 * 示例 3 ：
 * <p>
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= num.length <= 10^5
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


