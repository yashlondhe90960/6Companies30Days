/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        
        ListNode fakenode=new ListNode(-1);
        fakenode.next=head;
        Map<Integer,ListNode>map=new HashMap<>();
        ListNode curr=fakenode;
        int prefixSum=0;
        while(curr!=null){

            prefixSum+=curr.val;
            if(map.containsKey(prefixSum)){
                map.get(prefixSum).next=curr.next;
                map.clear();
                // If the situation is like the third testcase then it will be
                //helpful
                // now i have to do prefixsum=0 because i will iterate from
                //the first that is why i assign the fakenode(dummy)to the 
                //curr node
                prefixSum=0;
                curr=fakenode;
            }else{
                map.put(prefixSum,curr);
                curr=curr.next;
                
            }
        }
        return fakenode.next;
    }
}