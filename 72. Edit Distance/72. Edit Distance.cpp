class Solution {
public:
    int minDistance(string word1, string word2) {
        
        int n=word1.size();
        int m=word2.size();
        vector<vector<int>>dp(n,vector<int>(m,-1));
        int ans=editDistance(word1,word2,n,m,dp,0,0);
        return ans;
    }
    
    int editDistance(string s1,string s2,int n,int m,vector<vector<int>>&dp,int i,int j)
    {
        if(i>=n)
            return s2.size()-j;
        
        if(j>=m)
            return s1.size()-i;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        if(s1[i]==s2[j])
            return dp[i][j]=editDistance(s1,s2,n,m,dp,i+1,j+1);
        
        else{
            int insert=1+editDistance(s1,s2,n,m,dp,i,j+1);
            int remove=1+editDistance(s1,s2,n,m,dp,i+1,j);
            int replace=1+editDistance(s1,s2,n,m,dp,i+1,j+1);
            
            return dp[i][j]=min(insert,min(remove,replace));
        }
    }
};