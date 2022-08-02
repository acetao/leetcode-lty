package leetcode.leetcode242;

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arrs = s.toCharArray();
        char[] arrt = t.toCharArray();
        Arrays.sort(arrs);
        Arrays.sort(arrt);
        int i = 0, j = 0;
        while(i < arrs.length || j < arrt.length){
            char cs = i < arrs.length ? arrs[i] : '\0';
            char ct = j < arrt.length ? arrt[j] : '\0';
            if(cs != ct){
                return false;
            }
            i++; j++;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        Arrays.fill(nums1, 0);
        Arrays.fill(nums2, 0);
        for (int i = 0; i < s.length(); i++) {
            nums1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            nums2[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(nums1[i] != nums2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "anagram";
        String t = "nagaram";

//        String s = "rat";
//        String t = "car";

        System.out.println(solution.isAnagram(s, t));
    }
}


