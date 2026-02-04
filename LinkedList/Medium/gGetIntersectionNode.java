

package Medium;

import java.util.HashMap;

public class gGetIntersectionNode {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * =========================
     * Approach 1: Brute Force
     * =========================
     * Intuition:
     * Store all nodes of list1 in a HashMap.
     * Traverse list2 and check if any node already exists in the map.
     * The first such node is the intersection.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n)
     */
    public static ListNode getIntersectionNodeBrute(ListNode head1, ListNode head2) {
        HashMap<ListNode, Integer> map = new HashMap<>();

        ListNode temp = head1;
        while (temp != null) {
            map.put(temp, 1);
            temp = temp.next;
        }

        temp = head2;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    /*
     * =========================
     * Approach 2: Better (Length Difference)
     * =========================
     * Intuition:
     * Find lengths of both lists.
     * Move the pointer of the longer list by the length difference.
     * Traverse both lists together until nodes match.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public static ListNode getIntersectionNodeBetter(ListNode head1, ListNode head2) {
        
        int count1=0;
        int count2=0;
        ListNode temp1=head1;
        ListNode temp2=head2;

        while(temp1!=null){
            count1++;
            temp1=temp1.next;
        }
        while(temp2!=null){
            count2++;
            temp2=temp2.next;
        }
        

        int d;
        ListNode temp;
        if(count2>count1){
            d=count2-count1;
            temp=head2;
            while(d>0){
                temp=temp.next;
                d--;
            }
            temp1=head1;
            while(temp!=temp1){
                temp=temp.next;
                temp1=temp1.next;
            }
            return temp;
        }else{
            d=count1-count2;
            temp=head1;
            while(d>0){
                temp=temp.next;
                d--;
            }
            temp2=head2;
            while(temp!=temp2){
                temp=temp.next;
                temp2=temp2.next;
            }
            return temp;
        }
    }

    /*
     * =========================
     * Approach 3: Optimal (Two Pointer)
     * =========================
     * Intuition:
     * Traverse list1 then list2 using pointer1.
     * Traverse list2 then list1 using pointer2.
     * If there is an intersection, both pointers will meet there.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public static ListNode getIntersectionNodeOptimal(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;

        while (p1 != p2) {
            p1 = (p1 == null) ? head2 : p1.next;
            p2 = (p2 == null) ? head1 : p2.next;
        }

        return p1;
    }
}
