/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++)
        {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) + 1 > j)
                    j = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            if (i - j + 1 > max) {
                max = i - j + 1;
            }
        }
        return max;
    }
}
// @lc code=end

