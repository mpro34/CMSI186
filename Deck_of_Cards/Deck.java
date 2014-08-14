
/**
   This class models a deck of fifty-two ordinary playing cards.
*/



public class Deck extends Object {

   static final int DECK_SIZE = 52; // It's better practice to use DECK_SIZE vs. 52
   
   private Card [] cardList; // A deck's instance data is just an array of cards   
  
   /**
      Constructs a new deck object. It's cards are initially arranged ace  
	  through king of each suit, with the suits in "bridge-order," i.e., 
	  spades first, then hearts, diamonds, and clubs, respectively. Note
	  that this constructor is private; clients who want a new deck should
	  use the "static factory" method, newDeck(), below.
   */
   
   private Deck () {

      this.cardList = new Card [DECK_SIZE];

      int i = 0;
      for ( int s = Card.SPADES; s <= Card.CLUBS; s = s + 1 ) {
         for ( int r = Card.ACE; r <= Card.KING; r = r + 1 ) {
            this.cardList[i] = new Card (r, s);
            i = i + 1;
         }
      }
   }


   /**
      This classwide method serves as a factory for decks. It constructs,
	  and returns, a new deck object.
   */
   
   public static Deck newDeckOf52() {
      return new Deck (); // Uses this class' private constructor
   }
   

   /**
      Returns the card at index i in this deck; the first (aka top) card is 
      presumed to be at index zero. Note that this method returns a reference to
      the actual card object (vs. a new, equivalent card).
   */
   
   public Card cardAt ( int i ) {
      return this.cardList[i];
   }

   /**
      Returns a stringy representation of this deck.
   */
   
   public String toString () {
      String s = this.cardList[0].toString() + ",";
      for ( int i = 1; i < DECK_SIZE - 1; i++ ) {
         s = s + this.cardList[i].toString() + ",";
      }
      s = s + this.cardList[DECK_SIZE-1].toString();
      return "<" + s + ">";
   }


   /**
      Performs a riffle shuffle of this deck.
   */
   
   public void riffleShuffle () {
      Card [] list=new Card [DECK_SIZE];
      for (int i = 1; i<=26; i+=2) {
          list[i-1] = cardList[i];
          list[i] = cardList[i+26];
       }
	   //Burning the top card.
	   list[51]=cardList[0];
       for (int i=0; i<52; i++) {
	   cardList[i]=list[i];
       }
   }


   /**
      Performs a randomized shuffle of this deck.
   */
   
   public void randomShuffle () {
      int c1;
      int c2;
      Card c3;
      for (int i = 0; i <= 51; i++) {
          c1 = (int)Math.floor(((52.0-i) * Math.random()));
          c2 = (int)Math.floor(((52.0-i) * Math.random()));
          c3 = cardList[c1];
          cardList[c1] = cardList[c2];
          cardList[c2] = c3;
      }
	
   }


   /**
      Returns the index of (the first example of) card c in this deck (-1 if not found).
   */
   
   public int whereIs ( Card c ) {
      Deck d = Deck.newDeckOf52();
	  int i;
      for (i = 0; i < 52; i++) {
          if (this.cardAt(i).equals(c)) {
             break;
          }

      }
	    return i;
   }


   /**
      Returns true if this deck and the argument are equivalent,
	  i.e., they are identically constructed.
   */
   
   public boolean equals ( Object obj ) {
      return ( obj != null ) && ( obj instanceof Deck ) && ( DECK_SIZE==52 ); 
   }

}
