/*
Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.

Example 1:

Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers for each row is: 
row 0 -> 2 
row 1 -> 4 
row 2 -> 1 
row 3 -> 2 
row 4 -> 5 
Rows ordered from the weakest to the strongest are [2,0,3,1,4]

Example 2:

Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
Explanation: 
The number of soldiers for each row is: 
row 0 -> 1 
row 1 -> 4 
row 2 -> 1 
row 3 -> 1 
Rows ordered from the weakest to the strongest are [0,2,3,1]
 
Constraints:
m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] is either 0 or 1.
*/

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Queue<Integer>> sm = new TreeMap<>();

        for (int i = 0; i < mat.length; i++) {
            int cnt = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0)
                    break;
                cnt++;
            }
            Queue<Integer> q = sm.getOrDefault(cnt, new LinkedList<Integer>());
            q.add(i);
            sm.put(cnt, q);
            ;
        }

        int ans[] = new int[k];
        int i = 0;
        for (Integer key : sm.keySet()) {
            if (i == k)
                break;
            while (i < k && sm.get(key).size() > 0) {
                ans[i] = sm.get(key).remove();
                i++;
            }
        }

        return ans;
    }
}