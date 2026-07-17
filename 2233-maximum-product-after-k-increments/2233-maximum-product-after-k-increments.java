class Solution {
    public int maximumProduct(int[] nums, int k) {
        long res = 1;
        int MOD = 1000000007;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.offer(num);
        }

        while( k > 0){
            pq.offer(pq.poll() +1 );
            k--;
        }
        while(!pq.isEmpty()){
            res = (res * pq.poll()) % MOD;
        }

        return (int)res ;
    }
}