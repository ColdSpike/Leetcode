/* 
Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"

Example 2:
Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"
 
Constraints:
1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s and dictionary[i] consist of lowercase English letters.
*/

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {

        String ans = "";
        for (String item : dictionary) {

            if (item.length() > ans.length() || (item.length() == ans.length() && item.compareTo(ans) < 0)) {
                int j = 0;
                for (int i = 0; i < s.length() && j < item.length(); i++) {
                    if (s.charAt(i) == item.charAt(j))
                        j++;
                }
                if (j == item.length())
                    ans = item;
            }

        }
        return ans;
    }
}