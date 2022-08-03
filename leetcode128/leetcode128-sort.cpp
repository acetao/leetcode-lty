#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int longestConsecutive(vector<int> &nums)
    {
        if (nums.size() == 0)
            return 0;
        if (nums.size() == 1)
            return 1;
        int ans = 1;
        int len = 1;
        //排序
        sort(nums.begin(), nums.end());
        //去重
        int i = 0, j;
        for (j = 1; j < nums.size(); j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        //统计
        for (j = 1; j <= i; j++) {
            if (nums[j] - 1 == nums[j - 1]) {
                len++;
            } else {
                if (ans < len)
                    ans = len;
                len = 1;
            }
        }
        if (ans < len)
            ans = len;
        return ans;
    }
};

int main(int argc, char const *argv[])
{
    // vector<int> nums = { 100, 4, 200, 1, 3, 2 };
    // vector<int> nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
    // vector<int> nums = { 1, 2, 0, 1 };
    // vector<int> nums = { 0 };
    // vector<int> nums = { 0, -1 };
    vector<int> nums = { 9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7 };

    Solution sol;
    int ans = sol.longestConsecutive(nums);
    cout << ans << endl;

    return 0;
}
