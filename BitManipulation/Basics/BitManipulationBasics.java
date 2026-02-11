public class BitManipulationBasics {

    /* 
       ==============================
       1. Basic Bit Operations
       ==============================
    */

    // Check if ith bit is set (0-indexed from right)
    public static boolean isBitSet(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    // Set ith bit
    public static int setBit(int n, int i) {
        return n | (1 << i);
    }

    // Clear ith bit
    public static int clearBit(int n, int i) {
        return n & ~(1 << i);
    }

    // Toggle ith bit
    public static int toggleBit(int n, int i) {
        return n ^ (1 << i);
    }

    // Remove lowest set bit
    public static int removeLowestSetBit(int n) {
        return n & (n - 1);
    }

    // Get lowest set bit
    public static int getLowestSetBit(int n) {
        return n & -n;
    }

    /*
       ==============================
       2. Important Bit Tricks
       ==============================
    */

    // Check if number is power of 2
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Count set bits (Brian Kernighan's Algorithm)
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    // Count set bits (built-in)
    public static int countSetBitsBuiltIn(int n) {
        return Integer.bitCount(n);
    }

    // Check if number is even
    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    // Swap two numbers without temp
    public static int[] swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[]{a, b};
    }

    /*
       ==============================
       3. XOR Patterns (Very Important)
       ==============================
    */

    // Find single number (every other appears twice)
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    // Find missing number (0 to n)
    public static int missingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i];
        }
        return xor ^ n;
    }

    /*
       ==============================
       4. Subsets using Bitmask
       ==============================
    */

    public static void generateSubsets(int[] nums) {
        int n = nums.length;
        int total = 1 << n;  // 2^n subsets

        for (int mask = 0; mask < total; mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();
        }
    }

    /*
       ==============================
       5. Fast Exponentiation (Binary Exponentiation)
       ==============================
    */

    public static long fastPower(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= base;
            }
            base *= base;
            exp >>= 1;
        }

        return result;
    }

    /*
       ==============================
       6. Reverse Bits (Important LC)
       ==============================
    */

    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }

        return result;
    }

    /*
       ==============================
       7. Divide without / operator
       ==============================
    */

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;

        while (dvd >= dvs) {
            long temp = dvs, multiple = 1;

            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= temp;
            result += multiple;
        }

        return ((dividend > 0) == (divisor > 0)) ? result : -result;
    }

    /*
       ==============================
       8. Main Method (Testing)
       ==============================
    */

    public static void main(String[] args) {

        int n = 10; // 1010

        System.out.println(isBitSet(n, 1));      // true
        System.out.println(setBit(n, 0));        // 11
        System.out.println(clearBit(n, 1));      // 8
        System.out.println(toggleBit(n, 2));     // 14
        System.out.println(isPowerOfTwo(16));    // true
        System.out.println(countSetBits(10));    // 2

        int[] arr = {1, 2, 3};
        generateSubsets(arr);

        System.out.println(fastPower(2, 10));    // 1024
    }
}
