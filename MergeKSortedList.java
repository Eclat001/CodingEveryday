package facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

import structure.ListNode;

public class MergeKSortedList {
	//Time O(nlogk) Space O(k) --k is the number of linked lists, there are n nodes in the final linked list.
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        
        Comparator<ListNode> compare = new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        };
        		
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, compare);
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = node;
            head = head.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
