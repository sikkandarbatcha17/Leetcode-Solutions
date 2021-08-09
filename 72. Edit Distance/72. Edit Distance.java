class Solution {
    public static int minDistance(String word1, String word2) {
        
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        int ans=editDistance(word1,word2,dp,0,0);
        return ans;
    }
    
    public static int editDistance(String s1,String s2,int[][]dp,int i,int j)
    {
        if(i==s1.length())
            return s2.length()-j;
        
        if(j==s2.length())
            return s1.length()-i;
        
        if(dp[i][j]!=0)
            return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=editDistance(s1,s2,dp,i+1,j+1);
        
        else{
            int insert=1+editDistance(s1,s2,dp,i,j+1);
            int remove=1+editDistance(s1,s2,dp,i+1,j);
            int replace=1+editDistance(s1,s2,dp,i+1,j+1);
            
            return dp[i][j]=Math.min(insert,Math.min(remove,replace));
        }
    }
}