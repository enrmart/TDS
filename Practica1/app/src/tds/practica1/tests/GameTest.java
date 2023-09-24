package tds.practica1.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tds.practica1.Card;
import tds.practica1.CardType;
import tds.practica1.Deck;
import tds.practica1.Game;
import tds.practica1.Character;


class GameTest {
	
	private Game g;
	private Character c;
	private Deck d;
	private Card ca;
	private ArrayList <Card> cards;
	
	@BeforeEach
	void setUp() {
			g=new Game();
			c=new Character("Pedro",20,30);
			ca=new Card("Verde",20,5,CardType.DEFENSE);
			cards=new ArrayList <Card>();
			cards.add(ca);
			d=new Deck("Mazo1",cards);
		}
	
	@Test
	void addDeck() {
		g.addDeck(d);
		Deck actualDeck= g.getDeckByName("Mazo1");
		assertEquals(d,actualDeck);
	}
	
	@Test
	void addDeckNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			g.addDeck(null);
		});
	}
	
	@Test
	void addDeckExistente() {
		g.addDeck(d);
		assertThrows(IllegalArgumentException.class,()->{
			g.addDeck(d);
		});
	}
	
	@Test
	void removeDeck() {
		g.addDeck(d);
		g.removeDeck(d);
		assertNull(g.getDeckByName(d.getName()));
	}
	
	@Test
	void removeDeckNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			g.removeDeck(null);
		});
	}
	
	@Test
	void removeDeckNoExistente() {
		assertThrows(IllegalArgumentException.class,()->{
			g.removeDeck(d);
		});
	}
	
	@Test
	void getDeckByName() {
		g.addDeck(d);
		Deck actualDeck= g.getDeckByName("Mazo1");
		assertEquals(d.getName(),actualDeck.getName());
		assertIterableEquals(d.getCharacterList(),actualDeck.getCharacterList());
		assertIterableEquals(d.getCardList(),actualDeck.getCardList());
	}
	
	@Test
	void getDeckByNameNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			g.getDeckByName(null);
		});
	}
	
	@Test
	void updateDeck() {
		g.addDeck(d);
		ArrayList<Card> card2=new ArrayList<>(cards);
		Card ca2=new Card("Azul",20,5,CardType.DEFENSE);
		card2.add(ca2);
		Deck d2=new Deck("Mazo1",card2);
		
		g.updateDeck(d2);
		Deck actualDeck= g.getDeckByName("Mazo1");
		assertEquals(d2.getName(),actualDeck.getName());
		assertIterableEquals(d2.getCharacterList(),actualDeck.getCharacterList());
	}
	
	@Test
	void updateDeckNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			g.updateDeck(null);
		});
	}
	
	@Test
	void updateDeckNoExistente() {
		assertThrows(IllegalArgumentException.class,()->{
			g.updateDeck(d);
		});
	}
	
	@Test
	void addCard() {
		g.addCard(ca);
		Card actualCard= g.getCardByNumber(5);
		assertEquals(ca,actualCard);
	}
	
	@Test
	void addCardNula() {
		assertThrows(IllegalArgumentException.class,()->{
			g.addCard(null);
		});
	}
	
	@Test
	void addCardExistente() {
		g.addCard(ca);
		assertThrows(IllegalArgumentException.class,()->{
			g.addCard(ca);
		});
	}
	
	@Test
	void removeCard() {
		g.addCard(ca);
		g.removeCard(ca);
		assertNull(g.getCardByNumber(ca.getNumber()));
	}
	
	@Test
	void removeCardNula() {
		assertThrows(IllegalArgumentException.class,()->{
			g.removeCard(null);
		});
	}
	
	@Test
	void removeCardNoExistente() {
		assertThrows(IllegalArgumentException.class,()->{
			g.removeCard(ca);
		});
	}
	
	@Test
	void updateCard() {
		g.addCard(ca);
		Card ca2=new Card("Azul",20,5,CardType.DEFENSE);
		
		g.updateCard(ca2);
		Card actualCard= g.getCardByNumber(5);
		assertEquals(ca2.getCost(),actualCard.getCost());
		assertEquals(ca2.getName(),actualCard.getName());
		assertIterableEquals(ca2.getDeckList(),actualCard.getDeckList());
	}
	
	@Test
	void updateCardNula() {
		assertThrows(IllegalArgumentException.class,()->{
			g.updateCard(null);
		});
	}
	
	@Test
	void updateCardNoExistente() {
		assertThrows(IllegalArgumentException.class,()->{
			g.updateCard(ca);
		});
	}
	
	@Test
	void getCardByNumber() {
		g.addCard(ca);
		Card actualCard= g.getCardByNumber(5);
		assertEquals(ca.getName(),actualCard.getName());
		assertEquals(ca.getCost(),actualCard.getCost());
		assertIterableEquals(ca.getDeckList(),actualCard.getDeckList());
	}
	
	@Test
	void getCardByNumberLimiteSuperior() {
		Card ca2=new Card("Azul",20,200,CardType.DEFENSE);
		g.addCard(ca2);
		Card actualCard= g.getCardByNumber(200);
		assertEquals(ca2.getName(),actualCard.getName());
		assertEquals(ca2.getCost(),actualCard.getCost());
		assertIterableEquals(ca2.getDeckList(),actualCard.getDeckList());
	}
	
	@Test
	void getCardByNumberLimiteInferior() {
		Card ca2=new Card("Azul",20,0,CardType.DEFENSE);
		g.addCard(ca2);
		Card actualCard= g.getCardByNumber(0);
		assertEquals(ca2.getName(),actualCard.getName());
		assertEquals(ca2.getCost(),actualCard.getCost());
		assertIterableEquals(ca2.getDeckList(),actualCard.getDeckList());
	}
	
	@Test
	void getCardByNumberMayorLimiteSuperior() {
		assertThrows(IllegalArgumentException.class,()->{
			g.getCardByNumber(400);
		});
		
	}
	
	@Test
	void getCardByNumberMenorLimiteInferior() {
		assertThrows(IllegalArgumentException.class,()->{
			g.getCardByNumber(-4);
		});
	}
	
	@Test
	void addCharacter() {
		g.addCharacter(c);
		Character actualCharacter= g.getCharacterByName("Pedro");
		assertEquals(c,actualCharacter);
	}
	
	@Test
	void addCharacterNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			g.addCharacter(null);
		});
	}
	
	@Test
	void addCharacterExistente() {
		g.addCharacter(c);
		assertThrows(IllegalArgumentException.class,()->{
			g.addCharacter(c);
		});
	}
	
	@Test
	void removeCharacter() {
		g.addCharacter(c);
		g.removeCharacter(c);
		assertNull(g.getCharacterByName(c.getName()));
	}
	
	@Test
	void removeCharacterNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			g.removeCharacter(null);
		});
	}
	
	@Test
	void removeCharacterNoExistente() {
		assertThrows(IllegalArgumentException.class,()->{
			g.removeCharacter(c);
		});
	}
	
	@Test
	void getCharacterByName() {
		g.addDeck(d);
		Deck actualDeck= g.getDeckByName("Mazo1");
		assertEquals(d.getName(),actualDeck.getName());
		assertIterableEquals(d.getCharacterList(),actualDeck.getCharacterList());
		assertIterableEquals(d.getCardList(),actualDeck.getCardList());
	}
	
	@Test
	void getCharacterkByNameNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			g.getCharacterByName(null);
		});
	}
	
	@Test
	void updateCharacter() {
		g.addCharacter(c);
		Character c2=new Character("Pedro",40,50);
		
		g.updateCharacter(c2);
		Character actualCharacter= g.getCharacterByName("Pedro");
		assertEquals(c2.getAttack(),actualCharacter.getAttack());
		assertEquals(c2.getDefense(),actualCharacter.getDefense());
		assertIterableEquals(c2.getDeckList(),actualCharacter.getDeckList());
	}
	
	@Test
	void updateCharacterNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			g.updateCharacter(null);
		});
	}
	
	@Test
	void updateCharacterNoExistente() {
		assertThrows(IllegalArgumentException.class,()->{
			g.updateCharacter(c);
		});
	}
	
	@AfterEach
	void tearDown() {
		g.clearDatabase();
	}
}
