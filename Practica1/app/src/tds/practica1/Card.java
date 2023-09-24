package tds.practica1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Esta clase define la clase Card y sus caracteristicas
 * @author vicbarr
 * @author enrmart
 *
 */
@Entity
@Table(name="CARD")

public class Card {
	
	@ManyToMany(mappedBy="cardList")
	private List<Deck> deckList;
	
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "COST")
	private int cost;
	
	@Id 
	@Column(name = "CARDNUMBER")
	private int cardNumber;
	
	@Enumerated(EnumType.STRING)
	private CardType type;
	
	
	private Card() {
	}
	
	
	/**
	 * Contructor que crea una instancia Card 
	 * @param name nombre unico de cada carta
	 * @param cost	coste no nulo de cada carta
	 * @param cardNumber numero identificativo de cada carta 
	 * @param type tipo de la carta (attack, defense o unique)
	 * @throws IllegalArgumentException en caso de que el nombre sea nulo o vacio
	 * @throws IllegalArgumentException en caso de que el nombbre tenga una cantidad de caracteres menor a 1 o mayor a 10
	 * @throws IllegalArgumentExcetion  en caso de el coste de la carta sea menor que 0
	 * @throws IllegalArgumentExcetion en caso de que el numero de carta sea menor que 0
	 * @throws IllegalArgumentExcetion en caso de que el numero de carta sea mayor que 200
	 */
	public Card(String name, int cost, int cardNumber, CardType type) {
		setName(name);
		setCost(cost);
		setNumber(cardNumber);
		setType(type);
		this.deckList=new ArrayList<Deck>();
		
	}

	/**
	 * Asigna el nombre de carta 
	 * @param name nombre el cual estableceremos a la carta
	 * @throws IllegalArgumentExcetion en caso de que el nombre sea nulo o vacio
	 * @throws IllegalArgumentException en caso de que el nombbre tenga una cantidad de caracteres menor a 1 o mayor a 10
	 */
	public void setName(String name) {
		// TODO Auto-generated method stub
		if (name==null||name.isEmpty()) {
			throw new IllegalArgumentException("Nombre introducido incorrecto");
		}
		if(name.length()<1||name.length()>10){
			throw new IllegalArgumentException("Numero de caracteres del nombre icorrecto (entre 1 y 10)");
		}
		this.name=name;
	}
	
	/**
	 * Asigna el coste de la carta
	 * @param cost coste de la carta
	 * @throws IllegalArgumentException en caso de que el coste sea negativo
	 */
	public void setCost(int cost) {
		// TODO Auto-generated method stub
		if(cost<0) {
			throw new IllegalArgumentException("coste incorrecto, menor que 0");
		}
		this.cost=cost;
	}
	
	/**
	 * Asigna el numero a la carta
	 * @param number numero unico el cual identifica la carta
	 * @throws IllegalArgumentException El numero de id es negativo
	 * @throws IllegalArgumetException El numero de id es mayor qeu 200
	 */
	public void setNumber(int cardNumber) {
		// TODO Auto-generated method stub
		if(number<0) {
			throw new IllegalArgumentException("numero de carta incorrecto, menor que 0");
		}
		if(number>200) {
			throw new IllegalArgumentException("numero de carta incorrecto, mayor que 200");
		}
		
		this.cardNumber=number;
	}
	
	/**
	 * Asigna el tipo a la carta
	 * @param type tipo de la carta
	 */
	public void setType(CardType type) {
		// TODO Auto-generated method stub
		this.type=type;
	}
	
	/**
	 * Asigna una lista de barajas en las que esta nuestra carta
	 * @param deckList lista de mazos en los que esta nuestra carta
	 */
	public void setDeckList(List<Deck> deckList) {
		// TODO Auto-generated method stub
		this.deckList=deckList;
	}
	
	
	
	/**
	 * Retorna el nombre de la carta
	 * @return name String el cual contiene el nombre de la carta
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/**
	 * Retorna el coste de la carta
	 * @return cost Entero que representa el coste de la carta
	 */
	public int getCost() {
		// TODO Auto-generated method stub
		return cost;
	}
	
	/**
	 * Retorna el numero de identificacion de la carta
	 * @return cardNumber Entero que representa el numero de la carta
	 */
	public int getNumber() {
		// TODO Auto-generated method stub
		return this.cardNumber;
	}
	
	/**
	 * Retorna el tipo de la carta
	 * @return type Objeto tipo el cual pertenece a una enumeracion(ATTACK,DEFENSE,UNIQUE)
	 */
	public CardType getType() {
		// TODO Auto-generated method stub
		return type;
	}

	/**
	 * Retorna la lista de mazos en las que se encuentra nuestra carta
	 * @return copy copia del vector de mazos
	 */
	public List<Deck> getDeckList() {
		// TODO Auto-generated method stub
		List<Deck>copy=new ArrayList<>(this.deckList);
		return copy;
	}

	
	/**
	 * Agrega un nuevo mazo en el que se encuentra nuestra carta
	 * @param deck nuevo mazo
	 * @throws IllegalArgumentException en caso de que la carta ya se encuentre en ese mazo
	 * @throws IllegalArgumentException en caso de que se intente agregar un mazo con una carta UNIQUE a nuestra carta
	 */
	public void addDeck(Deck deck) {
		// TODO Auto-generated method stub
		if(deckList.contains(deck)) {
			throw new IllegalArgumentException("la carta ya se encuentra en ese mazo");
		}
		
		
		if(this.getType().equals(CardType.UNIQUE)) {
			for(int i=0;i<deck.getCardList().size();i++) {
				if(deck.getCardList().get(i).equals(CardType.UNIQUE)) {
					throw new IllegalArgumentException("Ya existe una carta tipo UNIQUE en el mazo");
				}
			}
		}
		
		if(deck.getCardList().size()==5) {
			throw new IllegalArgumentException("El mazo ya esta lleno");
		}

		
		deckList.add(deck);
		deck.getCardList().add(this);

	}

	/**
	 * Elimina nuestra carta de un mazo
	 * @param deck Mazo del que se eliminara nuestra carta
	 * @throws IllegalArgumentException en caso de que la carta no se encuentre en el mazo
	 */
	public void removeDeck(Deck deck) {
		// TODO Auto-generated method stub
		if(!deckList.contains(deck)) {
			throw new IllegalArgumentException("la carta no se encuentra en ese mazo");
		}
		deckList.remove(deck);
		deck.getCardList().remove(this);

	}

	@Override
	public boolean equals(Object o) {
		// If the object is compared with itself then return true
		if(this==o) {
			return true;
		}
		
		if(!(o instanceof Card)) {
			return false;
		}
		
		Card carta=(Card) o;
		
		return this.name.equals(carta.getName());
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getNumber());
	}

}

