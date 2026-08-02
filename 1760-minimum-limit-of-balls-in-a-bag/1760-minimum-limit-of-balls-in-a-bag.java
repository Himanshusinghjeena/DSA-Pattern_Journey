class Solution {
    public int minimumSize(int[] nums, int maxOperations) {

        int low = 1;
        int high = max(nums);       

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canDivide(nums, maxOperations, mid)) {
                ans = mid;          
                high = mid - 1;     
            } else {
                low = mid + 1;     
            }
        }

        return ans;
    }

    private boolean canDivide(int[] nums, int maxOperations, int penalty) {

        int operations = 0;

        for (int balls : nums) {

            operations += (balls - 1) / penalty;

            if (operations > maxOperations) {
                return false;
            }
        }

        return true;
    }

    private int max(int[] nums){
        int max = Integer.MIN_VALUE;
         for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}