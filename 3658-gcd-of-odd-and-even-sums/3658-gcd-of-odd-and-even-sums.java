class Solution {
    public int gcdOfOddEvenSums(int n) {
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 2; i <= 2 * n; i = i + 2) {
            oddSum = oddSum + (i - 1);
            evenSum += i;
        }

        return gcd(oddSum, evenSum);

    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}