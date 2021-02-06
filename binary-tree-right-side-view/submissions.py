'''
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []

        q1, q2 = [root], []
        flg = True
        ans = []
        while(q1 or q2):
            cur = None
            if flg:
                while q1:
                    cur = q1.pop(0)
                    if cur.left != None:
                        q2.append(cur.left)
                    if cur.right != None:
                        q2.append(cur.right)
            else:
                while q2:
                    cur = q2.pop(0)
                    if cur.left != None:
                        q1.append(cur.left)
                    if cur.right != None:
                        q1.append(cur.right)
            ans.append(cur.val)
            flg = not flg
        return ans
