
import java.util.HashMap;
import java.util.Map;

class Solution{

 public ListNode deleteDuplicatesBruteForce(ListNode head) {
      Map<Integer, Integer> map = new HashMap<>();
      ListNode temp = head;
      ListNode dummyNode = new ListNode(-1);
      ListNode first = dummyNode;
      while(temp != null){
        map.put(temp.val, map.getOrDefault(temp.val, 0) +1);
        temp = temp.next;
      }
      temp = head;
      while(temp != null){
        if(map.get(temp.val) == 1){
            ListNode newNode = new ListNode(temp.val);
            first.next = newNode;
            first = newNode;
        }
        temp = temp.next;
      }

        return dummyNode.next;
    }

public ListNode deleteDuplicatesOptimal(ListNode head) {
      ListNode dummyNode = new ListNode(0, head);
      ListNode prev = dummyNode;
      while(head != null){
        if(head.next != null && head.val == head.next.val){
            while(head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            prev.next = head.next;
        }
        else{
            prev = prev.next;
        }
        head = head.next;
      }
      return dummyNode.next;
    }

}