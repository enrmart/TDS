package com.uva.tds.practica3_grupo6;

import static org.junit.jupiter.api.Assertions.*;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
	private Reserva r1;
	private Reserva r2;
	private Reserva r3;
	IDatabaseManager database;
	
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
		
		database = EasyMock.mock(IDatabaseManager.class);
		gestor=new Gestor(database);
		

	}
	
	@Tag(value="Isolation")
	@Tag(value="Constructor")
	@Tag(value="Correcto")
	@Test
	void testGestor() {
		assertNotNull(gestor);
		EasyMock.expect(database.getByStateAndDates(null, null, null)).andReturn(new ArrayList<Reserva>()).times(1);
		EasyMock.replay(database);
		assertEquals(0, gestor.getNumReservas());
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Annadir")
	@Tag(value="Correcto")
	@Test
	void testAñadirReserva() {
		database.add(r1);
		EasyMock.expectLastCall().andVoid().times(1);
		ArrayList<Reserva> reservas1=new ArrayList<>();
		reservas1.add(r1);
		EasyMock.expect(database.getByDNI(dni1)).andReturn(reservas1).times(1);
		EasyMock.replay(database);
		gestor.annadirReserva(r1);
		assertIterableEquals(reservas1, gestor.getReservasDNI(dni1));
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Annadir")
	@Tag(value="Null")
	@Test
	void testAñadirReservaNula() {
		database.add(null);
		EasyMock.expectLastCall().andThrow(new IllegalArgumentException());
		EasyMock.replay(database);
		assertThrows(IllegalArgumentException.class,()->{
			gestor.annadirReserva(null);
		});
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Annadir")
	@Tag(value="Error")
	@Test
	void testAñadirReservaExistente() {
		database.add(r1);
		EasyMock.expectLastCall().andVoid().times(1);
		ArrayList<Reserva> reservas1=new ArrayList<>();
		reservas1.add(r1);
		database.add(r1);
		EasyMock.expectLastCall().andThrow(new IllegalStateException());
		EasyMock.replay(database);
		gestor.annadirReserva(r1);
		assertThrows(IllegalStateException.class,()->{
			gestor.annadirReserva(r1);
		});
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Eliminar")
	@Tag(value="Correcto")
	@Test
	void testEliminaReserva() {
		database.add(r1);
		EasyMock.expectLastCall().andVoid().times(1);
		ArrayList<Reserva> reservas1=new ArrayList<>();
		reservas1.add(r1);
		database.remove(r1);
		reservas1.remove(r1);
		EasyMock.expectLastCall().andVoid().times(1);
		EasyMock.expect(database.getByDNI(dni1)).andReturn(reservas1).times(1);
		EasyMock.replay(database);
		gestor.annadirReserva(r1);
		gestor.eliminarReserva(r1);
		assertIterableEquals(reservas1, gestor.getReservasDNI(dni1));
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Eliminar")
	@Tag(value="Null")
	@Test
	void testEliminaReservaNula() {
		database.remove(null);
		EasyMock.expectLastCall().andThrow(new IllegalArgumentException());
		EasyMock.replay(database);
		assertThrows(IllegalArgumentException.class,()->{
			gestor.eliminarReserva(null);
		});
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Eliminar")
	@Tag(value="Error")
	@Test
	void testEliminaReservaNoExistente() {
		database.remove(r1);
		EasyMock.expectLastCall().andThrow(new IllegalStateException());
		EasyMock.replay(database);
		assertThrows(IllegalStateException.class,()->{
			gestor.eliminarReserva(r1);
		});
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Contar")
	@Tag(value="Correcto")
	@Test
	void testGetNumReservas() {
		EasyMock.expect(database.getByStateAndDates(null, null, null)).andReturn(new ArrayList<Reserva>()).times(1);
		EasyMock.replay(database);
		assertEquals(0, gestor.getNumReservas());
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Reciente")
	@Tag(value="Correcto")
	@Test
	void testGetFechaReciente() {
		database.add(r1);
		EasyMock.expectLastCall().andVoid().times(1);
		ArrayList<Reserva> reservas1=new ArrayList<>();
		reservas1.add(r1);
		EasyMock.expect(database.getByStateAndDates(null,null,null)).andReturn(reservas1).times(2);
		EasyMock.replay(database);
		gestor.annadirReserva(r1);
		assertEquals(r1.getFechaCreacion(), gestor.getFechaReciente());
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Reciente")
	@Tag(value="Error")
	@Test
	void testGetFechaRecienteGestorVacio() {
		EasyMock.expect(database.getByStateAndDates(null,null,null)).andReturn(new ArrayList<Reserva>()).times(1);
		EasyMock.replay(database);
		assertThrows(IllegalStateException.class,()->{
			gestor.getFechaReciente();
		});
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Antigua")
	@Tag(value="Correcto")
	@Test
	void testGetFechaAntigua() {
		database.add(r1);
		EasyMock.expectLastCall().andVoid().times(1);
		ArrayList<Reserva> reservas1=new ArrayList<>();
		reservas1.add(r1);
		EasyMock.expect(database.getByStateAndDates(null,null,null)).andReturn(reservas1).times(2);
		EasyMock.replay(database);
		gestor.annadirReserva(r1);
		assertEquals(r1.getFechaCreacion(), gestor.getFechaAntigua());
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Antigua")
	@Tag(value="Error")
	@Test
	void testGetFechaAntiguaGestorVacio() {
		EasyMock.expect(database.getByStateAndDates(null,null,null)).andReturn(new ArrayList<Reserva>()).times(1);
		EasyMock.replay(database);
		assertThrows(IllegalStateException.class,()->{
			gestor.getFechaAntigua();
		});
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="DNI")
	@Tag(value="Correcto")
	@Test
	void testGetReservasDni() {
		database.add(r2);
		EasyMock.expectLastCall().andVoid().times(1);
		ArrayList<Reserva> reservas1=new ArrayList<>();
		reservas1.add(r2);
		database.add(r3);
		EasyMock.expectLastCall().andVoid().times(1);
		reservas1.add(r3);
		EasyMock.expect(database.getByDNI(dni2)).andReturn(reservas1).times(1);
		EasyMock.replay(database);
		gestor.annadirReserva(r2);
		gestor.annadirReserva(r3);
		assertIterableEquals(reservas1, gestor.getReservasDNI(dni2));
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="DNI")
	@Tag(value="Null")
	@Test
	void testGetReservasDniNulo() {
		database.getByDNI(null);
		EasyMock.expectLastCall().andThrow(new IllegalArgumentException());
		EasyMock.replay(database);		
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservasDNI(null);
		});
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Ordenadas")
	@Tag(value="Correcto")
	@Test
	void testGetReservasOrdenadas() {
		database.add(r2);
		EasyMock.expectLastCall().andVoid().times(1);
		ArrayList<Reserva> reservas1=new ArrayList<>();
		reservas1.add(r2);
		database.add(r3);
		EasyMock.expectLastCall().andVoid().times(1);
		reservas1.add(r3);
		database.add(r1);
		EasyMock.expectLastCall().andVoid().times(1);
		reservas1.add(r1);
		EasyMock.expect(database.getByStateAndDates(null, null, null)).andReturn(reservas1).times(1);
		EasyMock.replay(database);
		ArrayList<Reserva>lista=new ArrayList<>();
		lista.add(r1);
		lista.add(r3);
		lista.add(r2);
		gestor.annadirReserva(r2);
		gestor.annadirReserva(r3);
		gestor.annadirReserva(r1);
		assertIterableEquals(lista, gestor.getReservasOrdenadas());
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Fecha")
	@Tag(value="Correcto")
	@Test
	void testGetReservasFecha() {
		database.add(r2);
		EasyMock.expectLastCall().andVoid().times(1);
		ArrayList<Reserva> reservas1=new ArrayList<>();
		reservas1.add(r2);
		EasyMock.expect(database.getByStateAndDates(null, LocalDate.of(2022,3,3), LocalDate.of(2022,3,3))).andReturn(reservas1).times(1);
		EasyMock.replay(database);
		gestor.annadirReserva(r2);
		assertEquals(gestor.getReservasFecha(LocalDate.of(2022,3,3)).get(0),r2);
		EasyMock.verify(database);
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
	
	@Tag(value="Isolation")
	@Tag(value="Fechas")
	@Tag(value="Correcto")
	@Test
	void testGetReservasEntreFechas() {
		database.add(r2);
		EasyMock.expectLastCall().andVoid().times(1);
		ArrayList<Reserva> reservas1=new ArrayList<>();
		reservas1.add(r2);
		database.add(r3);
		EasyMock.expectLastCall().andVoid().times(1);
		reservas1.add(r3);
		database.add(r1);
		EasyMock.expectLastCall().andVoid().times(1);
		reservas1.add(r1);
		EasyMock.expect(database.getByStateAndDates(null,LocalDate.of(2022,1,1), LocalDate.of(2022,3,3))).andReturn(reservas1).times(1);
		EasyMock.replay(database);
		gestor.annadirReserva(r2);
		gestor.annadirReserva(r3);
		gestor.annadirReserva(r1);
		assertIterableEquals(reservas1, gestor.getReservasFechas(LocalDate.of(2022,1,1), LocalDate.of(2022,3,3)));
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Fechas")
	@Tag(value="Null")
	@Test
	void testGetReservasEntreFechasFecha1Nula() {
		database.getByStateAndDates(null,null,LocalDate.of(2022,4,4));
		EasyMock.expectLastCall().andThrow(new IllegalArgumentException());
		EasyMock.replay(database);
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservasFechas(null,LocalDate.of(2022,4,4));
		});
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Fechas")
	@Tag(value="Null")
	@Test
	void testGetReservasEntreFechasFecha2Nula() {
		database.getByStateAndDates(null,LocalDate.of(2022,4,4),null);
		EasyMock.expectLastCall().andThrow(new IllegalArgumentException());
		EasyMock.replay(database);
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservasFechas(LocalDate.of(2022,4,4),null);
		});
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="Estado")
	@Tag(value="Correcto")
	@Test
	void testGetReservasEstado() {
		database.add(r1);
		EasyMock.expectLastCall().andVoid().times(1);
		ArrayList<Reserva> reservas1=new ArrayList<>();
		reservas1.add(r1);
		EasyMock.expect(database.getByStateAndDates(EstadosReserva.REALIZADA,null,null)).andReturn(reservas1).times(1);
		EasyMock.replay(database);
		gestor.annadirReserva(r1);
		assertIterableEquals(reservas1, gestor.getReservasEstado(EstadosReserva.REALIZADA));
		EasyMock.verify(database);
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
	@Tag(value="Isolation")
	@Tag(value="EstadoFecha")
	@Tag(value="Correcto")
	@Test
	void testGetReservasEstadoFecha() {
		database.add(r2);
		EasyMock.expectLastCall().andVoid().times(1);
		ArrayList<Reserva> reservas1=new ArrayList<>();
		reservas1.add(r2);
		EasyMock.expect(database.getByStateAndDates(EstadosReserva.REALIZADA,LocalDate.of(2022,3,3),LocalDate.of(2022,3,3))).andReturn(reservas1).times(1);
		EasyMock.replay(database);
		gestor.annadirReserva(r2);
		assertIterableEquals(reservas1,gestor.getReservas(EstadosReserva.REALIZADA,LocalDate.of(2022,3,3)));
		EasyMock.verify(database);
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
	
	@Tag(value="Isolation")
	@Tag(value="EstadoFechas")
	@Tag(value="Correcto")
	@Test
	void testGetReservasEstadoEntreFechas() {
		database.add(r1);
		EasyMock.expectLastCall().andVoid().times(1);
		ArrayList<Reserva> reservas1=new ArrayList<>();
		reservas1.add(r1);
		EasyMock.expect(database.getByStateAndDates(EstadosReserva.REALIZADA,LocalDate.of(2022,2,1),LocalDate.of(2022,5,5))).andReturn(reservas1).times(1);
		EasyMock.replay(database);
		gestor.annadirReserva(r1);
		assertIterableEquals(reservas1, gestor.getReservas(EstadosReserva.REALIZADA,LocalDate.of(2022,2,1),LocalDate.of(2022,5,5)));
		EasyMock.verify(database);
	}
	
	@Tag(value="TDD")
	@Tag(value="EstadoFechas")
	@Tag(value="Null")
	@Test
	void testGetReservasEstadoNuloentreFechas() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservas(null,LocalDate.of(2022,2,1),LocalDate.of(2022,5,5));
		});
	}
	
	
	@Tag(value="Isolation")
	@Tag(value="EstadoFechas")
	@Tag(value="Null")
	@Test
	void testGetReservasEstadoentreFecha1Nula() {
		database.getByStateAndDates(EstadosReserva.REALIZADA,null,LocalDate.of(2022,5,5));
		EasyMock.expectLastCall().andThrow(new IllegalArgumentException());
		EasyMock.replay(database);
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservas(EstadosReserva.REALIZADA,null,LocalDate.of(2022,5,5));
		});
		EasyMock.verify(database);
	}
	
	@Tag(value="Isolation")
	@Tag(value="EstadoFechas")
	@Tag(value="Null")
	@Test
	void testGetReservasEstadoentreFecha2Nula() {
		database.getByStateAndDates(EstadosReserva.REALIZADA,LocalDate.of(2022,2,1),null);
		EasyMock.expectLastCall().andThrow(new IllegalArgumentException());
		EasyMock.replay(database);
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservas(EstadosReserva.REALIZADA,LocalDate.of(2022,2,1),null);
		});
		EasyMock.verify(database);
	}
	
	@Tag(value="TDD")
	@Tag(value="EstadoFechas")
	@Tag(value="Null")
	@Test
	void testGetReservasEstadoentreFechasNulas() {
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservas(EstadosReserva.REALIZADA,null,null);
		});
	}
	
	
	@Tag(value="Isolation")
	@Tag(value="EstadoFechas")
	@Tag(value="Fecha1Mayor")
	@Test
	void testGetReservasEstadoFecha1Mayor() {
		database.getByStateAndDates(EstadosReserva.REALIZADA,LocalDate.of(2022,5,5),LocalDate.of(2022,2,1));
		EasyMock.expectLastCall().andThrow(new IllegalArgumentException());
		EasyMock.replay(database);
		assertThrows(IllegalArgumentException.class,()->{
			gestor.getReservas(EstadosReserva.REALIZADA,LocalDate.of(2022,5,5),LocalDate.of(2022,2,1));
		});
		EasyMock.verify(database);
	}
}