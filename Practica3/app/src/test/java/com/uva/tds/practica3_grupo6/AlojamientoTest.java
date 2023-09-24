package com.uva.tds.practica3_grupo6;




import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author enrmart
 * @author vicbarr
 *
 */
class AlojamientoTest {
	
	private Gps c;
	private Alojamiento a;
	
	@BeforeEach
	void setUp() throws Exception {
		c=new Gps(24,56);	//duda si hay que usar mock 
		a=new Alojamiento("Id01","Carrion","Alojamiento comodo y asequible",c);
		
	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="Correcto")
	@Test
	void construccionAlojamientoCorrecta() {
		assertNotNull(a);
		assertEquals(a.getCoordenada(),c);
		assertEquals(a.getDescripcion(),"Alojamiento comodo y asequible");
		assertEquals(a.getId(),"Id01");
		assertEquals(a.getNombre(),"Carrion");
	}
	
	@Tag(value="TDD")
	@Tag(value="Identificador")
	@Tag(value="Correcto")
	@Test
	void setId() {
		a.setId("Id02");
		assertEquals("Id02",a.getId());
	}
	
	@Tag(value="TDD")
	@Tag(value="Identificador")
	@Tag(value="Minima Longitud")
	@Test
	void setIdMinimaLongitud() {
		a.setId("I");
		assertEquals("I",a.getId());
	}
	
	@Tag(value="TDD")
	@Tag(value="Identificador")
	@Tag(value="Maxima Longitud")
	@Test
	void setIdCorrectoMaximaLongitud() {
		a.setId("Id0234567892345");
		assertEquals("Id0234567892345",a.getId());
	}
	
	@Tag(value="TDD")
	@Tag(value="Identificador")
	@Tag(value="Error")
	@Test
	void setIdIncorrectoMenorLongitud() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setId("");
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Identificador")
	@Tag(value="Error")
	@Test
	void setIdIncorrectoMayorLongitud() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setId("Identificador123");
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Identificador")
	@Tag(value="Nulo")
	@Test
	void setIdIncorrectoNull() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setId(null);
		});

	}
	
	@Tag(value="TDD")
	@Tag(value="Nombre")
	@Tag(value="Correcto")
	@Test
	void setNombre() {
		a.setNombre("Celta");
		assertEquals("Celta",a.getNombre());
	}
	
	@Tag(value="TDD")
	@Tag(value="Nombre")
	@Tag(value="Nulo")
	@Test
	void setNombreNull() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setNombre(null);
		});

	}
	@Tag(value="TDD")
	@Tag(value="Nombre")
	@Tag(value="Vacio")
	@Test
	void setNombreVacio() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setNombre("");
		});

	}
	
	@Tag(value="TDD")
	@Tag(value="Descripcion")
	@Tag(value="Correcto")
	@Test
	void setDescripcion() {
		a.setDescripcion("Muy buen servicio");
		assertEquals("Muy buen servicio",a.getDescripcion());
	}
	
	@Tag(value="TDD")
	@Tag(value="Descripcion")
	@Tag(value="Nulo")
	@Test
	void setDescripcionNull() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setDescripcion(null);
		});

	}
	
	@Tag(value="TDD")
	@Tag(value="Descripcion")
	@Tag(value="Vacio")
	@Test
	void setDescripcionVacia() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setDescripcion("");
		});

	}
	
	@Tag(value="TDD")
	@Tag(value="Coorddenada")
	@Tag(value="Correcto")
	@Test
	void setCoordenada() {
		Gps gp2 =new Gps(0,0);
		a.setCoordenada(gp2);
		assertEquals(gp2,a.getCoordenada());
	}
	

	@Tag(value="TDD")
	@Tag(value="Coordenada")
	@Tag(value="Nulo")
	@Test
	void setCoordenadaNull() {
		assertThrows(IllegalArgumentException.class,()->{
			a.setCoordenada(null);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Equals")
	@Tag(value ="True")
	@Test
	void equalsTrue() {
		Alojamiento a2= new Alojamiento("Id01","Carrion","Alojamiento comodo y asequible",c);
		assertTrue(a.equals(a2));
	}
	
	@Tag(value="TDD")
	@Tag(value="Equals")
	@Tag(value ="True")
	@Test
	void equalsTrueMismoAlojamiento() {
		assertTrue(a.equals(a));
	}
	
	@Tag(value="TDD")
	@Tag(value="Equals")
	@Tag(value ="False")
	@Test
	void equalsFalse() {
		Alojamiento a2= new Alojamiento("Id02","Carrion","Alojamiento comodo y asequible",c);
		assertFalse(a.equals(a2));
	}
	
	@Tag(value="TDD")
	@Tag(value="Equals")
	@Tag(value ="False")
	@Test
	void equalsFalseNoInstance() {
		assertFalse(a.equals(c));
	}
	
	

}

