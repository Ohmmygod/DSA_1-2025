package pack;

public class MyLinkedList_670764 {
	int size;
	class Node {
		int	data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node head = null;

	public void add(int d) {
		Node n = new Node(d);
		if (head == null)
			head = n;
		else
		{
			n.next = head;
			head = n;
		}
		size++;
	}

	public int size() {
		return (size);
	}

	public void insert(int d) {
		Node n = new Node(d);
		if (head == null || d <= head.data)
		{
			n.next = head;
			head = n;
			size++;
			return ;
		}

		Node after = head;
		Node prev = null;
		while (after != null && after.data < d)
		{
			prev = after;
			after = after.next;
		}
		prev.next = n;
		n.next = after;
		size++;
	}

	public int find(int d) { // pisciner's style
		Node	run = head;
		int		idx;

		idx = 0;
		while (run != null)
		{
			if (run.data == d)
				return (idx);
			run = run.next;
			idx++;
		}
		return (-1);
	}

	public void delete(int d) {
		Node t = new Node(-1);
		t.next = head;
		Node cur = t;
		while (cur.next != null && cur.next.data != d) {
			cur = cur.next;
		}
		if (cur.next != null) {
			cur.next = cur.next.next;
			size--;
		}
		head = t.next;
	}

	public void getAt(int index) {
		Node	run = head;
		int		idx;

		idx = 0;
		while (run != null)
		{
			if (index == idx)
			{
				System.out.println(run.data);
				return ;
			}
			run = run.next;
			idx++;
		}
		System.out.println("IndexOutOfBound");
	}

	public void setAt(int index, int value) {
		Node	run = head;
		int		idx;

		idx = 0;
		while (run != null)
		{
			if (index == idx)
			{
				run.data = value;
				return ;
			}
			run = run.next;
			idx++;
		}
	}

	public String toString() {
		StringBuilder bd = new StringBuilder();
		bd.append("[");
		Node c = head;
		while (c != null)
		{
			bd.append(c.data + " ");
			c = c.next;
		}
		bd.append("]");
		return bd.toString();
	}

	// task 2
	public void add (int[] d) {
		for (int i = d.length - 1; i >= 0; i--)
			add(d[i]);
	}

	public void insert(int[] d) {
		for (int i = 0; i < d.length; i++)
			insert(d[i]);
	}
}