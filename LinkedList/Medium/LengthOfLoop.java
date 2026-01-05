package Medium;

import java.util.HashSet;

/*
====================================
 Length of Loop in Linked List
====================================

PROBLEM:
Given the head of a linked list, find the length of the loop.
If no loop exists, return 0.

------------------------------------
APPROACH 1: Brute Force (HashSet)
------------------------------------
Intuition:
- Traverse the list
- Store visited nodes in HashSet
- When a node repeats, loop is detected
- Traverse again to count loop length

TC: O(n)
SC: O(n)

------------------------------------
APPROACH 2: Optimal (Floyd’s Cycle Detection) ✅
------------------------------------
Intuition:
1. Use slow & fast pointers to detect loop
2. If slow == fast → loop exists
3. From meeting point, move one pointer until it comes back
4. Count steps → loop length

TC: O(n)
SC: O(1)

====================================
*/

// Node definition
class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class LengthOfLoop {

    // ---------- APPROACH 1 : HASHSET ----------
    public int lengthOfLoopHash(Node head) {
        if (head == null) return 0;

        HashSet<Node> set = new HashSet<>();
        Node curr = head;

        while (curr != null) {
            if (set.contains(curr)) {
                // count loop length
                int count = 1;
                Node temp = curr.next;
                while (temp != curr) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
            set.add(curr);
            curr = curr.next;
        }
        return 0;
    }

    // ---------- APPROACH 2 : FLOYD (OPTIMAL) ----------
    public int lengthOfALoop(Node head) {
        if (head == null) return 0;

        Node slow = head, fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {

                // Step 2: Count loop length
                int count = 1;
                Node temp = slow.next;

                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
        }
        return 0; // No loop
    }
}
