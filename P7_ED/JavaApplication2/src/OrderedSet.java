/**
 * @author Luca Castelli Aleardi (INF421, 2013, Ecole Polytechnique)
 * Interace describing methods of an ordered set
 */
public interface OrderedSet<E extends Comparable<E>> {

	// queries
	public boolean isEmpty();
	public boolean contains(E e);
	public E getMin();
	public boolean subset(OrderedSet<E> s);
	
	// update operations
	public void add(E e);
	public OrderedSet<E> union(OrderedSet<E> s);
}
