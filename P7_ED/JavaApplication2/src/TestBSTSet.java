import java.util.*;

/**
 * @author Luca Castelli Aleardi (INF421, 2013, Ecole Polytechnique)
 * Provides methods for testing operations on ordered sets (implementation based on binary search trees)
 */
public class TestBSTSet {

	  public static void main(String[] args) {
		  //test1();
		  //test2();
		  test3();
		  //test4();
		  //test5();
	  }

	  /**
	   * Test basic operations on BST: creation, addition, min search, element search
	   */
	  public static void test1() {
		  BSTSet<Integer> b1=new BSTSet<Integer>(); // create an empty binary search tree
		  int n=10;
		  for(int i=n/2;i>0;i--)
			  b1.add(i);
		  for(int i=n/2;i<n;i++)
			  b1.add(i);
		  new Fenetre(b1.root);
		  
		  System.out.println("S1="+b1);
		  System.out.println(b1.contains(1));
		  System.out.println(b1.contains(2));
		  System.out.println(b1.contains(4));
		  System.out.println(b1.contains(0));
		  System.out.println(b1.contains(10));
		  System.out.println("min="+b1.getMin());
	  }
	  
	  /**
	   * Test basic operations on BST: creation, addition, min search, element search
	   */
	  public static void test2() {
		  System.out.println("Testing basic operations on binary search trees");
		  BSTSet<String> s2=new BSTSet<String>();			
		  s2.add("to"); s2.add("be"); s2.add("or"); s2.add("not");
		  s2.add("to"); s2.add("be"); s2.add("that"); s2.add("is");
		  s2.add("the"); s2.add("question");
		  System.out.println("Hamlet 3/1: "+s2+"\n");
		  new Fenetre(s2.root);
		  
		  int n=10;
		  Queue<Integer> l = new LinkedList<Integer>();
		  for(int i=0;i<n;i++)
		    	l.add(2*i+1);
		  System.out.println(l);
		  BSTSet<Integer> b2= new BSTSet<Integer>(TreeNode.ofList(l)); // a binary search tree from a list
		  System.out.println(b2);
		  new Fenetre(b2.root);
	  }
	  
	  /**
	   * Test union of two binary search trees
	   */
	  public static void test3() {
        System.out.println("Testing union");
        BSTSet<Integer> b1 = new BSTSet<Integer>(); // create an empty binary search tree
        int n = 5;
        for (int i = n / 2; i > 0; i--) {
            b1.add(2 * i);
        }
        for (int i = n / 2; i < n; i++) {
            b1.add(2 * i);
        }
        new Fenetre(b1.root);
        
        BSTSet<Integer> b2 = new BSTSet<>(); 
        b2.add(9);
        b2.add(3);
        b2.add(1);
        b2.add(5);
        b2.add(7);
        b2.add(15);
        b2.add(11);
        b2.add(13);
        b2.add(17);
        b2.add(19);
        new Fenetre(b2.root);

        OrderedSet<Integer> u1 = b1.union(b2);
        new Fenetre(((BSTSet<Integer>) u1).root);

        OrderedSet<Integer> u2 = b2.union(b1);
        new Fenetre(((BSTSet<Integer>) u2).root);

        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);
        System.out.println("u1:=b1 U b2 = " + u1);
        System.out.println("u2:=b2 U b1 = " + u2);
    }
	  
	  /**
	   * Test subset
	   */
	  public static void test4() {
		  System.out.println("Testing subset");
		  BSTSet<Integer> b1=new BSTSet<Integer>();
		  BSTSet<Integer> b2=new BSTSet<Integer>();
		  int n=10;
		  
		  Random generator = new Random(10); // initialize the pseudo random generator 
		  OrderedList<Integer> s = new OrderedList<Integer>();
		  Queue<Integer> l=new LinkedList<Integer>();
		  for(int i=0;i<n;i++)
		    	s.add((int)(generator.nextDouble()*(2*n)));
		  ListNode<Integer> node=s.head;
		  while(node!=null) {
			  l.add(node.value);
			  node=node.next;
		  }
		  b1= new BSTSet<Integer>(TreeNode.ofList(l)); // create first tree from a list
		  System.out.println("b1="+b1);
		  new Fenetre(b1.root);
		  
		  generator = new Random(10); // re-initialize the pseudo random generator 
		  for(int i=0;i<n+4;i++)
		    	b2.add((int)(generator.nextDouble()*(2*n))); // create second tree with random insertion order
		  System.out.println("b2="+b2);
		  new Fenetre(b2.root);
		  
		  System.out.println("b1==b2? "+b1.subset(b2));
		  System.out.println("b2==b1? "+b2.subset(b1));
	  }

	  /**
	   * Test equality
	   */
	  public static void test5() {
		  System.out.println("Testing equality");
		  BSTSet<Integer> b1=new BSTSet<Integer>();
		  BSTSet<Integer> b2=new BSTSet<Integer>();
		  int n=10;
		  
		  Random generator = new Random(10); // initialize the pseudo random generator 
		  OrderedList<Integer> s = new OrderedList<Integer>();
		  Queue<Integer> l=new LinkedList<Integer>();
		  for(int i=0;i<n;i++)
		    	s.add((int)(generator.nextDouble()*(2*n)));
		  ListNode<Integer> node=s.head;
		  while(node!=null) {
			  l.add(node.value);
			  node=node.next;
		  }
		  b1= new BSTSet<Integer>(TreeNode.ofList(l)); // create first tree from a list
		  
		  generator = new Random(10); // re-initialize the pseudo random generator 
		  for(int i=0;i<n;i++)
		    	b2.add((int)(generator.nextDouble()*(2*n))); // create second tree with random insertion order
		  
		  System.out.println("b2="+b2);
		  System.out.println("b1="+b1);
		  new Fenetre(b1.root);
		  new Fenetre(b2.root);
		  
		  System.out.println("b1==b2? "+b1.equals(b2));
		  System.out.println("b2==b1? "+b2.equals(b1));
		  
		  System.out.println("\nUpdating b2");
		  b2.add(15);
		  System.out.println("b2="+b2);
		  System.out.println("b1="+b1);
		  System.out.println("b1==b2? "+b1.equals(b2));
		  System.out.println("b2==b1? "+b2.equals(b1));
		  
		  // testing equals on sets of String
		  System.out.println();
		  BSTSet<String> s2=new BSTSet<String>();		
		  BSTSet<String> s1=new BSTSet<String>();		
		  s2.add("to"); s2.add("be"); s2.add("or"); s2.add("not");
		  s2.add("to"); s2.add("be"); s2.add("that"); s2.add("is");
		  s2.add("the"); s2.add("question");
		  s1.add("question"); s1.add("be"); s1.add("or"); s1.add("not");
		  s1.add("to"); s1.add("be"); s1.add("is"); s1.add("that");
		  s1.add("the"); s1.add("to");

		  System.out.println("s1= "+s1);
		  System.out.println("s2= "+s2);
		  System.out.println("s1=s2? "+s1.equals(s2));
		  new Fenetre(s1.root);
		  new Fenetre(s2.root);
	  }

}
