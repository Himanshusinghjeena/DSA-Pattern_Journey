class Solution {
    

    int[] prefix;
    int total;
    Random rand;

    public Solution(int[] w) {
        prefix = new int[w.length];
        rand = new Random();

        prefix[0] = w[0];

        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }

        total = prefix[w.length - 1];
    }
    
    public int pickIndex() {
        
        int target = rand.nextInt(total) + 1;

        int low = 0;
        int high = prefix.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (prefix[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */