package leetcode.leetcode402;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Solutio4 {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        char[] arr = num.toCharArray();
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            list.add(num.charAt(i));
        }
        int len = list.size();
        int i = 0;
        // 输入num = "1432219", k = 3
        // 输出："1219"
        // 输入num = "10200", k = 1
        // 输出：200
        // 输入num="10", k = 2
        // 输出：0
        // 输入num="112", k = 1
        // 输出：11
        for (int t = 0; t < k; t++) {
            for (i = 0; i < len - 1; i++) { //从头开始搜索
                if (list.get(i) > list.get(i + 1)) { //比较：前面数字大于后面数字
                    list.remove(i);//将索引位置为i的数字删除
                    break;  //每删除一个数字，从头开始搜索和比较
                }
            }
            len--;  //字符串长度减一
        }
        // System.out.println(list);
        i = 0;
        // 输入num="10", k = 1
        // 输出：0
        while (i < len && list.get(i) == '0') i++; //删除前导无用的0
        if (i >= len) return "0";
        else {
            StringBuilder builder = new StringBuilder();
            for(;i < len; i++){
                builder.append(list.get(i));
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.next();
        int k = scanner.nextInt();
        Solutio4 solution = new Solutio4();
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


