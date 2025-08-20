class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode beforeLeft = dummyNode;
        for(int i = 1 ; i< left ; i++) beforeLeft = beforeLeft.next;
        ListNode sublistHead = beforeLeft.next;
        ListNode sublistTail = sublistHead;
        for(int i = left ; i < right ; i++) sublistTail = sublistTail.next;
        ListNode afterRight = sublistTail.next;
        sublistTail.next = null;
        ListNode reversed = reverse(sublistHead);
        beforeLeft.next = reversed;
        sublistHead.next = afterRight;
        return dummyNode.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}