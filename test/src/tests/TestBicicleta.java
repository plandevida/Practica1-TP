package src.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import src.tests.utils.TestUtilidadesCiclista;
import src.tests.utils.TestUtilidadesBicicleta;
import entidades.bicicletas.Bicicleta;
import entidades.tiempo.Reloj;

@RunWith(JUnit4.class)

public class TestBicicleta {
	private Bicicleta bicicleta;
	private TestUtilidadesBicicleta utilidadesBicicleta;
	private TestUtilidadesCiclista utilidadesCiclista;
	
	@Before
	public void run() {
		
		
		utilidadesCiclista = new TestUtilidadesCiclista(1.0d);
		
		utilidadesBicicleta = new TestUtilidadesBicicleta();
		
		bicicleta = new Bicicleta();
		
		
	}
	
	@Test
	public void testNoNulos() {
		
		// Comprobamos que las propiedades no sean nulas
		assertNotNull("Error: La bici es nula", bicicleta);
		assertNotNull("Error: La velocidad es nula", bicicleta.getVelocidad());
		assertNotNull("Error: El espacio es nulo", bicicleta.getEspacioRecorrido());
		assertNotNull("Error: El piñon actual es nulo", bicicleta.getPinhonactual());
		assertNotNull("Error: El plato actual es nulo", bicicleta.getPlatoactual());
		assertNotNull("Error: El radio de la rueda es nulo", bicicleta.getRadiorueda());
	}
	
	@Test
	public void testResultadosEsperados() {
		
		// Comprobamos que los resultados son los esperados
		
		// Se comprueban las variables esten correctas despues de dar una pedalada
		
		
		
		bicicleta.darPedalada(utilidadesCiclista.getCadencia());
		
		
		//se comprueba que la velocidad sea la esperada
		
		double velocidadesperada = utilidadesBicicleta.velocidadDeBici(utilidadesCiclista.getCadencia(), 
																	bicicleta.getRadiorueda(), 
																	bicicleta.getPlatos()[bicicleta.getPlatoactual()], 
																	bicicleta.getPinhones()[bicicleta.getPinhonactual()]);
		
		
		assertEquals("Error: La velocidad de la bicicleta no es la correcta", velocidadesperada, bicicleta.getVelocidad(), 0);
		
		
		//se comprueba que el espacio de la pedalada sea el esperado
		
		double espaciodelapedaladaesperado = utilidadesBicicleta.espacioDePedalada(bicicleta.getRadiorueda(), 
																	   bicicleta.getPlatos()[bicicleta.getPlatoactual()], 
																	   bicicleta.getPinhones()[bicicleta.getPinhonactual()]);
		
		assertEquals("Error: El espacio recorrido de la bicicleta no es el correcta", espaciodelapedaladaesperado, bicicleta.getEspacioDePedalada(), 0);
		
		
		//se comprueba que la relacion de transmision sea la esperada
		
		double relaciondeetransmisionesperado = utilidadesBicicleta.relacionDeTransmision(bicicleta.getPlatos()[bicicleta.getPlatoactual()],
																					     bicicleta.getPinhones()[bicicleta.getPinhonactual()]);
		
		assertEquals("Error: El espacio recorrido de la bicicleta no es el correcta", relaciondeetransmisionesperado, bicicleta.getRelacionDeTransmision(), 0);
		
		
		//se comprueba que el recorrido lineal sea el esperado
		
		double recorridoLinealDeLaRuedaesperado = utilidadesBicicleta.recorridoLinealDeLaRueda(bicicleta.getRadiorueda());
		
		assertEquals("Error: El espacio recorrido de la bicicleta no es el correcta", recorridoLinealDeLaRuedaesperado, bicicleta.getRecorridoLinealDeLaRueda(), 0);
		
		
		
		//Se comprueban las variables despues de frenar
		
		bicicleta.frenar();
		
		//se comprueba que la velocidad halla decrementado como esperamos despues de frenar
		
		double velocidadfrenado = utilidadesBicicleta.velocidadDeBici(1,bicicleta.getRadiorueda(), 
																				bicicleta.getPlatos()[bicicleta.getPlatoactual()], 
																				bicicleta.getPinhones()[bicicleta.getPinhonactual()]);
		
		velocidadfrenado = -(velocidadfrenado *0.1);
		
		double velocidadesperadafrenando = velocidadesperada + velocidadfrenado;

		assertEquals("Error: La velocidad de frenado de la bicicleta no es la correcta", velocidadesperadafrenando, bicicleta.getVelocidad(), 0);
		
		
	}
	
}
