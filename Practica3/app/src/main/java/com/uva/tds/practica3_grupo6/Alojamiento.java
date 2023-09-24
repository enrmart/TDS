package com.uva.tds.practica3_grupo6;

import java.util.Objects;

/**
 * 
 * @author enrmart
 * @author vicbarr
 *
 */
public class Alojamiento {
	
	private String identificador;
	private String nombre;
	private String descripcion;
	private Gps coordenada;
	
	
	
	
	
	/**
	 * Crea un objeto alojamiento
	 * 
	 * @param idetificador identificador unico del alojamiento con entre 1 y 15 caracteres
	 * @param nombre nombre no nulo del alojamiento
	 * @param descripcion pequena descripcion no nula
	 * @param coordenada objeto tipo GPS la cual muestra las coordenadas del alojamiento
	 * 
	 * @throws IllegalArgumentException si el identificador es nulo
	 * @throws IllegalArgumentException si el identificador tiene menos de 1 caracter
	 * @throws IllegalArgumentException si el identificador tiene mas de 15 caracteres
	 * @throws IllegalArgumentException si el nombre es nulo
	 * @throws IllegalArgumentException si el nombre esta vacio
	 * @throws IllegalArgumentException si la descripcion es nula
	 * @throws IllegalArgumentException si la descripcion esta vacia
	 * @throws IllegalArgumentException si la coordenada GPS es nula
	 */
	public Alojamiento(String identificador,String nombre,String descripcion,Gps coordenada) {
		setId(identificador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setCoordenada(coordenada);
	}
		
	
	/**
	 * Metodo el cual modifica el identificador del alojamiento
	 * 
	 * @param identificador id que estableceremos al alojamiento
	 * @throws IllegalArgumentException si el identificador es nulo
	 * @throws IllegalArgumentException si el identificador tiene menos de 1 caracter
	 * @throws IllegalArgumentException si el identificador tiene mas de 15 caracteres
	 */
	public void setId(String identificador) {
		if(identificador==null) {
			throw new IllegalArgumentException("El identificador es nulo");
		}
		if(identificador.length()<1||identificador.length()>15) {
			throw new IllegalArgumentException("La longitud del id es incorrecta");
		}
		this.identificador=identificador;
	}
	
	
	/**
	 * Metodo el cual modifica el nombre del alojamiento
	 * 
	 * @param nombre nombre que estableceremos al alojamiento
	 * @throws IllegalArgumentException si el nombre es nulo
	 * @throws IllegalArgumentException si el nombre esta vacio
	 */
	public void setNombre(String nombre){
		if(nombre==null) {
			throw new IllegalArgumentException("El nombre no puede ser nulo");
		}
		if(nombre.isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}
		this.nombre=nombre;
		
	}
	
	
	/**
	 * Metodo el cual modifica la descripcion de un alojamiento
	 * 
	 * @param descripcion pequena descripcion que estableceremos al alojamiento
	 * @throws IllegalArgumentException si la descripcion es nula
	 * @throws IllegalArgumentException si la descripcion esta vacia
	 */
	public void setDescripcion(String descripcion) {
		if(descripcion==null) {
			throw new IllegalArgumentException("La descripcion no puede ser nula");
		}
		if(descripcion.isEmpty()) {
			throw new IllegalArgumentException("La descripcion no puede estar vacia");
		}
		this.descripcion=descripcion;
	}
	
	/**
	 * Metodo que modifica las coordenadas del alojamiento
	 * 
	 * @param coordenada punto gps que estableceremos al alojamiento
	 * @throws IllegalArgumentException si la coordenada GPS es nula
	 */
	public void setCoordenada(Gps coordenada) {
		if(coordenada==null) {
			throw new IllegalArgumentException("La coordenada no puede ser nula");
		}
		this.coordenada=coordenada;
	}
	
	
	/**
	 * Metodo que devuelve el id del alojamiento
	 * 
	 * @return id del alojamiento
	 */
	public String getId() {
		return identificador;
	}
	
	
	/**
	 * Metodo que devuelve el nombre del alojamiento
	 * 
	 * @return nombre del alojamiento
	 */
	public String getNombre() {
		return nombre;
	}
	
	
	/**
	 * Metodo que devuelve la descripcion del alojamiento
	 * 
	 * @return descripcion del alojamiento
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	
	/**
	 * Metodo que devuelve las coordenadas del alojamiento
	 * 
	 * @return coordenadas del alojamiento
	 */
	public Gps getCoordenada() {
		return coordenada;
	}
	
	@Override
	public boolean equals(Object o) {
		// If the object is compared with itself then return true
				if (o == this) {
					return true;
				}

				/*
				 * Check if o is an instance of Complex or not "null instanceof [type]" also
				 * returns false
				 */
				
				if (!(o instanceof Alojamiento)) {
					return false;
				}

				Alojamiento alojamiento = (Alojamiento) o;

				return (this.identificador.equals(alojamiento.getId()));
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.identificador);
	}
}


