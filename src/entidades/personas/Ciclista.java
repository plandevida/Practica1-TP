package entidades.personas;

import java.util.StringTokenizer;

import interfaces.ObjetosConSalidaDeDatos;
import entidades.bicicletas.Bicicleta;
import entidades.tiempo.Reloj;

public class Ciclista extends Persona implements ObjetosConSalidaDeDatos {

	private Bicicleta bicicletamontada;
	private Reloj reloj;
	private double cadencia;
	
	private boolean frenando = false;

	public Ciclista(String nombre, double cadenciaCiclista, Bicicleta bicicletaamontar, Reloj relojCiclista) {
		/**
		 * Demomento el peso no es relevante, ni el cansancio
		 * 
		 * Esta clase hereda de persona @link Persona
		 */
		super(nombre, 50, 100);
		cadencia = cadenciaCiclista;
		bicicletamontada = bicicletaamontar;
		reloj = relojCiclista;
	}
	
	@Override
	public boolean ejecutar() {
		if ( !frenando ) {
			if (bicicletamontada.getVelocidad() < 30)
				pedalear();
			else
				frenando = true;
		}
		else {
			if (bicicletamontada.getVelocidad() < 15)
				frenando = false;
				
			bicicletamontada.frenar();
		}
		
		return true;
	}
	
	public StringTokenizer mostrarDatos() {
		StringBuilder mensaje = new StringBuilder(getNombre());
		mensaje.append(",");
		mensaje.append(getPeso());
		mensaje.append(",");
		mensaje.append(getCadencia());

		StringTokenizer stringTokenizer = new StringTokenizer(mensaje.toString(), ",");

		return stringTokenizer;
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
