# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
def inorder_traversal(node, arr):
    if node == None:
        return
    if node.left != None:
        inorder_traversal(node.left,arr)
    arr.append(node.val)
    if node.right != None:
        inorder_traversal(node.right,arr)
    
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        arr = []
        inorder_traversal(root,arr)
        print(arr)
        
        for i in range(len(arr)-1):
            if arr[i+1] <= arr[i]:
                return False
        return True