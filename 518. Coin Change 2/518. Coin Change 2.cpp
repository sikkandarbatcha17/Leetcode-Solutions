class Solution {
public:
    int change(int amount, vector<int>& coins) {
        
        int n=coins.size();
        vector<vector<int>>dp(n,vector<int>(amount+1,-1));
        int ans=coinChange(coins,dp,amount,n,0);
        return ans;
    }
    
    int coinChange(vector<int>&coins,vector<vector<int>> &dp,int amount,int n,int index)
    {
        if (amount==0)
            return 1;
        
        if(index>=n || amount<0)
            return 0;
        
        if(dp[index][amount]!=-1)
            return dp[index][amount];
        
        int left=coinChange(coins,dp,amount-coins[index],n,index);
        int right=coinChange(coins,dp,amount,n,index+1);
        
        return dp[index][amount]=left+right;
    }
};