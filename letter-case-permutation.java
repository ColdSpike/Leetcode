/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create. You can return the output in any order.

Example 1:
Input: S = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Example 2:
Input: S = "3z4"
Output: ["3z4","3Z4"]

Example 3:
Input: S = "12345"
Output: ["12345"]

Example 4:
Input: S = "0"
Output: ["0"]
 
Constraints:
S will be a string with length between 1 and 12.
S will consist only of letters or digits.
*/

class Solution {
    private List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        rec(S.length() - 1, S.toCharArray(), "");
        return ans;
    }

    private void rec(int pos, char[] s, String ns) {
        if (pos == -1) {
            ans.add(ns);
            return;
        }

        char c = s[pos];
        if (!Character.isDigit(c)) {
            rec(pos - 1, s, Character.toUpperCase(c) + ns);
            rec(pos - 1, s, Character.toLowerCase(c) + ns);
        } else {
            rec(pos - 1, s, c + ns);
        }
    }
}