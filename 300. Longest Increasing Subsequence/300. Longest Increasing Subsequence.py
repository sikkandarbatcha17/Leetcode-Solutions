class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        l=[]
        for i in nums:
            if len(l)==0 or l[-1]<i:
                l.append(i)
            else:
                index=bisect_left(l,i)
                l[index]=i
        return len(l)