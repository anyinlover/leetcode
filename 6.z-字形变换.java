/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] buildstring = new StringBuilder[numRows];
        for (int i = 0; i < buildstring.length; i++)
            buildstring[i] = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            int j = numRows - 1;
            buildstring[j-Math.abs(j-i%(2*j))].append(s.charAt(i));
        }
        StringBuilder result= new StringBuilder();
        for (StringBuilder e : buildstring)
            result.append(e.toString());

        return result.toString();
    }
}
// @lc code=end

