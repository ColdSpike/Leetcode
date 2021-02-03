'''
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Example 3:
Input: s = "a"
Output: "a"

Example 4:
Input: s = "ac"
Output: "a"
 
Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),

'''


class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s == "" or len(s) == 1:
            return s

        start, end = 0, 0

        for i in range(len(s)):
            len1 = self.expand(s, i, i)
            len2 = self.expand(s, i, i + 1)
            lenf = max(len1, len2)
            if lenf > end - start:
                start = i - ((lenf - 1) // 2)
                end = i + (lenf // 2)

        return s[start:end+1]

    def expand(self, s, start, end):
        if s == "" or start > end:
            return 0

        while start >= 0 and end < len(s) and s[start] == s[end]:
            start -= 1
            end += 1

        return end - start - 1
