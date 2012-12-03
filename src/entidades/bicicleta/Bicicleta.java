package entidades.bicicleta;

import entidades.ciclista.Ciclista;

public class Bicicleta {

	private int INCREMENTO_PEDALADA = 5;
	
	private int velocidad;
	
	private Ciclista ciclistamontado;
	
	public Bicicleta(Ciclista ciclistaquemonta) {
		ciclistamontado = ciclistaquemonta;
	}
	
	public int pedalear() {
		setVelocidadIncremento(INCREMENTO_PEDALADA);
		
		return getVelocidad();
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
	
	public void setCiclista(Ciclista ciclistaquemonta) {
		ciclistamontado = ciclistaquemonta;
	}
	
	public Ciclista getCiclista() {
		return ciclistamontado;
	}
}
