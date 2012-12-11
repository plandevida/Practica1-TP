package entidades.tiempo;

import interfaces.ObjetosQueSeEjecutan;

public class Contador implements ObjetosQueSeEjecutan {
	protected int impulsos;
	
	public Contador() {
		impulsos = 0;
	}
	
	public boolean ejecutar() { 
		nuevoImpulso();
		
		return true;
	}
	
	public void nuevoImpulso() {
		impulsos++;
	}
	
	public int getImpulsos() {
		return impulsos;
	}
}
