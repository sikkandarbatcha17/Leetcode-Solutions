class Solution {
    public static int change(int amount, int[] coins) {
        
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<amount+1;j++)
                dp[i][j]=-1;
        }
        int ans=coinChange(coins,dp,0,n,amount);
        return ans;
    }
    public static int coinChange(int[] coins,int[][] dp,int index,int n,int amount)
    {
        if(amount==0)
            return 1;
        
        if (index>=n || amount<0)
            return 0;
        
        if(dp[index][amount]!=-1)
            return dp[index][amount];
        
        int left=coinChange(coins,dp,index,n,amount-coins[index]);
        int right=coinChange(coins,dp,index+1,n,amount);
        
        return dp[index][amount]=left+right;
    }
}