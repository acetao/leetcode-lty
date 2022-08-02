#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    double myPow(double x, int n) {
        long long nn = n;
        return myPow(x, nn);
    }
    double myPow(double x, long long nn) {
        if(nn == 0)
            return 1;
        bool flag = true;
        if(nn < 0) {
            nn = -nn;
            flag = false;
        }
        double ans = myPow(x, nn / 2);
        ans = ans * ans;
        if(nn % 2 == 1)
            ans *= x;
        if(flag)
            return ans;
        else
            return 1.0 / ans;
    }
};

int main(int argc, char const *argv[])
{
    // double x = 2.0;
    // int n = 10;

    // double x = 2.1;
    // int n = 3;

    // double x = 2;
    // int n = -2;

    // double x = 1;
    // int n = -2147483648;

    double x;
    int n;
    cin >> x >> n;

    Solution sol;
    double ans = sol.myPow(x, n);
    cout << fixed << setprecision(5) << ans << "\n";

    return 0;
}
