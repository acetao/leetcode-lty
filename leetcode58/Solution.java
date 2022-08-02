package leetcode.leetcode58;

import java.util.Scanner;

class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        for(String word : words){
            System.out.println("word is : " + word + ", length: " + word.length());
        }
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
//        String s = "   fly me   to   the moon  ";
        Solution solution = new Solution();
        int len = solution.lengthOfLastWord(s);
        System.out.println("len = " + len);
    }
}
