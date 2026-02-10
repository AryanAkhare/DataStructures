/*
========================================================
Problem: Divide Two Integers (without using *, /, %)
========================================================

INTUITION:
-----------
Instead of subtracting divisor one-by-one (O(n)),
we subtract the largest possible power-of-two multiple
of the divisor each time.

This is similar to binary long division.

Example:
---------
dividend = 43, divisor = 3

3 × 1  = 3
3 × 2  = 6
3 × 4  = 12
3 × 8  = 24  <-- largest power-of-two multiple ≤ 43

Subtract 24, add 8 to answer.
Repeat until dividend < divisor.

--------------------------------------------------------

WHY BIT SHIFT?
--------------
Left shift (d << k) = d × 2^k
Fast, safe, and allowed.

--------------------------------------------------------

EDGE CASES:
-----------
1. Integer.MIN_VALUE / -1 → overflow
2. Negative numbers → handle sign separately
3. Avoid shifting beyond 31 bits (int overflow)

--------------------------------------------------------

TIME COMPLEXITY:
----------------
Outer loop  → O(log n)
Inner loop  → O(log n)
Overall     → O(log n)

SPACE COMPLEXITY:
-----------------
O(1)

--------------------------------------------------------
*/

public class Divide {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Determine sign
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // Convert to positive long to avoid overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int ans = 0;

        // Main logic
        while (n >= d) {
            int count = 0;

            // Find maximum power of two multiple
            while (count < 31 && n >= (d << (count + 1))) {
                count++;
            }

            ans += (1 << count);
            n -= (d << count);
        }

        return sign == 1 ? ans : -ans;
    }
}

/*
========================================================
INTERVIEW QUESTIONS YOU MAY BE ASKED
========================================================

Q1. Why not use simple subtraction?
Ans: It causes O(n) time → TLE for large inputs.

Q2. Why convert to long?
Ans: Math.abs(Integer.MIN_VALUE) overflows in int.

Q3. Why limit count < 31?
Ans: Shifting beyond 31 bits causes infinite loops.

Q4. Why only one overflow case?
Ans: Only MIN_VALUE / -1 exceeds int range.

Q5. Is this optimal?
Ans: Yes, O(log n) is the best possible without division.

========================================================
*/
