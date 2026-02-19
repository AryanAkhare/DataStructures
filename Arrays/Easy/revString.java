/*
-------------------------------------------------------------
Problem: Reverse String

Write a function that reverses a string.
The input string is given as an array of characters char[] s.

You must do this in-place with O(1) extra memory.

Example:
Input:  ['h','e','l','l','o']
Output: ['o','l','l','e','h']
-------------------------------------------------------------
*/

public class RevString {

    public static void main(String[] args) {

        Solution sol = new Solution();

        char[] arr = {'h','e','l','l','o'};

        sol.reverseStringTwoPointer(arr);

        System.out.println(arr);
    }
}

class Solution {

    /*
    -------------------------------------------------------------
    Approach 1: Two Pointer (Optimal & Expected)

    Intuition:
    - First element swaps with last.
    - Second swaps with second-last.
    - Continue until pointers meet.

    Time: O(n)
    Space: O(1)
    -------------------------------------------------------------
    */
    public void reverseStringTwoPointer(char[] s) {

        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
    }


    /*
    -------------------------------------------------------------
    Approach 2: Using Built-in (Not In-Place Properly)

    Intuition:
    - Convert to StringBuilder.
    - Reverse.
    - Convert back to char[].

    Time: O(n)
    Space: O(n)
    -------------------------------------------------------------
    */
    public void reverseStringUsingBuilder(char[] s) {

        String reversed = new StringBuilder(new String(s))
                .reverse()
                .toString();

        for (int i = 0; i < s.length; i++) {
            s[i] = reversed.charAt(i);
        }
    }


    /*
    -------------------------------------------------------------
    Approach 3: Recursive (Conceptual)

    Intuition:
    - Swap outer characters.
    - Recursively reverse inner part.

    Time: O(n)
    Space: O(n) recursion stack
    -------------------------------------------------------------
    */
    public void reverseStringRecursive(char[] s) {
        helper(s, 0, s.length - 1);
    }

    private void helper(char[] s, int left, int right) {

        if (left >= right) return;

        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        helper(s, left + 1, right - 1);
    }
}
