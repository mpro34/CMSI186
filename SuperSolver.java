/** Once I write all of the operation classes and get the array code working, I will be able to perform operations with the same number of digits each.
	I should add some code that adds 0's to the front of a string, so that that integer will have the same number of digits when performing an 		operation.
*/

public class SuperSolver {
	
	public static void main(String[] args) {

	String SUPERINTEGER1 = args[0];
	String SUPERINTEGER2 = args[2];
	char operation = args[1].charAt(0); 
	
/**  Tests for incorrect inputs #1
	for (int i=0;i<SUPERINTERGER1.length();i++) {
	    int [] ar1 = toArray(SUPERINTEGER1);
            switch (ar1[i]) {
            	case 1:  ar1[i] = 0;  break;
            	case 2:  ar1[i] = 1;  break;
            	case 3:  ar1[i] = 2;  break;
            	case 4:  ar1[i] = 3;  break;
            	case 5:  ar1[i] = 4;  break;
            	case 6:  ar1[i] = 5;  break;
            	case 7:  ar1[i] = 6;  break;
            	case 8:  ar1[i] = 7;  break;
            	case 9:  ar1[i] = 8;  break;
            	case 10: ar1[i] = 9;  break;
            	default: throw new IllegalArgumentException(); break;
	    }
	}
//	#2		
	for (int i=0;i<SUPERINTERGER2.length();i++) {
	    int [] ar2 = toArray(SUPERINTEGER2);
            switch (ar2[i]) {
            	case 1:  ar2[i] = 0;  break;
            	case 2:  ar2[i] = 1;  break;
            	case 3:  ar2[i] = 2;  break;
            	case 4:  ar2[i] = 3;  break;
            	case 5:  ar2[i] = 4;  break;
            	case 6:  ar2[i] = 5;  break;
            	case 7:  ar2[i] = 6;  break;
            	case 8:  ar2[i] = 7;  break;
            	case 9:  ar2[i] = 8;  break;
            	case 10: ar2[i] = 9;  break;
       		default: throw new IllegalArgumentException(); break;
	    }
	}*/
	
	//Adds '0's to the beginning of a superinteger if and only if one is longer than the other.
        while (SUPERINTEGER1.length() != SUPERINTEGER2.length()) {
		if (SUPERINTEGER1.length()<SUPERINTEGER2.length()) {
			SUPERINTEGER1 = "0".concat(SUPERINTEGER1);
		}
		else if (SUPERINTEGER1.length()>SUPERINTEGER2.length()) {
			SUPERINTEGER2 = "0".concat(SUPERINTEGER2);
		}
	}


	//Creates an object that contains two superintegers.
	SuperInteger s1 = new SuperInteger(SUPERINTEGER1);
	SuperInteger s2 = new SuperInteger(SUPERINTEGER2);
	
	System.out.println("SI 1: "+ s1.toBinary());
	System.out.println("SI 2: "+ s2.toBinary());
			 
	//Determines which operation to evoke on the superintegers inputed.
/**		if (operation == '+') {
			System.out.println("Adding.......");
			System.out.println("\nSUM: " + s.add());
		}
		else if (operation == '-') {
			System.out.println("Subtracting......");
			System.out.println("\nSUBTRACT: " + s.subtract());
		} */
	//	else if (operation == '*') {
	//		System.out.println("MULTIPLIED " + s.multiply());
	//	}
	//	else if (operation == '/') {
	//		System.out.println("DIVIDEND: " + s.divide());
	//	}
	//	else if (operation == '%') {
	//		System.out.println("MODULO: " + s.modulo());
	//	}


			//System.out.println(s2);
	             //   System.out.println(s2.toString());
			//System.out.println(operation);
	}
}
