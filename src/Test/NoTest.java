package Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Model.No;

@DisplayName("Teste unitário da classe No")
class NoTest {

	@Test
	@DisplayName("No folha - Apenas o filho direito")
	void deveRetornarEhNoFolhaSoFilhoDireito() {
		No noUm = new No(1, null, null); 
		No noDois = new No(2, noUm, null);
		
		assertFalse(noDois.ehFolha());
		assertTrue(noUm.ehFolha());
	}
	
	@Test
	@DisplayName("No folha - Apenas o filho esquerdo")
	void deveRetornarEhNoFolhaSoFilhoEsquerdo() {
		No noUm = new No(1, null, null); 
		No noDois = new No(2, null, noUm);
		
		assertFalse(noDois.ehFolha());
		assertTrue(noUm.ehFolha());
	}
	

	@Test
	@DisplayName("No folha - Os dois filhos")
	void deveRetornarEhNoFolhaDoisFilhos() {
		No noUm = new No(1, null, null); 
		No noDois = new No(2, null, null);
		No noTres = new No(3, noUm, noDois);
		
		assertFalse(noTres.ehFolha());
		assertTrue(noUm.ehFolha());
		assertTrue(noDois.ehFolha());
	}
	
	@Test
	@DisplayName("No folha - Raiz é folha")	
	void deveRetornarEhNoFolha() {
		No noUm = new No(1, null, null); 
		assertTrue(noUm.ehFolha());
	}

}