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
		
		assertEquals("Error: El espacio recorrido de la bicicleta no es el correcta", espaciodelapedaladaesperado, utilidadesBicicleta.espacioDePedalada(bicicleta.getRadiorueda(), bicicleta.getPlatos()[bicicleta.getPlatoactual()], bicicleta.getPinhones()[bicicleta.getPinhonactual()]), 0);
		
		
		//se comprueba que la relacion de transmision sea la esperada
		
		double relaciondeetransmisionesperado = utilidadesBicicleta.relacionDeTransmision(bicicleta.getPlatos()[bicicleta.getPlatoactual()],
																					     bicicleta.getPinhones()[bicicleta.getPinhonactual()]);
		
		assertEquals("Error: El espacio recorrido de la bicicleta no es el correcta", relaciondeetransmisionesperado, utilidadesBicicleta.relacionDeTransmision(bicicleta.getPlatos()[bicicleta.getPlatoactual()], bicicleta.getPinhones()[bicicleta.getPinhonactual()]), 0);
		
		
		//se comprueba que el recorrido lineal sea el esperado
		
		double recorridoLinealDeLaRuedaesperado = utilidadesBicicleta.recorridoLinealDeLaRueda(bicicleta.getRadiorueda());
		
		assertEquals("Error: El espacio recorrido de la bicicleta no es el correcta", recorridoLinealDeLaRuedaesperado, utilidadesBicicleta.recorridoLinealDeLaRueda(bicicleta.getRadiorueda()), 0);
		
		
		
		//Se comprueban las variables despues de frenar
		
		bicicleta.frenar();
		
		//se comprueba que la velocidad halla decrementado como esperamos despues de frenar
		
		double velocidadfrenado = utilidadesBicicleta.velocidadDeBici(1,bicicleta.getRadiorueda(), 
																				bicicleta.getPlatos()[bicicleta.getPlatoactual()], 
																				bicicleta.getPinhones()[bicicleta.getPinhonactual()]);
		
		velocidadfrenado = -(velocidadfrenado *0.1);
		
		double velocidadesperadafrenando = velocidadesperada + velocidadfrenado;

		assertEquals("Error: La velocidad de frenado de la bicicleta no es la correcta", velocidadesperadafrenando, bicicleta.getVelocidad(), 0);
		
		
		
		//Se comprueban que los pi�ones se incremente y decrementen correctamente
		
		int incrementarpinhonesperado = bicicleta.getPinhonactual() +1;
		
		bicicleta.incrementarPinhon();
		
		assertEquals("Error: El incremento de pi�on de la bicicleta no es la correcta", incrementarpinhonesperado, bicicleta.getPinhonactual(), 0);
		
		int decrementarpinhonesperado = bicicleta.getPinhonactual() -1;
			
		bicicleta.decrementarPinhon();
		
		assertEquals("Error: El decremento de pi�on de la bicicleta no es la correcta", decrementarpinhonesperado, bicicleta.getPinhonactual(), 0);
		
		
		
		//Se comprueban que los platos se incremente y decrementen correctamente
		
		int incrementarplatoesperado = bicicleta.getPlatoactual() +1;
		
		bicicleta.incrementarPlato();
		
		assertEquals("Error: El incremento del plato de la bicicleta no es la correcta", incrementarplatoesperado, bicicleta.getPlatoactual(), 0);
		
		int decrementarplatoesperado = bicicleta.getPlatoactual() -1;
		
		bicicleta.decrementarPlato();
		
		assertEquals("Error: El decremento de pi�on de la bicicleta no es la correcta", decrementarplatoesperado, bicicleta.getPlatoactual(), 0);
	}
	
}
