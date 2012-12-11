package entidades.personas;

import interfaces.ObjetosQueSeEjecutan;

public class Persona implements ObjetosQueSeEjecutan {
	private String nombre;
	private int peso;
	private int cansancio;
	
	public Persona(String nombrepersona, int pesopersona, int estadofisico) {
		nombre = nombrepersona;
		peso = pesopersona;
		cansancio = (estadofisico >= 0 && estadofisico < 100) ? estadofisico : 100;
	}
	
	public boolean ejecutar() { return true; }
	
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getCansancio() {
		return cansancio;
	}
	public void setCansancio(int cansancio) {
		this.cansancio = cansancio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
