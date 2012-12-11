package entidades.bicicletas;

import interfaces.ObjetosConSalidaDeDatos;
import interfaces.ObjetosQueSeEjecutan;

public class Bicicleta implements ObjetosQueSeEjecutan, ObjetosConSalidaDeDatos{

	private int INCREMENTO_PEDALADA = 5;
	
	private int velocidad;
	
	public Bicicleta() {
		velocidad = 0;
	}
	
	public boolean ejecutar() {
		velocidad--;
		
		return true;
	}
	
	public void mostrarDatos() {
		System.out.println("-- Bicicleta: ");
		System.out.println("velocidad: " + getVelocidad());
	}
	
	public void darPedalada() {
		setVelocidadIncremento(INCREMENTO_PEDALADA);
	}
	
	private void setVelocidadIncremento(int incrementovelocidad) {
		velocidad += incrementovelocidad;
	}
	
	public void setVelocidad(int velocidadnueva) {
		velocidad = velocidadnueva;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
}
