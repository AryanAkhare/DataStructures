package Easy;

public class removeduplicateinsrotedll {
    /*
class Node{
    int data;
    Node next, prev;
    Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}
*/

class Solution {

    /*
     ========================== INTUITION ==========================
     The doubly linked list is SORTED.
     Hence, duplicate elements will always appear next to each other.

     We traverse the list using a pointer `temp`.
     If current node's data is same as next node's data:
     - Delete the next node
     - Fix both next and prev pointers
     Otherwise:
     - Move temp forward
     ==============================================================
    */

    Node removeDuplicates(Node head) {

        /*
         ========================== APPROACH ==========================
         1. Start from head.
         2. Compare current node with its next node.
         3. If duplicate found:
            - Skip the duplicate node
            - Fix prev pointer of the node after duplicate
         4. Else move to next node.
         ==============================================================
        */

        Node temp = head;

        while (temp != null && temp.next != null) {

            // Duplicate found
            if (temp.data == temp.next.data) {

                Node duplicate = temp.next;
                Node nextNode = duplicate.next;

                // Remove duplicate
                temp.next = nextNode;

                // Fix prev link if nextNode exists
                if (nextNode != null) {
                    nextNode.prev = temp;
                }
            }
            // No duplicate, move forward
            else {
                temp = temp.next;
            }
        }
        return head;
    }

    /*
     ===================== TIME COMPLEXITY =====================
     O(N)
     - Each node is visited once.

     ===================== SPACE COMPLEXITY =====================
     O(1)
     - In-place removal, no extra space.
     ===========================================================
    */
}

}
