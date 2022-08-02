package leetcode.leetcode268;

import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        for(int x : nums){
            sum1 += x;
        }
        int sum2 = n * (n + 1) /2;
        return sum2 - sum1;
    }
    //排序后搜索
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            if(nums[i] != i)
                return i;
        }
        return n;
    }

    //异或运算：原理x^x=0,即一个数和自身异或，结果为0。
    //0与任何一个数x异或，结果为x。0^x=x
    //假设nums=[0,3,1],数组长度n=3。丢失的数字为2
    //res ^= res ^ 0 ^ 3 ^ 1 ^ (0 ^ 1 ^ 2 ^ 3)
    //     = res ^ 2 ^ (0^0)^(1^1)^(3^3)
    //       = res ^ 2 ^ 0 ^ 0 ^ 0 = 2
    public int missingNumber3(int[] nums) {
        int n = nums.length;
        int res = 0;
        //第一次异或:把数组里面的每个数进行异或。
        for (int num : nums) {
            res ^= num;
        }
        //第二次异或:没有丢失的数，异或了两次，结果变为0.
        //丢失的数，相当于与0异或，结果就是丢失的这个数。
        //注意：i<=n
        for(int i = 0; i <= n; i++){
            res ^= i;
        }
        //经过两次异或后，结果就是丢失的那个数。
        return res;
    }

    public int missingNumber4(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }
        int res = -1;
        for(int i = 0; i <= nums.length; i++){
            if(!set.contains(i)){
                res = i;
                break;
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String line = cin.nextLine();
        int beginIndex = line.indexOf("[");
        int endIndex = line.lastIndexOf("]");
        String str = line.substring(beginIndex + 1, endIndex);
        System.out.println(str);

        String[] tmp = str.split(",");
        int[] nums = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            nums[i] = Integer.parseInt(tmp[i]);
        }
        for (int x : nums) {
            System.out.print(x + " ");
        }
        System.out.println();

        Solution solution = new Solution();
        int x = solution.missingNumber(nums);
        System.out.println(x);

        x = solution.missingNumber2(nums);
        System.out.println(x);

        x = solution.missingNumber3(nums);
        System.out.println(x);

        x = solution.missingNumber4(nums);
        System.out.println(x);
    }
}
