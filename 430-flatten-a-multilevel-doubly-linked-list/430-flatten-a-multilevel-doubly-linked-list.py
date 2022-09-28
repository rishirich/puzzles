"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

class Solution(object):
    def flatten(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        print(head)
        
        if head == None:
            return head
        
        stack = [head]
        prev = None
        
        while stack:
            
            curr = stack.pop()
            if prev:
                prev.next = curr
                curr.prev = prev
                prev.child = None
            
            while curr:
                if curr.child:
                    break
                prev = curr
                curr = curr.next
            
            if curr: 
                if curr.child and curr.next:
                    stack.append(curr.next)
                    stack.append(curr.child)
                    prev = curr
                elif curr.child:
                    stack.append(curr.child)
                    prev = curr
            
        return head