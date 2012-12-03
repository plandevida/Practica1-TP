package entidades.ciclista;

import entidades.bicicleta.Bicicleta;

public class Ciclista {

	private Bicicleta bicicletamontada;
	
	public Ciclista(Bicicleta bicicletaamontar) {
		bicicletamontada = bicicletaamontar;
	}
	
	public void setBicicleta(Bicicleta bicicletaamontar) {
		bicicletamontada = bicicletaamontar;
	}
	
	public Bicicleta getBicicleta() {
		return bicicletamontada;
	}
}
