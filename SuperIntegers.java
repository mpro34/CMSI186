/** This class contains all of the methods used for creation and manipulation of super integers.

	TWO PROBLEMS: 
		1. I need to find a way to add a '-' to my first if statement within subtract() method.	
		*/

import java.util.Arrays;



public class SuperIntegers { 

	private String superint1;
	private String superint2;
     //	private boolean sign;
	
		
		
	public SuperIntegers (String s1, String s2) {
	 	 this.superint1 = s1; 
		 this.superint2 = s2; 
	}


	//	if (s.charAt(0) == -) {
	//		sign = false;
	//	else {
	//		sign = true;
	//	}
 

	//Converts an inputed SuperInteger String into an array	
	 public static int[] toArray (String st) {
		int[] siList = new int[st.length()];
		for (int i=0; i<st.length(); i++) {
			char myChar = st.charAt(i);
			String myString = String.valueOf(myChar);
			int myInt = Integer.valueOf(myString);
			siList[i] = myInt;
		//	System.out.println(siList[i]);
		 }
		return siList;
	} 
	
	//Converts an array into a string
	public static String toString (int[] ar) {
		String myString = "";
		for (int i=0; i<ar.length; i++) {
			String addString = Integer.toString(ar[i]);
			myString = myString.concat(addString);
		}
		return myString;
			
	}
		


	
	
	//Returns a string of a Super Integer.
//	public String toString() {
//		return this.Supers();
//	}
	
//	Performs Addition on two super integers.
	public String add() {
		String s = this.superint1;
		String t = this.superint2;
		int[] sum = new int[s.length()];
		int carry = 0;
		int[] siList1 = toArray(s);
		int[] siList2 = toArray(t);


		//System.out.println("HELLO: " + siList1[1]);
		//System.out.println("s.length: " + s.length());
		//System.out.println(t);
		for (int i = s.length()-1; i >= 0; i--) {


			if ((siList1[i]+siList2[i])>9 && (carry==0)) {
				sum[i]=(siList1[i]+siList2[i])-10;
				carry++;
			}
			else if ((siList1[i]+siList2[i]+1)>9 && (carry==1)) {
				sum[i]=(siList1[i]+siList2[i]+1)-10;
				carry=1;
			}
			else if ((siList1[i]+siList2[i]+1)<=9 && (carry==1)) {
				sum[i]=(siList1[i]+siList2[i]+1);
				carry=0;
			}
			else if ((siList1[i]+siList2[i])<=9 && (carry==0)) {
				sum[i]=(siList1[i]+siList2[i]);
				
			}
			else {
				throw new IllegalArgumentException();
			}
		}

		return toString(sum);
	}
	
//  Performs Subtraction on two super integers.	
	public String subtract() {
	   String s = this.superint1;
	   String t = this.superint2;
	   int[] sub = new int[s.length()];
	   int[] siList1 = toArray(s);
	   int[] siList2 = toArray(t);
	   int borrow = 0;
	   boolean change = false;
	   String subFinal = "";
	   //Test to see if the two super integers are identical.


	   for (int i = 0; i < s.length(); i++) {
			if ((siList1[i] < siList2[i]) && (siList2[i]!=0)) {
				change = true;

				break;
			}
			else if ((siList1[i] == siList2[i]) && (i == s.length())) {

				change = false;
				break;
			}
			else if (siList1[i]>siList2[i]) {
				change = false;
				break;
			}
			else {
				continue;
			}
	   }

	   if (change == true) {
		   for (int i = 0; i <=s.length()-1; i++) {
			System.out.println(siList1[i]);
			System.out.println(siList2[i]);
				int [] temp = siList1;
				siList1 = siList2;
				siList2 = temp;
				change = true;

		   }
	   }

   		if (change == true) {
	
			for (int i=s.length()-1; i>=0; i--) {
				if (siList1[i]<siList2[i] && borrow == 0) {
					sub[i]=(siList1[i]+10)-siList2[i];
					borrow++;
				}
				else if (siList1[i]<siList2[i] && borrow == 1) {
					sub[i]=(siList1[i]+9)-siList2[i];
					borrow = 0;
				}
				else if (siList1[i]>siList2[i] && borrow == 0) {
					sub[i]=siList1[i]-siList2[i];
				}
				else if (siList1[i]>siList2[i] && borrow == 1) {
					sub[i]=(siList1[i]-1)-siList2[i];
					borrow = 0;
				}

				subFinal = "-".concat(toString(sub)); 
	
		   	   }
		   }
			
		   else if (change == false) {

				for (int i=s.length()-1; i>=0; i--) {
					if (siList1[i]<siList2[i] && borrow == 0) {
						sub[i]=(siList1[i]+10)-siList2[i];
						borrow++;
					}
					else if (siList1[i]<siList2[i] && borrow == 1) {
						if (siList1[i]-1 < 0) {
							sub[i]=(siList1[i]+9)-siList2[i];
							borrow = 0;
						}
						else {
							sub[i]=(siList1[i]-1)-siList2[i];
							borrow = 0;
						}
					}
					else if (siList1[i]>siList2[i] && borrow == 0) {
						sub[i]=siList1[i]-siList2[i];
					}
					else if (siList1[i]>siList2[i] && borrow == 1) {
						sub[i]=(siList1[i]-1)-siList2[i];
						borrow = 0;
					}
					else if (siList1[i] == siList2[i] && borrow == 0) {
						sub[i]=siList1[i]-siList2[i];
					}

				subFinal = toString(sub); 
			
				}
			
			}
		   if ((subFinal.charAt(0) == '0')) {
			subFinal = subFinal.substring(1,subFinal.length());
		   }
		return subFinal;
	}
		
	
	

//  Performs Multiplication on two super integers.
/**	public int multiply() {
		String s = this.superint1;
		String t = this.superint2;
		int[] siList1 = toArray(s);
		int[] siList2 = toArray(t);
		int[] mult = new int[s.length()];
		int carry = 0;
		
		for (int i=s.length(); i>=0; i--) {
			while (
			for (int j=s.length(); j>=0; j--) {
				siList[i]*siList[s.length()-j];
				
	}*/
//  Performs Division on two super integers.
/**	public String divide() {
		
		 return "not ready";
	}
	public String remainder() {
		
		 return "not ready";
	} */
	
		





	//Convert int array of deciamls to int array of binary
		/**int[] temp = new int[SI.length()];
		for (int i=0; i<SI.length(); i++) {
			while (SuperInt[i]>1) {
				int j = 0;
				temp[j] = SuperInt[i]%2;
				SuperInt[i]=SuperInt[i]/2;
				System.out.println(temp[i]);
				System.out.println(SuperInt[i]);
				j++;
			}
		}*/
			
		
	
	
}
