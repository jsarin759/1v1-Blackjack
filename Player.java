import java.util.ArrayList;

public class Player
{
  private ArrayList<Card> hand;
  private int handValue;
  private ArrayList<Integer> acesIndices;

  public Player()
  {
    hand = new ArrayList<Card>();
    handValue = 0;
    acesIndices = new ArrayList<Integer>();
  }

  public ArrayList<Card> getHand()
  {
    return hand;
  }

  public int getValue()
  {
    return handValue;
  }

  public ArrayList<Integer> getAcesIndices()
  {
    return acesIndices;
  }

  public void addCard(Card c, int i)
  {
    hand.add(c);
    handValue += c.getValue();
    if(c.getRank().equals("Ace"))
      acesIndices.add(i);
  }

  public void switchAce()
  {
    if(getAcesIndices().size() > 0)
    {
      int index = acesIndices.remove(0);
      this.getHand().get(index).setValueAce(1);
      handValue -= 10;
    }
  }
  
  public boolean hasBust()
  {
    return handValue > 21;
  }

  public boolean hasBlackjack()
  {
    return (hand.size() == 2 && handValue == 21);
  }

  public void reset()
  {
    hand.clear();
    handValue = 0;
    acesIndices.clear();
  }

  public void displayHandandValue()
  {
    if(hand.size() > 2)
      System.out.println("\nThe dealer received a " + hand.get(hand.size() - 1));
    System.out.println("\nDealer's hand: " + hand);
    System.out.println("Dealer's hand's value: " + handValue);
  }

  public Card removeCard(int i)
  {
    Card c = hand.remove(i);
    handValue -= c.getValue();
    return c;
  }
}