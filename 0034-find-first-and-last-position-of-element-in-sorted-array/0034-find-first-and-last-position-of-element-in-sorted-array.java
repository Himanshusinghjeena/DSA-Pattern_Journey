class Solution {

    public int[] searchRange(int[] nums, int target) {

        return new int[]{firstPosition(nums, target), lastPosition(nums, target)};
    }

    public int firstPosition(int[] nums, int target) {

        if (nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return nums[low] == target ? low : -1;
    }

    public int lastPosition(int[] nums, int target) {

        if (nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low + 1) / 2;

            if (nums[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return nums[low] == target ? low : -1;
    }
}