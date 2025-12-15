package Medium;

public class Atoi {

    // Problem:
    // Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
    // The algorithm should:
    // 1. Ignore leading whitespaces.
    // 2. Check for an optional '+' or '-' sign.
    // 3. Read digits until a non-digit character is encountered.
    // 4. Clamp the result within the range [-2^31, 2^31 - 1].
    // 5. Return the final integer value.

    // Example:
    // Input: "   -13sb"
    // Output: -13
    //
    // Input: "4193 with words"
    // Output: 4193
    //
    // Input: "words and 987"
    // Output: 0

    public static int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        int sign = 1;   // stores sign (+1 or -1)
        long num = 0;   // use long to detect overflow safely

        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If string contains only spaces
        if (i == n) return 0;

        // Step 2: Check sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits to number
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = num * 10 + (s.charAt(i) - '0');

            // Step 4: Handle overflow
            if (sign * num <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if (sign * num >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            i++;
        }

        // Step 5: Return final value
        return (int) (sign * num);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-13sb")); // Output: -13
    }
}
