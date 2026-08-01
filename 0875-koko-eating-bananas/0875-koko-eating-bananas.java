class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = max(piles);

        while(low <= high){
        int mid = low + (high - low) /2;
        long totalH = calcHours(piles, mid);

         if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public long calcHours(int[] arr, int hourly) {
        long totalHours = 0; 
        for (int pile : arr) {
            totalHours += (pile + hourly - 1L) / hourly; 
        }
        return totalHours;
    }

    public int max(int[] piles){
        int ans = Integer.MIN_VALUE;
        for(int pile : piles){
            ans = Math.max(ans ,pile);
        }
        return ans;
    }
}