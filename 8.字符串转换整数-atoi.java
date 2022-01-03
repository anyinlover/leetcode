/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        int sign=1, base=0, i=0;
        while (s.charAt(i) == ' ') {
            i++;
            if (i == s.length()) return 0;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+')
            sign=s.charAt(i++) == '-' ? -1:1;
        while (i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9')
        {
            if (base>Integer.MAX_VALUE/10 ||
                    (base==Integer.MAX_VALUE/10 && s.charAt(i) - '0' > 7))
                return (sign==1) ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            base = 10*base + (s.charAt(i++) - '0');
        }
        return base*sign;
    }
}
// @lc code=end

