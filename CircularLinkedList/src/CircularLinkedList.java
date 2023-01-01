
public class CircularLinkedList {
	Node head;

	public CircularLinkedList() {	
		this.head = null;
	}
	public void insert(int val) {
		Node tmp = new Node(val);
		if(head == null) {
			tmp.next = tmp;
			head = tmp;
		}else {
			/*
			 * tmp.next = head;
			 * 
			 * Node it = head.next; while(it.next != head) { it = it.next; } it.next = tmp;
			 * head = tmp;
			 */
			int swapNode = tmp.data;
			tmp.data = head.data;
			head.data = swapNode;

			tmp.next = head.next;
			head.next = tmp;	
		}
	}
	public void delete() {
		if(head != null) {
			if(head.next == head) {
				head.next = null;
				head = null;
			}else {
				Node itp = head;
				Node it = head.next;
				while(it.next == head) {
					itp= it;
					it= it.next;
				}
				itp.next = head;
				it.next = null;
				it = null;
			}
		}
	}
	public void deleteFirst() {
		/*
		 * Node it = head.next; Node tmp = head.next; while(it.next != head) { it =
		 * it.next; } it.next = tmp; head.next = null; head = tmp; tmp = null;
		 */
		Node tmp = head.next;
		int t = head.data;
		head.data = tmp.data;
		tmp.data =  t;
		head.next = tmp.next;
		tmp.next = null;
		tmp = null;
		/*without using head
		 * int t = it.next.data;
		 * it.next.data = it.data;
		 * it.data = t;
		 * 
		 * it.next = it.next.next;
		 * it.next.next = null;
		 * it.next = null;
		 * 
		 * 
		 */
	}
	public String toString() {
		String str = "";
		if(this.head == null) {
			str += "LL is empty";
		}else {
			Node it = head;
			do {
				str += "" + it.data;
				it = it.next;
			} while(it != head);
			str += "\n";
		}
		return str;
	}
}
