class Solution(object):
    def minPathSum(self, grid):
        
        r=len(grid)
        c=len(grid[0])
        dp=[[grid[0][0] for i in range(c)] for i in range(r)]
        
        for i in range(1,c):
            dp[0][i]=dp[0][i-1]+grid[0][i]
        for j in range(1,r):
            dp[j][0]=dp[j-1][0]+grid[j][0]
            
        for i in range(1,r):
            for j in range(1,c):
                dp[i][j]=grid[i][j]+min(dp[i-1][j],dp[i][j-1])
                
        return dp[-1][-1]
        
        