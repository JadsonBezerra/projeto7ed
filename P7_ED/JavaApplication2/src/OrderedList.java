import java.util.*;

/**
 * @author Luca Castelli Aleardi (INF421, 2013, Ecole Polytechnique)
 * An implementation of an ordered set based on linked lists
 */
public class OrderedList<E extends Comparable<E>> implements OrderedSet<E>{
	
	public ListNode<E> head;
	
	public OrderedList() {
		this.head=null;
	}
	
	public OrderedList(ListNode<E> l) {
		this.head=l;
	}

	public OrderedList(TreeNode<E> b) {
		if(b==null) { 
			this.head=null;
			return;
		}
		LinkedList<E> l=b.toList();
		this.head=ListNode.fromLinkedList(l);
	}

	public void add(E e) {
		this.head=ListNode.add(e, this.head);
	}

	public OrderedSet<E> union(OrderedSet<E> s) {
		OrderedList<E> l=(OrderedList<E>)s;
		return new OrderedList<E>(ListNode.union(this.head, l.head));
	}

	public boolean contains(E x) {
		ListNode<E> s=this.head;
		while (s != null) {
			if (s.value.compareTo(x)==0) return true;
			s = s.next;
		}
		return false;
	}
	
	public boolean equals(OrderedSet<E> t) {
		OrderedList<E> u=(OrderedList<E>)t;
		ListNode<E> s1=this.head;
		ListNode<E> s2=u.head;
		while (s1 != null && s2!=null) {
			if (s1.value.compareTo(s2.value)!=0) return false;
			s1=s1.next;
			s2=s2.next;
		}
		if(s1==s2) // both must be null (is the two sets coincide)
			return true;
		return false;
	}
	
	public boolean subset(OrderedSet<E> t) {
		OrderedList<E> u=(OrderedList<E>)t;
		ListNode<E> s1=this.head;
		ListNode<E> s2=u.head;
		while (s1 != null && s2!=null) {
	        if (s1.value.compareTo(s2.value) < 0) return false;
	        if (s1.value.compareTo(s2.value) == 0) s1 = s1.next;
	        s2=s2.next;
		}
		if(s1==null) return true;
		return false;
	}
	
	public boolean isEmpty() {
		if(this.head==null)
			return true;
		return false;
	}
	
	public E getMin() {
		if(this.head==null)
			return null;
		return this.head.value;
	}
	
	public String toString() {
		String result="";
		ListNode<E> s=this.head;
		while (s != null) {
			result=result+" "+s.value;
			s = s.next;
		}
		return result;
	}

}
