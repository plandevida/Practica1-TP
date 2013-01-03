package entidades.bicicletas;

import java.util.StringTokenizer;

import interfaces.ObjetosConSalidaDeDatos;
import interfaces.ObjetosQueSeEjecutan;

public class Bicicleta implements ObjetosQueSeEjecutan, ObjetosConSalidaDeDatos {

	protected double velocidadactual;

	// El array representa los piñones de la bicicleta con el indice
	// del array y su valor es el número de dientes del piñón
	protected int[] pinhones = new int[] { 15, 20, 25, 30 };

	// El array representa los plato de la bicicleta con el indice
	// del array y su valor es el número de dientes del plato
	protected int[] platos = new int[] { 30, 40, 50 };

	// Continen el indice del piñón que se esta utilizando
	protected int platoactual;

	// Continen el indice del plato que se esta utilizando
	protected int pinhonactual;

	protected double radiorueda;
	
	//Espacio que lleva recorrido
	protected double espaciorecorrido;

	public Bicicleta() {
		setVelocidad(0);
		setPinhonactual(0);
		setPlatoactual(0);
		radiorueda = 0.2d;
	}

	public boolean ejecutar() {

		return true;
	}

	/**
	 * Relación entre el plato y piñón que se están usando actualmente.
	 * 
	 * @reutrn Un entero que es relación entre ambos valores.
	 */
	public int relacionDeTransmision() {

		int relaciondetrasminsion = platos[platoactual] / pinhones[pinhonactual];

		return relaciondetrasminsion;
	}
	
	/**
	 * Devuelve el la longitud de la rueda.
	 * 
	 * @return El valor de la longitud de la rueda.
	 */
	private double recorridoLinealDeLaRueda() {

		double recorridolinealdelarueda = Math.PI * this.radiorueda;

		return recorridolinealdelarueda;

	}
	
	/**
	 * Calcula el espacio recorrido por cada pedalada que se da.
	 * 
	 * @return El valor del espacio recorrido.
	 */
	private double espacioDePedalada() {

		double espaciodepedalada = recorridoLinealDeLaRueda() * relacionDeTransmision();

		return espaciodepedalada;
	}
	
	/**
	 * Calcula la velocidad de la bicicleta en función de la cadencia del ciclista.
	 * 
	 * @param cadenciaciclista Frecuencia con la que el ciclista da pedaladas.
	 * @return La velocidad de la bicicleta.
	 */
	public double velocidadDeBici(double cadenciaciclista) {

		double velocidadbici = espacioDePedalada() / cadenciaciclista;

		return velocidadbici;
	}
	
	/**
	 * Método para obtener una salida de datos de un objeto.
	 * 
	 * @return Una cadena de texto separada por tokens.
	 */
	public StringTokenizer mostrarDatos() {
		StringBuilder mensaje = new StringBuilder();
		mensaje.append(getVelocidad());
		
		return new StringTokenizer(mensaje.toString(), ",");
	}
	
	/**
	 * Realiza una pedalada en la bicicleta, aumentando su velocidad.
	 * 
	 * @param cadenciaciclista Frecuencia con la que el ciclista da pedaladas. 
	 */
	public void darPedalada(double cadenciaciclista) {
		double velocidad = velocidadDeBici(cadenciaciclista);
		
		setEspacioRecorrido(espacioDePedalada());
		setVelocidadIncremento(velocidad);
	}
	
	/**
	 * Incrementa el piñón de la bicicleta.
	 */
	public void incrementarPinhon() {
		if (pinhonactual < pinhones.length - 1) {
			pinhonactual++;
		}
	}
	
	/**
	 * Decrementa el piñón de la bicicleta.
	 */
	public void decrementarPinhon() {
		if (pinhonactual > 0) {
			pinhonactual--;
		}
	}
	
	/**
	 * Incrementa el plato de la bicicleta.
	 */
	public void incrementarPlato() {
		if (platoactual < platos.length - 1) {
			platoactual++;
		}
	}
	
	/**
	 * Decrementa el plato de la bicicleta.
	 */
	public void decrementarPlato() {
		if (platoactual > 0) {
			platoactual--;
		}
	}
	
	/**
	 * Cambia el valor del espacio recorrido por la bicicleta.
	 * 
	 * @param espaciodepedalada Frecuencia con la que el ciclista da pedaladas.
	 */
	public void setEspacioRecorrido(double espaciodepedalada){
		
		espaciorecorrido += espaciodepedalada;
	}
	
	/**
	 * Incrementa la velocidad de la bicicleta.
	 * 
	 * @param incrementovelocidad Valor a aumentar la velocidad de la bicicleta.
	 */
	private void setVelocidadIncremento(double incrementovelocidad) {
		velocidadactual += incrementovelocidad;
	}
	
	/**
	 * Cambia la velocidad de la bicicleta.
	 * 
	 * @param velocidadnueva La nueva velocidad de la bicicleta.
	 */
	public void setVelocidad(double velocidadnueva) {
		velocidadactual = velocidadnueva;
	}
	
	/**
	 * Obtiene el espacio total recorrido por la bicicleta.
	 * 
	 * @return Espacio recorrido por la bicicleta.
	 */
	public double getEspacioRecorrido(){
		return espaciorecorrido;
	}
	
	/**
	 * Obtiene la velocidad a la que va la bicicleta.
	 * 
	 * @return El valor de la velocidad de la bicicleta.
	 */
	public double getVelocidad() {
		return velocidadactual;
	}
	
	/**
	 * Obtiene los piónes y sus dientes.
	 * 
	 * @return Una lista de los piónes y sus dientes.
	 */
	public int[] getPinhones() {
		return pinhones;
	}
	
	/**
	 * Obtiene los platos y sus dientes.
	 * 
	 * @return Una lista de los platos y sus dientes.
	 */
	public int[] getPlatos() {
		return platos;
	}
	
	/**
	 * Obtiene el plato engranado actualmente.
	 *  
	 * @return El indice de la lista de platos del plato engranado.
	 */
	public int getPlatoactual() {
		return platoactual;
	}
	
	/**
	 * Ajusta el plato engranado actualmente por otro.
	 * 
	 * @param platoactual El nuevo plato a engranar.
	 */
	public void setPlatoactual(int platoactual) {
		this.platoactual = platoactual;
	}
	
	/**
	 * Obtiene el piñón engranado actualmente.
	 * 
	 * @return El indice de la lista de piñones del piñón engranado
	 */
	public int getPinhonactual() {
		return pinhonactual;
	}
	
	/**
	 * Ajusta el piñón engranado actualmente por otro.
	 * 
	 * @param pinhonactual El nuevo piñón a engranar.
	 */
	public void setPinhonactual(int pinhonactual) {
		this.pinhonactual = pinhonactual;
	}
	
	/**
	 * Obtiene el radio de la rueda.
	 * 
	 * @return Valor del radio de la rueda.
	 */
	public double getRadiorueda() {
		return radiorueda;
	}

//	 private enum Pinhones {
//		 UNO(10), //0
//		 DOS(20), //1
//		 TRES(30), //2
//		 CUATRO(40); //3
//		
//		 private int numerodedientes;
//		
//		 Pinhones(int numerodientes) {
//			 numerodedientes = numerodientes;
//		 }
//		
//		 public int getNumeroDientes() {
//			 return numerodedientes;
//		 }
//		
//		 public Pinhones desdeIndice(int indice) {
//			 return ( indice < Pinhones.values().length) ? Pinhones.values()[indice] : null;
//		 }
//	 }
}
