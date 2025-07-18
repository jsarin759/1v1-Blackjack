public class Card
{
    private String suit;
    private String rank;
    private int value;

    public Card(String s, int r)
    {
        suit = s;
        rank = "" + r;
        value = r;
    }

    public Card(String s, String r)
    {
        suit = s;
        rank = r;
        if (r.equals("Ace"))
            value = 11;
        else
            value = 10;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getRank()
    {
        return rank;
    }

    public int getValue()
    {
        return value;
    }

    public String toString()
    {
        return rank + " of " + suit;
    }

    public void setValueAce(int i)
    {
        value = i;
    }
}
