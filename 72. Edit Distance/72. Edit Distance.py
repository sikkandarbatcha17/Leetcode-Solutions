class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        dp=[[-1 for i in range(len(word2))] for i in range(len(word1))]
        def minDistance2(word1, word2, i, j, dp):
            
            if i >= len(word1):
                return len(word2) - j
            if j >= len(word2):
                return len(word1) - i

            if dp[i][j]!=-1:
                return dp[i][j]
            
            if word1[i] == word2[j]:
                dp[i][j]=minDistance2(word1, word2, i + 1, j + 1, dp)
                return dp[i][j]
            else: 
                insert = 1 + minDistance2(word1, word2, i, j + 1, dp)
                delete = 1 + minDistance2(word1, word2, i + 1, j, dp)
                replace = 1 + minDistance2(word1, word2, i + 1, j + 1, dp)
                dp[i][j]= min(insert, delete, replace)
                return dp[i][j]
        
        ans=minDistance2(word1,word2,0,0,dp)
        return ans
        