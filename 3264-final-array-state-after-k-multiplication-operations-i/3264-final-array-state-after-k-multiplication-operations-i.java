class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a, b) -> a[0] == b[0]
        ? a[1] - b[1]
        : a[0] - b[0]
);

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] { nums[i], i });
        }
        while (k > 0) {
            int[] ele = pq.poll();
            ele[0] *= multiplier;
            pq.offer(new int[] { ele[0], ele[1] });
            k--;
        }

        int[] res = new int[nums.length];
        while(!pq.isEmpty()){
            int[] ele = pq.poll();
            res[ele[1]] = ele[0];
        }
        return res;
    }
}