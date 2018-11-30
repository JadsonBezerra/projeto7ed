import java.util.*;

/**
 * @author Luca Castelli Aleardi (INF421, 2013, Ecole Polytechnique)
 * A class representing the node of a linked list
 */
public class ListNode<E extends Comparable<E>> {
	
	ListNode<E> next;
	E value;

	public ListNode(E e, ListNode<E> next) {
		this.next=next;
		this.value=e;
	}

	public ListNode(E e) {
		this.next=null;
		this.value=e;
	}
		
	public static<E extends Comparable<E>> ListNode<E> add(E e, ListNode<E> m) {
		if(m==null)
			return new ListNode<E>(e);
		
		int c = e.compareTo(m.value);
		if(c<0)
			return new ListNode<E>(e, m);
		else if(c==0)
			return m;
		else {
			m.next=add(e, m.next);
			return m;
		}
	}
		
	public static<E extends Comparable<E>> ListNode<E> union(ListNode<E> m1, ListNode<E> m2) {
		if(m1==null)
			return m2;
		if(m2==null)
			return m1;
		
		int c = m1.value.compareTo(m2.value);
		if(c<0) {
			return new ListNode<E>(m1.value, union(m1.next, m2));
			//m1.next=union(m1.next, m2);
			//return m1;
		}
		else if(c>0){
			return new ListNode<E>(m2.value, union(m1, m2.next));
			//m2.next=union(m1, m2.next);
			//return m2;
		}
		else {
			return new ListNode<E>(m2.value, union(m1.next, m2.next));
		}
	}
	
	public static<E extends Comparable<E>> ListNode<E> fromLinkedList(LinkedList<E> l) {
		if(l.isEmpty()) return null;
		E e=l.poll();
		ListNode<E> result=new ListNode<E>(e, fromLinkedList(l));
		return result;
	}
		
}
