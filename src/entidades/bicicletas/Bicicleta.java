package entidades.bicicletas;

import interfaces.ObjetosQueSeEjecutan;

public class Bicicleta implements ObjetosQueSeEjecutan {

	private int INCREMENTO_PEDALADA = 5;
	
	private int velocidad;
	
	public boolean ejecutar() {return true;}
	
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
