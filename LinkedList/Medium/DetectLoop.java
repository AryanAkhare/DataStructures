package Medium;

import org.w3c.dom.Node;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DetectLoop {

    // Function to detect cycle in linked list
    public boolean hasCycle(ListNode head) {
        
        //O(N)  TC 0(1) SC

        // Intuition:
        // Use two pointers:
        // slow  → moves 1 step at a time
        // fast  → moves 2 steps at a time
        //
        // If a cycle exists, fast will eventually catch slow
        // If no cycle, fast will reach null

        // Edge case: empty list or single node
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow=head , fast=head;
    
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}
