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

        unordered_set<int> us;
        for (auto x : nums)
            us.insert(x);       //哈希并去重

        int ans = 1;
        while (!us.empty()) {
            int x = *(us.begin());
            us.erase(x);
            int ll = x - 1;
            int rr = x + 1;
            while (us.find(ll) != us.end()) {
                us.erase(ll);
                ll--;
            }
            while (us.find(rr) != us.end()) {
                us.erase(rr);
                rr++;
            }
            ll++;
            rr--;
            ans = max(ans, rr - ll + 1);//rr-ll+1为[ll,rr]区间元素个数
        }

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
