/** This class contains all of the methods used for creation and manipulation of super integers.
*/

import java.util.Arrays;

public class SuperInteger { 

	private String superint;
	private String addSuper = "";
	
	public SuperInteger (String s) {
	 	superint = s;  
	}

//converts a String value to a super integer.	
	public static SuperInteger toSuper(String s) { return new SuperInteger(s); }
	
//returns the String value of the specified super integer.		
	public String getSuperInt() { return superint; }
	
//returns the length of a specified super integer.
	public int getLength() { return superint.length(); }
	
//returns the character value at a specified location of a super integer.	
	public char getCharAt(int i) { return superint.charAt(i); }
	
//Adds strings to the end of a super integer.
	public SuperInteger getConcat(String s) { return toSuper(superint.concat(s)); }
	
//takes away or cuts off part of a super integer.	
	public SuperInteger getSubstring(int i) { return toSuper(superint.substring(i)); }
	
//A more accurate approach to the above method of substring.
	public SuperInteger getSub(int i, int j) { return toSuper(superint.substring(i,j)); }
	
//Determines if the first inputed SuperInteger is greater than or equal to the second.	
	public boolean isGreaterorEqual(SuperInteger b) {
		boolean greater = false;
		b = b.toBinary();
		SuperInteger a = new SuperInteger(superint);
		a = a.toBinary();
		if (a.getLength() > b.getLength()) { greater = true; }
		else if (a.getLength() == b.getLength())
			for (int i=0;i<a.getLength();i++) {
				if (Integer.valueOf(a.getCharAt(i)) > Integer.valueOf(b.getCharAt(i))) { greater = true; }
				else if (Integer.valueOf(a.getCharAt(i)) == Integer.valueOf(b.getCharAt(i))) { greater = true; }
				else {
					greater = false;
					break;
				}
			}
			return greater;
	}

//Multiplies a decimal number by two and returns the super integer result.
	public SuperInteger byTwo() {
		SuperInteger multi = new SuperInteger(superint);
		int[] siList = new int[multi.getLength()];
		siList = toArray(multi.getSuperInt());
		SuperInteger answer = new SuperInteger("");
		int carry = 0;
		
		for (int i=siList.length-1; i>=0; i--) {
			if ((siList[i]*2+1) > 9 && i<1 && carry==1) {
				answer = answer.getConcat(new StringBuffer(Integer.toString(siList[i]*2+1)).reverse().toString());
			}
			else if ((siList[i]*2) > 9 && i<1 && carry==0) {
				answer = answer.getConcat(new StringBuffer(Integer.toString(siList[i]*2)).reverse().toString());
			}
			else if ((siList[i]*2) > 9 && carry == 0) {
				answer = answer.getConcat((Integer.toString((siList[i]*2)-10)));
				carry=1;
			}
			else if ((siList[i]*2) > 9 && carry == 1) {
				answer = answer.getConcat((Integer.toString((siList[i]*2+1)-10)));
				carry=1;
			}
			else if ((siList[i]*2) <= 9 && carry == 0) {
				answer = answer.getConcat(Integer.toString(siList[i]*2));
				carry=0;
			}
			else if ((siList[i]*2) <=9 && carry == 1) {
				answer = answer.getConcat(Integer.toString(siList[i]*2+1));
				carry=0;
			}
		}
		String reverse = new StringBuffer(answer.getSuperInt()).reverse().toString();
		return toSuper(reverse);
	}
				
//This methods returns the given Super integer's binary value.
	public SuperInteger toBinary () {
		int carry = 0;
		int quit = 1;
		SuperInteger binary = new SuperInteger("");
		SuperInteger t = new SuperInteger(superint);

		int[] siList = new int[t.getLength()];
		int[] div = new int[siList.length];
	  while (quit>0) {
		quit = 0;
		for (int i=0; i<t.getLength(); i++) {
			char myChar = t.getCharAt(i);
			String myString = String.valueOf(myChar);
			int myInt = Integer.valueOf(myString);
			siList[i] = myInt;
		 }
		 carry = 0;
		 for (int i=0; i<siList.length; i++) {
			if (siList[i]==0 && carry==0) {
				div[i] = 0;
				carry = 0;
			}
			else if (siList[i]<2 && carry == 0) {
				div[i] = 0;
				carry = 1;
			}
			else if (siList[i]>=2 && carry == 0) {
				div[i] = (int)Math.ceil(siList[i]/2);
				carry = siList[i]%2;
			}
			else if (carry<2 & carry>0) {
				div[i] = (int)Math.ceil((carry*10 + siList[i])/2);		
				carry = (carry*10 + siList[i])%2;
			}
	   }
		for (int j=0; j<div.length; j++) { quit += div[j]; }

		binary = binary.getConcat(Integer.toString(carry));
		
		int count = 0;
		for (int i=0; i<div.length; i++) {
			addSuper = addSuper.concat(Integer.toString(div[i]));
			count++;
		}
		if (addSuper.length() > count) { addSuper = addSuper.substring(count); }
		t = toSuper(addSuper);
		}
		String reverse = new StringBuffer(binary.getSuperInt()).reverse().toString();
		return toSuper(reverse);
	}
	
	
	//Converts an inputed SuperInteger String into an array	
	 public static int[] toArray (String st) {
		int[] siList = new int[st.length()];
		for (int i=0; i<st.length(); i++) {
			char myChar = st.charAt(i);
			String myString = String.valueOf(myChar);
			int myInt = Integer.valueOf(myString);
			siList[i] = myInt;
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
		
	
//	Performs Addition on two super integers.//Working on this right now!!, need to adjust the if statements, or 
	public SuperInteger add(SuperInteger b) {
		int carry = 0;
		SuperInteger sum = new SuperInteger("");
		b = b.toBinary();
		SuperInteger s = new SuperInteger(superint);
		s = s.toBinary();
		//This while loop attempts to add a number of zeros to the binary values so that they are the same length.
		 while (s.getLength() != b.getLength()) {
			if (s.getLength()<b.getLength()) {
				s = new SuperInteger("0").getConcat(s.getSuperInt());
			}
			else if (s.getLength()>b.getLength()) {
				b = new SuperInteger("0").getConcat(b.getSuperInt());
			}
		  }
		
		for (int i = s.getLength(); i>0; i--) {
			int [] superint1 = toArray(s.getSuperInt());
			int [] superint2 = toArray(b.getSuperInt());
			int intersum = (superint1[i-1]+superint2[i-1]);

			if (i==1 && carry == 1 && intersum == 1) {
				sum = new SuperInteger("10").getConcat(sum.getSuperInt());
			}
			else if (i==1 && carry == 1 && intersum > 1) {
				sum = new SuperInteger("11").getConcat(sum.getSuperInt());
			}
			else if (i==1 && carry == 0 && intersum > 1) {
				sum = new SuperInteger("10").getConcat(sum.getSuperInt());
			}
			else if (intersum > 1 && carry == 0) {
				sum = new SuperInteger("0").getConcat(sum.getSuperInt());
				carry++;
			}
			else if (intersum > 1 && carry == 1) { 
				sum = new SuperInteger("1").getConcat(sum.getSuperInt()); 
				carry=1;
			}
			else if (intersum == 1 && carry == 1) {
				sum = new SuperInteger("0").getConcat(sum.getSuperInt()); 
				carry=1;
			}
			else if (intersum < 1 && carry == 1) {
				carry=0;
				sum = new SuperInteger("1").getConcat(sum.getSuperInt());
			}
			else {
				sum = new SuperInteger(Integer.toString(intersum)).getConcat(sum.getSuperInt());
			}
		}
		return sum.toDecimal();
	}
	

//Converts a binary value into its cooresponding decimal value.	
	public SuperInteger toDecimal () {
		SuperInteger dec = new SuperInteger(superint);
		int[] siList = new int[dec.getLength()];
		SuperInteger temp = new SuperInteger("0");
		int carry=0;
		String finalTemp = "";
		
		for (int i=0; i<dec.getLength(); i++) {
			char myChar = dec.getCharAt(i);
			String myString = String.valueOf(myChar);
			int myInt = Integer.valueOf(myString);
			siList[i] = myInt;
		 }
		 
		 for (int i=0; i<siList.length; i++) {
			 temp = temp.byTwo();
			 int[] TEMP = new int[temp.getLength()];
			 TEMP = toArray(temp.getSuperInt());
			 for (int j=TEMP.length-1; j>=0; j--) {
			 	 if (TEMP[j] > 8 && siList[i]==1) {
						TEMP[j] = 0;
						carry = 1;
		    	 }
				 if (carry==1) {
						TEMP[j] = TEMP[j]+1;
						if (TEMP[j] > 9) { carry=1; }
						else { carry=0; }
				 }
				 else { 
				 	TEMP[j] = TEMP[j] + siList[i]; 
					break;
				}
			 }
			 temp = toSuper(toString(TEMP));
		 } 
		 return temp;
	}
		
	
//Returns the twos complement of a super integer.	
	public SuperInteger twosComplement () {
		SuperInteger complement = new SuperInteger(superint);
		int carry=0;
		complement=complement.toBinary();
		while (complement.getLength()<8) {
				complement = new SuperInteger("0").getConcat(complement.getSuperInt());
		}
		
		int [] siList = toArray(complement.getSuperInt());
		for (int i=0; i<complement.getLength(); i++) {
			if (siList[i] == 1) {
				siList[i] = 0;
			}
			else if (siList[i] == 0) {
				siList[i] = 1;
			}
		}
		if (siList[siList.length-1]==1 && carry==0) {
			siList[siList.length-1]=0;
			carry=1;
		}
		else if (siList[siList.length-1]==0 && carry==0) {
			siList[siList.length-1]=1;
			carry=0;
		}
		for (int j=siList.length-2; j>0; j--) {
			if (siList[j]==1 && carry==1) {
				siList[j]=0;
				carry=1;
			}
			else if (siList[j]==0 && carry==1) {
				siList[j]=1;
				carry=0;
			}
			else { siList[j]=siList[j]; }
		}
		return toSuper(toString(siList));
	}
	
	
	
	
	
	
	
	
	
	
//  Performs Subtraction on two super integers.	
	public SuperInteger subtract(SuperInteger b) {
		int borrow = 0;
		SuperInteger sub = new SuperInteger("");
		SuperInteger s = new SuperInteger(superint);
		s = s.toBinary();
	//This while loop attempts to add a number of zeros to the binary values so that they are the same length.
		  b = b.twosComplement();
		  while (s.getLength() != b.getLength()) {
			if (s.getLength()<b.getLength()) {
				s = new SuperInteger("0").getConcat(s.getSuperInt());
			}
			else if (s.getLength()>b.getLength()) {
				b = new SuperInteger("0").getConcat(b.getSuperInt());
			}
		  }
		sub = (s.toDecimal()).add(b.toDecimal());
		sub = sub.toBinary();
		int[] subAr = new int[sub.getLength()];
		subAr = toArray(sub.getSuperInt());
		if (subAr.length > 8) { subAr[0] = 0; }
		sub = toSuper(toString(subAr));
		  return sub.toDecimal();
	}
	

//  Performs Multiplication on two super integers.
	public SuperInteger multiply(SuperInteger b) {
		SuperInteger product = new SuperInteger("0");
		SuperInteger right = new SuperInteger(b.getSuperInt());
		right = right.toBinary();
		SuperInteger left = new SuperInteger(superint);
		left = left.toBinary();
		SuperInteger [][] table = new SuperInteger[left.getLength()][2];
		table[0][0] = left;
		table[0][1] = right;
		for (int i=1; i<left.getLength(); i++) {
			table[i][0] = left.getSub(0,left.getLength()-i);
			table[i][1] = table[i-1][1].getConcat("0");
		}
		for (int j=0; j<left.getLength(); j++) {
			if ((table[j][0].getSuperInt()).endsWith("1")) {
				product = ((product.toDecimal()).add((table[j][1].toDecimal()))).toBinary();
			}
			
		}
		return product.toDecimal();
	}
	
//  Performs Division on two super integers.
	public SuperInteger divide(SuperInteger divisor) {
		divisor = divisor.toBinary();
		SuperInteger dividend = new SuperInteger(superint);
		dividend = dividend.toBinary();
//		System.out.println("divisor: "+ divisor.getSuperInt());
//		System.out.println("dividend: "+ dividend.getSuperInt());
		SuperInteger quotient = new SuperInteger("");
		SuperInteger innerDividend = new SuperInteger("");
		
	if ((dividend.getSub(0,divisor.getLength())).isGreaterorEqual(divisor)) {
			//	dividend = dividend.subtract(divisor);
//				System.out.println("H  E  R  E  1");
//				System.out.println("first: "+ Integer.valueOf((dividend.getSub(0,divisor.getLength())).getSuperInt()));
//				System.out.println("second: "+ Integer.valueOf((divisor.getSuperInt())));
				innerDividend = (dividend.getSub(0,divisor.getLength())).subtract(divisor);
	//			System.out.println("INNER: "+innerDividend.getSuperInt());
				quotient = quotient.getConcat("1");
		//		System.out.println("QUOTIENT: "+quotient.getSuperInt());
			}
		for (int i=0; i<dividend.getLength()-divisor.getLength()+1; i++) {
			if (innerDividend.isGreaterorEqual(divisor)) {
//				System.out.println("E A G L E  O P T I O N");
				innerDividend = ((innerDividend.toDecimal()).subtract(divisor.toDecimal())).toBinary();
	//			System.out.println("INNER: "+innerDividend.getSuperInt());
				quotient = quotient.getConcat("1");
				innerDividend = innerDividend.getConcat(Character.toString(dividend.getCharAt(i+divisor.getLength()-1)));
				
			}
			else {
		//		System.out.println("T O O  S M A L L");
		//		System.out.println("I: "+i);
		//		System.out.println("first: "+ Integer.valueOf(innerDividend.getSuperInt()));
		//		System.out.println("second: "+ Integer.valueOf((divisor).getSuperInt()));
				innerDividend = innerDividend.getConcat(Character.toString(dividend.getCharAt(i+divisor.getLength()-1)));
		//		System.out.println("INNER: "+innerDividend.getSuperInt());
			//	quotient = quotient.getConcat("0");
				
			}
	//I think the problem lies b/c I add 1's and 0's in random places.
			if ((Integer.valueOf(innerDividend.getSuperInt())) < (Integer.valueOf(divisor.getSuperInt()))) { 
				quotient = quotient.getConcat("0"); 
			}
	//		System.out.println("QUOTIENT: "+quotient.getSuperInt());
	//		System.out.println("INNER: "+innerDividend.getSuperInt());
		 }											
		 return quotient.toDecimal();
	}
	
// Performs the remainder on two super integers
	public SuperInteger remainder(SuperInteger divisor) {
		divisor = divisor.toBinary();
		SuperInteger dividend = new SuperInteger(superint);
		dividend = dividend.toBinary();
//		System.out.println("divisor: "+ divisor.getSuperInt());
//		System.out.println("dividend: "+ dividend.getSuperInt());
		SuperInteger quotient = new SuperInteger("");
		SuperInteger innerDividend = new SuperInteger("");
		
	if ((dividend.getSub(0,divisor.getLength())).isGreaterorEqual(divisor)) {
			//	dividend = dividend.subtract(divisor);
//				System.out.println("H  E  R  E  1");
//				System.out.println("first: "+ Integer.valueOf((dividend.getSub(0,divisor.getLength())).getSuperInt()));
//				System.out.println("second: "+ Integer.valueOf((divisor.getSuperInt())));
				innerDividend = (dividend.getSub(0,divisor.getLength())).subtract(divisor);
//				System.out.println("INNER: "+innerDividend.getSuperInt());
				quotient = quotient.getConcat("1");
	//			System.out.println("QUOTIENT: "+quotient.getSuperInt());
			}
		for (int i=0; i<dividend.getLength()-divisor.getLength()+1; i++) {
			if (innerDividend.isGreaterorEqual(divisor)) {
	//			System.out.println("E A G L E  O P T I O N");
				innerDividend = ((innerDividend.toDecimal()).subtract(divisor.toDecimal())).toBinary();
	//			System.out.println("INNER: "+innerDividend.getSuperInt());
				quotient = quotient.getConcat("1");
				innerDividend = innerDividend.getConcat(Character.toString(dividend.getCharAt(i+divisor.getLength()-1)));
				
			}
			else {
	//			System.out.println("T O O  S M A L L");
		//		System.out.println("I: "+i);
		//		System.out.println("first: "+ Integer.valueOf(innerDividend.getSuperInt()));
			//	System.out.println("second: "+ Integer.valueOf((divisor).getSuperInt()));
				innerDividend = innerDividend.getConcat(Character.toString(dividend.getCharAt(i+divisor.getLength()-1)));
		//		System.out.println("INNER: "+innerDividend.getSuperInt());
			//	quotient = quotient.getConcat("0");
				
			}
			if ((Integer.valueOf(innerDividend.getSuperInt())) < (Integer.valueOf(divisor.getSuperInt()))) { 
				quotient = quotient.getConcat("0"); 
			}
//			System.out.println("QUOTIENT: "+quotient.getSuperInt());
//			System.out.println("INNER: "+innerDividend.getSuperInt());
		 }											
		 return innerDividend.toDecimal();
	}
}
