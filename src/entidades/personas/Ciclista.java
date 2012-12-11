package entidades.personas;

import interfaces.ObjetosConSalidaDeDatos;
import entidades.bicicletas.Bicicleta;

public class Ciclista extends Persona implements ObjetosConSalidaDeDatos {

	private Bicicleta bicicletamontada;
	
	public Ciclista(String nombre, Bicicleta bicicletaamontar) {
		/** 
		 * Demomento el peso no es relevante, ni el cansancio
		 * @see Persona
		 */
		super(nombre, 50, 100);
		bicicletamontada = bicicletaamontar;
	}
	
	@Override
	public boolean ejecutar() {
		pedalear();
		
		return false;
	}
	
	public void mostrarDatos() {
		System.out.println("-- Ciclista: " + getNombre());
		System.out.println("peso" + getPeso());
		System.out.println("cansancio: " + getCansancio());
		System.out.println("-- Fin ciclista --");
	}
	
	private void pedalear() {
		bicicletamontada.darPedalada();
	}
	
	public void setBicicleta(Bicicleta bicicletaamontar) {
		bicicletamontada = bicicletaamontar;
	}
	
	public Bicicleta getBicicleta() {
		return bicicletamontada;
	}
}
