package leetcode.leetcode2114;

class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for(String sentence : sentences){
            String[] words = sentence.split("\\s");
            if(ans < words.length)
                ans = words.length;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] sentences = {
                "alice and bob love chocolate",
                "i think so too",
                "this is great thanks very much"
        };
        System.out.println(solution.mostWordsFound(sentences));
    }
}


