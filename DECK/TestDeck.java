
/**
   Test program for the material in class Deck. Run this program as follows:
        java -ea TestDeck
    in order to enable assertions during testing.
*/

public class TestDeck {

    /**
        This main program invokes each of the unit test methods; each one, in turn,
        is responsible for thoroughly testing some method, and will typically contain 
        a set of test contexts, or "fixtures," within which the tests themselves take
        place.
    */

    public static void main ( String[] args ) {
        toStringTest();
        newDeckOf52Test();
        whereIsTest();
        cardAtTest();
        equalsTest();
        randomShuffleTest();
        riffleShuffleTest();
    }
   
    static void toStringTest () {
      Deck d = Deck.newDeckOf52();
      assert d.toString().equals("<ace of spades,deuce of spades,three of spades,four of spades,five of spades,six of spades,seven of spades,eight of spades,nine of spades,ten of spades,jack of spades,queen of spades,king of spades,ace of hearts,deuce of hearts,three of hearts,four of hearts,five of hearts,six of hearts,seven of hearts,eight of hearts,nine of hearts,ten of hearts,jack of hearts,queen of hearts,king of hearts,ace of diamonds,deuce of diamonds,three of diamonds,four of diamonds,five of diamonds,six of diamonds,seven of diamonds,eight of diamonds,nine of diamonds,ten of diamonds,jack of diamonds,queen of diamonds,king of diamonds,ace of clubs,deuce of clubs,three of clubs,four of clubs,five of clubs,six of clubs,seven of clubs,eight of clubs,nine of clubs,ten of clubs,jack of clubs,queen of clubs,king of clubs>");
   }

    static void newDeckOf52Test() {
      Deck d1 = Deck.newDeckOf52();
      assert (d1 instanceof Deck);
      assert (Deck.DECK_SIZE == 52);
      assert (d1!=null);  
	}


    static void whereIsTest () {
	  Deck d = Deck.newDeckOf52();
      	  assert d.whereIs( new Card ( Card.ACE, Card.SPADES )) == 0;
	  assert d.whereIs( new Card ( Card.SIX, Card.SPADES )) == 5;
	  assert d.whereIs( new Card ( Card.JACK, Card.SPADES )) == 10;
	  assert d.whereIs( new Card ( Card.THREE, Card.HEARTS )) == 15;
	  assert d.whereIs( new Card ( Card.EIGHT, Card.HEARTS )) == 20;
	  assert d.whereIs( new Card ( Card.KING, Card.HEARTS )) == 25;
	  assert d.whereIs( new Card ( Card.FIVE, Card.DIAMONDS )) == 30;
	  assert d.whereIs( new Card ( Card.TEN, Card.DIAMONDS )) == 35;
	  assert d.whereIs( new Card ( Card.DEUCE, Card.CLUBS )) == 40;
	  assert d.whereIs( new Card ( Card.SEVEN, Card.CLUBS )) == 45;
	  assert d.whereIs( new Card ( Card.QUEEN, Card.CLUBS )) == 50;
    }

    static void cardAtTest () {
      Deck d = Deck.newDeckOf52();
      assert 0 == d.cardAt(0).compareTo(new Card ( Card.ACE, Card.SPADES ) );
      assert 0 == d.cardAt(5).compareTo(new Card ( Card.SIX, Card.SPADES ) );
      assert 0 == d.cardAt(10).compareTo(new Card ( Card.JACK, Card.SPADES ) );
      assert 0 == d.cardAt(15).compareTo(new Card ( Card.THREE, Card.HEARTS ) );
      assert 0 == d.cardAt(20).compareTo(new Card ( Card.EIGHT, Card.HEARTS ) );
      assert 0 == d.cardAt(25).compareTo(new Card ( Card.KING, Card.HEARTS ) );
      assert 0 == d.cardAt(30).compareTo(new Card ( Card.FIVE, Card.DIAMONDS ) );
      assert 0 == d.cardAt(35).compareTo(new Card ( Card.TEN, Card.DIAMONDS ) );
      assert 0 == d.cardAt(40).compareTo(new Card ( Card.DEUCE, Card.CLUBS ) );
      assert 0 == d.cardAt(45).compareTo(new Card ( Card.SEVEN, Card.CLUBS ) );
      assert 0 == d.cardAt(50).compareTo(new Card ( Card.QUEEN, Card.CLUBS ) );
   }

    static void equalsTest () {
      assert Deck.newDeckOf52().equals(Deck.newDeckOf52());
   }
    //Need to add more variety of tests.
    static void randomShuffleTest () {
      Deck d = Deck.newDeckOf52();
      Deck d1 = Deck.newDeckOf52();
      d1.randomShuffle();
      assert d.cardAt(0) != d1.cardAt(0);  
      assert d.cardAt(5) != d1.cardAt(5);
      assert d.cardAt(10) != d1.cardAt(10);
      assert d.cardAt(15) != d1.cardAt(15);
      assert d.cardAt(20) != d1.cardAt(20);
      assert d.cardAt(25) != d1.cardAt(25);
      assert d.cardAt(30) != d1.cardAt(30);
      assert d.cardAt(35) != d1.cardAt(35);
      assert d.cardAt(40) != d1.cardAt(40);
      assert d.cardAt(45) != d1.cardAt(45);
      assert d.cardAt(50) != d1.cardAt(50);	  
   }

    static void riffleShuffleTest () {
      Deck d = Deck.newDeckOf52();
      Deck d1 = Deck.newDeckOf52();
      d.riffleShuffle();
      assert d.cardAt(1) == d1.cardAt(27);
      assert d.cardAt(10) == d1.cardAt(11);
      assert d.cardAt(15) == d1.cardAt(16);
      assert d.cardAt(20) == d1.cardAt(21);
      assert d.cardAt(25) == d1.cardAt(26);
      assert d.cardAt(30) == d1.cardAt(31);
      assert d.cardAt(35) == d1.cardAt(36);
      assert d.cardAt(40) == d1.cardAt(41);
      assert d.cardAt(45) == d1.cardAt(46);
      assert d.cardAt(50) == d1.cardAt(51);	 
      
    }
}
