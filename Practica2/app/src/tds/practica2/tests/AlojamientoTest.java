package tds.practica2.tests;




import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tds.practica2.Alojamiento;
import tds.practica2.Gps;

class AlojamientoTest {
	
	private Gps c;
	private Alojamiento a;
	
	@BeforeEach
	void setUp() throws Exception {
		c=new Gps(24,56);	//duda si hay que usar mock 
		a=new Alojamiento("Id01","Carrion","Alojamiento comodo y asequible",c);
		
	}

	@Test
	void construccionAlojamientoCorrecta() {
		assertNotNull(a);
	}
	
	@Test
	void setIdCorrecto() {
		a.setId("Id02");
		assertEquals("Id02",a.getId());
	}
	
	
	@Test
	void setIdIncorrectoMenor() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setId("");
		});

	}
	
	
	@Test
	void setIdIncorrectoNull() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setId(null);
		});

	}
	
	@Test
	void setIdIncorrectoMayor() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setId("Identificador123");
		});

	}
	
	
	
	
	@Test
	void setNombreCorrecto() {
		a.setNombre("Celta");
		assertEquals("Celta",a.getNombre());
	}
	
	@Test
	void setNombreIncorrectoNull() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setNombre(null);
		});

	}
	
	@Test
	void setIdIncorrectoMenorVacio() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setNombre("");
		});

	}
	
	
	@Test
	void setDescripcionCorrecta() {
		a.setDescripcion("Muy buen servicio");
		assertEquals("Muy buen servicio",a.getDescripcion());
	}
	
	@Test
	void setDescripcionIncorrectaNull() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setDescripcion(null);
		});

	}
	
	@Test
	void setDescripcionIncorrectaMenorVacio() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setDescripcion("");
		});

	}
	
	@Test
	void setCoordenadaCorrecta() {
		a.setCoordenada(new Gps(0,0));
		assertEquals(new Gps(0,0),a.getCoordenada());
	}
	

	
	@Test
	void setCoordenadaIncorrectaNull() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setCoordenada(null);
		});

	}
	
	

}

