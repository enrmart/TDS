package tds.practica1.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tds.practica1.Character;
import tds.practica1.Deck;
import tds.practica1.Card;
import tds.practica1.CardType;


class CharacterTest {
	
	private Character c;
	private Card ca;
	private Deck d;
	private ArrayList<Card> cards;
	
	@BeforeEach
	void setUp() {
		c=new Character("Pedro",20,30);
		ca=new Card("Verde",20,5,CardType.DEFENSE);
		cards=new ArrayList <Card>();
		cards.add(ca);
		d=new Deck("Mazo1",cards);
	}
	
	@Test
	void Contructortest() {
		assertNotNull(c);
	}
	
	@Test
	void getNameTest() {
		assertEquals("Pedro", c.getName());
	}
	
	@Test
	void setName() {
		c.setName("Azul");
		assertEquals("Azul",c.getName());
	}
	
	@Test
	void setNameNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			c.setName(null);
		});
	}
	
	@Test
	void setNameVacio() {
		assertThrows(IllegalArgumentException.class,()->{
			c.setName("");
		});
	}
	
	@Test
	void getAttack() {
		assertEquals(20,c.getAttack());
	}
	
	@Test
	void setAttack() {
		c.setAttack(50);
		assertEquals(50,c.getAttack());
	}
	@Test
	void setAttackValorLimite() {
		c.setAttack(0);
		assertEquals(0,c.getAttack());
	}
	
	@Test
	void setAttackValorInferiorLImite() {
		assertThrows(IllegalArgumentException.class,()->{
			c.setAttack(-5);
		});
	}
	
	@Test
	void getDefense() {
		assertEquals(30,c.getDefense());
	}
	
	@Test
	void setDefense() {
		c.setDefense(50);
		assertEquals(50,c.getDefense());
	}
	@Test
	void setDefenseValorLimite() {
		c.setDefense(0);
		assertEquals(0,c.getDefense());
	}
	
	@Test
	void setDefenseValorInferiorLImite() {
		assertThrows(IllegalArgumentException.class,()->{
			c.setDefense(-5);
		});
	}
	
	@Test
	void getDeckList() {
		c.getDeckList();
	}
	
	@Test
	void setDeckList() {
		ArrayList<Deck> ds=new ArrayList<Deck>();
		ds.add(d);
		c.setDeckList(ds);
		assertIterableEquals(ds,c.getDeckList());
	}
	
	@Test
	void setDeckListNula() {
		assertThrows(IllegalArgumentException.class,()->{
			c.setDeckList(null);
		});
	}
	
	@Test
	void addDeck() {
		Deck z=new Deck("Mazo2",cards);
		c.addDeck(z);
		assertEquals(z,c.getDeckList().get(0));
	}
	
	@Test
	void addDeckContenido() {
		c.addDeck(d);
		assertThrows(IllegalArgumentException.class,()->{
			c.addDeck(d);
		});
	}
	
	@Test
	void removeDeck() {
		c.addDeck(d);
		c.removeDeck(d);
		assertTrue(c.getDeckList().isEmpty());
	}
	
	@Test
	void removeDeckNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			c.removeDeck(null);
		});
	}
	
	@Test
	void removeDeckNoContenido() {
		assertThrows(IllegalArgumentException.class,()->{
			c.removeDeck(d);
		});
	}
	
	@Test
	void equals2ObjetosDistintos() {
		Character o=new Character("Pedro",30,40);
		assertTrue(c.equals(o));
	}
	
	@Test
	void equalsMismoObjeto() {
		Character o=new Character("Pedro",30,40);
		assertTrue(o.equals(o));
	}
	
	@Test
	void equalsNoInstancia() {
		assertFalse(c.equals(ca));
	}
	@Test
	void HashCode(){
		assertEquals(Objects.hash(c.getName()),c.hashCode());
	}
	
	
}
