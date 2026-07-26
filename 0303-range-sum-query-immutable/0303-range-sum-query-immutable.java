class NumArray {
    int[] arr ;
    int[] prefix;

    public NumArray(int[] nums) {
        this.arr = nums;
        prefix = new int[arr.length+1];
        prefix[0] = 0;
        
        for(int i=1; i<prefix.length; i++){
            prefix[i] =  prefix[i-1] + arr[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
            return prefix[right+1] - prefix[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */