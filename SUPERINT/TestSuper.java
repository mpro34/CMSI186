 /** This class tests the two classes ClockSolver() and Clock(). Adding more assertions, may make this a better test program. 
	You must add other objects to add other tests, however.
*/
public class TestSuper {


	public static void main ( String[] args ) {
        addTest();
        subtractTest();
      //  toStringTest();
	toArrayTest();
   	}

	static void addTest() {
	  String SUPERINTEGER1 = "200";
	  String SUPERINTEGER2 = "100";
	  String SUPERINTEGER3 = "100";
	  String SUPERINTEGER4 = "200";
	  String SUPERINTEGER5 = "210";
	  String SUPERINTEGER6 = "200";
	  String SUPERINTEGER7 = "200";
	  String SUPERINTEGER8 = "210";
	  String SUPERINTEGER9 = "100";
	  String SUPERINTEGER10 = "100";
	  String SUPERINTEGER11 = "100";
	  String SUPERINTEGER12 = "010";
	  String SUPERINTEGER13 = "010";
	  String SUPERINTEGER14 = "100";
	  SuperIntegers s1 = new SuperIntegers(SUPERINTEGER1, SUPERINTEGER2);
	  SuperIntegers s2 = new SuperIntegers(SUPERINTEGER3, SUPERINTEGER4);
  	  SuperIntegers s3 = new SuperIntegers(SUPERINTEGER5, SUPERINTEGER6);
	  SuperIntegers s4 = new SuperIntegers(SUPERINTEGER7, SUPERINTEGER8);
	  SuperIntegers s5 = new SuperIntegers(SUPERINTEGER9, SUPERINTEGER10);
  	  SuperIntegers s6 = new SuperIntegers(SUPERINTEGER11, SUPERINTEGER12);
	  SuperIntegers s7 = new SuperIntegers(SUPERINTEGER13, SUPERINTEGER14);

	  assert "300".equals(s1.add());
	  assert "300".equals(s2.add());
	  assert "410".equals(s3.add());
	  assert "410".equals(s4.add());
	  assert "200".equals(s5.add());
	  assert "110".equals(s6.add());
	  assert "110".equals(s7.add());
	}


	static void subtractTest() {
	  String SUPERINTEGER1 = "200";
	  String SUPERINTEGER2 = "100";
	  String SUPERINTEGER3 = "100";
	  String SUPERINTEGER4 = "200";
	  String SUPERINTEGER5 = "210";
	  String SUPERINTEGER6 = "200";
	  String SUPERINTEGER7 = "200";
	  String SUPERINTEGER8 = "210";
	  String SUPERINTEGER9 = "100";
	  String SUPERINTEGER10 = "100";
	  String SUPERINTEGER11 = "100";
	  String SUPERINTEGER12 = "10";
	  String SUPERINTEGER13 = "10";
	  String SUPERINTEGER14 = "100";
	  SuperIntegers s1 = new SuperIntegers(SUPERINTEGER1, SUPERINTEGER2);
	  SuperIntegers s2 = new SuperIntegers(SUPERINTEGER3, SUPERINTEGER4);
  	  SuperIntegers s3 = new SuperIntegers(SUPERINTEGER5, SUPERINTEGER6);
	  SuperIntegers s4 = new SuperIntegers(SUPERINTEGER7, SUPERINTEGER8);
	  SuperIntegers s5 = new SuperIntegers(SUPERINTEGER9, SUPERINTEGER10);
  	  SuperIntegers s6 = new SuperIntegers(SUPERINTEGER11, SUPERINTEGER12);
	  SuperIntegers s7 = new SuperIntegers(SUPERINTEGER13, SUPERINTEGER14);
		
	  assert "100".equals(s1.subtract());
	  assert "-100".equals(s2.subtract());
	  assert "10".equals(s3.subtract());
	  assert "-010".equals(s4.subtract());
	  assert "00".equals(s5.subtract());
	  assert "90".equals(s6.subtract());
	  assert "-90".equals(s7.subtract());
	}

/**	static void toStringTest() {
	int [] ar1 = {2, 3, 5, 1, 5, 2, 9};
	int [] ar2 = {15, 23, 45, 66, 97};
	int [] ar3 = {123, 456, 789, 156, 642};
	System.out.print(toString(ar1));
	}*/
	static void toArrayTest() {
      System.out.println("NOT READY");
	}
}





