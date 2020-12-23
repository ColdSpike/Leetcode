'''

Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
 
Note:
1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100

'''


class Solution:
    def findLength(self, a: List[int], b: List[int]) -> int:
        dp = [[0 for _ in range(len(b) + 1)] for _ in range(len(a) + 1)]

        for i in range(1, len(a) + 1):
            for j in range(1, len(b) + 1):
                if a[i-1] == b[j-1]:
                    dp[i][j] = 1 + dp[i-1][j-1]
                else:
                    dp[i][j] = 0
        ans = 0
        for i in range(1, len(a) + 1):
            for j in range(1, len(b) + 1):
                ans = max(ans, dp[i][j])
        return ans
