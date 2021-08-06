/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
n == nums.length
1 <= n <= 5 * 104
-231 <= nums[i] <= 231 - 1
 
Follow-up: Could you solve the problem in linear time and in O(1) space?
*/

// moore's algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, freq = 0;
        for(int num:nums){
            if(num == candidate)
                freq++;
            else if(freq == 0){
                candidate = num;
                freq = 1;
            }
            else
                freq--;
        }
        
        freq = 0;
        for(int num:nums){
            if(num == candidate)
                freq++;
        }
        
        if(freq > nums.length / 2)
            return candidate;
        
        return -1;
    }
}


// Simple
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            if(entry.getValue() > nums.length/2)
                return entry.getKey();
        }
        return -1;
    }
}
