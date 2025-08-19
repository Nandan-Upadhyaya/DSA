
 /* Definition for singly-linked list. */
   class ListNode {
      int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    
    // Not so good solution 
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
    ListNode temp1 = list1;
    ListNode temp2 = list2;
    ListNode dummyNode = new ListNode(-1);
    ListNode cur = dummyNode;
    if(list1 == null && list2 != null) return list2;
    if(list2 == null && list1 != null) return list1;
    while(temp1 != null && temp2 != null){
        if(temp1.val <= temp2.val){
            ListNode newNode = new ListNode(temp1.val);
            cur.next = newNode;
            cur = newNode;
            temp1 = temp1.next;
        }
        else{
             ListNode newNode = new ListNode(temp2.val);
            cur.next = newNode;
            cur = newNode;
            temp2 = temp2.next;
        }
        if(temp1 == null && temp2 != null) {
             while(temp2 != null){
                ListNode newNode = new ListNode(temp2.val);
                cur.next = newNode;
                cur = newNode;
                temp2 = temp2.next;
             }
        }

        if(temp2 == null && temp1 != null) {
             while(temp1 != null){
                ListNode newNode = new ListNode(temp1.val);
                cur.next = newNode;
                cur = newNode;
                temp1 = temp1.next;
             }
        }
    }

    return dummyNode.next;        
    }


    // Optimal way to merge two sorted linked lists
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

    ListNode dummyNode = new ListNode(-1);
    ListNode cur = dummyNode;
    while(list1!= null && list2 != null){

        if(list1.val <= list2.val){
            cur.next = list1;
            list1 = list1.next;
        }

        else{
            cur.next = list2;
            list2 = list2.next;
           
        }
         cur = cur.next;
    }

cur.next = (list1 == null) ? list2 : list1;
        

    return dummyNode.next;     
    }
}