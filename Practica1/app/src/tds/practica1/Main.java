package tds.practica1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game game=new Game();
		Card card=new Card("asd", 20,50, CardType.DEFENSE);
		Character c=new Character("Pedro",20,30);
		ArrayList <Card> cards=new ArrayList <Card>();
		cards.add(card);
		Deck d=new Deck("Mazo1",cards);
		d.addCharacter(c);
		game.addDeck(d);
		c.setAttack(40);
		c.setDefense(50);
		game.updateCharacter(c);
		
		
		Character c2=game.getCharacterByName("Pedro");

		System.out.println("PERSONAJE:"+c2.getName()+" ATAQUE:" +c2.getAttack()+" DEFENSA:"+c2.getDefense());
		

		
		
	}

}
