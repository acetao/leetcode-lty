package leetcode.leetcode468;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] ip = {
                "192.168.1.1",
                "192.168.1.0",
                "192.168.01.1",
                "192.168.1.00",
                "192.168@1.1",
                "172.16.254.1",
                "2001:0db8:85a3:0:0:8A2E:0370:7334",
                "256.256.256.256",
                "2001:db8:85a3:0:0:8A2E:0370:7334",
                "2001:0db8:85a3::8A2E:037j:7334",
                "02001:0db8:85a3:0000:0000:8a2e:0370:7334"
        };
        for(String s : ip){
            System.out.println(solution.validIPAddress(s));
        }
    }
}
