package Hard;


public class RotateRightLL {

    
    class Node {
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }
    

    class Solution {

        /*
         Intuition:
         - Rotating right by k means last k nodes move to the front.
         - Convert the list into a circular linked list.
         - Find the new last node at position (n - k).
         - Break the circle and return the new head.
        */
        public Node rotate(Node head, int k) {

            if (head == null || head.next == null || k == 0) return head;

            // Step 1: find length and last node
            Node temp = head;
            int count = 1;
            while (temp.next != null) {
                temp = temp.next;
                count++;
            }

            // Step 2: normalize k
            k = k % count;
            if (k == 0) return head;

            // Step 3: make circular
            temp.next = head;

            // Step 4: find new last node
            Node newLast = head;
            for (int i = 1; i < count - k; i++) {
                newLast = newLast.next;
            }
            //  For LEFT rotation, loop condition becomes:
            // for (int i = 1; i < k; i++)

            // Step 5: break circle
            Node newHead = newLast.next;
            newLast.next = null;

            return newHead;
        }
    }
}
