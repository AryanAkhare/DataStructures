package Easy;

public class getKthfromend {
    int getKthFromLast(Node head, int k) {
        // Your code here
        
        int count=0;
        Node curr=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        if(count==0 || k>count) return -1;
        Node temp=head;
        for(int i=0 ;i<count-k;i++){
            temp=temp.next;
        }
        return temp.data;
    }
}
