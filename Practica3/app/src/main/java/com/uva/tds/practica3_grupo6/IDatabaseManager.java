package com.uva.tds.practica3_grupo6;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase encargada de gestionar la conexión con una base de datos. Incluye
 * operaciones para añadir reservas, eliminarlas, obtenerlas a partir de su id,
 * obtenerlas a partir de un dni
 * y la obtención de una lista de reservas según el estado y fechas de creación
 * @author marcorr
 *
 */
public interface IDatabaseManager {
	
	/**
	 * Añade una reserva a la base de datos
	 * @param reserva La reserva a añadir
	 * @throws IllegalArgumentException si reserva es nula
	 * @throws IllegalStateException si reserva ya existe en la bbdd
	 */
	public void add(Reserva reserva);
	
	/**
	 * Elimina una reserva de la base de datos
	 * @param reserva La reserva a eliminar
	 * @throws IllegalArgumentException si reserva es nulo
	 * @throws IllegalStateException si reserva no existe en la bbdd
	 */
	public void remove(Reserva reserva);
	
	/**
	 * Devuelve una reserva de la base de datos
	 * @param id Id de la reserva a obtener
	 * @return La reserva que coincide con el id. Si no hay ninguna, se
	 * devuelve null
	 * @throws IllegalArgumentException si id es nulo
	 */
	public Reserva get(String id);
	
	/**
	* Devuelve la lista de reservas que han sido realizadas usando un dni concreto
	* @param dni Dni de las reservas que queremos obtener
	* @return La lista de reservas realizadas con el dni proporcionado. Si no hay ninguna
	* se devuelve la lista vacía
	* @throws IllegalArgumentException si dni es nulo
	*/
	public ArrayList<Reserva> getByDNI(String dni);
	

	
	/**
	 * Devuelve la lista de reservas en el estado state y entre las fechas de creación
	 * date1 y date2 (incluidas date1 y date2). Si date1 y date2 son nulos
	 * se ignora este criterio para la búsqueda. Si date1 y date2 son iguales, 
	 * las reservas que se obtengan serán las referidas a la fecha concreta de date1.
	 * @param state El estado del que se quieres obtener las reservas.
	 * Si es nulo, se ignora este criterio para la búsqueda
	 * @param date1 La fecha inferior del intervalo
	 * @param date2 La fecha superior del intervalo
	 * @return La lista de reservas que cumplen con los criterios. Si no hay
	 * reservas, se devuelve una lista vacía
	 * @throws IllegalArgumentException si date1 es nulo y date2 no, o viceversa
	 * @throws IllegalArgumentException si date2 es menor que date1
	 */
	public ArrayList<Reserva> getByStateAndDates(EstadosReserva state,LocalDate date1,LocalDate date2);
	


}