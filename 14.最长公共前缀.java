/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int tmp = 0;
        int min = Integer.MAX_VALUE;
        String sh;
        for (String s : strs)
        {
            tmp = s.length();
            if (tmp < min) min = tmp;
        }
        if (min == 0) return "";
        for (int i=0; i<min; i++)
        {
            char ch = strs[0].charAt(i);
            for (int j=1; j<strs.length; j++)
                if (ch != strs[j].charAt(i))
                    return strs[0].substring(0,i);
            if (i==min-1)
                return strs[0].substring(0,min);
        }
        return "";
    }
}
// @lc code=end

