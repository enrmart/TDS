package tds.practica1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/*
 * Esta clase define la clase Character y sus caracteristicas
 * @enrmart
 * @vicbarr
 */
@Entity
@Table(name="CHARACTER")

public class Character {
	
	@Id 
	@Column(name = "NAME")
	private String name;
	
	@Column(name="ATTACK")
	private int attack;
	
	@Column(name="DEFENSE")
	private int defense;
	
	@ManyToMany(mappedBy="characterList")
	private List <Deck> decks;
	
	private Character() {

	}
	
	/**
	 * Constructor que crea una instancia de la clase Character
	 * @param name El nombre de la carta 
	 * @param attack El valor de ataque de la carta 
	 * @param defense El valor de defensa de la carta
	 * @throws IllegalArgumentException si el nombre es nulo o vacio
	 * @throws IllegalArgumentException si el valor del ataque es menor que 0
	 * @throws IllegalArgumentException si el valor de la defensa es menor que 0
	 */
	public Character(String name, int attack, int defense) {
		setName(name);
		setAttack(attack);
		setDefense(defense);
		this.decks=new ArrayList <>();
	}

	/**
	 * Devuelve el nombre del personaje 
	 * @return el nombre del personaje
	 */
	public String getName() {
		
		return this.name;
	}
	
	public void setName(String name) {
		if(name==null){
			throw new IllegalArgumentException("El nombre del personaje es nulo");
		}
		if(name.isEmpty()) {
			throw new IllegalArgumentException("El nombre del personaje esta vacio");
		}
		this.name=name;
	}

	/**
	 * Devuelve el valor de ataque
	 * @return el valor de ataque  
	 */
	public int getAttack() {
		return this.attack;
	}
	
	/**
	 * Asigna el valor de ataque del personaje
	 * @param attack el valor del ataque del personaje
	 * 
	 * @throws IllegalArgumentException si el valor del ataque es menor que 0
	 */
	public void setAttack(int attack) {
		if(attack<0) {
			throw new IllegalArgumentException("El valor de ataque no debe ser menor que 0");
		}
		this.attack=attack;
	}
	/**
	 * Devuelve la defensa del personaje
	 * @return el valor de la defensa
	 */
	public int getDefense() {
		return this.defense;
	}
	
	/**
	 * Asigna el valor de defensa del personaje
	 * @param defense el valor de la defensa del personaje
	 * 
	 * @throws IllegalArgumentException si el valor de la defensa es menor que 0
	 */
	public void setDefense(int defense) {
		if(defense<0) {
			throw new IllegalArgumentException("El valor de defensa no debe ser menor que 0");
		}
		this.defense=defense;
	}
	
	/**
	 * Devuelve la lista de mazos asociados al personaje
	 * @return la lista de mazos asociados
	 */
	public List<Deck> getDeckList() {
		List <Deck> copy= new ArrayList<>(this.decks);
		return copy;
	}
	
	/**
	 * Asocia una lista al 
	 * @param deckList la lista de mazos que se asociara al personaje 
	 * 
	 * @throws IllegalArgumentException Si el la lista de mazos es nula
	 */
	public void setDeckList(List<Deck> deckList) {
		if(deckList==null) {
			throw new IllegalArgumentException("La lista de mazos no debe ser nula");
		}
		this.decks=deckList;
	}
	/**
	 * Asigna un mazo al personaje
	 * @param deck el mazo que asigna
	 * 
	 * @throws IllegalArgumentException Si el mazo ya esta en la lista 
	 */
	public void addDeck(Deck deck) {
		if(this.decks.contains(deck)) {
			throw new IllegalArgumentException("El mazo ya pertenece al personaje");
		}
		this.decks.add(deck);
		deck.getCharacterList().add(this);
	}
	/**
	 * Quita un mazo de los asignados al personaje
	 * @param deck el mazo que elimina
	 * 
	 * @throws IllegalArgumentException Si el mazo es nulo
	 * @throws IllegalArgumentException Si el mazo no esta asignado al personaje 
	 */
	public void removeDeck(Deck deck) {
		if(deck==null) {
			throw new IllegalArgumentException("El mazo no puede ser nulo");
		}
		if(!this.decks.contains(deck)) {
			throw new IllegalArgumentException("El mazo debe estar asignado al personaje");
		}
		this.decks.remove(deck);
		deck.getCharacterList().remove(this);
		
	}
	
	@Override
	public boolean equals(Object o) {
		//Compara a ver si es el mismo objeto 
		if(this ==o) {
			return true;
		}
		
		if(!(o instanceof Character)) {
			return false;
		}
		
		Character personaje=(Character) o;
		
		return this.name.equals(personaje.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}

}
