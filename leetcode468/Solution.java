package leetcode.leetcode468;

class Solution {
    public String validIPAddress(String queryIP) {
        /** IPv4地址：格式是：“x1.x2.x3.x4”，
         * 其中 0 <= xi <= 255 且 xi 不能包含 前导零。
         *（1）xi只包含一位数字，范围是 0 到 9。
         *（2）xi包含两位数字，第一位的范围是 1 到 9，第二位是 0 到 9。
         *（3）xi包含三位数字，且第一位为 1。第二、三位可以是 0 到 9。
         *（4）xi包含三位数字，且第一位为 2，第二位为 0 到 4。那么第三位可以是 0 到 9。
         *（5）xi包含三位数字，且第一位为 2，第二位为 5，那么第三位可以是 0 到 5。
         */
        String reg4 = "(([0-9]|[1-9][0-9]|[1][0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}"
            + "([0-9]|[1-9][0-9]|[1][0-9]{2}|2[0-4][0-9]|25[0-5])";

        /** IPv6地址：格式为“x1:x2:x3:x4:x5:x6:x7:x8”
         * （1）1 <= xi.length <= 4
         * （2）xi是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )
         * 和大写英文字母( 'A' 到 'F' )。
         * （3）在xi中允许前导零。
         */
        String reg6 = "(([0-9a-fA-F]{1,4})\\:){7}" + "([0-9a-fA-F]{1,4})";
        if(queryIP.contains(".")) {
            if (queryIP.matches(reg4))
                return "IPv4";
            else return "Neither";
        }else if(queryIP.contains(":")){
            if(queryIP.matches(reg6))
                return "IPv6";
            else return "Neither";
        }else{
            return "Neither";
        }
    }
}
