package Easy;


class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
public class MiddleofLinkedList {
    Node middleofLinkedList(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next==null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
