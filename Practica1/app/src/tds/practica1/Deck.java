package tds.practica1;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;


/**
 * Esta clase define la clase Deck y sus caracteristicas
 * @author vicbarr
 * @author enrmart
 *
 */
@Entity
@Table(name="DECK")

public class Deck {
	
	@Id 
	@Column(name = "NAME")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "CARD_DECK", joinColumns = @JoinColumn(name = "DECK_ID", referencedColumnName = "NAME"), inverseJoinColumns = @JoinColumn(name = "CARD_ID", referencedColumnName = "CARDNUMBER"))
	private List<Card> cardList;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "CHARACTER_DECK", joinColumns = @JoinColumn(name = "DECK_ID", referencedColumnName = "NAME"), inverseJoinColumns = @JoinColumn(name = "CHARACTER_ID", referencedColumnName = "NAME"))
	private List<Character> characterList;


	private Deck() {

	}

	/**
	 * Constructor de la clase Deck
	 * @param name nombre unico que tomara el mazo
	 * @param cardList lista de cartas las cuales componen el mazo
	 * @throw IllegalArgumentException En caso de que el nombre de el mazo sea incorrecto
	 * @throw IllegalArgumentException En caso de que el numero de cartas del mazo no se encuentre entre 2 y 5
	 */
	public Deck(String name, List<Card> cardList) {
		setName(name);
		setCardList(cardList);
		this.characterList=new ArrayList<>();
	}

	/**
	 * Metodo que devuelve el nombre del mazo
	 * @return nombre unico del mazo
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/**
	 * Metodo que establece el nombre del mazo
	 * @param name Nombre unico que se le establecera al mazo
	 */
	public void setName(String name) {
		// TODO Auto-generated method stub
		if(name==null||name.isEmpty()) {
			throw new IllegalArgumentException("El nombre es incorrecto");
		}
		this.name=name;
	}

	/**
	 * Metodo que devuelve la lista de cartas que componen el mazo
	 * @return copy lista con todas las cartas 
	 */
	public List<Card> getCardList() {
		// TODO Auto-generated method stub
		List<Card>copy=new ArrayList<>(this.cardList);
		return copy;
	}

	/**
	 * 
	 * Metodo que establece la lista de cartas que componen el mazo
	 * @param cardList lista de cartas que componen nuestro mazo
	 */
	public void setCardList(List<Card> cardList) {
		// TODO Auto-generated method stub
		if(cardList==null||cardList.size()<1||cardList.size()>5) {
			throw new IllegalArgumentException("El numero de cartas en el mazo es incorrecto");
		}
		this.cardList=cardList;
		
	}

	/**
	 * Metodo que agrega una carta a nuestro mazo
	 * @param card carta la cual vamos a agregar 
	 * @throws IllegalArgumentException En caso de que la carta que se quiere agregar ya este en el mazo
	 * @throws IllegalArgumentException En caso de que se intente agregar una carta tipo UNIQUE a un amzo que ya tiene una de estas
	 */
	public void addCard(Card card) {
		// TODO Auto-generated method stub
		if(cardList.contains(card)) {
			throw new IllegalArgumentException("La carta ya se encuentra en el mazo");
		}
		if(card.getType().equals(CardType.UNIQUE)) {
			for(int i=0;i<cardList.size();i++) {
				if(cardList.get(i).equals(CardType.UNIQUE)) {
					throw new IllegalArgumentException("Ya existe una carta tipo UNIQUE en el mazo");
				}
			}
		}
		cardList.add(card);
		card.getDeckList().add(this);

	}

	/**
	 * Metodo que elimina una carta del mazo
	 * @param card carta que queremos eliminar 
	 * @throws IllegalArgumentException En caso de que se intente eliminar una carta que no se encuentre en el mazo
	 */
	public void removeCard(Card card) {
		// TODO Auto-generated method stub
		if(!cardList.contains(card)) {
			throw new IllegalArgumentException("La carta no se encuentra en el mazo");
		}
		cardList.remove(card);
		card.getDeckList().remove(this);

	}

	/**
	 * Metodo que devuelve los personajes de nuestro mazo
	 * @return copy Lista con todos los personajes que componen el mazo
	 */
	public List<Character> getCharacterList() {
		// TODO Auto-generated method stub
		List<Character>copy=new ArrayList<>(this.characterList);
		return copy;
	}

	/**
	 * Metodo que Establece la lista de personajes que componen un mazo
	 * @param characterList Lista de caracteres que compondran el mazo
	 */
	public void setCharacterList(List<Character> characterList) {
		// TODO Auto-generated method stub
		this.characterList=characterList;
	}

	/**
	 * Metodo que agregara un personaje a el mazo
	 * @param character Personaje que agregaremos al mazo
	 * @throws IllegalArgumentExcetion En caso de que el personaje que queremos agregar ya se encuentre en el mazo
	 */
	public void addCharacter(Character character) {
		// TODO Auto-generated method stub
		if(characterList.contains(character)) {
			throw new IllegalArgumentException("El personaje ya se encuentra en el mazo");
		}
		characterList.add(character);
		character.getDeckList().add(this);
		

	}

	/**
	 * Metodo que elimina un persnaje del mazo
	 * @param character Personaje que queremos eliminar
	 * @throws IllegalArggumentException En caso de que el personaje que se quiera eliminar del mazo
	 */
	public void removeCharacter(Character character) {
		// TODO Auto-generated method stub
		if(!characterList.contains(character)) {
			throw new IllegalArgumentException("El personaje no se encuentra en el mazo");
		}
		characterList.remove(character);
		character.getDeckList().remove(this);

	}

	@Override
	public boolean equals(Object o) {
		// If the object is compared with itself then return true
		if(this==o) {
			return true;
		}
		
		if(!(o instanceof Deck)) {
			return false;
		}
		
		Deck deck=(Deck) o;
		
		return this.name.equals(deck.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getName());
	}

}

