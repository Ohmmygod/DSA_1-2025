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
		Node prev = null;
		Node run = head;
		Node tmp = null;

		while (run != null)
		{
			tmp = run.next;
			run.next = prev;
			prev = run;
			run = tmp;
		}
		head = prev;
	}

	public void q3_remove_dup() {
		Node run = head;
		while (run != null && run.next != null)
		{
			if (run.data == run.next.data)
				run.next = run.next.next;
			else
				run = run.next;
		}
	}

	public void q4_increment_digits() {
		Node notNine = null;
		Node run = head;
		while (run != null) {
			if (run.data != 9)
				notNine = run;
			run = run.next;
		}
		if (notNine == null) 
		{
			Node newHead = new Node(1);
			newHead.next = head;
			head = newHead;
			notNine = head;
		} 
		else
			notNine.data++;
		run = notNine.next;
		while (run != null) {
			run.data = 0;
			run = run.next;
		}
	}

	public boolean q5_isPalindrome() {
		int n = size();
		if (n == 0) 
			return true;

		int[] arr = new int[n];
		Node run = head;
		int idx = 0;
		while (run != null)
		{
			arr[idx++] = run.data;
			run = run.next;
		}

		int i = 0, j = n - 1;
		while (i < j)
		{
			if (arr[i] != arr[j])
				return false;
			i++;
			j--;
		}
		return true;
	}
}
