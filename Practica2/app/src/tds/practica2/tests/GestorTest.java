package tds.practica2.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import tds.practica2.Alojamiento;
import tds.practica2.EstadosReserva;
import tds.practica2.Gestor;
import tds.practica2.Gps;
import tds.practica2.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author vicbarr
 * @author enrmart
 *
 */

class GestorTest {

	private Gestor gestor;
	private String dni1;
	private String dni2;
	private Alojamiento alojamiento3;
	private ArrayList<Reserva> lista;
	private Reserva r1;
	private Reserva r2;
	private Reserva r3;

	@BeforeEach
	void setUp() throws Exception {
		
		
		Gps c1=new Gps(0,0);
		Gps c2=new Gps(10,10);
		Gps c3=new Gps(20,20);
		
	
		Alojamiento alojamiento1=new Alojamiento("Id01","Carrion","Alojamiento comodo y asequible",c1);
		Alojamiento alojamiento2=new Alojamiento("Id02","Laguna","Alojamiento muy comodo y asequible",c2);
		alojamiento3=new Alojamiento("Id03","Paredes","Alojamiento bastante comodo y asequible",c3);

		dni1="34518605K";
		dni2="71992312N";
		
		r1=new Reserva("Reserva1",LocalDate.of(2022,1,1),alojamiento1,dni1);
		r2=new Reserva("Reserva2",LocalDate.of(2022,3,3),alojamiento2,dni2);
		r3=new Reserva("Reserva3",LocalDate.of(2022,2,2),alojamiento3,dni2);
		
		gestor=new Gestor();
		
		
		gestor.añadirReserva(r1);
		gestor.añadirReserva(r2);
		gestor.añadirReserva(r3);
		lista= new ArrayList<>();

	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="Correcto")
	@Test
	void testGestor() {
		gestor=new Gestor();
		assertNotNull(gestor);
	}
	
	@Tag(value="TDD")
	@Tag(value="Añadir")
	@Tag(value="Correcto")
	@Test
	void testAñadirReserva() {
		fail();
		assertTrue(gestor.getReservasDNI(dni1).contains(r1));
		assertTrue(gestor.getReservasDNI(dni2).contains(r2));
		assertTrue(gestor.getReservasDNI(dni2).contains(r3));
	}
	
	@Tag(value="TDD")
	@Tag(value="Añadir")
	@Tag(value="Null")
	@Test
	void testAñadirReservaNula() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.añadirReserva(null);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Añadir")
	@Tag(value="Error")
	@Test
	void testAñadirReservaExistente() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.añadirReserva(r1);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Eliminar")
	@Tag(value="Correcto")
	@Test
	void testEliminaReserva() {
		fail();
		gestor.eliminarReserva(r1);
		assertFalse(gestor.getReservasDNI(dni1).contains(r1));
	}
	
