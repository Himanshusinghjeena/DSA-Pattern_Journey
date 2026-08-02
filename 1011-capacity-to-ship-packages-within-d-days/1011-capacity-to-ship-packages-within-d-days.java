class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = max(weights);        
        int high = sum(weights);       
        int ans = high;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int requiredDays = calcDays(weights, mid);

            if (requiredDays <= days) {
                ans = mid;           
                high = mid - 1;
            } else {
                low = mid + 1;       
            }
        }
        return ans;
    }

    

    public int calcDays(int[] arr, int capacity) {
        int day = 1;  
        int load = 0;

        for (int weight : arr) {
            if (load + weight > capacity) {
                day++;          
                load = 0;       
            }
            load += weight;     
        }
        return day;
    }


    public int max(int[] weights){
        int max = Integer.MIN_VALUE;
        for(int weight:  weights){
            max = Math.max(max,weight);
        }
        return max;
    }

    public int sum(int[] weights){
        int sum =0;
        for(int weight: weights){
            sum+= weight;
        }
        return sum;
    }
}