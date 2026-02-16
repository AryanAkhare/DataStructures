import java.util.*;

/*
    Problem:
    -------------------------------------------------
    You are given an integer array nums.
    Return the number of distinct prime factors
    across the product of all elements of nums.

    Example:
    Input: nums = [2,4,3,7,10]
    Output: 4
    Explanation:
    Product = 2 * 4 * 3 * 7 * 10
    Prime factors = {2,3,5,7}
    Answer = 4

    -------------------------------------------------
    Key Observation:
    -------------------------------------------------
    Instead of multiplying all numbers (which may overflow),
    we directly collect prime factors of each number.

    Because:
    Prime factors of product =
    Union of prime factors of individual numbers.

    -------------------------------------------------
    APPROACH 1: Trial Division (Your Approach)  ✅
    -------------------------------------------------
    Idea:
    - For each number:
        - Try dividing from 2 to √n.
        - If divisible, add factor to set.
        - Remove all occurrences of that factor.
    - If remaining n > 1 → it is prime.

    Time Complexity:
    O(N * √M)
    where:
        N = size of array
        M = maximum value in nums

    Space Complexity:
    O(K)  (K = number of distinct prime factors)

    This is optimal for typical constraints.
*/

class Solution {

    // -----------------------------
    // APPROACH 1: Trial Division
    // -----------------------------
    public int distinctPrimeFactors(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            int n = num;

            for (int i = 2; i * i <= n; i++) {

                if (n % i == 0) {
                    set.add(i);
                }

                while (n % i == 0) {
                    n = n / i;
                }
            }

            if (n > 1) {
                set.add(n);
            }
        }

        return set.size();
    }
}

/*
-------------------------------------------------
APPROACH 2: Precompute Smallest Prime Factor (SPF)
-------------------------------------------------

Better when:
- Numbers are large
- Many queries
- Constraints up to 10^6

Idea:
1. Precompute smallest prime factor for every number
   using Sieve.
2. For each number:
   - Keep dividing by SPF[n]
   - Add SPF[n] to set

Time Complexity:
O(MAX log log MAX)  for sieve
O(N log M)          for factorization

Space Complexity:
O(MAX)

-------------------------------------------------

Code for SPF approach:
-------------------------------------------------

class Solution {

    static int MAX = 100000;
    static int[] spf = new int[MAX + 1];

    static {
        for (int i = 2; i <= MAX; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= MAX; j += i) {
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }
    }

    public int distinctPrimeFactors(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            while (num > 1) {
                set.add(spf[num]);
                num = num / spf[num];
            }
        }

        return set.size();
    }
}

-------------------------------------------------
APPROACH 3: Multiply First (NOT Recommended)
-------------------------------------------------

1. Multiply all numbers.
2. Factorize the product.

Problem:
- Product may overflow.
- Even using long won't work for large inputs.
- Worst approach.

Time Complexity:
O(√P) where P = product (very large)

Not practical.

-------------------------------------------------
Final Recommendation:
-------------------------------------------------
✔ Use Trial Division for normal constraints.
✔ Use SPF (Sieve) if constraints are large.

-------------------------------------------------
Interview Tip:
-------------------------------------------------
Always mention:
"Instead of multiplying, we use union of prime factors,
because multiplication can overflow."
*/
