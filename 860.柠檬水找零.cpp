/*
 * @lc app=leetcode.cn id=860 lang=cpp
 *
 * [860] 柠檬水找零
 */

#include <vector>
using namespace std;

// @lc code=start
class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int five = 0;
        int ten = 0;
        for (int b : bills) {
            if (b == 5) {
                five++;
            } else if (b == 10) {
                if (five == 0) {
                    return false;
                }
                ten++;
                five--;
            } else {
                if (five > 0 && ten > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;

    }
};
// @lc code=end

