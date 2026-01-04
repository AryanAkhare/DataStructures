import java.util.HashMap;

public class FindStartofCycle {

    /* -----------------------------
       LeetCode ListNode
    ------------------------------ */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /* -----------------------------
       GFG Node
    ------------------------------ */
    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }

    /* =====================================================
       LEETCODE – BRUTE FORCE (HASHMAP)
       INTUITION:
       - If a cycle exists, a node will be visited again.
       - Store each visited node in a HashMap.
       - The first node that repeats is the start of the cycle.
       - Extra space is used to remember visited nodes.
       ===================================================== */
    static class LC_Brute {
        public ListNode detectCycle(ListNode head) {
            HashMap<ListNode, Integer> map = new HashMap<>();
            ListNode temp = head;

            while (temp != null) {
                if (map.containsKey(temp)) {
                    return temp;   // first repeated node = cycle start
                }
                map.put(temp, temp.val);
                temp = temp.next;
            }
            return null; // no cycle
        }
    }

    /* =====================================================
       LEETCODE – OPTIMAL (FLOYD’S CYCLE DETECTION)
       INTUITION:
       - Use two pointers:
         slow moves 1 step, fast moves 2 steps.
       - If a cycle exists, slow and fast will meet inside the loop.
       - Reset slow to head.
       - Move both slow and fast one step at a time.
       - The node where they meet again is the start of the cycle.
       - Works because distance from head to cycle start
         equals distance from meeting point to cycle start.
       ===================================================== */
    static class LC_Optimal {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    slow = head;
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow; // cycle start node
                }
            }
            return null; // no cycle
        }
    }

    /* =====================================================
       GFG – FIND FIRST NODE OF LOOP
       INTUITION:
       - Same logic as Floyd’s algorithm.
       - First detect the cycle using slow and fast pointers.
       - Reset slow to head after detection.
       - Move both pointers one step at a time.
       - Meeting point gives the first node of the loop.
       - Return node.data instead of node itself.
       ===================================================== */
    static class GFG_Solution {
        public int cycleStart(Node head) {
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    slow = head;
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow.data; // first node of loop
                }
            }
            return -1; // no loop
        }
    }
}
// Both approaches take O(n) time, but Floyd’s is optimal because it uses O(1) space.