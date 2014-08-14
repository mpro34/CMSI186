
import java.util.*;

public class Trie implements java.lang.Iterable {
	
    public static Node root;
//Creates the root node
	public Trie() {
	    root = new Node();
	}
	
//Creates a Node Object, within each Node is an array of TrieNode Objects. Each TrieNode contains two items:
	//1. a character specified in the argument
	//2. a pointer to the next Node.
//Each Node acts as the dots on the Trie in the notes. Not all Nodes will be used.

	public static Trie newTrieFromAlphabets ( char[] a) {
      Trie t = new Trie();
	  root = new Node(a);
	  return t;
	}
   
   public boolean add (String s) {	
   		Trie ta = new Trie();
		boolean inSet = false;
		for (int i=0; i<s.length(); i++) {
			for (int wn=0; wn<root.getSize(); wn++) {
				if (s.charAt(i) == root.getNData(wn)) {
					inSet = true;
				}
			}	
			for (int j=0; j<root.getSize(); j++) {
				if (root.getNData(j) == s.charAt(i)) {
					root.setData(j,s.charAt(i));
					root.setNext(j, new Node());
				}
			}
		}
		if (inSet == false) { throw new IllegalArgumentException(); } 
		return inSet;
	}

//Smallest element is TrieNodes; Node = array of TrieNodes
	static class Node {
      private TrieNode[] middle;
      //A node filled with nulls
      public Node() {
         middle = new TrieNode[26];
      }
	  //A node filled with user specified characters
	  public Node(char[] ch) {
		  middle = new TrieNode[ch.length];
		  for (int i=0;i<ch.length;i++) {
			  //FIX a null pointer exception here
			  System.out.println("COMPARE: "+ ch[i]);
			  System.out.println("TO: "+(middle[i].bottom)==null);
			 middle[i].bottom = ch[i];
		  }
	  }
	  public char getNData(int loc) { return middle[loc].bottom; }
	  
	  public Node getNNext(int loc) { return middle[loc].nextNode; }
	  
	  public int getSize() { return middle.length; }
	  
	  public void setData(int loc, char c) { middle[loc].bottom = c; }
	  
	  public void setNext(int loc, Node n) { middle[loc].nextNode = n; }
	}
	  
	  
	  
//Smallest element is characters	  ; TrieNode = characters
	  class TrieNode {
	//The two elements of each TrieNode
		 private char bottom;
		 public Node nextNode;
      //A node filled with nulls
         public TrieNode(char c) {
         	this(c, null);
      	 }
	  //A node filled with user specified characters
	     public TrieNode(char c, Node n) {
		   bottom = c;
		   nextNode = n;
		  }
		  
		  public char getData() { return bottom; }
		  
		  public Node getNext() { return nextNode; }
	  }
		
	public java.util.Iterator iterator() {
      return new TrieIterator (this);
	}

//Implementing the Iterable interface	
    class TrieIterator implements java.util.Iterator {
		Trie tr = new Trie();
		
		public TrieIterator (Trie tr) {
			this.tr = tr;
		}
		//'\u0000' is equivalent to the null character in java
		public boolean hasNext() {
			throw new UnsupportedOperationException();
		}
		
		public Node next() {
			Node ans = new Node();
			for (int i=0; i<root.getSize(); i++) {
				if (root.getNData(i) != '\u0000') {
					ans = root.getNNext(i);
				}
			}
			return ans;
		}
		
		public void remove() { throw new UnsupportedOperationException(); }
	}
		
		
		
//Small Test Program 
	public static void main ( String[] args ) {
		char[] testData = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Trie t = new Trie();
		t.add(args[0]);
		
		
	}
	
	
}
