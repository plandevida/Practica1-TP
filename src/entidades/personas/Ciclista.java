package entidades.personas;

import entidades.bicicletas.Bicicleta;

public class Ciclista extends Persona {

	private Bicicleta bicicletamontada;
	
	public Ciclista(Bicicleta bicicletaamontar) {
		/** 
		 * Demomento el peso no es relevante, ni el cansancio
		 * @see Persona
		 */
		super(50, 100);
		bicicletamontada = bicicletaamontar;
	}
	
	@Override
	public boolean ejecutar() {
		pedalear();
		
		return false;
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
