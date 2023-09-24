package tds.practica2;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 * 
 * @author vicbarr
 * @author enrmart
 *
 */
public class Gestor {
	
	/*Constructor de {@link Gestor.class} que creara un ArrayList de {@link Reserva.class}
	 * 
	 */
	public Gestor() {
		
	}
	
	/**Funcion para agregar Reservas no repetidas al gestor
	 * 
	 * @param r {@link Reserva.class} a annadir
	 * 
	 * @throws IllegalArgumentException Si la reserva es nula
	 * @throws IllegalArgumentException Si la reserva ya esta en el gestor
	 */
	public void añadirReserva(Reserva r) {
		
	}
	
	/**Elimina una {@link Reserva.class} existentes del {@link Gestor.class}
	 * 
	 * @param r {@link Reserva.class} a eliminar
	 * 
	 * @throws IllegalArgumentException Si la reserva es nula
	 * @throws IllegalArgumentException Si la reserva no pertence al gestor
	 */
	public void eliminarReserva(Reserva r) {
		
	}
	
	/** Devuelve el numero de {@link Reserva.class} en el {@link Gestor.class}
	 * 
	 * @return el numero de reservas
	 */
	public int getNumReservas(){
		return 0;
	}
	
	/**Devuelve la fecha de creacion de la {@link Reserva.class} mas reciente
	 * 
	 * @return la {@link LocalDate.class} correspondiente a la reserva mas reciente
	 * 
	 *  @throws IllegalStateException Si no hay ninguna reserva en el gestor
	 */
	public LocalDate getFechaReciente() {
		return null;
	}
	
	/**Devuelve la fecha de creacion de la {@link Reserva.class} mas antigua
	 * 
	 * @return la {@link LocalDate.class} correspondiente a la reserva mas antigua
	 * 
	 * @throws IllegalStateException Si no hay ninguna reserva en el gestor
	 */
	public LocalDate getFechaAntigua() {
		return null;
	}
	
	/**Devuelve las reservas asociadas a un DNI
	 * 
	 * @param DNI el Dni de la persona que tiene reservas aasociadas
	 * 
	 * @return un {@link ArrayList.class} de las reservas asociadas al DNI
	 * 
	 * @throws IllegalArgumentException Si el DNI es nulo
	 */
	public ArrayList<Reserva> getReservasDNI (String DNI){
		return null;
	}
	
	/**Devuelve las {@link Reserva.class} ordenadas cronologicamente
	 * en funcion de la fecha de creación
	 * 
	 * @return un {@link ArrayList.class} de las reservas ordenadas
	 */
	public ArrayList <Reserva> getReservasOrdenadas() {
		return null;
	}
	
	/**Devuelve las {@link Reserva.class} creadas en una fecha
	 * 
	 * @param fecha Un {@link LocalDate.class} que se corresponde con una fecha de creación 
	 * 
	 * @return un {@link ArrayList.class} de las reservas creadas en la fecha
	 * 
	 * @throws IllegalArgumentException Si la fecha es nula 
	 */
	public ArrayList <Reserva> getReservasFecha(LocalDate fecha) {
		return null;
	}
	
	/**Devuelve las {@link Reserva.class} creadas entre 2 fechas
	 * 
	 * @param fecha1 la {@link LocalDate.class} mas antigua de las reservas
	 * @param fecha2 la {@link LocalDate.class} mas reciente de las reservas
	 *  
	 * @return un {@link ArrayList.class} de las reservas ordenadas
	 * 
	 * @throws IllegalArgumentException Si la fecha1 es nula
	 * @throws IllegalArgumentException Si la fecha2 es nula
	 */
	public ArrayList <Reserva> getReservasFechas(LocalDate fecha1,LocalDate fecha2) {
		return null;
	}
	
	/**Devuelve las {@link Reserva.class} que tienen determinado {@link EstadosReserva.class}
	 * 
	 * @param estado Un {@link EstadosReserva.class} 
	 * 
	 * @return un {@link ArrayList.class} de las reservas que tienen ese estado
	 * 
	 * @throws IllegalArgumentException Si el {@link EstadosReserva.class} es nula
	 */
	public ArrayList <Reserva> getReservasEstado(EstadosReserva estado) {
		return null;
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
	public ArrayList <Reserva> getReservas(EstadosReserva estado,LocalDate fecha) {
		return null;
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
	 */
	public ArrayList <Reserva> getReservas(EstadosReserva estado,LocalDate fecha1,LocalDate fecha2) {
		return null;
	}
}
