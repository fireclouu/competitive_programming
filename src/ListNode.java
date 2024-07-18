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
			if (i + 1 != val.length) pointer.next = new ListNode();
		}
		return node;
	}
}
