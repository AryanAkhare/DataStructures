package Medium;

/*
    Problem: Maximum Depth of Parentheses
    Given a string s containing only '(' and ')', find the maximum depth of nested parentheses.

    Approach:
    1. Initialize two variables:
        - count: to track current depth while iterating.
        - max: to store the maximum depth encountered.
    2. Iterate over each character in the string:
        - If '(', increment count (going deeper).
        - If ')', decrement count (closing a parenthesis).
        - After each step, update max with Math.max(max, count).
    3. Return max after the loop.

    Intuition:
    - Every '(' increases the current nesting depth.
    - Every ')' decreases it.
    - Maximum depth at any point is the deepest nested '(' seen so far.

    Time Complexity: O(n)  -> Single pass over the string
    Space Complexity: O(1) -> Only two extra integer variables used
*/

public class MaxDepthParenthesis {

    public int maxDepth(String s) {
        int count = 0;  // Current depth of parentheses
        int max = 0;    // Maximum depth encountered

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;  // Entering a new nested level
            } else if (ch == ')') {
                count--;  // Closing a level
            }

            // Update maximum depth if current depth is greater
            max = Math.max(max, count);
        }

        return max;  // Return the maximum depth
    }
}
