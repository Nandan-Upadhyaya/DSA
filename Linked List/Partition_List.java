

class Solution {
    public ListNode partitionBruteForce(ListNode head, int x) {
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        ListNode temp = head;

        while(temp != null) {
            if(temp.val < x) {
                ListNode newNode = new ListNode(temp.val);
                prev.next = newNode;
                prev = newNode;
            }
            temp = temp.next;
        }

        temp = head;

         while(temp != null) {
            if(temp.val >= x) {
                ListNode newNode = new ListNode(temp.val);
                prev.next = newNode;
                prev = newNode;
            }
            temp = temp.next;
        }

        return dummyNode.next;
    }

    public ListNode partitionOptimized(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1);
        ListNode bigDummy = new ListNode(-1);
        ListNode small = smallDummy;
        ListNode big = bigDummy;

        while(head != null) {
            if(head.val < x){
                small.next = head;
                small = head;
            }
            else {
                big.next = head;
                big = head;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigDummy.next;
        return smallDummy.next;
    }
}