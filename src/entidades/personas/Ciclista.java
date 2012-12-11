package entidades.personas;

import entidades.bicicletas.Bicicleta;
import entidades.tiempo.Reloj;

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
	
	public void pedalear(Reloj reloj) {
		bicicletamontada.darPedalada();
	}
	
	public void setBicicleta(Bicicleta bicicletaamontar) {
		bicicletamontada = bicicletaamontar;
	}
	
	public Bicicleta getBicicleta() {
		return bicicletamontada;
	}
}
