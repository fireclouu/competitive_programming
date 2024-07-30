import java.util.ArrayList;
import java.util.List;

public class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	
	// utils
	public static ListNode createListNode(int... val) {
		ListNode node = new ListNode();
		ListNode pointer = node;
		for (int i = 0; i < val.length; i++) {
			pointer.val = val[i];
			if (i + 1 != val.length) {
				pointer.next = new ListNode();
				pointer = pointer.next;
			}
		}
		return node;
	}
	
	public static List<Integer> getListNodeValues(ListNode node) {
		List<Integer> values = new ArrayList<>();
		ListNode pointer = node;
		do {
			values.add(pointer.val);
		} while ((pointer = pointer.next) != null);
		
		return values;
	}
}
