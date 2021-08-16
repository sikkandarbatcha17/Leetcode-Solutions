class Solution {
    public void sortColors(int[] nums) {
        
        int low=0,temp;
        int mid=0;
        int high=nums.length-1;
        
        while(mid<=high)
        {
            switch(nums[mid])
            {
                case 0:
                    temp=nums[mid];
                    nums[mid]=nums[low];
                    nums[low]=temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp=nums[mid];
                    nums[mid]=nums[high];
                    nums[high]=temp;
                    high--;
                    break;
            }
        }
    }
}