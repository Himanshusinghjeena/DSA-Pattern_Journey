class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m <= 0 || k <= 0 || m > Integer.MAX_VALUE / k || m * k > bloomDay.length) {
            return -1;
        }
        int low = min(bloomDay);
        int high = max(bloomDay);
        int ans = high;
        
        while(low<= high){  
        int mid = low +(high -low)/2;
        if(possible(bloomDay,mid,m,k)) {
            ans=mid; 
            high = mid-1;
        }else{
            low=mid+1;
        } 
    }
        return ans;
    }
    public boolean possible(int[] arr,int day, int m ,int k){
        int count =0; int bouque =0;
        if(m*k > arr.length) return false;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= day){
                count++;
            }
            else {
                bouque += count/k;
                count=0;
            }
        }
         
        bouque += count/k;
        if(bouque >=m) return true;
        return false;
    }


    public int min(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int num : arr){
           min = Math.min(num,min);
        }
        return min;
    }

    public int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num : arr){
            max = Math.max(num,max);
        }
        return max;
    }
} 