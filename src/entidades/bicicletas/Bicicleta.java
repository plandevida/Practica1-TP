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

	protected int radiorueda;
	
	//Espacio que lleva recorrido
	
	protected double espaciorecorrido;

	public Bicicleta() {
		setVelocidad(0);
		setPinhonactual(0);
		setPlatoactual(0);
	}

	public boolean ejecutar() {

		return true;
	}

	/**
	 * Relación entre el plato y piñón que se están usando actualmente.
	 * 
	 */
	public int relacionDeTransmision() {

		int relaciondetrasminsion = platos[platoactual] / pinhones[pinhonactual];

		return relaciondetrasminsion;
	}

	public double recorridoLinealDeLaRueda() {

		double recorridolinealdelarueda = Math.PI * this.radiorueda;

		return recorridolinealdelarueda;

	}

	public double espacioDePedalada() {

		double espaciodepedalada = recorridoLinealDeLaRueda() * relacionDeTransmision();

		return espaciodepedalada;
	}

	public double velocidadDeBici(double cadencia) {

		double velocidadbici = espacioDePedalada() / cadencia;

		return velocidadbici;
	}
	
	
	public StringTokenizer mostrarDatos() {
		StringBuilder mensaje = new StringBuilder();
		mensaje.append(getVelocidad());
		
		return new StringTokenizer(mensaje.toString(), ",");
	}

	public void darPedalada(double cadenciaciclista) {
		double velocidad = velocidadDeBici(cadenciaciclista);
		
		setEspacioRecorrido(espacioDePedalada());
		setVelocidadIncremento(velocidad);
	}
	
	public void incrementarPinhon() {
		if (pinhonactual < pinhones.length - 1) {
			pinhonactual++;
		}
	}
	
	public void decrementarPinhon() {
		if (pinhonactual > 0) {
			pinhonactual--;
		}
	}
	
	public void incrementarPlato() {
		if (platoactual < platos.length - 1) {
			platoactual++;
		}
	}
	
	public void decrementarPlato() {
		if (platoactual > 0) {
			platoactual--;
		}
	}
	
	public void setEspacioRecorrido(double espaciodepedalada){
		
		espaciorecorrido += espaciodepedalada;
	}

	private void setVelocidadIncremento(double incrementovelocidad) {
		velocidadactual += incrementovelocidad;
	}

	public void setVelocidad(double velocidadnueva) {
		velocidadactual = velocidadnueva;
	}
	
	public double getEspacioRecorrido(){
		return espaciorecorrido;
	}
	public double getVelocidad() {
		return velocidadactual;
	}

	public int[] getPinhones() {
		return pinhones;
	}

	public int[] getPlatos() {
		return platos;
	}

	public int getPlatoactual() {
		return platoactual;
	}

	public void setPlatoactual(int platoactual) {
		this.platoactual = platoactual;
	}

	public int getPinhonactual() {
		return pinhonactual;
	}

	public void setPinhonactual(int pinhonactual) {
		this.pinhonactual = pinhonactual;
	}

	public int getRadiorueda() {
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
