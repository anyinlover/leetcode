/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()||s.length()==1) return s;
        int max_s = 0;
        int max_l = 1;
        for (int i=0; i< s.length();)
        {
            if (s.length() - i <= max_l/2) break;
            int j=i;
            int k=i;
            while (k<s.length()-1 && s.charAt(k+1)==s.charAt(k)) k++;
            i = k+1;
            while (k<s.length()-1 && j > 0 && s.charAt(k+1)==s.charAt(j-1))
            {
                k++;
                j--;
            }
            int len = k-j+1;
            if (len>max_l)
            {
                max_s = j;
                max_l = len;
            }
        }
        return s.substring(max_s, max_s+max_l);
    }
}
// @lc code=end

