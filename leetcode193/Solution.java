package leetcode.leetcode193;

import java.util.ArrayList;

public class Solution {
    String[] validPhoneNumbers(String[] phones){
        ArrayList<String> list = new ArrayList<>();
        int cnt = 0;
        for(String phone : phones){
            if(phone.matches("^(\\([0-9]{3}\\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$")) {
                list.add(phone);
                cnt++;
            }
        }
        String[] ans = new String[cnt];
        ans = list.toArray(ans);
        return ans;
    }

    /** 正则表达式为: ^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$
     * 987-123-4567
     * 1234567890
     * (123)456-7890
     * @param args
     */
    public static void main(String[] args) {
        String[] phones = {
                "987-123-4567",
                "1234567890",
                "(123)456-7890"
        };
        Solution solution = new Solution();
        String[] ans = solution.validPhoneNumbers(phones);
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
