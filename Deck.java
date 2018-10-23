import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard; 
	public int nUsed;
	
	
	public Deck(int nDeck){
		cards=new ArrayList<Card>(); 
		usedCard=new ArrayList<Card>();
		for(int i=0;i<nDeck;i++)
		{
			for(Card.Suit s : Card.Suit.values()) //ªá¦â
			{
				for(int num=1;num<=13;num++) //A~K
				{
					Card card=new Card(s,num);
					cards.add(card);
					
				}
			}
		}
		shuffle();
	}
	
	public void printDeck(){
		
		for(int deck=0;deck<cards.size();deck++)
		{
			Card c=cards.get(deck);
			c.printCard();
			
		}

	}
	public void shuffle()
	{
		nUsed=0;
		cards.addAll(usedCard);
		usedCard.clear();
		for(int i=0;i<cards.size();i++)
		{
			Random rnd =new Random();
			int j = rnd.nextInt(i+1);
			Card first=cards.get(i);
			cards.set(i,cards.get(j));
			cards.set(j,first);
		}	
		
	}
	public Card getOneCard()
	{  
		if(cards.size() == 0) 
		{
		   shuffle();
		}
		
		Card c=cards.get(0);
		cards.remove(0);
		usedCard.add(c);
		nUsed++;
		return c;
		
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
