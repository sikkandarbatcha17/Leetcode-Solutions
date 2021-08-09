class Solution(object):
    def coinChange(self, coins, amount):

        n=len(coins)
        dp=[[0 for i in range(amount+1)] for i in range(n+1)]
        
        for i in range(n+1):
            for j in range(amount+1):
                if j==0:
                    dp[i][j]=0
                elif i==0:
                    dp[i][j]=100000
                elif j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(1+dp[i][j-coins[i-1]],dp[i-1][j])
        if dp[-1][-1]>10000:
            return -1
        else:
            return dp[-1][-1]
        