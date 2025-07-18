public class User extends Player
{
  private String name;
  private double balance;
  private double bet;

  public User(String n)
  {
    this(n, 0, 0);
  }
  
  public User(String n, double ba, double be)
  {
    super();
    name = n;
    balance = ba;
    bet = be;
  }

  public String getName()
  {
    return name;
  }

  public double getBalance()
  {
    return balance;
  }

  public void setBalance(double n)
  {
    balance = n;
  }

  public void updateBalance(double n)
  {
    balance += n;
  }

  public double getBet()
  {
    return bet;
  }

  public void setBet(double n)
  {
    if (n <= balance)
    {
      bet = n;
    }    
  }

  public void displayHandandValue()
  {
    if (getHand().size() > 2)
      System.out.println("\nYou received a " + getHand().get(getHand().size() - 1));
    System.out.println("\nYour hand: " + getHand());
    System.out.println("Your hand's value: " + getValue());
  }
}