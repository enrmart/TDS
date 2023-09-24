package com.uva.tds.practica3_grupo6;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author vicbarr
 * @author enrmart
 *
 */

public class Reserva {
	static final String MENSAJEERROR="La reserva debe estar Realizada";
	private String id;
	private LocalDate fechaCreacion;
	private Alojamiento alojamiento;
	private LocalDate fechaModificacion;
	private EstadosReserva estado;
	private String dni;
	
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
	public Reserva(String id, LocalDate fechaCreacion,Alojamiento alojamiento,String dni ) {
		
		this.setId(id);
		this.setCreacion(fechaCreacion);
		this.setEstado(EstadosReserva.REALIZADA);
		this.setAlojamiento(alojamiento);
		this.setModificacion(fechaCreacion);
		this.setDni(dni);
		
		
	}
	
	private void setId(String id) {
		if(id==null) {
			throw new IllegalArgumentException("El identificador no puede ser nulo");
		}
		if(id.length()<1 || id.length()>12) {
			throw new IllegalArgumentException("El identificador debe estar entre 1 y 12 caracteres");
		}
		this.id=id;
		
	}

	private void setCreacion(LocalDate fechaCreacion) {
		if(fechaCreacion==null) {
			throw new IllegalArgumentException("El identificador no puede ser nulo");
		}
		this.fechaCreacion=fechaCreacion;
		
	}

	private void setEstado(EstadosReserva realizada) {
		this.estado=realizada;
	}

	private void setModificacion(LocalDate fechaModificacion) {
		this.fechaModificacion=fechaModificacion;
		
	}

	/**Metodo el {@link String.class} que identifica la {@link Reserva.class}
	 * 
	 * @return el identificador de la reserva
	 */
	public String getId() {
		return this.id;
	}
	
	/**Devuelve la {@link LocalDate.class} de modificacion
	 * 
	 * @return la fecha de modificacion
	 */
	public LocalDate getFechaMod() {
		return this.fechaModificacion;
	}
	
	/**
	 * Metodo que devuelve la {@link LocalDate.class} de creacion
	 * 
	 * @return la fecha de creacion
	 */
	public LocalDate getFechaCreacion() {
		return this.fechaCreacion;
	}
	
	/**
	 * Metodo que modifica el {@link Alojamiento.class} de la {@link Reserva.class}
	 * 
	 * @throws IllegalArgumentException Si el {@link Alojamiento.class} es null
	 * @throws IllegalArgumentException Si la {@link Reserva.class} no esta {@link EstadosReserva.class#REALIZADA}
	 */
	public void setAlojamiento(Alojamiento alojamiento) {
		if(alojamiento==null) {
			throw new IllegalArgumentException("El alojamiento no puede ser nulo");
		}
		if(!(this.estado.equals(EstadosReserva.REALIZADA))) {
			throw new IllegalArgumentException(MENSAJEERROR);
		}
		this.alojamiento=alojamiento;
		this.fechaModificacion=LocalDate.now();
	}
	
	/**
	 * Metodo que devuelve el {@link Alojamiento.class} de la {@link Reserva.class}
	 * 
	 * @return el alojamiento asociado a la reserva
	 */
	public Alojamiento getAlojamiento() {
		return this.alojamiento;
	}
	
	/**
	 * Confirma la reserva{@link EstadosReserva.class#CONFIRMADA}
	 * 
	 * @throws IllegalArgumentException Si la {@link Reserva.class} no esta en{@link EstadoReserva.class#REALIZADA}
	 */
	public void confirmarReserva() {	
		if(!(this.estado.equals(EstadosReserva.REALIZADA))) {
			throw new IllegalArgumentException(MENSAJEERROR);
		}
		this.estado=EstadosReserva.CONFIRMADA;
		this.fechaModificacion=LocalDate.now();
	}
	
	/**
	 * Metodo para pagar la {@link Reserva.class} y pasa el estado a 
	 * {@link EstadosReserva.class#PAGADA}
	 * 
	 * @throws IllegalArgumentException Si la reserva no esta confirmada
	 */
	public void pagarReserva() {
		if(!(this.estado.equals(EstadosReserva.CONFIRMADA))) {
			throw new IllegalArgumentException(MENSAJEERROR);
		}
		this.estado=EstadosReserva.PAGADA;
		this.fechaModificacion=LocalDate.now();
	}
	
	/**
	 * Metodo que cancela la {@link Reserva.class}y pasa al estado
	 * {@link EstadosReserva.class#CANCELADA}
	 * 
	 * @throws IllegalArgumentException Si la reserva no esta confirmada
	 * @throws IllegalArgumentException Si la reserva no esta pagada
	 */
	public void cancelarReserva() {
		if(this.estado.equals(EstadosReserva.CONFIRMADA)|| (this.estado.equals(EstadosReserva.PAGADA))) {
			this.estado=EstadosReserva.CANCELADA;
			this.fechaModificacion=LocalDate.now();
		}else {
			throw new IllegalArgumentException("La Reserva debe estar pagada o confirmada");
		}
		
		
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
	public void setDni(String dni) {
		if(dni==null) {
			throw new IllegalArgumentException("El Dni no puede ser nulo");
		}
		if(dni.length()<9) {
			throw new IllegalArgumentException("El Dni no puede tener una longitud inferior a 9");
		}
		if(dni.length()>10) {
			throw new IllegalArgumentException("El Dni no puede tener una longitud superior a 10");
		}
		if(!compruebaLetraDni(dni)) {
			throw new IllegalArgumentException("La letra del Dni no es correcta");
		}
		this.dni=dni;
		this.fechaModificacion=LocalDate.now();
	}
	
	private boolean compruebaLetraDni(String dni) {
		String digitocontrol = "TRWAGMYFPDXBNJZSQVHLCKE";
		return dni.charAt(8) == digitocontrol.charAt(Integer.parseInt(dni.substring(0, 8)) % 23);
	}

	/**
	 * Metodo que devuelve el Dni{@link String.class} 
	 * de la persona que realizo la {@link Reserva.class} 
	 * 
	 * @return un String correspondiente al DNI
	 */
	public String getDni() {
		return this.dni;
	}
	
	/**
	 * Metodo que devuelve el estado{@link EstadosReserva.class} 
	 * en el que se encuentra la {@link Reserva.class}
	 * 
	 * 
	 * @return el estado de la reserva
	 */
	public EstadosReserva getEstado() {
		return this.estado;
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
		if(r==null) {
			throw new IllegalArgumentException("La reserva a comparar no puede ser nula");
		}
		if(this.fechaCreacion.isAfter(r.getFechaCreacion())) {
			return "anterior";
		}else if(this.fechaCreacion.isBefore(r.getFechaCreacion())) {
			return "posterior";
		}else{
			return "iguales";
		}
	}
	
	@Override
	public boolean equals(Object o) {
		// If the object is compared with itself then return true
				if (o == this) {
					return true;
				}

				/*
				 * Check if o is an instance of Complex or not "null instanceof [type]" also
				 * returns false
				 */
				if (!(o instanceof Reserva)) {
					return false;
				}

				Reserva reserva = (Reserva) o;

				return (this.id.equals(reserva.getId()));
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
}
