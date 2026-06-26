class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        
        // Add index to track target friend
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = times[i][0]; // arrival
            arr[i][1] = times[i][1]; // leave
            arr[i][2] = i;           // friend index
        }
        
        // Sort by arrival time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        // Min heap for free chairs
        PriorityQueue<Integer> freeChairs = new PriorityQueue<>();
        
        // Min heap for occupied chairs → (leaveTime, chair)
        PriorityQueue<int[]> occupied = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        
        int chairNumber = 0;
        
        for (int[] friend : arr) {
            int arrival = friend[0];
            int leave = friend[1];
            int index = friend[2];
            
            // Free chairs where people already left
            while (!occupied.isEmpty() && occupied.peek()[0] <= arrival) {
                freeChairs.offer(occupied.poll()[1]);
            }
            
            int chair;
            
            // Assign smallest available chair
            if (!freeChairs.isEmpty()) {
                chair = freeChairs.poll();
            } else {
                chair = chairNumber++;
            }
            
            // If this is target friend → return
            if (index == targetFriend) {
                return chair;
            }
            
            // Mark chair as occupied
            occupied.offer(new int[]{leave, chair});
        }
        
        return -1; // never reached
    }
}