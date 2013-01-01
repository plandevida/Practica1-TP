package entidades.bicicletas;

import java.util.StringTokenizer;

import interfaces.ObjetosConSalidaDeDatos;
import interfaces.ObjetosQueSeEjecutan;

public class Bicicleta implements ObjetosQueSeEjecutan, ObjetosConSalidaDeDatos{
	
	protected double velocidadactual;
	
	// El array representa los piñones de la bicicleta con el indice
	// del array y su valor es el número de dientes del piñón
	protected int[] pinhones = new int[] {15, 20, 25, 30};
	
	// El array representa los plato de la bicicleta con el indice
	// del array y su valor es el número de dientes del plato
	protected int[] platos = new int[] {30, 40, 50};
	
	protected int platoactual;
	protected int pinhonactual;
	protected int radiorueda;
	
	public Bicicleta() {
		setVelocidad(0);
		setPinhonactual(0);
		setPlatoactual(0);
	}
	
	public boolean ejecutar() {
		velocidadactual--;
		
		return true;
	}
	
	/****/
	public int relacionDeTransmision(){
		
		int relaciondetrasminsion = platoactual/pinhonactual;
		
		return relaciondetrasminsion;
		
	}
	
	public double recorridoLinealDeLaRueda (){
		
		double recorridolinealdelarueda = 3.14 *this.radiorueda;
		
		return recorridolinealdelarueda;
		
	}
	
	public double espacioDePedalada (){
		
		double espaciodepedalada = recorridoLinealDeLaRueda() * relacionDeTransmision();
		
		return espaciodepedalada;
	}
	/***/
	public StringTokenizer mostrarDatos() {
		System.out.println("-- Bicicleta: ");
		System.out.println("velocidad: " + getVelocidad());
		
		return null;
	}
	
	public void darPedalada(double cadenciaciclista) {
		
		setVelocidadIncremento(0.0);
	}
	
	private void setVelocidadIncremento(double incrementovelocidad) {
		velocidadactual += incrementovelocidad;
	}
	
	public void setVelocidad(int velocidadnueva) {
		velocidadactual = velocidadnueva;
	}
	
	public double getVelocidad() {
		return velocidadactual;
	}
	
	public double getVelocidadactual() {
		return velocidadactual;
	}

	public void setVelocidadactual(double velocidadactual) {
		this.velocidadactual = velocidadactual;
	}

	public int[] getPinhones() {
		return pinhones;
	}
	
	
	public void setPinhones(int[] pinhones) {
		this.pinhones = pinhones;
	}

	public int[] getPlatos() {
		return platos;
	}

	public void setPlatos(int[] platos) {
		this.platos = platos;
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

	public void setRadiorueda(int radiorueda) {
		this.radiorueda = radiorueda;
	}

	protected int getRelacionPlatos() {
		return ( platos[platoactual]/pinhones[pinhonactual] );
	}
	
//	private enum Pinhones {
//		UNO(10),    //0
//		DOS(20),	//1
//		TRES(30),	//2
//		CUATRO(40);	//3
//		
//		private int numerodedientes;
//		
//		Pinhones(int numerodientes) {
//			numerodedientes = numerodientes;
//		}
//		
//		public int getNumeroDientes() {
//			return numerodedientes;
//		}
//		
//		public Pinhones desdeIndice(int indice) {
//			return ( indice < Pinhones.values().length) ? Pinhones.values()[indice] : null;
//		}
//	}
}
