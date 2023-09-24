package tds.practica1.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tds.practica1.Card;
import tds.practica1.CardType;
import tds.practica1.Deck;
import tds.practica1.Character;

class CardTest {

	private Card card;
	private Character character;
	private Deck deck;
	private ArrayList<Card> cards;
	
	@BeforeEach
	void setUp() throws Exception {
		card=new Card("Chaman",10,23,CardType.UNIQUE);
		character= new Character("Pedro",20,30);
		cards=new ArrayList <Card>();
		cards.add(card);
		deck=new Deck("Mazo1",cards);
		
	}

	@Test
	void construccionCartaCorrecta() {
		assertNotNull(card);
	}
	
	@Test
	void getCardName() {
		assertEquals("Chaman",card.getName());
	}
	
	@Test
	void getCardCost() {
		assertEquals(10,card.getCost());
	}
	
	@Test
	void getCardNumber() {
		assertEquals(23,card.getNumber());
	}
	
	@Test
	void getCardType() {
		assertEquals(CardType.UNIQUE,card.getType());
	}
	
	@Test
    public void setNameCorrecto() {
		card.setName("Brujo");
		assertEquals("Brujo",card.getName());
	}
	
	
	@Test
    public void setNameNull() {
		assertThrows(IllegalArgumentException.class,()->{
			card.setName(null);
		});
	}
	
	
	@Test
    public void setNameVacio() {
		assertThrows(IllegalArgumentException.class,()->{
			card.setName("");
		});
	}
	
	
	@Test
    public void setNameIncorrectoCaracteres() {
		assertThrows(IllegalArgumentException.class,()->{
			card.setName("UnNombreDeMasDe10");
		});
	}
	
	
	@Test
    public void setCardCostCorrecto() {
		card.setCost(22);
		assertEquals(22,card.getCost());
	}
	
	
	@Test
    public void setCostIncorrectoMenor() {
		assertThrows(IllegalArgumentException.class,()->{
			card.setCost(-23);
		});
	}
	
	@Test
	void setCardNumber() {
		card.setNumber(33);
		assertEquals(33,card.getNumber());
	}
	
	
	@Test
    public void setNumberIncorrectoMenor() {
		assertThrows(IllegalArgumentException.class,()->{
			card.setNumber(-2);
		});
	}
	
	
	@Test
    public void setNumberIncorrectoMayor() {
		assertThrows(IllegalArgumentException.class,()->{
			card.setNumber(210);
		});
	}
	
	@Test
	void setCardtype() {
		card.setType(CardType.DEFENSE);
		assertEquals(CardType.DEFENSE,card.getType());
	}
	
	
	@Test
	void setDeckList() {
		ArrayList<Deck> lista = new ArrayList<Deck>();
		lista.add(deck);
		card.setDeckList(lista);
		assertEquals(lista,card.getDeckList());
		
	}
	
	
	@Test
	void addDeckCorrecto() {
		Card c1=new Card("Carlos",2,2,CardType.ATTACK);
		ArrayList <Card> CL=new ArrayList <Card>();
		CL.add(c1);
		Deck d1=new Deck("Mazo2",CL);
		
		card.addDeck(d1);
		assertTrue(card.getDeckList().contains(d1));
		
	}
	
	
	@Test
	void addDeckRepetido() {
		card.addDeck(deck);
		assertThrows(IllegalArgumentException.class,()->{
			card.addDeck(deck);
		});
		
	}
	
	
	@Test
	void addDeckUNIQUEDuplicado() {
		Card c1=new Card("Carlos",2,2,CardType.UNIQUE);
		ArrayList <Card> CL=new ArrayList <Card>();
		CL.add(c1);
		Deck d1=new Deck("Mazo2",CL);
		assertThrows(IllegalArgumentException.class,()->{
			card.addDeck(d1);
		});
		
	}
	
	@Test
	void addDeckLleno() {
		Card c1=new Card("Carlos",1,1,CardType.ATTACK);
		Card c2=new Card("Diego",2,2,CardType.ATTACK);
		Card c3=new Card("Juan",3,3,CardType.ATTACK);
		Card c4=new Card("David",4,4,CardType.ATTACK);
		Card c5=new Card("Isaias",5,5,CardType.ATTACK);
		ArrayList <Card> CL=new ArrayList <Card>();
		CL.add(c1);
		CL.add(c2);
		CL.add(c3);
		CL.add(c4);
		CL.add(c5);
		Deck d1=new Deck("Mazo2",CL);
		assertThrows(IllegalArgumentException.class,()->{
			card.addDeck(d1);
		});
		
	}
	
	
	@Test
	void removeDeck() {
		Card c1=new Card("Carlos",1,1,CardType.ATTACK);
		Card c2=new Card("Diego",2,2,CardType.ATTACK);
		ArrayList <Card> CL=new ArrayList <Card>();
		CL.add(c1);
		CL.add(c2);
		Deck d1=new Deck("Mazo2",CL);
		card.addDeck(d1);
		card.removeDeck(d1);
		assertTrue(!card.getDeckList().contains(d1));
		
	}
	
	
	@Test
	void removeDeckNoContenido() {
		Card c1=new Card("Carlos",1,1,CardType.ATTACK);
		Card c2=new Card("Diego",2,2,CardType.ATTACK);
		ArrayList <Card> CL=new ArrayList <Card>();
		CL.add(c1);
		CL.add(c2);
		Deck d1=new Deck("Mazo2",CL);
		assertThrows(IllegalArgumentException.class,()->{
			card.removeDeck(d1);
		});
		
	}
	
	
	@Test
	void HashCode(){
		assertEquals(Objects.hash(card.getNumber()),card.hashCode());
	}
	
	
	@Test
	void equalsDistintos(){
		Card c1=new Card("David",27,27,CardType.DEFENSE);
		assertFalse(c1.equals(card));
	}
	
	
	@Test
	void equalsIguales(){
		Card c1=new Card("Chaman",10,23,CardType.UNIQUE);
		assertTrue(c1.equals(card));
	}
	
	
	@Test
	void equalsNoInstancia() {
		assertFalse(card.equals(character));
	}

}
