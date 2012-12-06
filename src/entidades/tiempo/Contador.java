package entidades.tiempo;

public class Contador {
	protected int impulsos;
	
	public Contador() {
		impulsos = 0;
	}
	
	public void nuevoImpulso() {
		impulsos++;
	}
	
	public int getImpulsos() {
		return impulsos;
	}
}
