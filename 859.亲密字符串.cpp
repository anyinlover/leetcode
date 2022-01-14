/*
 * @lc app=leetcode.cn id=859 lang=cpp
 *
 * [859] 亲密字符串
 */
#include <vector>
#include <string>
using namespace std;

// @lc code=start
class Solution {
public:
    bool buddyStrings(string s, string goal) {
        int len = s.size();
        if (len != goal.size()) {
            return false;
        }
        if (s == goal) {
            vector<int> counts(26);
            int offset;
            for (int i = 0; i < len; i++) {
                offset = s[i] - 'a';
                counts[offset]++;
                if (counts[offset] > 1) {
                    return true;
                }
            }
            return false;
        }

        int first = -1;
        int second = -1;
        for (int i = 0; i < len; i++) {
            if (s[i] != goal[i]) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        if (second != -1 && s[first] == goal[second] && s[second] == goal[first]) {
            return true;
        }
        return false;
    }
};
// @lc code=end

