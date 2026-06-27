class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        for (long x : freq.keySet()) {

            if (x == 1) {
                int count = freq.get(1L);

                if (count % 2 == 0)
                    ans = Math.max(ans, count - 1);
                else
                    ans = Math.max(ans, count);

                continue;
            }

            long curr = x;
            int length = 0;

            while (freq.containsKey(curr) && freq.get(curr) >= 2) {

                length += 2;

                curr = curr * curr;
            }

            if (freq.containsKey(curr)) {
                length += 1;
            } else {
                length -= 1;
            }

            ans = Math.max(ans, length);
        }

        return ans;
    }
}