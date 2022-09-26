      
def backtrack(nums, i, sub, subs):
    if i == len(nums):
        if subs.count(sub) == 0:
            subs.append(list(sub))
    else:
        sub.append(nums[i])
        backtrack(nums,i+1,sub,subs)
        sub.remove(nums[i])
        backtrack(nums,i+1,sub,subs)
    
class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        subs = []
        nums = sorted(nums)
        backtrack(nums,0,[],subs)
        return subs
