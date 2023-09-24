package tds.practica2;

import java.time.LocalDate;
/**
 * @author vicbarr
 * @author enrmart
 *
 */

public class Reserva {
	
	/**Crea un objeto {@link Reserva.class}estableciendo su estado a creada{@link EstadosReserva.class#REALIZADA} 
	 * 
	 * @param id el identificador unico de la clase
	 * @param FechaCreacion la {@link LocalDate.class} en la que se crea 
	 * @param alojamiento el {@link Alojamiento.class} que se va a reservar
	 * @param dni de la persona que reserva 
	 * 
	 * @throws IllegalArgumentException Si el id es nulo
	 * @throws IllegalArgumentException Si la longitud del id no esta entre 1 y 12
	 * @throws IllegalArgumentException Si la fechaCreacion es nula
	 * @throws IllegalArgumentException Si el Alojamiento es nulo
	 * @throws IllegalArgumentException Si el Dni es nulo
	 * @throws IllegalArgumentException Si el Dni tiene menor longitud de la esperada
	 * @throws IllegalArgumentException Si el Dni tiene mayor longitud de la esperada
	 * @throws IllegalArgumentException Si hay mas letras de una letra
	 * @throws IllegalArgumentException Si no hay letra
	 * @throws IllegalArgumentException Si la letra del Dni no es correcta 
	 * 
	 */
	public Reserva(String id, LocalDate FechaCreacion,Alojamiento alojamiento,String dni ) {
		
	}
	
	/**Metodo el {@link String.class} que identifica la {@link Reserva.class}
	 * 
	 * @return el identificador de la reserva
	 */
	public String getId() {
		return null;
	}
	
	/**Devuelve la {@link LocalDate.class} de modificacion
	 * 
	 * @return la fecha de modificacion
	 */
	public LocalDate getFechaMod() {
		return null;
	}
	
	/**
	 * Metodo que devuelve la {@link LocalDate.class} de creacion
	 * 
	 * @return la fecha de creacion
	 */
	public LocalDate getFechaCreacion() {
		return null;
	}
	
	/**
	 * Metodo que modifica el {@link Alojamiento.class} de la {@link Reserva.class}
	 * 
	 * @throws IllegalArgumentException Si el {@link Alojamiento.class} es null
	 * @throws IllegalArgumentException Si la {@link Reserva.class} no esta {@link EstadosReserva.class#REALIZADA}
	 */
	public void setAlojamiento(Alojamiento alojamiento) {
	}
	
	/**Metodo que devuelve el {@link Alojamiento.class} de la {@link Reserva.class}
	 * 
	 * @return el alojamiento asociado a la reserva
	 */
	public Alojamiento getAlojamiento() {
		return null;
	}
	
	/**Confirma la reserva{@link EstadosReserva.class#CONFIRMADA}
	 * 
	 */
	public void confirmarReserva() {	
	}
	
	/**
	 * Metodo para pagar la {@link Reserva.class} y pasa el estado a 
	 * {@link EstadosReserva.class#PAGADA}
	 * 
	 * @throws IllegalArgumentException Si la reserva no esta confirmada
	 */
	public void pagarReserva() {
		
	}
	
	/**
	 * Metodo que cancela la {@link Reserva.class}y pasa al estado
	 * {@link EstadosReserva.class#CANCELADA}
	 * 
	 * @throws IllegalArgumentException Si la reserva no esta confirmada
	 * @throws IllegalArgumentException Si la reserva no esta pagada
	 */
	public void cancelarReserva() {
		
	}
	/** 
	 * Metodo que modifica el Dni de la {@link Reserva.class}
	 * 
	 * @throws IllegalArgumentException Si el Dni es nulo
	 * @throws IllegalArgumentException Si el Dni tiene menor longitud de la esperada
	 * @throws IllegalArgumentException Si el Dni tiene mayor longitud de la esperada
	 * @throws IllegalArgumentException Si hay mas letras de una letra
	 * @throws IllegalArgumentException Si no hay letra
	 * @throws IllegalArgumentException Si la letra del Dni no es correcta 
	 * @throws IllegalArgumentException Si la {@link Reserva.class} no esta {@link EstadosReserva.class#REALIZADA}
	 */
	public void setDni(String Dni) {
	}
	
	/**
	 * Metodo que devuelve el Dni{@link String.class} 
	 * de la persona que realizo la {@link Reserva.class} 
	 * 
	 * @return un String correspondiente al DNI
	 */
	public String getDni() {
		return null;
	}
	
	/**
	 * Metodo que devuelve el estado{@link EstadosReserva.class} 
	 * en el que se encuentra la {@link Reserva.class}
	 * 
	 * 
	 * @return el estado de la reserva
	 */
	public EstadosReserva getEstado() {
		return null;
	}
	
	/**
	 * Metodo que indica si una {@link Reserva.class} 
	 * ha sido creada anterior,igual o posteriormente que otra
	 * 
	 * @param r la reserva con la que se compara
	 * @return Un String que indica como estan creada una respecto a la otra
	 * 
	 * @throws IllegalArgumentException Si la {@link Reserva.class} es nula
	 */
	public String comparaReserva(Reserva r) {
		return null;
	}
	
	@Override
	public boolean equals(Object o) {
		return false;
	}
	
}
