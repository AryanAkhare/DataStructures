package Easy;

/*
    Problem: Merge Two Sorted Linked Lists
    TUF Style – All Approaches
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeTwoSorted {

    /*---------------------------------------------------
      APPROACH 1: Iterative (Using Dummy Node) ⭐ RECOMMENDED
      ---------------------------------------------------
      Intuition:
      - Use a dummy node to simplify edge cases.
      - Compare nodes from both lists.
      - Attach smaller node to current pointer.
      - Finally attach remaining list.

      Time Complexity: O(n + m)
      Space Complexity: O(1)
    */
    public ListNode mergeTwoLists_Dummy(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // attach remaining nodes
        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    /*---------------------------------------------------
      APPROACH 2: Iterative (Without Dummy Node)
      ---------------------------------------------------
      Intuition:
      - First decide head manually.
      - Then continue merging using a pointer.

      Time Complexity: O(n + m)
      Space Complexity: O(1)
    */
    public ListNode mergeTwoLists_NoDummy(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;

        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode curr = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;
        return head;
    }

    /*---------------------------------------------------
      APPROACH 3: Recursive Solution
      ---------------------------------------------------
      Intuition:
      - Pick smaller node as head.
      - Recursively merge remaining lists.

      Time Complexity: O(n + m)
      Space Complexity: O(n + m)  (recursion stack)
    */
    public ListNode mergeTwoLists_Recursive(ListNode l1, ListNode l2) {

        // base cases
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists_Recursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_Recursive(l1, l2.next);
            return l2;
        }
    }

    /*---------------------------------------------------
      APPROACH 4: Brute Force (Using Extra Space)
      ---------------------------------------------------
      Intuition:
      - Store all values in array/list.
      - Sort it.
      - Rebuild linked list.

      ❌ Not recommended in interviews

      Time Complexity: O((n+m) log(n+m))
      Space Complexity: O(n+m)
    */
    // Not implemented intentionally (bad approach)
}
