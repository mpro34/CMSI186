//To RUN this code, must type "javac *.java" so that the interface is recognized.

//package custom;
import java.util.*;
//import custom.*;

public class ArrayCircularList<E> extends java.util.ArrayList implements CircularList<E> {
	public int head = 0;
    private java.util.ArrayList data;
    public int tail;
	
 //Default constructor of an circlelist with a capacity of 10.
	public ArrayCircularList() {
		this.data = new java.util.ArrayList();
 //     for (int i = pointer; i<size; pointer++) {
   //      if (pointer == (size-1))
      //General IDEA:
      /** Add some code using iterator so that once eData.hasNext() either resets the pointer 
       to the beginning of the loop or keeps iterating through eData.
       */
     // Iterator<Object> datalist = eData.iterator();
	}
	
	public ArrayCircularList(int s) {
		this.data = new java.util.ArrayList(s);
		tail = s;
		int num=0;
		for (int i = 0; i<s; i++ ) {
			num++;
			this.data.add(num);
			
		}
	}
	
	public int size() { return data.size(); }
	
	
	public boolean add (java.lang.Object o) {
		tail++;
		return data.add(o);
	}		
		
	
	public boolean remove(java.lang.Object o) {
		if (data.size() == 0) { throw new UnsupportedOperationException(); }
		else { 
			tail--;
			return data.remove(o);
		}
	}
	
	//Different from the above remove method, in that this method remove the element at a specified index.
	public Object remove(int i) {
		tail--;
		return data.remove(i);
	}
	
//Returns true or false depending on whether the array list is empty.	
	public boolean isEmpty() {
		return data.size() == 0;
	}
//Returns a true or false depending on if the array list contains the specified element.	
	public boolean contains (Object o) {
		return data.contains(o);
	}
	
	public java.util.Iterator<E> iterator() {
      return new MyIterator (this);
	}
	
	public void clear() {
		data.clear();
	}
	
	public java.lang.Object[] toArray() {
		return data.toArray();
	}
	
	public java.lang.String toString() {
		return data.toString();
	}

//Implementing the Iterable interface	
    class MyIterator implements java.util.Iterator {
		ArrayCircularList cal;
		int location;
		
		public MyIterator (ArrayCircularList<E> cal) {
			this.cal = cal;
			this.location = -1;
		}
		
		public boolean hasNext() {
			this.circle();
			return this.location < (data.size()-1);
		}
		
//The location gets reset to the beginning once the end of the ArrayCircularList is reached.		
		public void circle() {
			if (this.location > (data.size())) { location = -1; }
		}
		
		public java.lang.Object next() {
			if (location >= (data.size()-1)) {throw new java.util.NoSuchElementException(); }
			this.location++;
			return cal.get(this.location);
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	
//Small Test Program 
	public static void main ( String[] args ) {
		
		ArrayCircularList a = new ArrayCircularList(Integer.parseInt(args[0]));
		System.out.println("ARRAY :" + a.toString());
		System.out.println(a.size());
		a.remove(2);
		System.out.println(a.size());
		a.add(1);
		System.out.println(a.size());
		a.add(2);
		System.out.println(a.size());
		a.add(3);
		System.out.println(a.size());
		a.add(4);
		a.add(5);
		a.add(6);
		System.out.println("ARRAY :" + a.toString());
		System.out.println(a.contains(5));
		System.out.println(a.isEmpty());
	
		a.add(2);
		a.remove(2);
		System.out.println("ARRAY :" + a.toString());
		
		
	}
	
	
}