	@Tag(value="TDD")
	@Tag(value="Eliminar")
	@Tag(value="Null")
	@Test
	void testEliminaReservaNula() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.eliminarReserva(null);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Eliminar")
	@Tag(value="Error")
	@Test
	void testEliminaReservaNoExistente() {
		Reserva r4=new Reserva("Reserva4",LocalDate.of(2022,2,2),alojamiento3,dni2);
		assertThrows(IllegalArgumentException.class,()->{
			gestor.eliminarReserva(r4);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Contar")
	@Tag(value="Correcto")
	@Test
	void testGetNumReservas() {
		assertEquals(3,gestor.getNumReservas());
	}
	
	@Tag(value="TDD")
	@Tag(value="Reciente")
	@Tag(value="Correcto")
	@Test
	void testGetFechaReciente() {
		assertEquals(LocalDate.of(2022,3,3),gestor.getFechaReciente());
	}
	
	@Tag(value="TDD")
	@Tag(value="Reciente")
	@Tag(value="Error")
	@Test
	void testGetFechaRecienteGestorVacio() {
		gestor.eliminarReserva(r1);
		gestor.eliminarReserva(r2);
		gestor.eliminarReserva(r3);
		assertThrows(IllegalStateException.class,()->{
			gestor.getFechaReciente();
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Antigua")
	@Tag(value="Correcto")
	@Test
	void testGetFechaAntigua() {
		assertEquals(LocalDate.of(2022,1,1),gestor.getFechaAntigua());
	}
	
	@Tag(value="TDD")
	@Tag(value="Antigua")
	@Tag(value="Error")
	@Test
	void testGetFechaAntiguaGestorVacio() {
		gestor.eliminarReserva(r1);
		gestor.eliminarReserva(r2);
		gestor.eliminarReserva(r3);
		assertThrows(IllegalStateException.class,()->{
			gestor.getFechaReciente();
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="DNI")
	@Tag(value="Correcto")
	@Test
	void testGetReservasDni() {
		fail();
		assertTrue(gestor.getReservasDNI(dni2).contains(r2));
		assertTrue(gestor.getReservasDNI(dni1).contains(r3));
	}
	
	@Tag(value="TDD")
	@Tag(value="DNI")
	@Tag(value="Null")
	@Test
	void testGetReservasDniNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservasDNI(null);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Ordenadas")
	@Tag(value="Correcto")
	@Test
	void testGetReservasOrdenadas() {
		lista.add(r1);
		lista.add(r3);
		lista.add(r2);
		assertIterableEquals(gestor.getReservasOrdenadas(),lista);
	}
	
	@Tag(value="TDD")
	@Tag(value="Fecha")
	@Tag(value="Correcto")
	@Test
	void testGetReservasFecha() {
		fail();
		assertEquals(gestor.getReservasFecha(LocalDate.of(2022,3,3)).get(0),r2);
	}
	
	@Tag(value="TDD")
	@Tag(value="Reciente")
	@Tag(value="Null")
	@Test
	void testGetReservasFechaNula() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservasFecha(null);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Fechas")
	@Tag(value="Correcto")
	@Test
	void testGetReservasEntreFechas() {
		lista.add(r2);
		lista.add(r3);
		assertIterableEquals(gestor.getReservasFechas(LocalDate.of(2022,1,2),LocalDate.of(2022,4,4)),lista);
	}
	
	@Tag(value="TDD")
	@Tag(value="Fechas")
	@Tag(value="Null")
	@Test
	void testGetReservasEntreFechasFecha1Nula() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservasFechas(null,LocalDate.of(2022,4,4));
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Fechas")
	@Tag(value="Null")
	@Test
	void testGetReservasEntreFechasFecha2Nula() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservasFechas(LocalDate.of(2022,1,2),null);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Estado")
	@Tag(value="Correcto")
	@Test
	void testGetReservasEstado() {
		lista.add(r1);
		lista.add(r2);
		lista.add(r3);
		fail();
		assertTrue(gestor.getReservasEstado(EstadosReserva.REALIZADA).contains(r1));
		assertTrue(gestor.getReservasEstado(EstadosReserva.REALIZADA).contains(r2));
		assertTrue(gestor.getReservasEstado(EstadosReserva.REALIZADA).contains(r3));
	}
	
	@Tag(value="TDD")
	@Tag(value="Estado")
	@Tag(value="Null")
	@Test
	void testGetReservasEstadoNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservasEstado(null);
		});
	}
	@Tag(value="TDD")
	@Tag(value="EstadoFecha")
	@Tag(value="Correcto")
	@Test
	void testGetReservasEstadoFecha() {
		fail();
		assertTrue(gestor.getReservas(EstadosReserva.REALIZADA,LocalDate.of(2022,3,3)).contains(r2));
	}
	
	@Tag(value="TDD")
	@Tag(value="EstadoFecha")
	@Tag(value="Null")
	@Test
	void testGetReservasEstadoNuloFecha() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservas(null,LocalDate.of(2022,3,3));
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="EstadoFecha")
	@Tag(value="Null")
	@Test
	void testGetReservasEstadoFechaNula() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservas(EstadosReserva.REALIZADA,null);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="EstadoFechas")
	@Tag(value="Correcto")
	@Test
	void testGetReservasEstadoEntreFechas() {
		fail();
		assertTrue(gestor.getReservas(EstadosReserva.REALIZADA,LocalDate.of(2022,2,1),LocalDate.of(2022,5,5)).contains(r2));
		assertTrue(gestor.getReservas(EstadosReserva.REALIZADA,LocalDate.of(2022,2,1),LocalDate.of(2022,5,5)).contains(r3));
		assertEquals(2,gestor.getReservas(EstadosReserva.REALIZADA,LocalDate.of(2022,2,1),LocalDate.of(2022,5,5)).size());
	}
	
	@Tag(value="TDD")
	@Tag(value="EstadoFechas")
	@Tag(value="Null")
	@Test
	void testGetReservasEstadoentreFechasNula() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservas(null,LocalDate.of(2022,2,1),LocalDate.of(2022,5,5));
		});
	}
	
	
	@Tag(value="TDD")
	@Tag(value="EstadoFechas")
	@Tag(value="Null")
	@Test
	void testGetReservasEstadoentreFecha1Nula() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservas(EstadosReserva.REALIZADA,null,LocalDate.of(2022,5,5));
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="EstadoFechas")
	@Tag(value="Null")
	@Test
	void testGetReservasEstadoentreFecha2Nula() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservas(EstadosReserva.REALIZADA,LocalDate.of(2022,2,1),null);
		});
	}
	
	

}