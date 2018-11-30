
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Luca Castelli Aleardi (INF421, 2013, Ecole Polytechnique) An implementation of an ordered set based on binary search trees
 */
public class BSTSet<E extends Comparable<E>> implements OrderedSet<E> {

    TreeNode<E> root;

    /**
     * Create an empty binary search tree
     */
    public BSTSet() {
        this.root = null;
    }

    /**
     * Create an empty binary search tree
     */
    public BSTSet(TreeNode<E> root) {
        this.root = root;
    }

    /**
     * Check whether a given element already exists
     */
    public boolean contains(E element) {
        if (isEmpty()) {
            return false;
        } else {
            return this.root.contains(element);
        }
    }

    /**
     * Return the smallest element in the set. Return null if the set is empty
     */
    public E getMin() {
        if (isEmpty()) {
            return null;
        } else {
            return this.root.getMin();
        }
    }

    /**
     * Check whether the set is empty
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Check whether the set is a subset of s
     */
    public boolean subset(OrderedSet<E> s) {
        BSTSet<E> t = (BSTSet<E>) s;
        return TreeNode.subset(this.root, t.root);
    }

    /**
     * Add a new element in the ordered set: order on elements is preserved Elements are added only once
     */
    public void add(E element) {
        if (isEmpty()) {
            this.root = new TreeNode<>(element);
        } else {
            this.root.add(element);
        }
    }

    /**
     * Return a new set obtained as the union of two given sets
     */
    public OrderedSet<E> union(OrderedSet<E> s) {
        BSTSet<E> t = (BSTSet<E>) s;
        return new BSTSet<E>(this.root.union(t.root));
    }

    /**
     * Return a String representing the (ordered) set
     */
    public String toString() {
        if (this.root == null) {
            return "[]";
        }
        return "[" + this.root.infixOrder() + "]";
    }

}
