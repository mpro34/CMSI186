
public class LinkedList {

    class ListElement {
        private int data;
        private ListElement next;

        public ListElement ( int i, ListElement ptr ) {
            data = i; next = ptr;		
        }

        public int getData () {
            return data;		
        }

        public ListElement getNext () {
            return next;		
        }
		
		public void setNext(ListElement p) {
			next = p;
		}

    }

    private int size;
	private ListElement first;
	private ListElement now;
	private ListElement temp;

    public LinkedList() {
        size = 0;
        first = null;
	}

    public void add ( int i ) {
		first = new ListElement ( i,  ( size == 0 ) ? null : first );
		temp = first;
		while (temp.getNext() != null) {
			temp=temp.getNext();
		}
		if (size!=0) {
			temp.setNext(new ListElement (i,null));
		}
		size++;
    }
	
    public String toString () {
        if ( size == 0 ) { return "<>"; }
        else {
            String s = String.valueOf ( temp.getData() );
            ListElement ptr = (first.getNext());
		    while ( ptr != null ) {
                s = s + "," + String.valueOf(ptr.getData());
				ptr = ptr.getNext();
		    }
		    return "<" + s + ">";
        }
    }


    /** A small application for testing the material in this class. */
	
    public static void main ( String[] args ) {
	
        LinkedList list = new LinkedList();
		list.add ( 6 );
		System.out.println("FIRST: " +list.toString());
		list.add ( -14 );
		System.out.println("SECOND: " +list.toString());
		list.add ( 0 );
		System.out.println("THIRD: " +list.toString());
		list.add ( 27 );
		System.out.println ("FOURTH: " + list.toString() );
		

    }
	
}


