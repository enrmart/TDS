package com.uva.tds.practica3_grupo6;
/**
 * 
 * @author enrmart
 * @author vicbarr
 *
 */
public class Gps {
	
	private double latitud;
	private double longitud;
	
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
		setLatitud(latitud);
		setLongitud(longitud);
	}
	
	/**
	 * Metodo que establece la latitud del punto GPS
	 * 
	 * @param latitud numero real que representara la latitud de la coordeanda
	 * @throws IllegalArgumentException si la latitud es menor de -90
	 * @throws IllegalArgumentException si la latitud es mayor de 90
	 */
	public void setLatitud(double latitud) {
		if (latitud<-90||latitud>90) {
			throw new IllegalArgumentException("La latitud debe estar contenida en [-90,90]");
		}
		this.latitud=latitud;
	}
	
	
	/**
	 * Metodo que establece la longitud del punto GPS
	 * @param longitud numero real que representara la longitud de la coordeanda
	 * @throws IllegalArgumentException si la longitud es menor de -180
	 * @throws IllegalArgumentException si la longitud es mayor de 180
	 */
	public void setLongitud(double longitud){
		if (longitud<-180||longitud>180) {
			throw new IllegalArgumentException("La longitud debe estar contenida en [-180,180]");
		}
		this.longitud=longitud;
	}
	
	
	/**
	 * Metodo que devuelve la latitud de nuestro punto GPS
	 * @return latitud del punto GPS
	 */
	public double getLatitud() {
		return latitud;
	}
	
	/**
	 * Metodo que devuelve la latitud de nuestro punto GPS
	 * @return longitud del punto GPS
	 */
	public double getLongitud() {
		return longitud;
	}
}





