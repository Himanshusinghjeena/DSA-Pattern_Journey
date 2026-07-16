class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int unique = map.size();

        while (k > 0 && !pq.isEmpty()) {

            int[] cur = pq.poll();
            int freq = cur[1];

            if (k >= freq) {
                k -= freq;
                unique--;
            } else {
                break;
            }
        }

        return unique;
    }
}