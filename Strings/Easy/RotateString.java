package Easy;

/*
Problem Statement:
------------------
Given two strings s and goal, check if goal is a rotation of s.
A string is a rotation of another if it can be obtained by 
shifting characters from the start to the end any number of times.

Example:
Input: s = "abcde", goal = "cdeab"
Output: true

Intuition:
----------
- If two strings are rotations, then goal must be a substring of s+s.
- Why? Because doubling s contains all possible rotations of s consecutively.
- First, check if lengths are equal. If not, goal cannot be a rotation.
- Then check if goal exists in the doubled string.

Approach:
---------
1. Check if lengths of s and goal are equal. If not, return false.
2. Create a new string by concatenating s with itself.
3. Check if goal is a substring of the doubled string.

Time Complexity: O(n)
- Doubling s takes O(n), checking substring also takes O(n) in Java.

Space Complexity: O(n)
- Doubling s requires extra space of size 2n.
*/

public class RotateString {

    public boolean rotateString(String s, String goal) {
        // Step 1: lengths must be equal
        if (s.length() != goal.length()) return false;

        // Step 2: check if goal is a substring of s+s
        String doubled = s + s;
        return doubled.contains(goal);
    }
}
