class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = max(nums);

        int ans = -1;

        while(low <= high ){
            int mid = low + (high - low) /2 ;
            if(calcThreshold(nums,mid) <= threshold){
                ans = mid;
                high = mid-1;
            }
            else{
                low= mid+1;
            }
        }
        return ans;
    }

    public int calcThreshold(int[] nums, int divisor){
        int count = 0;
        for(int num: nums){
              count += (num + divisor - 1) / divisor;
        }
        return count;
    }


    public int max(int[] nums){
        int ans = Integer.MIN_VALUE;
        for(int num : nums){
            ans = Math.max(ans,num);
        }
        return ans;
    }
}