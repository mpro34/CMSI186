/** This class takes in the user inputs and uses the methods from SuperInteger.java to invoke the specified command.
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
	
//Creates an object that contains two superintegers.
	SuperInteger s1 = new SuperInteger(SUPERINTEGER1);
	SuperInteger s2 = new SuperInteger(SUPERINTEGER2);
			 
//Determines which operation to evoke on the superintegers inputed.
	    if (operation == '+') {
			System.out.println("SUM: " + (s1.add(s2)).getSuperInt());
		}
		else if (operation == '-') {
			System.out.println("DIFFERENCE: " + (s1.subtract(s2)).getSuperInt());
		} 
		else if (operation == 'x') {
			System.out.println("PRODUCT: " + (s1.multiply(s2)).getSuperInt());
		}
		else if (operation == '/') {
			System.out.println("QUOTIENT: " + (s1.divide(s2)).getSuperInt());
		}
		else if (operation == '%') {
			System.out.println("REMAINDER: " + (s1.remainder(s2)).getSuperInt());
		}

	}
}
