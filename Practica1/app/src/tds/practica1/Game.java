package tds.practica1;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


/**
 * Clase que maneja el juego de cartas con operaciones de base de datos
 * 
 * @author enrmart
 * @author vicbarr
 * 
 */
public class Game {
	/**
	 * Añade el mazo al juego
	 * 
	 * @param deck el mazo a añadir
	 * 
	 * 
	 */
	public void addDeck(Deck deck) {
			if(deck==null) {
				throw new IllegalArgumentException("El mazo no puede ser nulo");
			}
			
			if(getDeckByName(deck.getName())!=null) {
				throw new IllegalArgumentException("El mazo con ese nombre ya pertenece a la base de datos");
			}
			Session session = getSession();
			
			try {
				session.beginTransaction();

				session.persist(deck);
				
				session.flush();
				session.close();

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
	}
	/**
	 * Elimina un mazo de la lista de mazos 
	 * @param deck el mazo a eliminar 
	 */
	public void removeDeck(Deck deck) {
		
		if(deck==null) {
			throw new IllegalArgumentException("El mazo no puede ser nulo");
		}
		
		if(getDeckByName(deck.getName())==null) {
			throw new IllegalArgumentException("El mazo no pertenece a la base de datos");
		}
		
		Session session = getSession();
		
		
		try {
			session.beginTransaction();
			
			session.remove(deck);
			
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	public void updateDeck(Deck deck) {
		if(deck==null) {
			throw new IllegalArgumentException("El mazo no puede ser nulo");
		}
		
		if(getDeckByName(deck.getName())==null) {
			throw new IllegalArgumentException("El mazo no pertenece a la base de datos");
		}
		
		Session session = getSession();
		
		try {
			session.beginTransaction();
			
			session.update(deck);
			session.getTransaction().commit();
			
			session.close(); 
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	
	}

	public Deck getDeckByName(String name) {
		if(name==null) {
			throw new IllegalArgumentException("El nombre del mazo no puede ser nulo");
		}
		Session session = getSession();

		try {
			session.beginTransaction();
			
			Deck deck=session.get(Deck.class,name);
			
			if(deck!=null) {
				Hibernate.initialize(deck.getCharacterList());
				Hibernate.initialize(deck.getCardList());
			}
			session.close();
			return deck;

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return null;
	}

	public void addCard(Card card) {
		if(card==null) {
			throw new IllegalArgumentException("La carta no puede ser nula");
		}
		
		if(getCardByNumber(card.getNumber())!=null) {
			throw new IllegalArgumentException("La carta con ese numero ya pertenece a la base de datos");
		}
		Session session = getSession();
		
		try {
			session.beginTransaction();

			session.persist(card);
			session.flush();
			session.close(); 

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	public void removeCard(Card card) {
		if(card==null) {
			throw new IllegalArgumentException("La carta no puede ser nulo");
		}
		if(getCardByNumber(card.getNumber())==null) {
			throw new IllegalArgumentException("La carta no pertenece a la base de datos");
		}
		
		Session session = getSession();

		try {
			session.beginTransaction();
			
			session.remove(card);
			
			session.getTransaction().commit();
			session.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	public void updateCard(Card card) {
		if(card==null) {
			throw new IllegalArgumentException("El mazo no puede ser nulo");
		}
		
		if(getCardByNumber(card.getNumber())==null) {
			throw new IllegalArgumentException("La carta no pertenece a la base de datos");
		}
		
		Session session = getSession();

		try {
			session.beginTransaction();
			
			
			session.update(card);
			session.getTransaction().commit();
			session.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	public Card getCardByNumber(int cardNumber) {
		if(cardNumber<0 || cardNumber>200) {
			throw new IllegalArgumentException("El numero de carta debe estar entre 0 y 200");
		}
		Session session = getSession();

		try {
			session.beginTransaction();
			
			Card card=session.get(Card.class,cardNumber);
			if(card!=null) {
				Hibernate.initialize(card.getDeckList());
			}
			session.close(); 
			return card;

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return null;
	}

	public void addCharacter(Character character) {
		if(character==null) {
			throw new IllegalArgumentException("El personaje no puede ser nulo");
		}
		
		if(getCharacterByName(character.getName())!=null) {
			throw new IllegalArgumentException("El personaje con ese nombre ya pertenece a la base de datos");
		}
		Session session = getSession();
		
		try {
			session.beginTransaction();

			session.persist(character);
			session.flush();
			session.close(); 
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	public void removeCharacter(Character character) {
		if(character==null) {
			throw new IllegalArgumentException("EL personaje no puede ser nulo");
		}
		
		if(getCharacterByName(character.getName())==null) {
			throw new IllegalArgumentException("El personaje no pertenece a la base de datos");
		}
		Session session = getSession();

		try {
			session.beginTransaction();
			
			session.remove(character);
			
			session.getTransaction().commit();
			session.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	
	}

	public void updateCharacter(Character character) {
		if(character==null) {
			throw new IllegalArgumentException("El personaje no puede ser nulo");
		}
		
		if(getCharacterByName(character.getName())==null) {
			throw new IllegalArgumentException("El personaje no pertenece a la base de datos");
		}
		
		Session session = getSession();
		
		try {
			session.beginTransaction();
			
			session.update(character);
			session.getTransaction().commit();
			session.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		
	}

	public Character getCharacterByName(String name) {
		if(name==null) {
			throw new IllegalArgumentException("El nombre del mazo no puede ser nulo");
		}
		Session session = getSession();

		try {
			session.beginTransaction();
			
			Character character=session.get(Character.class,name);
			if(character!=null) {
				Hibernate.initialize(character.getDeckList());
			}
			session.close(); 
			return character;

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return null;
	}
	
	
	private Session getSession() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session;
		try {
			session = factory.getCurrentSession();
			return session;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	/*
	 * Elimina todos los datos de la base de datos
	 */
	public void clearDatabase() {
		Session session = getSession();
		session.getTransaction().begin();
		Query query=session.createSQLQuery("Truncate table CARD_DECK");
		query.executeUpdate();
		query=session.createSQLQuery("Truncate table CHARACTER_DECK");
		query.executeUpdate();
		query=session.createSQLQuery("Truncate table DECK");
		query.executeUpdate();
		query=session.createSQLQuery("Truncate table CARD");
		query.executeUpdate();
		query=session.createSQLQuery("Truncate table CHARACTER");
		query.executeUpdate();
		session.close();
	}


}

