'''

Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

Clarification:
Confused why the returned value is an integer, but your answer is an array?
Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller.
Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 
Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3]
Explanation: Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively. It doesn't matter what you leave beyond the returned length.

Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3]
Explanation: Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively. It doesn't matter what values are set beyond the returned length.
 

Constraints:

0 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in ascending order.

'''

# METHOD 1


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        l = len(nums)
        if l < 3:
            return l

        freq = 1
        curr = nums[0]
        i = 1

        while i < len(nums) and i < l:
            print(i, curr, freq, nums)
            if curr == nums[i] and freq < 2:
                freq += 1
                i += 1
                continue
            elif curr == nums[i]:
                l -= 1
                t = i
                for j in nums[i + 1:]:
                    nums[i] = j
                    i += 1
                i = t
            else:
                freq = 1
                curr = nums[i]
                i += 1

        return l

# METHOD 2
# 2 pointer version


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        l = len(nums)
        if l < 3:
            return l

        i, j = 2, 2

        while j < l:
            if nums[j] != nums[i - 2]:
                nums[i] = nums[j]
                i += 1
            j += 1

        return i
