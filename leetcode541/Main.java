package leetcode.leetcode541;

class Solution {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        //i += 2k: 每计数至 2k 个字符
        for(int i = 0; i < str.length; i += 2*k){
            //i + k <= str.length: 剩余字符小于 2k 但大于或等于 k 个
            if(i + k <= str.length){
                rev(str, i, i + k); //反转前 k 个字符
                continue; //继续处理下一个 2k 个字符
            }
            // 剩余字符少于 k 个，则将剩余字符全部反转
            rev(str, i, str.length);
        }
        return new String(str);
    }
    //反转[from, to)区间字符串
    private void rev(char[] str, int from, int to){
        int i = from, j = to - 1;
        while(i < j){
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
    }
}

public class Main{
    public static void main(String[] args) {
//        String s = "abcdefg";
//        //String s = "abcd";
//        int k = 2;

        String s = "abcdefghij";
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.reverseStr(s, k));
    }
}
