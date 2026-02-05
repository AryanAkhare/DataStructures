public class DeleteAllOccurrenceDLL {

    /* 
     ===================== INTUITION =====================
     We traverse the doubly linked list node by node.
     
     Whenever we find a node with value == x:
     - We delete that node by reconnecting its previous and next nodes.
     
     Since it is a doubly linked list:
     - prev node can directly point to next
     - next node can directly point to prev
     
     Special cases handled:
     1) Deleting head node
        - Move head to head.next
        - Set new head.prev = null
     2) Deleting middle node
        - prev.next = next
        - next.prev = prev
     3) Deleting tail node
        - prev.next = null
     
     Continue traversal until list ends.
     =====================================================
    */

    /* Structure of Doubly Linked List */
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    static class Solution {

        /*
         ===================== APPROACH =====================
         1. Start traversal from head.
         2. If current node's data == x:
            - Store next and prev nodes.
            - Handle head deletion separately.
            - Otherwise connect prev and next.
         3. Move to next node after deletion.
         =====================================================
        */

        static Node deleteAllOccurOfX(Node head, int x) {

            Node temp = head;

            while (temp != null) {

                // If node to be deleted is found
                if (temp.data == x) {

                    Node nextNode = temp.next;
                    Node prevNode = temp.prev;

                    // Case 1: deleting head node
                    if (temp == head) {
                        head = nextNode;
                        if (head != null) {
                            head.prev = null;
                        }
                    }
                    // Case 2 & 3: deleting middle or tail node
                    else {
                        if (prevNode != null) {
                            prevNode.next = nextNode;
                        }
                        if (nextNode != null) {
                            nextNode.prev = prevNode;
                        }
                    }

                    // Move forward after deletion
                    temp = nextNode;
                } 
                // If current node does not match x
                else {
                    temp = temp.next;
                }
            }
            return head;
        }
    }

    /*
     ===================== TIME COMPLEXITY =====================
     O(N)
     - Each node is visited exactly once.
     
     ===================== SPACE COMPLEXITY =====================
     O(1)
     - No extra space used, deletion done in-place.
     ===========================================================
    */
}
