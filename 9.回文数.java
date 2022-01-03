/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x<0 || x!=0 && x%10==0) return false;

        int result = 0;
        while (x > result)
        {
            int tail = x%10;
            result = result*10+tail;
            x /= 10;
        }
        return (x==result)||(x==result/10);
    }
}
// @lc code=end

