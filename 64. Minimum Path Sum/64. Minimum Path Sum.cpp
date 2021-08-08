class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        
        int m=grid.size();
        int n=grid[0].size();
        vector<vector<int>>dp(m,vector<int>(n,-1));
        int ans=mps(grid,0,0,m,n,dp);
        return ans;   
    }
    int mps(vector<vector<int>>&grid,int i,int j,int m,int n,vector<vector<int>>&dp)
    {
        if((i==m-1)&&(j==n-1))
            return grid[i][j];
        
        if(i>=m || j>=n)
                return 1000;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int right=grid[i][j]+mps(grid,i,j+1,m,n,dp);
        int bottom=grid[i][j]+mps(grid,i+1,j,m,n,dp);
        return dp[i][j]=min(right,bottom);
    }
};