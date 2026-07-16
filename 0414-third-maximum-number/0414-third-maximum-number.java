class Solution {
    public int thirdMax(int[] nums) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num))
                continue;

            set.add(num);
            minHeap.offer(num);

            if (minHeap.size() > 3) {
                int removed = minHeap.poll();
                set.remove(removed);
            }
        }

        if (minHeap.size() < 3) {
            while (minHeap.size() > 1) {
                minHeap.poll();
            }
            return minHeap.peek();
        }

        return minHeap.peek();
    }
}