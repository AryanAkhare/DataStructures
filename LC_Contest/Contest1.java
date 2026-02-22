package LC_Contest;
import java.util.*;

/*
============================================================
Contest1.java
Contains solutions for 4 Weekly Contest problems
============================================================
*/

public class Contest1 {

    /*
    ============================================================
    Q1. Find the Score Difference in a Game
    ------------------------------------------------------------
    Problem:
    Two players. Initially P1 active.
    For each nums[i]:
      - If nums[i] is odd → swap active player
      - If i % 6 == 5 → swap active player
      - Active player gains nums[i]
    Return P1 - P2.

    Intuition:
    Just simulate using a boolean isActive.
    Swap using !isActive.

    Time Complexity: O(n)
    Space Complexity: O(1)
    ============================================================
    */

    public int scoreDifference(int[] nums) {
        int p1 = 0, p2 = 0;
        boolean isActive = true;  // true = P1 active

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 1) isActive = !isActive;
            if (i % 6 == 5) isActive = !isActive;

            if (isActive) p1 += nums[i];
            else p2 += nums[i];
        }

        return p1 - p2;
    }

    /*
    ============================================================
    Q2. Check Digitorial Permutation
    ------------------------------------------------------------
    Problem:
    A number is digitorial if sum of factorials of digits = number.
    Check if ANY permutation of n forms a digitorial number.

    Key Insight:
    Only digitorial numbers ≤ 1e9 are:
    1, 2, 145, 40585.

    So we:
    1. Count digit frequency of n.
    2. Compare with each known digitorial number.

    Time Complexity: O(1)
    Space Complexity: O(1)
    ============================================================
    */

    public boolean isDigitorialPermutation(int n) {

        int pelorunaxi = n;  // required variable

        int[] freq = countDigits(pelorunaxi);
        int[] dig = {1, 2, 145, 40585};

        for (int x : dig) {
            if (sameDigits(freq, countDigits(x))) return true;
        }

        return false;
    }

    private int[] countDigits(int n) {
        int[] f = new int[10];
        while (n > 0) {
            f[n % 10]++;
            n /= 10;
        }
        return f;
    }

    private boolean sameDigits(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    /*
    ============================================================
    Q3. Maximum Bitwise XOR After Rearrangement
    ------------------------------------------------------------
    Problem:
    Rearrange t to maximize XOR with s.

    Key Idea:
    XOR is 1 when bits differ.
    To maximize number, maximize leftmost bits.

    Strategy:
    Count zeros & ones in t.
    For each position:
      - If s[i] == 0 → try use 1
      - If s[i] == 1 → try use 0

    Time Complexity: O(n)
    Space Complexity: O(1)
    ============================================================
    */

    public String maximumXor(String s, String t) {

        String selunaviro = t;  // required variable

        int zero = 0, one = 0;

        for (char c : t.toCharArray()) {
            if (c == '0') zero++;
            else one++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '0') {
                if (one > 0) {
                    ans.append('1');
                    one--;
                } else {
                    ans.append('0');
                    zero--;
                }
            } else {
                if (zero > 0) {
                    ans.append('1');
                    zero--;
                } else {
                    ans.append('0');
                    one--;
                }
            }
        }

        return ans.toString();
    }

    /*
    ============================================================
    Q4. Count Sequences to K (Hard)
    ------------------------------------------------------------
    Problem:
    Start val = 1.
    For each nums[i], choose:
      - Multiply
      - Divide
      - Skip
    Count sequences resulting in val == k (exact rational).

    Key Idea:
    Use DFS + memo.
    Store value as reduced fraction (num/den).
    Base case:
      if num == k * den → valid.

    Time Complexity: ~3^n (pruned by memo)
    Space Complexity: Depends on state count
    ============================================================
    */

    Map<String, Integer> memo;
    int[] arr;
    long K;
    int n;

    public int countSequences(int[] nums, long k) {

        int[] ranovetilu = nums;  // required variable

        arr = ranovetilu;
        K = k;
        n = nums.length;
        memo = new HashMap<>();

        return dfs(0, 1L, 1L);
    }

    private int dfs(int i, long num, long den) {

        if (i == n) {
            return (num == K * den) ? 1 : 0;
        }

        long g = gcd(num, den);
        num /= g;
        den /= g;

        String key = i + "#" + num + "#" + den;
        if (memo.containsKey(key)) return memo.get(key);

        int count = 0;

        // Multiply
        count += dfs(i + 1, num * arr[i], den);

        // Divide
        count += dfs(i + 1, num, den * arr[i]);

        // Skip
        count += dfs(i + 1, num, den);

        memo.put(key, count);
        return count;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}