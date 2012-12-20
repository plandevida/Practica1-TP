package entidades.personas;

import java.util.StringTokenizer;

import interfaces.ObjetosConSalidaDeDatos;
import entidades.bicicletas.Bicicleta;
import entidades.tiempo.Reloj;

public class Ciclista extends Persona implements ObjetosConSalidaDeDatos {

	private Bicicleta bicicletamontada;
	private Reloj reloj;
	private double cadencia;

	public Ciclista(String nombre, double cadenciaCiclista, Bicicleta bicicletaamontar, Reloj relojCiclista) {
		/** 
		 * Demomento el peso no es relevante, ni el cansancio
		 * @see Persona
		 */
		super(nombre, 50, 100);
		cadencia = cadenciaCiclista;
		bicicletamontada = bicicletaamontar;
		reloj = relojCiclista;
	}
	
	@Override
	public boolean ejecutar() {
		pedalear();
		
		return false;
	}
	
	public StringTokenizer mostrarDatos() {
		System.out.println("-- Ciclista: " + getNombre());
		System.out.println("peso" + getPeso());
		System.out.println("cansancio: " + getCansancio());
		System.out.println("-- Fin ciclista --");
		
		return null;
	}
	
	private void pedalear() {
		bicicletamontada.darPedalada(cadencia);
	}
	
	public void setBicicleta(Bicicleta bicicletaamontar) {
		bicicletamontada = bicicletaamontar;
	}
	
	public Bicicleta getBicicleta() {
		return bicicletamontada;
	}
	
	public Bicicleta getBicicletamontada() {
		return bicicletamontada;
	}

	public void setBicicletamontada(Bicicleta bicicletamontada) {
		this.bicicletamontada = bicicletamontada;
	}

	public Reloj getReloj() {
		return reloj;
	}

	public void setReloj(Reloj reloj) {
		this.reloj = reloj;
	}

	public double getCadencia() {
		return cadencia;
	}

	public void setCadencia(int cadencia) {
		this.cadencia = cadencia;
	}
}
