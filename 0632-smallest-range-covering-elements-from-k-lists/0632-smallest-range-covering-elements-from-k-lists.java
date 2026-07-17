class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            pq.offer(new int[]{value, i, 0}); 
            max = Math.max(max, value);
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        while (true) {

            int[] curr = pq.poll();

            int min = curr[0];
            int list = curr[1];
            int index = curr[2];

            if (max - min < end - start) {
                start = min;
                end = max;
            }

            if (index + 1 == nums.get(list).size()) {
                break;
            }

            int next = nums.get(list).get(index + 1);
            pq.offer(new int[]{next, list, index + 1});

            max = Math.max(max, next);
        }

        return new int[]{start, end};
    }
}