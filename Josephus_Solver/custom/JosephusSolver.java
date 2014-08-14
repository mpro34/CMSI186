//This class utilizes a standard for loop to iterate through the circle array to solve the Josephus problem.

//package custom;
//import custom.*;

public class JosephusSolver extends ArrayCircularList {
	private int n;
	private int k;
	private int bomb;

	public static void main (String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		if (n<2) { throw new UnsupportedOperationException(); }
		if (k<1) { throw new UnsupportedOperationException(); }
		//The Josephus algorithm is performed below.
		ArrayCircularList<Integer> cal = new ArrayCircularList<Integer> (n);
		for (int i = 1; cal.size()>1; i+=k) {
			if (i>cal.size()) {
				while (i>cal.size()) { i = (i-cal.size()); }
				cal.remove(i-1);
				if (i>cal.size() ) { i-=k; }
			}
			else { cal.remove(i-1); }
		}
		//Prints the surviving place in the circle
		//System.out.println(cal.toString());
	}
	
	
	

}