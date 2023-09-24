package tds.practica1.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tds.practica1.Card;
import tds.practica1.CardType;
import tds.practica1.Character;
import tds.practica1.Deck;

class DeckTest {

	
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
	void construccionDeckCorrecto() {
		assertNotNull(deck);
	}
	
	@Test
	void setDeckName() {
		deck.setName("Mazo2");
		assertEquals("Mazo2",deck.getName());
	}
	
	@Test
	void setDeckNameNull() {
		
		assertThrows(IllegalArgumentException.class,()->{
			deck.setName(null);
		});
	}
	
	@Test
	void setDeckNameVacio() {
		
		assertThrows(IllegalArgumentException.class,()->{
			deck.setName("");
		});
	}
	@Test
	void setCardList() {
		ArrayList<Card>CL=new ArrayList <Card>();
		Card c1=new Card("Carlos",1,1,CardType.ATTACK);
		CL.add(c1);
		deck.setCardList(CL);
		assertEquals(CL,deck.getCardList());
	}
	
	@Test
	void setCardListMenor() {
		ArrayList<Card>CL=new ArrayList <Card>();
		assertThrows(IllegalArgumentException.class,()->{
			deck.setCardList(CL);
		});
		
	}
	
	@Test
	void setCardListMayor() {
		Card c1=new Card("Carlos",1,1,CardType.ATTACK);
		Card c2=new Card("Diego",2,2,CardType.ATTACK);
		Card c3=new Card("Juan",3,3,CardType.ATTACK);
		Card c4=new Card("David",4,4,CardType.ATTACK);
		Card c5=new Card("Isaias",5,5,CardType.ATTACK);
		Card c6=new Card("Ana",6,6,CardType.ATTACK);
		ArrayList<Card>CL=new ArrayList <Card>();
		CL.add(c1);
		CL.add(c2);
		CL.add(c3);
		CL.add(c4);
		CL.add(c5);
		CL.add(c6);
		assertThrows(IllegalArgumentException.class,()->{
			deck.setCardList(CL);
		});
		
	}
	
	@Test
	void setCardListNull() {
		assertThrows(IllegalArgumentException.class,()->{
			deck.setCardList(null);
		});
		
	}
	
	@Test
	void addCardCorrecta() {
		Card c1=new Card("Carlos",1,1,CardType.ATTACK);
		deck.addCard(c1);
		assertTrue(deck.getCardList().contains(c1));
		
	}
	
	@Test
	void addCardYaContenida(){
		assertThrows(IllegalArgumentException.class,()->{
			deck.addCard(card);
		});
		
	}
	
	@Test
	void addCardUNIQUEDuplicado(){
		Card c1=new Card("Carlos",1,1,CardType.UNIQUE);
		assertThrows(IllegalArgumentException.class,()->{
			deck.addCard(c1);
		});
		
	}
	
	@Test
	void removeCardCorrecta() {
		Card c1=new Card("Carlos",1,1,CardType.UNIQUE);
		deck.addCard(c1);
		deck.removeCard(c1);
		assertFalse(deck.getCardList().contains(c1));
		
	}
	
	@Test
	void removeCardNoContenida(){
		Card c1=new Card("Carlos",1,1,CardType.UNIQUE);
		assertThrows(IllegalArgumentException.class,()->{
			deck.removeCard(c1);
		});
		
	}
	
	@Test
	void setCharacterListCorrecta() {
		ArrayList<Character>CharL=new ArrayList <Character>();
		CharL.add(character);
		deck.setCharacterList(CharL);
		assertEquals(CharL,deck.getCharacterList());
		
	}
	
	@Test
	void addCharacterCorrecto() {
		ArrayList<Character>CharL=new ArrayList <Character>();
		CharL.add(character);
		deck.setCharacterList(CharL);
		Character char1= new Character("Francisco",4,5);
		deck.addCharacter(char1);
		assertTrue(deck.getCharacterList().contains(char1));
		
	}
	
	@Test
	void addCharacterYaContenido() {
		ArrayList<Character>CharL=new ArrayList <Character>();
		CharL.add(character);
		deck.setCharacterList(CharL);
		assertThrows(IllegalArgumentException.class,()->{
			deck.addCharacter(character);
		});
	}
	
	@Test
	void removeCharacter() {
		ArrayList<Character>CharL=new ArrayList <Character>();
		CharL.add(character);
		deck.setCharacterList(CharL);
		deck.removeCharacter(character);
		assertFalse(deck.getCharacterList().contains(character));
		
	}
	

	@Test
	void removeCharacterNoContenido() {
		assertThrows(IllegalArgumentException.class,()->{
			deck.removeCharacter(character);
		});
	}
	
	
	@Test
	void HashCode(){
		assertEquals(Objects.hash(deck.getName()),deck.hashCode());
	}
	
	
	@Test
	void equalsDistintos(){
		Character char1= new Character("Francisco",4,5);
		assertFalse(char1.equals(character));
	}
	
	
	@Test
	void equalsIguales(){
		assertTrue(character.equals(character));
	}
	
	
	@Test
	void equalsNoInstancia() {
		assertFalse(character.equals(card));
	}

}
