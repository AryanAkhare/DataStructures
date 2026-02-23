/*
===========================================================
Problem: 27. Remove Element (LeetCode - Easy)
===========================================================

Problem Statement:
Given an integer array nums and an integer val, remove all occurrences
of val in-place. The order of the elements may be changed.

Return the number of elements k such that the first k elements
of nums contain elements not equal to val.

You must:
- Modify array in-place
- Use O(1) extra space
- Return k

-----------------------------------------------------------
Example 1:
Input: nums = [3,2,2,3], val = 3
Output: 2
nums becomes [2,2,_,_]

Example 2:
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5
nums becomes [0,1,4,0,3,_,_,_]

-----------------------------------------------------------
Intuition:

We DO NOT delete elements.
Instead:

1. Maintain a pointer k.
2. Traverse array using i.
3. If nums[i] != val:
      - Copy nums[i] to nums[k]
      - Increment k

At the end:
- First k elements are valid.
- Remaining elements don't matter.

This is a TWO POINTER technique:
- i → scans the array
- k → builds the result in-place

-----------------------------------------------------------
Dry Run:

nums = [3,2,2,3], val = 3

i=0 → nums[0]=3 → skip
i=1 → nums[1]=2 → nums[0]=2 → k=1
i=2 → nums[2]=2 → nums[1]=2 → k=2
i=3 → nums[3]=3 → skip

Return k=2

Final array: [2,2,?,?]

-----------------------------------------------------------
Time Complexity:
O(n)
We traverse the array once.

Space Complexity:
O(1)
No extra space used.

-----------------------------------------------------------
Why This Works?

We overwrite unwanted elements.
We compact valid elements to the front.
No shifting required.
Efficient and interview-friendly.

===========================================================
*/

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        int k = 0;  // Pointer for valid elements

        for (int i = 0; i < nums.length; i++) {

            // If current element is NOT equal to val
            if (nums[i] != val) {

                nums[k] = nums[i];  // Place it at correct position
                k++;                // Move pointer forward
            }
        }

        return k;  // Number of valid elements
    }

    // Main method for testing
    public static void main(String[] args) {

        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int k = removeElement(nums, val);

        System.out.println("Valid Count: " + k);

        System.out.print("Modified Array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}