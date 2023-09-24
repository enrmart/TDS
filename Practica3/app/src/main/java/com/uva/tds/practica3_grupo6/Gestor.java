package com.uva.tds.practica3_grupo6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author vicbarr
 * @author enrmart
 *
 */
public class Gestor {
	
	private IDatabaseManager iDataBase;
	
	/**
	 * Constructor de {@link Gestor.class} que creara un ArrayList de {@link Reserva.class}
	 * 
	 * @param iDataBase MockObject de {@link IDatabaseManager.class}
	 */
	public Gestor(IDatabaseManager iDataBase) {
		setIDatabaseManager(iDataBase);
		
	}
	
	private void setIDatabaseManager(IDatabaseManager iDataBase) {
		this.iDataBase = iDataBase;
	}


	/**Funcion para agregar Reservas no repetidas al gestor
	 * 
	 * @param r {@link Reserva.class} a annadir
	 * 
	 * @throws IllegalArgumentException Si la reserva es nula
	 * @throws IllegalArgumentException Si la reserva ya esta en el gestor
	 */
	public void annadirReserva(Reserva r) {
		try {iDataBase.add(r);}
		catch(IllegalArgumentException e1) {throw e1;}
		catch(IllegalStateException e2) {throw e2;}
		
	}
	
	/**Elimina una {@link Reserva.class} existentes del {@link Gestor.class}
	 * 
	 * @param r {@link Reserva.class} a eliminar
	 * 
	 * @throws IllegalArgumentException Si la reserva es nula
	 * @throws IllegalArgumentException Si la reserva no pertence al gestor
	 */
	public void eliminarReserva(Reserva r) {
		try {iDataBase.remove(r);}
		catch(IllegalArgumentException e1) {throw e1;}
		catch(IllegalStateException e2) {throw e2;}
	}
	
	/** Devuelve el numero de {@link Reserva.class} en el {@link Gestor.class}
	 * 
	 * @return el numero de reservas
	 */
	public int getNumReservas(){
		return iDataBase.getByStateAndDates(null, null, null).size();
	}
	
	/**Devuelve la fecha de creacion de la {@link Reserva.class} mas reciente
	 * 
	 * @return la {@link LocalDate.class} correspondiente a la reserva mas reciente
	 * 
	 *  @throws IllegalStateException Si no hay ninguna reserva en el gestor
	 */
	public LocalDate getFechaReciente() {
		if(iDataBase.getByStateAndDates(null,null, null).isEmpty()) {
			throw new IllegalStateException("No hay ninguna reserva en el gestor");
		}
		List<Reserva>reservas=this.getReservasOrdenadas();
		return reservas.get(0).getFechaCreacion();
	}
	
	/**Devuelve la fecha de creacion de la {@link Reserva.class} mas antigua
	 * 
	 * @return la {@link LocalDate.class} correspondiente a la reserva mas antigua
	 * 
	 * @throws IllegalStateException Si no hay ninguna reserva en el gestor
	 */
	public LocalDate getFechaAntigua() {
		if(iDataBase.getByStateAndDates(null,null, null).isEmpty()) {
			throw new IllegalStateException("No hay ninguna reserva en el gestor");
		}
		List<Reserva>reservas=this.getReservasOrdenadas();
		int ultimapos=reservas.size()-1;
		return reservas.get(ultimapos).getFechaCreacion();
		
	}
	
	/**Devuelve las reservas asociadas a un DNI, 
	 * si no hay ninguna se devuelve null
	 * 
	 * @param dni el Dni de la persona que tiene reservas aasociadas
	 * 
	 * @return un {@link ArrayList.class} de las reservas asociadas al DNI
	 * 
	 * @throws IllegalArgumentException Si el DNI es nulo
	 */
	public List<Reserva> getReservasDNI (String dni)throws IllegalArgumentException{
		return iDataBase.getByDNI(dni);
	}
	
	/**Devuelve las {@link Reserva.class} ordenadas cronologicamente
	 * en funcion de la fecha de creación
	 * 
	 * @return un {@link ArrayList.class} de las reservas ordenadas
	 */
	public List <Reserva> getReservasOrdenadas() {
		ArrayList<Reserva> reservas=iDataBase.getByStateAndDates(null, null, null);
		reservas.sort((d1,d2) -> d1.getFechaCreacion().compareTo(d2.getFechaCreacion()));
		return reservas;
	}
	
