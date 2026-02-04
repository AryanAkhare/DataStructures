package Recursion;

public class Pow {

    /*
     * Intuition:
     * We want to calculate x^n efficiently.
     * Instead of multiplying x n times (O(n)),
     * we use Binary Exponentiation.
     *
     * If n is even:
     *   x^n = (x * x)^(n / 2)
     *
     * If n is odd:
     *   x^n = x * (x * x)^((n - 1) / 2)
     *
     * For negative powers:
     *   x^-n = 1 / x^n
     *
     * This reduces the time complexity to O(log n).
     */

    public static double myPow(double x, int n) {

        // Base case
        if (n == 0) return 1.0;

        // Handle negative power
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }

        // Recursive call
        double half = myPow(x, n / 2);

        // If n is even
        if (n % 2 == 0) {
            return half * half;
        }

        // If n is odd
        return half * half * x;
    }

    /*
     * Time Complexity:
     * O(log n) — power is halved at each recursive call
     *
     * Space Complexity:
     * O(log n) — recursion stack space
     */
     public static double myPowIterative(double x, int n) {

        long nn = n;          // to handle Integer.MIN_VALUE
        double ans = 1.0;

        // Handle negative power
        if (nn < 0) {
            x = 1 / x;
            nn = -nn;
        }

        // Binary Exponentiation (Iterative)
        while (nn > 0) {
            if (nn % 2 == 1) {    // if power is odd
                ans *= x;
                nn--;
            } else {              // if power is even
                x *= x;
                nn /= 2;
            }
        }

        return ans;
    }

    /*
     * Time Complexity:
     * O(log n) — power is reduced by half at each step
     *
     * Space Complexity:
     * O(1) — no extra space used
     */
}
