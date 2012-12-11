package manager;

import interfaces.ObjetosConSalidaDeDatos;
import interfaces.ObjetosQueSeEjecutan;

import java.util.ArrayList;
import java.util.List;

import entidades.bicicletas.Bicicleta;
import entidades.personas.Ciclista;
import entidades.tiempo.Reloj;

public class Manager {

	private List<ObjetosQueSeEjecutan> listaejecutables;
	private List<ObjetosConSalidaDeDatos> listasalidadatos;
	private Ciclista ciclista;
	private Bicicleta bicicleta;
	private Reloj reloj;
	
	public void iniciar() {
		reloj = new Reloj();
		bicicleta = new Bicicleta();
		ciclista = new Ciclista(bicicleta);
		
		listaejecutables = new ArrayList<ObjetosQueSeEjecutan>();
		
		listaejecutables.add(reloj);
		listaejecutables.add(bicicleta);
		listaejecutables.add(ciclista);
		
		listasalidadatos = new ArrayList<ObjetosConSalidaDeDatos>();
	}
	
	public void ejecutar() {
		
		for (ObjetosQueSeEjecutan objetoejecutable : listaejecutables) {
			objetoejecutable.ejecutar();
			
			for (ObjetosConSalidaDeDatos objetosalidadatos : listasalidadatos) {
				objetosalidadatos.mostrarDatos();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Manager manager = new Manager();
		
		manager.iniciar();
		manager.ejecutar();
	}
}