	/**Devuelve las {@link Reserva.class} creadas en una fecha
	 * 
	 * @param fecha Un {@link LocalDate.class} que se corresponde con una fecha de creación 
	 * 
	 * @return un {@link ArrayList.class} de las reservas creadas en la fecha
	 * 
	 * @throws IllegalArgumentException Si la fecha es nula 
	 */
	public List <Reserva> getReservasFecha(LocalDate fecha) {
		if(fecha==null) {
			throw new IllegalArgumentException("La fecha no puede ser nula");
		}
		return iDataBase.getByStateAndDates(null, fecha, fecha);
	}
	
	/**Devuelve las {@link Reserva.class} creadas entre 2 fechas
	 * 
	 * @param fecha1 la {@link LocalDate.class} mas antigua de las reservas
	 * @param fecha2 la {@link LocalDate.class} mas reciente de las reservas
	 *  
	 * @return un {@link ArrayList.class} de las reservas ordenadas
	 * 
	 * @throws IllegalArgumentException Si la fecha1 es nula y la fecha 2 no 
	 * @throws IllegalArgumentException Si la fecha2 es nula y la fecha 1 no 
	 */
	public List <Reserva> getReservasFechas(LocalDate fecha1,LocalDate fecha2) {
		return iDataBase.getByStateAndDates(null, fecha1, fecha2);
	}
	
	/**Devuelve las {@link Reserva.class} que tienen determinado {@link EstadosReserva.class}
	 * 
	 * @param estado Un {@link EstadosReserva.class} 
	 * 
	 * @return un {@link ArrayList.class} de las reservas que tienen ese estado
	 * 
	 * @throws IllegalArgumentException Si el {@link EstadosReserva.class} es nula
	 */
	public List <Reserva> getReservasEstado(EstadosReserva estado) {
		if(estado==null) {
			throw new IllegalArgumentException("El estado no puede ser nulo");
		}
		return  iDataBase.getByStateAndDates(estado, null, null);
	}
	
	/**Devuelve las {@link Reserva.class} que tienen determinado {@link EstadosReserva.class}
	 * y fueron creadas en determinada fecha
	 * 
	 * @param estado Un {@link EstadosReserva.class}
	 * @param fecha Un {@link LocalDate.class} que se corresponde con la fecha de creacion
	 * 
	 * @return un {@link ArrayList.class} de las reservas que tienen ese estado y esa fecha de creacion
	 * 
	 * @throws IllegalArgumentException Si el {@link EstadosReserva.class} es nula
	 * @throws IllegalArgumentException Si la fecha es nula
	 */
	public List <Reserva> getReservas(EstadosReserva estado,LocalDate fecha) {
		if(estado==null) {
			throw new IllegalArgumentException("El estado no puede ser nulo");
		}
		if(fecha==null) {
			throw new IllegalArgumentException("La fecha no puede ser nula");
		}
		return iDataBase.getByStateAndDates(estado, fecha, fecha);
	}
	
	/**Devuelve las {@link Reserva.class} que tienen determinado {@link EstadosReserva.class}
	 * y fueron creadas entre 2 fechas
	 * 
	 * @param estado Un {@link EstadosReserva.class}
	 * @param fecha1 la {@link LocalDate.class} mas antigua de las reservas
	 * @param fecha2 la {@link LocalDate.class} mas reciente de las reservas
	 * 
	 * @return un {@link ArrayList.class} de las reservas que tienen ese estado y estan entre fecha1 y fehca2
	 * 
	 * @throws IllegalArgumentException Si el {@link EstadosReserva.class} es nula
	 * @throws IllegalArgumentException Si la fecha1 es nula
	 * @throws IllegalArgumentException Si la fecha2 es nula
	 * @throws IllegalArgumentException Si la fecha 1 y la fecha2 son nulas
	 */
	public List <Reserva> getReservas(EstadosReserva estado,LocalDate fecha1,LocalDate fecha2) {
		if(estado==null) {
			throw new IllegalArgumentException("El estado no puede ser nulo");
		}
		if(fecha1==null && fecha2==null) {
			throw new IllegalArgumentException("La fecha1 y la fecha2 no pueden ser nulas al mismo tiempo");		
		}
		return iDataBase.getByStateAndDates(estado, fecha1, fecha2);
	}
}
