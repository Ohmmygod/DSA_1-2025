package pack;

public class MyTrickyLinkedList  extends MyLinkedList_670764 {
	public MyTrickyLinkedList() {
		super();
	}

	public void q1_rotate_counter_clockwise(int k) {
		if (head == null || k <= 0) return;

		int n = size();
		k = k % n;
		if (k == 0) return;
	
		Node cur = head;
		for (int i = 1; i < k; i++) {
			cur = cur.next;
		}
		Node newHead = cur.next;
		if (newHead == null) return;
	
		Node tail = newHead;
		while (tail.next != null) {
			tail = tail.next;
		}
		tail.next = head;
		cur.next = null;
		head = newHead;
	}

	public void q2_reverse() {
		// int	idx = size - 1;


	}

	public void q3_remove_dup() {

	}

	public void q4_increment_digits() {

	}

	public boolean q5_isPalindrome() {
		return false;
	}
}
