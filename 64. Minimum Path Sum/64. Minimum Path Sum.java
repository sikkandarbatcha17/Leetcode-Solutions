class Solution {
    public static int minPathSum(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        int ans=mps(grid,0,0,dp,m,n);
        return ans;
    }
    public static int mps(int[][] grid,int i,int j,int[][] dp,int m,int n)
    {
        if(i==m-1 && j==n-1)
            return grid[i][j];
        
        if(i>=m || j>=n)
            return 1000;
        
        if(dp[i][j]!=0)
            return dp[i][j];
        
        int right=grid[i][j]+mps(grid,i,j+1,dp,m,n);
        int bottom=grid[i][j]+mps(grid,i+1,j,dp,m,n);
        return dp[i][j]=Math.min(right,bottom);
    }
}