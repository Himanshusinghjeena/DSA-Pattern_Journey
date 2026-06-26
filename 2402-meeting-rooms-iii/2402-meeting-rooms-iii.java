class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> available = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        PriorityQueue<long[]> occupied = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] == b[0]) {
                    return Long.compare(a[1], b[1]);
                }
                return Long.compare(a[0], b[0]);  
            }
        );

        int[] count = new int[n];

        for (int[] meeting : meetings) {

            int start = meeting[0];
            int end = meeting[1];

            while (!occupied.isEmpty() && occupied.peek()[0] <= start) {
                long[] room = occupied.poll();
                available.offer((int) room[1]);
            }

            if (!available.isEmpty()) {

                int room = available.poll();

                count[room]++;

                occupied.offer(new long[]{
                    end,
                    room
                });

            }

            else {

                long[] room = occupied.poll();

                long finishTime = room[0];
                int roomNo = (int) room[1];

                long duration = end - start;

                count[roomNo]++;

                occupied.offer(new long[]{
                    finishTime + duration,
                    roomNo
                });
            }
        }

        int answer = 0;

        for (int i = 1; i < n; i++) {
            if (count[i] > count[answer]) {
                answer = i;
            }
        }

        return answer;
    }
}