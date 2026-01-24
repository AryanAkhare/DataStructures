package Medium;

import java.util.*;

/*
 =========================
  Linked List Node (LC)
 =========================
*/
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

/*
 =========================
  Linked List Node (GFG)
 =========================
*/
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SegregateOddEven {

    /*
     ============================================================
     PROBLEM 1 (LeetCode):
     Odd Even Linked List
     -> Odd / Even based on POSITION (1-based indexing)
     ============================================================
    */

    /*
     --------------------
     BRUTE FORCE APPROACH
     --------------------
     Intuition:
     - Store odd position nodes first
     - Then store even position nodes
     - Build a new linked list
    */
    public ListNode oddEvenListBrute(ListNode head) {
        if (head == null) return null;

        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;

        // Collect odd index nodes
        while (temp != null) {
            arr.add(temp.val);
            if (temp.next == null) break;
            temp = temp.next.next;
        }

        // Collect even index nodes
        temp = head.next;
        while (temp != null) {
            arr.add(temp.val);
            if (temp.next == null) break;
            temp = temp.next.next;
        }

        // Build new linked list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }

    /*
     Time Complexity: O(N)
     Space Complexity: O(N)
    */

    /*
     --------------------
     OPTIMAL APPROACH
     --------------------
     Intuition (TUF):
     - Maintain two pointers: odd and even
     - Keep start of even list
     - Rewire pointers in-place
    */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;          // first odd node
        ListNode even = head.next;    // first even node
        ListNode evenHead = even;     // to attach later

        while (even != null && even.next != null) {
            odd.next = even.next;     // link next odd
            odd = odd.next;

            even.next = odd.next;    // link next even
            even = even.next;
        }

        odd.next = evenHead;          // attach even list
        return head;
    }

    /*
     Time Complexity: O(N)
     Space Complexity: O(1)
    */

    /*
     ============================================================
     PROBLEM 2 (GFG):
     Segregate Even and Odd Nodes
     -> Even / Odd based on VALUE
     ============================================================
    */

    /*
     --------------------
     OPTIMAL APPROACH
     --------------------
     Intuition (TUF):
     - Create two lists: even list & odd list
     - Preserve order
     - Join even list with odd list
    */
    
    
public ListNode evenOddList(ListNode head) {
    if (head == null || head.next == null) return head;

    // even index list starts from 2nd node
    ListNode even = head.next;
    ListNode evenHead = even;

    // odd index list starts from 1st node
    ListNode odd = head;
    ListNode oddHead = odd;

    while (even != null && even.next != null) {
        odd.next = even.next;
        odd = odd.next;

        even.next = odd.next;
        even = even.next;
    }

    // attach odd list after even list
    even.next = oddHead;
    odd.next = null;

    return evenHead;
}


}
