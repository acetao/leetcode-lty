#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    string removeDuplicateLetters(string s)
    {
        bool flag[256] = {0};          //字符是否在栈中
        unordered_map<char, int> freq; //字符出现次数
        stack<char> stk;               //单调栈

        //先计算每个字符出现次数
        for (auto c : s)
        {
            freq[c]++;
        }

        for (auto c : s) //遍历字符串
        {
            freq[c]--;   //计数减一
            if (flag[c]) //如果该字符已经在栈中，跳过该字符
                continue;
            //如果栈非空，且栈顶字符大于当前扫描到的字符c
            while (!stk.empty() && stk.top() > c)
            {
                //即使栈顶字符大于当前字符c，但是该栈顶字符在原始字符串s中
                //只出现过一次，不能出栈
                if (freq[stk.top()] == 0)
                    break;
                //若栈顶字符在原始字符串s中出现不止一次，此次出栈后，
                //后面还可以入栈，但是必须把该字符是否在栈栈中的标志位置为false
                flag[stk.top()] = false;
                stk.pop(); //则弹出栈顶的字符（比当前字符c大）
            }
            stk.push(c);    //当前字符c入栈
            flag[c] = true; //标志当前字符c已经在栈中
        }
        string res;          // res存放结果
        while (!stk.empty()) //弹出单调栈中的字符
        {
            res.append(1, stk.top());
            stk.pop();
        }
        reverse(res.begin(), res.end()); //逆序结果字符串
        return res;
    }
};

int main(int argc, char const *argv[])
{
    // string s = "bcabc";
    string s = "cbacdcbc";
    Solution sol;
    string res = sol.removeDuplicateLetters(s);
    cout << res << "\n";

    system("pause");
    return 0;
}
