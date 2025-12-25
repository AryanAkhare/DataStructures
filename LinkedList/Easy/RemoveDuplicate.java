package Easy;


class Node {
    int data;   // Value of node
    Node next;  // Pointer to next node

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}



public class RemoveDuplicate {
    public static Node removeDuplicate(Node head){
        Node curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.data==curr.next.data) curr.next=curr.next.next;
            else{
                curr=curr.next;
            }
        }
        return head;
    }
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
}
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(5);
        printList(head);

        

    }
}
