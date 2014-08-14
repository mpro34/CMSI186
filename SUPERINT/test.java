public class test {	    

	public static void main (String [] args) {
		int [] ar = {1, 2, 3, 4, 5};
		String myString = "";
		for (int i=0; i<ar.length; i++) {
			String addString = Integer.toString(ar[i]);
			myString = myString.concat(addString);
		}
		System.out.println(myString);
			
	}
}

		 
