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
class GpsTest {

	private Gps c;
	
	@BeforeEach
	void setUp() throws Exception {
		c=new Gps(-90,-180);
	}
	
	@Tag(value="TDD")
	@Tag(value="Constructor")
	@Tag(value="Correcto")
	@Test
	void creacionCorrecta() {
		assertNotNull(c);
		assertEquals(c.getLatitud(),-90);
		assertEquals(c.getLongitud(),-180);
	}
	
	@Tag(value="TDD")
	@Tag(value="Latitud")
	@Tag(value="Correcto")
	@Test
	void setLatitudCorrecta() {
		c.setLatitud(90);
		assertEquals(c.getLatitud(), 90);
	}
	
	@Tag(value="TDD")
	@Tag(value="Latitud")
	@Tag(value="Error")
	@Test
	void setLatitudMenorLongitud() {
		assertThrows(IllegalArgumentException.class,()->{
			c.setLatitud(-91);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Latitud")
	@Tag(value="Error")
	@Test
	void setLatitudMayorLongitud() {
		assertThrows(IllegalArgumentException.class,()->{
			c.setLatitud(91);
		});
	}
	
	
	@Tag(value="TDD")
	@Tag(value="Longitud")
	@Tag(value="Correcto")
	@Test
	void setLongitudCorrecta() {
		c.setLongitud(180);
		assertEquals(c.getLongitud(), 180);
	}
	
	@Tag(value="TDD")
	@Tag(value="Longitud")
	@Tag(value="Error")
	@Test
	void setLongitudMenorLongitud() {
		assertThrows(IllegalArgumentException.class,()->{
			c.setLongitud(-181);
		});
	}
	
	@Tag(value="TDD")
	@Tag(value="Longitud")
	@Tag(value="Error")
	@Test
	void setLongitudMayorLongitud() {
		assertThrows(IllegalArgumentException.class,()->{
			c.setLongitud(181);
		});
	}
	

}

