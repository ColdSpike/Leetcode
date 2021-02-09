/*
Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

class Solution {
    public int[] intersect(int[] n1, int[] n2) {
        List<Integer> l = new ArrayList();
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < n1.length; i++) {
            m.put(n1[i], m.getOrDefault(n1[i], 0) + 1);
        }
        for (int i = 0; i < n2.length; i++) {
            if (m.getOrDefault(n2[i], 0) > 0) {
                l.add(n2[i]);
                m.put(n2[i], m.get(n2[i]) - 1);
            }
        }

        int ans[] = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            ans[i] = l.get(i);
        }

        return ans;
    }
}