import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MergeTwoSortedList extends Tests<List<ListNode>, ListNode> {

	@Override
	void testInit() {
		List<ListNode> list;
		
		list = new ArrayList<>();
		list.add(ListNode.createListNode(1, 2, 4));
		list.add(ListNode.createListNode(1, 3, 4));
		mapTest.put(list, ListNode.createListNode(1, 1, 2, 3, 4, 4));
		
		list = new ArrayList<>();
		list.add(ListNode.createListNode(1, 2));
		list.add(ListNode.createListNode(1, 3, 4));
		mapTest.put(list, ListNode.createListNode(1, 1, 2, 3, 4));
		
		list = new ArrayList<>();
		list.add(ListNode.createListNode(5));
		list.add(ListNode.createListNode(1, 2, 4));
		mapTest.put(list, ListNode.createListNode(1, 2, 4, 5));
		
		list = new ArrayList<>();
		list.add(new ListNode(5));
		list.add(null);
		mapTest.put(list, ListNode.createListNode(5));
		
		list = new ArrayList<>();
		list.add(null);
		list.add(new ListNode(5));
		mapTest.put(list, ListNode.createListNode(5));
		
		list = new ArrayList<>();
		list.add(null);
		list.add(null);
		mapTest.put(list, null);
		
	}

	@Override
	ListNode solution(List<ListNode> lists) {
		ListNode list1 = lists.get(0);
		ListNode list2 = lists.get(1);

		if (list1 == null && list2 == null) return list1;

		// Solution 1

		List<Integer> nodeItems = new ArrayList<>();
		ListNode nodeMerge = new ListNode(), pointer = nodeMerge;

		while (list1 != null || list2 != null) {
			if (list1 != null) nodeItems.add(list1.val);
			if (list2 != null) nodeItems.add(list2.val);

			list1 = list1 != null ? list1.next : null;
			list2 = list2 != null ? list2.next : null;
		}

		Collections.sort(nodeItems);

		for (int i = 0; i < nodeItems.size(); i++) {
			pointer.val = nodeItems.get(i);
			if (i != nodeItems.size() - 1) {
				pointer.next = new ListNode();
				pointer = pointer.next;
			}
		}
		return nodeMerge;
	}
	
	public MergeTwoSortedList(boolean verbose) {
		super(verbose);
	}
}
