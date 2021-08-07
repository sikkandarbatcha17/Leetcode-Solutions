class Solution {
    public static int binarySearch(int[] seq,int low,int high,int x)
    {
        int mid;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(seq[mid]==x)
                return mid;
            else if(seq[mid]>x)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
    
    public static int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        int[] seq=new int[n];
        int len=0;
        
        seq[len++]=nums[0];
        for(int i=1;i<n;i++)
        {
            if(nums[i]>seq[len-1])
                seq[len++]=nums[i];
            else{
                int index=binarySearch(seq,0,len-1,nums[i]);
                seq[index]=nums[i];
            }
        }
        
        return len;
    }
}