package tds.practica2.tests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tds.practica2.Gps;

class GpsTest {

	private Gps c;
	
	@BeforeEach
	void setUp() throws Exception {
		c=new Gps(-90,-180);
	}

	@Test
	void creacionCorrecta() {
		assertNotNull(c);
	}
	
	@Test
	void setLatitudCorrecta() {
		c.setLatitud(90);
		assertEquals(c.getLatitud(), 90);
	}
	
	@Test
	void setLatitudIncorrectaMenor() {
		
		assertThrows(IllegalArgumentException.class,()->{
			c.setLatitud(-91);
		});
	}
	
	@Test
	void setLatitudIncorrectaMayor() {
		assertThrows(IllegalArgumentException.class,()->{
			c.setLatitud(91);
		});
	}
	
	
	
	@Test
	void setLongitudCorrecta() {
		c.setLongitud(180);
		assertEquals(c.getLongitud(), 180);
	}
	
	
	@Test
	void setLongitudIncorrectaMenor() {
		
		assertThrows(IllegalArgumentException.class,()->{
			c.setLongitud(-181);
		});
	}
	
	@Test
	void setLongitudIncorrectaMayor() {
		assertThrows(IllegalArgumentException.class,()->{
			c.setLongitud(181);
		});
	}
	

}

