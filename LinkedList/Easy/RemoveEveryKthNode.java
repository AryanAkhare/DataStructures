package Easy;

public class RemoveEveryKthNode {
    Node deleteKthNode(Node head,int k){

        Node prev=null;
        Node curr=head;
        int count=0;

        while(curr!=null){
            count++;
            if(count%k==0){
                prev.next=curr.next;

                if(prev==null){
                    prev=head.next;
                }
            }else{
                prev=curr;
            }
            curr=curr.next;
        }
        return head;
    }
}
