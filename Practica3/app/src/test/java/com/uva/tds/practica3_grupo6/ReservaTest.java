package com.uva.tds.practica3_grupo6;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


class ReservaTest {
	
	private Alojamiento alojamiento;
	private String dni;
	private Reserva r;
	
	@BeforeEach
	void setUP() {
		Gps c=new Gps(24,56);
		alojamiento=new Alojamiento("Id01","Carrion","Alojamiento comodo y asequible",c);

		dni="34518605K";
		r=new Reserva("Reserva1",LocalDate.of(2021,12,25),alojamiento,dni);
	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="Valores Limites")
	@Tag(value ="Correcto")
	@Test
	void Constructor() {
		assertNotNull(r);
		assertEquals(EstadosReserva.REALIZADA,r.getEstado());
		assertEquals(r.getDni(),dni);
		assertEquals("Reserva1",r.getId());
		
	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="Valores Limites")
	@Tag(value="Limite Superior")
	@Tag(value ="Correcto")
	@Test
	void ConstructorMaximaLongitud() {
		r=new Reserva("Reserva1234",LocalDate.of(2021,12,25),alojamiento,dni);
		assertNotNull(r);
		assertEquals(r.getEstado(),EstadosReserva.REALIZADA);
		assertEquals(r.getDni(),dni);
		assertEquals(r.getId(),"Reserva1234");
		
	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="Valores Limites")
	@Tag(value="Limite Inferior")
	@Tag(value ="Correcto")
	@Test
	void ConstructorMinimaLongitud() {
		r=new Reserva("1",LocalDate.of(2021,12,25),alojamiento,dni);
		assertNotNull(r);
		assertEquals(r.getEstado(),EstadosReserva.REALIZADA);
		assertEquals(r.getDni(),dni);
		assertEquals(r.getId(),"1");
		
	}
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="id")
	@Tag(value ="Null")
	@Test
	void ConstructoridNull() {
		assertThrows(IllegalArgumentException.class,()->{
			r=new Reserva(null,LocalDate.of(2021,12,25),alojamiento,dni);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="id")
	@Tag(value="Error")
	@Test
	void ConstructoridVacio() {
		assertThrows(IllegalArgumentException.class,()->{
			r=new Reserva("",LocalDate.of(2021,12,25),alojamiento,dni);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="id")
	@Tag(value="Valores Limites")
	@Tag(value="Error")
	@Test
	void ConstructoridMayorLongitud() {
		assertThrows(IllegalArgumentException.class,()->{
			r=new Reserva("Reserva123123",LocalDate.of(2021,12,25),alojamiento,dni);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="Fecha")
	@Tag(value="Null")
	@Test
	void ConstructorFechaNull() {
		assertThrows(IllegalArgumentException.class,()->{
			r=new Reserva("Reserva1",null,alojamiento,dni);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Alojamiento")
	@Tag(value="Null")
	@Test
	void ConstructorAlojamientoNull() {
		assertThrows(IllegalArgumentException.class,()->{
			r=new Reserva("Reserva1",LocalDate.of(2021,12,25),null,dni);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="DNI")
	@Tag(value="Null")
	@Test
	void ConstructorDniNull() {
		assertThrows(IllegalArgumentException.class,()->{
			r=new Reserva("Reserva1",LocalDate.of(2021,12,25),alojamiento,null);
		});
	}
	
	@Tag(value = "Error")
	@Test
	void ConstructorDniLetraIncorrecta() {
		assertThrows(IllegalArgumentException.class,()->{
			r=new Reserva("Reserva1",LocalDate.now(),alojamiento,"34518605P");
		});
	}
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="DNI")
	@Tag(value="Error")
	@Test
	void ConstructorDniNoLetra() {
		assertThrows(IllegalArgumentException.class,()->{
			r=new Reserva("Reserva1",LocalDate.now(),alojamiento,"345186058");
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="DNI")
	@Tag(value="Error")
	@Test
	void ConstructorDniMasLetras() {
		assertThrows(IllegalArgumentException.class,()->{
			r=new Reserva("Reserva1",LocalDate.now(),alojamiento,"3451860PP");
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="DNI")
	@Tag(value="Valores Limites")
	@Tag(value="Error")
	@Test
	void ConstructorDniMenorLongitud() {
		assertThrows(IllegalArgumentException.class,()->{
			r=new Reserva("Reserva1",LocalDate.now(),alojamiento,"3451860P");
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="DNI")
	@Tag(value="Valores Limites")
	@Tag(value="Error")
	@Test
	void ConstructorDniMayorLongitud() {
		assertThrows(IllegalArgumentException.class,()->{
			r=new Reserva("Reserva1",LocalDate.now(),alojamiento,"345186068P");
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Fecha Modificacion")
	@Tag(value="Correcto")
	@Test
	void getFechaMod() {
		assertEquals(r.getFechaMod(),LocalDate.now());
	}
	
	@Tag(value="TDD")
	@Tag(value="Identificacion Reserva")
	@Tag(value="Correcto")
	@Test
	void getId() {
		assertEquals(r.getId(),"Reserva1");
	}
	
	@Tag(value="TDD")
	@Tag(value="Alojamiento")
	@Tag(value="Correcto")
	@Test
	void setAlojamiento() {
		Gps c=new Gps(24,56);
		Alojamiento alojamiento2=new Alojamiento("Id01","Carrion","Alojamiento comodo y asequible",c);
		r.setAlojamiento(alojamiento2);
		assertEquals(r.getAlojamiento().getId(),alojamiento2.getId());
		
	}
	
	@Tag(value="TDD")
	@Tag(value="Alojamiento")
	@Tag(value="Null")
	@Test
	void setAlojamientoNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			r.setAlojamiento(null);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Alojamiento")
	@Tag(value="Error")
	@Test
	void setAlojamientoReservaConfirmada() {
		r.confirmarReserva();
		assertThrows(IllegalArgumentException.class,()->{
			r.setAlojamiento(alojamiento);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Alojamiento")
	@Tag(value="Error")
	@Test
	void setAlojamientoReservaPagada() {
		r.confirmarReserva();
		r.pagarReserva();
		assertThrows(IllegalArgumentException.class,()->{
			r.setAlojamiento(alojamiento);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Alojamiento")
	@Tag(value="Error")
	@Test
	void setAlojamientoReservaCancelada() {
		r.confirmarReserva();
		r.cancelarReserva();
		assertThrows(IllegalArgumentException.class,()->{
			r.setAlojamiento(alojamiento);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Alojamiento")
	@Tag(value="Correcto")
	@Test
	void getAlojamiento() {
		assertEquals(r.getAlojamiento(),alojamiento);
	}
	
	@Tag(value="TDD")
	@Tag(value="DNI")
	@Tag(value="Error")
	@Test
	void setDniReservaConfirmada() {
		r.confirmarReserva();
		assertThrows(IllegalArgumentException.class,()->{
			r.setDni("");
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="DNI")
	@Tag(value="Error")
	@Test
	void setDniReservaPagada() {
		r.confirmarReserva();
		r.pagarReserva();
		assertThrows(IllegalArgumentException.class,()->{
			r.setDni("");
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="DNI")
	@Tag(value="Error")
	@Test
	void setDniReservaCancelada() {
		r.confirmarReserva();
		r.cancelarReserva();
		assertThrows(IllegalArgumentException.class,()->{
			r.setDni("");
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="DNI")
	@Tag(value="Null")
	@Test
	void setDniNulo() {
		assertThrows(IllegalArgumentException.class,()->{
			r.setDni(null);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="DNI")
	@Tag(value="Valores Limite")
	@Tag(value = "Error")
	@Test
	void setDniIncorrectoMenorLongitud() {
		assertThrows(IllegalArgumentException.class,()->{
			r.setDni("3451860P");
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="DNI")
	@Tag(value="Valores Limite")
	@Tag(value ="Error")
	@Test
	void setDniIncorrectoMayorLongitud() {
		assertThrows(IllegalArgumentException.class,()->{
			r.setDni("3451860048P");
		});
	}
	@Tag(value="TDD")
	@Tag(value="DNI")
	@Tag(value = "Error")
	@Test
	void setDniIncorrectoMasLetras() {
		assertThrows(IllegalArgumentException.class,()->{
			r.setDni("3451860PP");
		});
	}
	@Tag(value="TDD")
	@Tag(value="DNI")
	@Tag(value = "Error")
	@Test
	void setDniIncorrectoNoLetras() {
		assertThrows(IllegalArgumentException.class,()->{
			r.setDni("345186089");
		});
	}
	@Tag(value="TDD")
	@Tag(value="DNI")
	@Tag(value = "Error")
	@Test
	void setDniLetraIncorrecta() {
		assertThrows(IllegalArgumentException.class,()->{
			r.setDni("34518605P");
		});
	}
	@Tag(value="TDD")
	@Tag(value="DNI")
	@Tag(value="Correcto")
	@Test
	void getDni() {
		assertEquals(r.getDni(),dni);
	}
	
	@Tag(value="TDD")
	@Tag(value="Confirmar")
	@Tag(value = "Correcto")
	@Test
	void ConfirmarReserva() {
		r.confirmarReserva();
		assertEquals(r.getEstado(),EstadosReserva.CONFIRMADA);
		assertEquals(r.getFechaMod(),LocalDate.now());	
	}
	
	@Tag(value="TDD")
	@Tag(value="Confirmar")
	@Tag(value ="Error")
	@Test
	void PagarReservaSinRealizar() {
		r.confirmarReserva();
		r.pagarReserva();
		assertThrows(IllegalArgumentException.class,()->{
			r.confirmarReserva();
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Pagar")
	@Tag(value = "Correcto")
	@Test
	void PagarReserva() {
		r.confirmarReserva();
		r.pagarReserva();
		assertEquals(r.getEstado(),EstadosReserva.PAGADA);
		assertEquals(r.getFechaMod(),LocalDate.now());
	}
	
	@Tag(value="TDD")
	@Tag(value="Pagar")
	@Tag(value ="Error")
	@Test
	void PagarReservaSinConfirmar() {
		assertThrows(IllegalArgumentException.class,()->{
			r.pagarReserva();
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Cancelar")
	@Tag(value="Elementos conjunto")
	@Tag(value = "Correcto")
	@Test
	void CancelarReservaConfirmada() {
		r.confirmarReserva();
		r.cancelarReserva();
		assertEquals(r.getEstado(),EstadosReserva.CANCELADA);
		assertEquals(r.getFechaMod(),LocalDate.now());
	}
	
	@Tag(value="TDD")
	@Tag(value="Cancelar")
	@Tag(value="Elementos conjunto")
	@Tag(value = "Correcto")
	@Test
	void CancelarReservaPagada() {
		r.confirmarReserva();
		r.pagarReserva();
		r.cancelarReserva();
		assertEquals(r.getEstado(),EstadosReserva.CANCELADA);
		assertEquals(r.getFechaMod(),LocalDate.now());
	}
	
	@Tag(value="TDD")
	@Tag(value="Cancelar")
	@Tag(value="Elementos conjunto")
	@Tag(value ="Error")
	@Test
	void CancelarReservaFallo() {
		assertThrows(IllegalArgumentException.class,()->{
			r.cancelarReserva();
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Comparar")
	@Tag(value="Elementos conjunto")
	@Tag(value = "Correcto")
	@Test
	void comparaReservaAnterior() {
		Reserva r2= new Reserva("Reserva2",LocalDate.of(2020, 3, 5),alojamiento,dni);
		r.comparaReserva(r2);
		assertEquals(r.comparaReserva(r2),"anterior");
	}
	
	@Tag(value="TDD")
	@Tag(value="Comparar")
	@Tag(value="Elementos conjunto")
	@Tag(value = "Correcto")
	@Test
	void comparaReservaPosterior() {
		Reserva r2= new Reserva("Reserva2",LocalDate.now(),alojamiento,dni);
		r.comparaReserva(r2);
		assertEquals(r.comparaReserva(r2),"posterior");
	}
	
	@Tag(value="TDD")
	@Tag(value="Comparar")
	@Tag(value="Elementos conjunto")
	@Tag(value = "Correcto")
	@Test
	void comparaReservaIguales() {
		Reserva r2= new Reserva("Reserva 2",LocalDate.of(2021,12,25),alojamiento,dni);
		assertEquals(r.comparaReserva(r2),"iguales");
	}
	
	@Tag(value="TDD")
	@Tag(value="Comparar")
	@Tag(value="Elementos conjunto")
	@Tag(value ="Error")
	@Test
	void comparaReservaNula() {
		assertThrows(IllegalArgumentException.class,()->{
			r.comparaReserva(null);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Equals")
	@Tag(value ="True")
	@Test
	void equalsTrue() {
		Reserva r2= new Reserva("Reserva1",LocalDate.of(2021,12,25),alojamiento,dni);
		assertTrue(r.equals(r2));
	}
	
	@Tag(value="TDD")
	@Tag(value="Equals")
	@Tag(value ="True")
	@Test
	void equalsTrueMismaReserva() {
		assertTrue(r.equals(r));
	}
	
	@Tag(value="TDD")
	@Tag(value="Equals")
	@Tag(value ="False")
	@Test
	void equalsFalse() {
		Reserva r2= new Reserva("Reserva2",LocalDate.of(2021,12,25),alojamiento,dni);
		assertFalse(r.equals(r2));
	}
	
	@Tag(value="TDD")
	@Tag(value="Equals")
	@Tag(value ="False")
	@Test
	void equalsFalseNoInstance() {
		assertFalse(r.equals(alojamiento));
	}
}
