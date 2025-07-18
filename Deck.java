import java.util.ArrayList;

public class Deck
{
    Card[] deck;
    int amtRemoved;

    final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Deck()
    {
        deck = new Card[52];
        for (int i = 0; i < 4; i++)
        {
            for (int j = 2; j <= 10; j++)
            {
                deck[i * 13 + (j - 2)] = new Card(suits[i], j);
            }
            deck[13 * i + 9] = new Card(suits[i], "Jack");
            deck[13 * i + 10] = new Card(suits[i], "Queen");
            deck[13 * i + 11] = new Card(suits[i], "King");
            deck[13 * i + 12] = new Card(suits[i], "Ace");
        }
    }

    public void shuffle()
    {
        for (int i = 0; i < 51; i++)
        {
            Card current = deck[i];
            int index = (int) (Math.random() * (51 - i)) + (i + 1);
            deck[i] = deck[index];
            deck[index] = current;
        }
    }

    public Card[] removeCard(int n)
    {
        amtRemoved += n;
        Card[] temp = new Card[n];
        for (int i = 0; i < 52; i++)
        {
            if (i < n)
                temp[i] = deck[i];
            if (i < (52 - n))
                deck[i] = deck[i + n];
            else
                deck[i] = null;
        }
        return temp;
    }
    
    public void returnHandtoDeck(ArrayList<Card> c)
    {
        int len = c.size();
        int start = 52 - amtRemoved;
        for (int i = start; i < start + len; i++)
        {
            deck[i] = c.get(i - start);
        }
        amtRemoved -= len;
    } 
}
