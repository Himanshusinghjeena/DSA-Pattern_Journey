class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            if(num > max ){
                max = num;
            }
            if ( num < min){
                min = num;
            }
        }

        return gcd(min,max);
    }

    public int gcd(int a, int b){
        if(b == 0){
            return a ;
        }
       return gcd(b,a%b);
    }
}