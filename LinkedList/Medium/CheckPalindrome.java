package Medium;

import java.util.ArrayList;
import java.util.Stack;

/*
===========================
 Palindrome Linked List
===========================

APPROACH 1: Array Conversion (Brute Force)
-----------------------------------------
Intuition:
- Copy linked list values into array
- Use two pointers to check palindrome

TC: O(n)
SC: O(n)
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class CheckPalindrome {

    // ---------- APPROACH 1 : ARRAY ----------
    public boolean isPalindromeArray(ListNode head) {

        ArrayList<Integer> arr = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        int left = 0, right = arr.size() - 1;
        while (left < right) {
            if (!arr.get(left).equals(arr.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /*
    ===========================
    APPROACH 2: Stack
    ===========================
    Intuition:
    - Push all node values into stack
    - Stack reverses order
    - Compare while popping

    TC: O(n)
    SC: O(n)
    */

    // ---------- APPROACH 2 : STACK ----------
    public boolean isPalindromeStack(ListNode head) {

        Stack<Integer> st = new Stack<>();
        ListNode curr = head;

        // push all values
        while (curr != null) {
            st.push(curr.val);
            curr = curr.next;
        }

        // compare
        curr = head;
        while (curr != null) {
            if (curr.val != st.pop()) {
                return false;
            }
            curr = curr.next;
        }

        return true;
    }

    /*
    ===========================
    APPROACH 3: Optimal (Already Done)
    ===========================
    Slow + Fast Pointer
    Reverse second half
    Compare halves

    TC: O(n)
    SC: O(1)
    */
   public boolean isPalindrome(ListNode head) {

        // Edge cases: empty or single node
        if (head == null || head.next == null) return true;

        // 1️⃣ Find middle (slow at end of first half)
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2️⃣ Reverse second half
        ListNode secondHalf = reverse(slow.next);
        ListNode firstHalf = head;

        // 3️⃣ Compare both halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Reverse linked list helper
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
