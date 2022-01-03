/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        if (!p.isEmpty() && p.charAt(0) == '*') return false;
        boolean[][] f = new boolean[s.length()+1][p.length()+1];
        f[0][0]=true;
        for (int k=1; k<p.length(); k+=2) {
            if (p.charAt(k) == '*')
                f[0][k + 1] = f[0][k - 1];
        }

        for (int i=1; i<=s.length(); i++)
        {
            for (int j=1; j<=p.length(); j++)
            {
                if (p.charAt(j-1)!='*')
                    f[i][j]=f[i-1][j-1]&&isCharMatch(s.charAt(i-1),p.charAt(j-1));
                else
                    f[i][j]=f[i][j-2]||f[i-1][j]&&isCharMatch(s.charAt(i-1),p.charAt(j-2));
            }
        }
        return f[s.length()][p.length()];
    }

    private static Boolean isCharMatch(char i, char j)
    {
        return j=='.' || i==j;
    }
}
// @lc code=end

