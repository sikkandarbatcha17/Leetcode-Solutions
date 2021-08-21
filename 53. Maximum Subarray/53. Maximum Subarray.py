class Solution(object):
    def maxSubArray(self, nums):
        maxi=nums[0]
        sumi=0
        for i in nums:
            sumi+=i
            if(sumi>maxi):
                maxi=sumi
            if sumi<0:
                sumi=0
        return maxi
        