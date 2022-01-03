/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1.length > nums2.length ? nums2.clone() : nums1.clone();
        int[] B = nums1.length > nums2.length ? nums1.clone() : nums2.clone();

        int m = A.length;
        int n = B.length;

        int imin = 0;
        int imax = m;
        int half_len = (m+n+1)/2;
        double max_left;
        double min_right;

        while(imin <= imax)
        {
            int i = (imin+imax)/2;
            int j = half_len - i;
            if (i<m && B[j-1]>A[i])
                imin = i + 1;
            else if (i > 0 && A[i-1]>B[j])
                imax = i -1;
            else
            {
                if (i==0) max_left = B[j-1];
                else if (j==0) max_left = A[i-1];
                else max_left = Math.max(A[i-1], B[j-1]);

                if ((m+n)%2==1)
                    return max_left;

                if (i==m) min_right = B[j];
                else if (j==n) min_right = A[i];
                else min_right = Math.min(A[i], B[j]);
                return (max_left+min_right)/2;
            }
        }
        return 0.0;

    }
}
// @lc code=end

