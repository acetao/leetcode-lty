
class Solution {
    public String reversePrefix(String word, char ch) {
        if (word == null || word.length() == 0)
            return word;
        int pos = word.indexOf(ch);
        if (pos < 0)
            return word;
        StringBuffer buffer = new StringBuffer();
        int tmp = pos;
        while (pos >= 0) {
            buffer.append(word.charAt(pos));
            pos--;
        }
        for (int i = tmp + 1; i < word.length(); i++) {
            buffer.append(word.charAt(i));
        }
        return buffer.toString();
    }
}

public class Leetcode2000 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String word = "abcdefd";
        char ch = 'd';
        word = sol.reversePrefix(word, ch);
        System.out.println(word);
    }
}