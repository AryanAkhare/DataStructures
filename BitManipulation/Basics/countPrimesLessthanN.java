package BitManipulation.Basics;

/*
    Problem:
    -------------
    Given an integer n, return the number of prime numbers that are strictly less than n.

    Example:
    Input: n = 10
    Output: 4
    Explanation: Prime numbers less than 10 are 2, 3, 5, 7.

    ------------------------------------------------------------

    Intuition:
    -------------
    Instead of checking every number individually for primality
    (which would be slow), we use the Sieve of Eratosthenes.

    The idea:
    - Assume all numbers are prime initially.
    - Start from 2 (first prime).
    - Mark all multiples of 2 as non-prime.
    - Move to next unmarked number and repeat.
    - Continue this process up to sqrt(n).

    Why till sqrt(n)?
    Because if a number has a factor greater than sqrt(n),
    it must also have a smaller factor already processed.

    ------------------------------------------------------------

    Approach (Sieve of Eratosthenes):
    -------------
    1. Create an array prime[] of size n+1.
    2. Mark all numbers from 2 to n as 1 (assume prime).
    3. For each number i from 2 to sqrt(n):
         - If it is marked prime,
           mark all multiples of i starting from i*i as non-prime.
    4. Count all numbers marked prime from 2 to n-1.

    ------------------------------------------------------------

    Time Complexity:
    -------------
    O(n log log n)

    Explanation:
    The sieve runs in nearly linear time.
    It is much faster than checking each number individually.

    ------------------------------------------------------------

    Space Complexity:
    -------------
    O(n)
    Because we use an extra array of size n.

*/

public class countPrimesLessthanN {
    
    public int countPrimes(int n) {

        // Edge case: if n <= 2, no primes exist less than n
        if (n <= 2) return 0;

        int prime[] = new int[n + 1];
        
        // Assume all numbers are prime initially
        for (int i = 2; i < prime.length; i++) {
            prime[i] = 1;
        }

        // Sieve process
        for (int i = 2; i * i < n; i++) {
            if (prime[i] == 1) {
                
                // Mark multiples of i as non-prime
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = 0;
                }
            }
        }

        // Count primes less than n
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i] == 1) count++;
        }

        return count;
    }
}
