class Solution {

    class Node {
        int sum;
        int[] cols;

        Node(int sum, int[] cols) {
            this.sum = sum;
            this.cols = cols;
        }
    }

    public int kthSmallest(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        int[] startCols = new int[m];
        int startSum = 0;

        for (int i = 0; i < m; i++) {
            startSum += mat[i][0];
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);

        Set<String> visited = new HashSet<>();

        pq.offer(new Node(startSum, startCols));
        visited.add(Arrays.toString(startCols));

        while (k-- > 1) {

            Node curr = pq.poll();

            for (int row = 0; row < m; row++) {

                int[] nextCols = curr.cols.clone();

                if (nextCols[row] + 1 >= n)
                    continue;

                nextCols[row]++;

                String key = Arrays.toString(nextCols);

                if (visited.contains(key))
                    continue;

                visited.add(key);

                int newSum = curr.sum
                           - mat[row][nextCols[row] - 1]
                           + mat[row][nextCols[row]];

                pq.offer(new Node(newSum, nextCols));
            }
        }

        return pq.peek().sum;
    }
}