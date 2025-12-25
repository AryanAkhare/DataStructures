package Easy;

public class CountFrequency {
    /*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
// complete the below function
class Solution {
    public static int count(Node head, int key) {
        // code here
        int count=0;
        if(head==null) return 0;
        Node curr=head;
        while(curr!=null){
            if(curr.data==key){
                count++;
            }
            curr=curr.next;
        }
        return count;
    }
}
}
