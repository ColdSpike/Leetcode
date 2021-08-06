/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]
 
Constraints:
1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
*/

// moore's algorithm
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0, freq1 = 0, freq2 = 0;
        for(int num:nums){
            if(num == candidate1)
                freq1++;
            else if(num == candidate2)
                freq2++;
            else if(freq1 == 0){
                candidate1 = num;
                freq1 = 1;
            }
            else if(freq2 == 0){
                candidate2 = num;
                freq2 = 1;
            }else{
                freq1--;
                freq2--;
            }
        }
    
        freq1 = 0;
        freq2 = 0;
        for(int num:nums){
            if(num == candidate1)
                freq1++;
            else if(num == candidate2)
                freq2++;
        }
    
        List<Integer> ans = new ArrayList<>(2);
        if(freq1 > nums.length/3)
            ans.add(candidate1);
        if(freq2 > nums.length/3)
            ans.add(candidate2);
        
        return ans;
    }
}

// Simple
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            if(entry.getValue() > nums.length/3)
                ans.add(entry.getKey());
        }
        return ans;
    }
}
