package Recursion;

/*
Problem:
You are given a long integer n. A number is called "good" if:
- Digits at even indices (0-based) can be chosen from {0,2,4,6,8} → 5 choices
- Digits at odd indices can be chosen from {2,3,5,7} → 4 choices
Return the total number of good numbers of length n.
Since the answer can be very large, return it modulo 10^9 + 7.
*/

/*
Intuition:
- Even positions = (n + 1) / 2
- Odd positions = n / 2
- Total good numbers = 5^(even positions) × 4^(odd positions)
- Use fast exponentiation (recursion) to compute powers efficiently.
*/

public class countGoodNumbers {

    static class Solution {

        public static final long MOD = 1_000_000_007;

        public int countGoodNumbers(long n) {
            long even = (n + 1) / 2;
            long odd = n / 2;

            long ans = (power(5, even) * power(4, odd)) % MOD;
            return (int) ans;
        }

        // Fast power using recursion
        public long power(long x, long y) {
            if (y == 0) return 1;

            long half = power(x, y / 2);

            if (y % 2 == 0) {
                return (half * half) % MOD;
            } else {
                return (x * half % MOD * half % MOD) % MOD;
            }
        }
    }
}

/*
Time Complexity:
- O(log n), because fast exponentiation reduces the power calculation to log(n)

Space Complexity:
- O(log n), due to recursive call stack
*/
