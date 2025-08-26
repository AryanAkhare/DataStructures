package OnAnswers;

public class nthRoot {
    
    /**
     * Problem:
     * --------
     * Given two integers n and m, find the nth root of m.
     * That means find an integer x such that x^n = m.
     * If no such integer exists, return -1.
     *
     * Example:
     * --------
     * n = 3, m = 27  → output = 3 (since 3^3 = 27)
     * n = 2, m = 20  → output = -1 (no integer square root)
     *
     * Intuition:
     * ----------
     * Instead of checking every number from 1 to m,
     * we can use binary search in the range [1, m].
     * - Calculate mid = (low + high)/2
     * - If mid^n == m → found the root
     * - If mid^n < m → move right (low = mid+1)
     * - If mid^n > m → move left (high = mid-1)
     * 
     * Time Complexity:
     * ----------------
     * O(log m * log n) 
     *   - log m → because we do binary search on [1..m]
     *   - log n → because Math.pow may internally take O(log n) multiplications
     *
     * Space Complexity:
     * -----------------
     * O(1) (we only use a few variables)
     */
    public int nthRoot(int n, int m) {
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            double power = Math.pow(mid, n);

            if (power == m) {
                return mid; // exact root found
            } else if (power < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // no integer root exists
    }
    public long power(long n, long m) {
        long result = 1;
        long base = n;

        while (m > 0) {
        if ((m & 1) == 1) {   // if m is odd
            result *= base;
        }
        base *= base; // square the base
        m >>= 1;      // divide exponent by 2
    }

    return result;
    }

    // Example test
    public static void main(String[] args) {
        nthRoot obj = new nthRoot();
        System.out.println(obj.nthRoot(3, 27)); // 3
        System.out.println(obj.nthRoot(2, 20)); // -1
    }
}
