class Solution {

    public int numOfStrings(String[] patterns, String word) {

        int ans = 0;

        for (String pattern : patterns) {

            if (isSubstring(word, pattern)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isSubstring(String word, String pattern) {

        int n = word.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && word.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }

            if (j == m)
                return true;
        }

        return false;
    }
}