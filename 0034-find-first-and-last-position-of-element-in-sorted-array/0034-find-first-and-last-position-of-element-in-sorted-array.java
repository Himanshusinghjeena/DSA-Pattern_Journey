class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans ={-1,-1};
        ans[0] = firstPosition(nums,target);
        ans[1] = lastPosition(nums,target);
        return ans;

    }
       int firstPosition(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2 ;
            if(nums[mid] >= target){
                if(nums[mid] == target) ans= mid;
                high = mid-1;
            }else {
                low=mid+1;
            }
        }
        return ans;
        }


        int lastPosition(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2 ;
            if(nums[mid] <= target){
                if(nums[mid] == target) ans = mid;
                low = mid+1;
            }else {
                high=mid-1;
            }
        }
        return ans;
        }
}