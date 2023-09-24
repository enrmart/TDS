package tds.practica2;

public class Gps {
	
	/**Constructor de {@link Gps.class} 
	 * 
	 * @param latitud numero real que representara la latitud de la coordeanda
	 * @param longitud numero real que representara la longitud de la coordeanda
	 * @throws IllegalArgumentException si la latitud es menor de -90
	 * @throws IllegalArgumentException si la latitud es mayor de 90
	 * @throws IllegalArgumentException si la longitud es menor de -180
	 * @throws IllegalArgumentException si la longitud es mayor de 180
	 */
	public Gps(double latitud, double longitud) {
		
	}
	
	/**
	 * Metodo que establece la latitud del punto GPS
	 * 
	 * @param latitud numero real que representara la latitud de la coordeanda
	 * @throws IllegalArgumentException si la latitud es menor de -90
	 * @throws IllegalArgumentException si la latitud es mayor de 90
	 */
	public void setLatitud(double latitud) {}
	
	
	/**
	 * Metodo que establece la longitud del punto GPS
	 * @param longitud numero real que representara la longitud de la coordeanda
	 * @throws IllegalArgumentException si la longitud es menor de -180
	 * @throws IllegalArgumentException si la longitud es mayor de 180
	 */
	public void setLongitud(double longitud){}
	
	
	/**
	 * Metodo que devuelve la latitud de nuestro punto GPS
	 * @return latitud del punto GPS
	 */
	public double getLatitud() {
		return -1;
	}
	
	/**
	 * Metodo que devuelve la latitud de nuestro punto GPS
	 * @return longitud del punto GPS
	 */
	public double getLongitud() {
		return -1;
	}
}





