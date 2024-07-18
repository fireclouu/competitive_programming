import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedList extends Tests<List<ListNode>, ListNode> {

	@Override
	void testInit() {
		List<ListNode> list;
		
		list = new ArrayList<>();
		list.add(ListNode.createListNode(1, 2, 4));
		list.add(ListNode.createListNode(1, 3, 4));
		
		mapTest.put(list, ListNode.createListNode(1, 1, 2, 3, 4, 4));
	}

	@Override
	ListNode wrapFunction(List<ListNode> t) {
		return mergeTwoLists(t);
	}
	
	public MergeTwoSortedList(boolean verbose) {
		super(verbose);
	}
	
	public ListNode mergeTwoLists(List<ListNode> lists) {
		return new ListNode();
	}
}
