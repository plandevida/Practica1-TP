package entidades.tiempo;

public class Reloj extends Contador {
	private int segundos;
	private int minutos;
	private int horas;
	
	public Reloj() {
		segundos = 0;
		minutos = 0;
		horas = 0;
	}
	
	@Override
	public void nuevoImpulso() {
		
		if (++impulsos >= 100) {
			impulsos = 0;
			if (++segundos >= 60) {
				segundos = 0;
				if (++minutos >= 60) {
					minutos = 0;
					horas++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Reloj reloj = new Reloj();
		
		for (int i=0; i < (100*60*60*60*60+1600000); i++) {
			reloj.nuevoImpulso();
			
			System.out.println("impulsos: " +reloj.getImpulsos());
			System.out.println("segundos: " + reloj.getSegundos());
			System.out.println("minutos: " + reloj.getMinutos());
			System.out.println("horas: " + reloj.getHoras());
		}
	}

	public int getSegundos() {
		return segundos;
	}

	public int getMinutos() {
		return minutos;
	}
	
	public int getHoras() {
		return horas;
	}

}