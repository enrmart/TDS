package tds.practica2;



public class Alojamiento {
	
	
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
	public Alojamiento(String idetificador,String nombre,String descripcion,Gps coordenada) {}
		
	
	/**
	 * Metodo el cual modifica el identificador del alojamiento
	 * 
	 * @param identificador id que estableceremos al alojamiento
	 * @throws IllegalArgumentException si el identificador es nulo
	 * @throws IllegalArgumentException si el identificador tiene menos de 1 caracter
	 * @throws IllegalArgumentException si el identificador tiene mas de 15 caracteres
	 */
	public void setId(String identificador) {}
	
	
	/**
	 * Metodo el cual modifica el nombre del alojamiento
	 * 
	 * @param nombre nombre que estableceremos al alojamiento
	 * @throws IllegalArgumentException si el nombre es nulo
	 * @throws IllegalArgumentException si el nombre esta vacio
	 */
	public void setNombre(String nombre){}
	
	
	/**
	 * Metodo el cual modifica la descripcion de un alojamiento
	 * 
	 * @param descripcion pequena descripcion que estableceremos al alojamiento
	 * @throws IllegalArgumentException si la descripcion es nula
	 * @throws IllegalArgumentException si la descripcion esta vacia
	 */
	public void setDescripcion(String descripcion) {}
	
	/**
	 * Metodo que modifica las coordenadas del alojamiento
	 * 
	 * @param coordenada punto gps que estableceremos al alojamiento
	 * @throws IllegalArgumentException si la coordenada GPS es nula
	 */
	public void setCoordenada(Gps coordenada) {}
	
	
	/**
	 * Metodo que devuelve el id del alojamiento
	 * 
	 * @return id del alojamiento
	 */
	public String getId() {
		return null;
	}
	
	
	/**
	 * Metodo que devuelve el nombre del alojamiento
	 * 
	 * @return nombre del alojamiento
	 */
	public String getNombre() {
		return null;
	}
	
	
	/**
	 * Metodo que devuelve la descripcion del alojamiento
	 * 
	 * @return descripcion del alojamiento
	 */
	public String getDescripcion() {
		return null;
	}
	
	
	/**
	 * Metodo que devuelve las coordenadas del alojamiento
	 * 
	 * @return coordenadas del alojamiento
	 */
	public String getCoordenada() {
		return null;
	}
	

}


