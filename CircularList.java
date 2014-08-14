//package custom;
//import custom.*;

public interface CircularList<E> extends java.lang.Iterable {
	
	public boolean add (E o);
	public void clear();
	public boolean contains (java.lang.Object o);
	public boolean equals (java.lang.Object o);
	public boolean isEmpty();
	public java.util.Iterator<E> iterator();
	public boolean remove (java.lang.Object o);
	public int size();
	public java.lang.Object[] toArray();
	public java.lang.String toString();

}