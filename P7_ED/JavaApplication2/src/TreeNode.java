import java.util.LinkedList;
import java.util.Queue;

/**
 * @author J-C. Filliatre and L. Castelli Aleardi (INF421, 2013, Ecole Polytechnique)
 * An implementation of an ordered set based on binary search trees
 */
public class TreeNode<E extends Comparable<E>> {
	  final E value;
	  TreeNode<E> left, right;

	  public TreeNode(TreeNode<E> left, E value, TreeNode<E> right) {
		  this.left=left;
                  this.right=right;
                  this.value=value;
	  }

	  public TreeNode(E value) {
		  this.left=null;
                  this.right=null;
                  this.value=value;
	  }

	  public boolean contains(E x) {
		  if(x.compareTo(this.value)==0)return true;
                  else if(x.compareTo(this.value)<0){
                      if(this.left==null) return false;
                      else return this.left.contains(x);
                  }
                  else{
                      if(this.right==null) return false;
                      else return this.right.contains(x);
                  }
	  }

	  public TreeNode<E> add(E x) {
            if(this.value.compareTo(x)==0) return null;
            else if(this.value==null) return new TreeNode<>(x);
            else if(x.compareTo(this.value)<0){
                if(this.left==null) return this.left=new TreeNode<>(x);
                else return this.left.add(x);
            }
            else{
                if(this.right==null) return this.right=new TreeNode<>(x);
                else return this.right.add(x);
            }
	  }

	  public E getMin() {
            if(this.value==null) return null;
            else if(this.left==null) return this.value;
            else return this.left.getMin();
	  }

	  static<E extends Comparable<E>> TreeNode<E> ofList(Queue<E> l, int n, int k) {
		throw new Error("A completer: exo 1");
	  }
	  
	  static<E extends Comparable<E>> TreeNode<E> ofList(Queue<E> l) {
	    int n = l.size();
	    return ofList(l, n, (int)(Math.log(n) / Math.log(2)));
	  }
	  
	   
	  /* subset */
	  static<E extends Comparable<E>> boolean subset(TreeNode<E> s1, TreeNode<E> s2) {
		throw new Error("A completer: exo 2");
	  }
	  
	  /* split(v,s) returns two trees, containing values
	   * from s smaller and greater than s
	   */
	  public Pair<TreeNode<E>> split(E x) {
		TreeNode<E> esq=null,dir=null;
                Queue<TreeNode<E>> fila = null;
                if(this.value!=null) fila.add(this);
                while(!fila.isEmpty()){
                    TreeNode<E> atual=fila.poll();
                    if(x.compareTo(atual.value)<0){
                        if(esq==null) esq=new TreeNode(atual.value);
                        else esq.add(atual.value);
                    }
                    if(x.compareTo(atual.value)>0){
                        if(dir==null) dir=new TreeNode(atual.value);
                        else dir.add(atual.value);
                    }
                    if(atual.left!=null) fila.add(atual.left);
                    if(atual.right!=null) fila.add(atual.right);
                }
                
                return new Pair(esq,dir);
                
	  }
	  
	  /* union */
	  public TreeNode<E> union(TreeNode<E> s2) {  
            Pair<TreeNode<E>> par=s2.split(this.value);
            TreeNode<E> esq=null,dir=null;
            if(this.left!=null && par.a!=null) esq =this.left.union(par.a);
            else if(this.left!=null) esq = this.left;
            else if(par.a!=null) esq = par.a;
            
            if(this.right!=null && par.b!=null) dir =this.right.union(par.b);
            else if(this.right!=null) dir = this.right;
            else if(par.b!=null) dir = par.b; 
            
            return new TreeNode<>(esq,this.value,dir);
	  }

	  public String infixOrder() {
		  String result="";
		  if(this.left!=null) result=result+this.left.infixOrder();
	      result=result+" "+this.value;
	      if(this.right!=null) result=result+this.right.infixOrder();
	      return result;
	  }
	
		 /**
	   * Return the list of elements listed according to infix order
	   */
	  public LinkedList<E> toList() {
		  LinkedList<E> result=null;
		  if(this.left!=null) result=(this.left.toList());
		  if(result==null) result=new LinkedList<E>();
	      result.add(this.value);
	      if(this.right!=null) result.addAll(this.right.toList());
	      return result;
	  }

	  public String toString() {
		    return "(" + this.left + "+" + this.value + "+" + this.right + ")";
	  }

}
