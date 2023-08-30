package Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Controller.ArvoreBinariaBuilder;
import Model.ArvoreBinariaBusca;
import Model.No;

class ArvoreBinariaTest {

	private ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
	private ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder();

	@BeforeEach
	void inicializarArvore() {
		arvore = new ArvoreBinariaBusca();
	}

	@Test
	void deveRetornarEhVaziaSemRaiz() {
		assertTrue(arvore.arvoreEstaVazia());
	}

	@Test
	void deveRetornarNaoEhVaziaComRaiz() {
		No noUm = new No(1, null, null);
		arvore.setRaiz(noUm);

		assertFalse(arvore.arvoreEstaVazia());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.getQuantidadeNos());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(1, arvore.getQuantidadeNos());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		assertEquals(2, arvore.getQuantidadeNos());

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		assertEquals(2, arvore.getQuantidadeNos());

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		assertEquals(3, arvore.getQuantidadeNos());

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		assertEquals(4, arvore.getQuantidadeNos());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		assertEquals(4, arvore.getQuantidadeNos());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		assertEquals(5, arvore.getQuantidadeNos());

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertEquals(7, arvore.getQuantidadeNos());

		assertFalse(arvore.arvoreEstaVazia());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.getAlturaDaArvore());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(0, arvore.getAlturaDaArvore());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		assertEquals(1, arvore.getAlturaDaArvore());

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		assertEquals(1, arvore.getAlturaDaArvore());

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		assertEquals(1, arvore.getAlturaDaArvore());

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		assertEquals(2, arvore.getAlturaDaArvore());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		assertEquals(2, arvore.getAlturaDaArvore());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		assertEquals(2, arvore.getAlturaDaArvore());

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertEquals(2, arvore.getAlturaDaArvore());

		assertFalse(arvore.arvoreEstaVazia());
	}

	@Test
	void deveRetornarAlturaSubNosComElementos() {

		arvore = builder.montaArvoreCheiaDoisNiveis();
		No noTres = arvore.getRaiz().getEsquerdo();

		assertEquals(1, arvore.getAlturaDoNo(noTres));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.getProfundidadeDoNo(noRef));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.getProfundidadeDoNo(noRef));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		No noRef = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.getProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		noRef = arvore.getRaiz().getEsquerdo();
		assertEquals(1, arvore.getProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		noRef = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.getProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		noRef = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.getProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		noRef = arvore.getRaiz().getDireito().getDireito();
		assertEquals(2, arvore.getProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		noRef = arvore.getRaiz().getDireito().getDireito();
		assertEquals(2, arvore.getProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		noRef = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.getProfundidadeDoNo(noRef));

		assertFalse(arvore.arvoreEstaVazia());
	}

	@Test
	void deveRetornarNullSePegarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertNull(arvore.getNoArvorePorValor(20));
	}

	@Test
	void deveRetornarNullSePegarNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertNull(arvore.getNoArvorePorValor(20));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertNull(arvore.getNoArvorePorValor(20));
	}

	@Test
	void deveRetornarNoSePegarRaiz() {
		arvore = builder.montaArvoreSoRaiz();

		No noRetornado = arvore.getNoArvorePorValor(5);

		assertNotNull(noRetornado);
		assertEquals(5, noRetornado.getValor());
	}

	@Test
	void deveRetornarNoSePegarOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();

		No noRetornado = arvore.getNoArvorePorValor(3);

		assertNotNull(noRetornado);
		assertEquals(3, noRetornado.getValor());
	}

	@Test
	void deveRetornarFalseContemArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertFalse(arvore.contem(20));
	}

	@Test
	void deveRetornarFalseContemNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertFalse(arvore.contem(20));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertFalse(arvore.contem(20));
	}

	@Test
	void deveRetornarTrueContemSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertTrue(arvore.contem(5));
	}

	@Test
	void deveRetornarNoComtemOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertTrue(arvore.contem(3));
		assertTrue(arvore.contem(4));
		assertTrue(arvore.contem(1));
	}
	
	@Test
	void deveAdicionarNaRaizQuandoVazia() {
		arvore = builder.montaArvoreVazia();
		
		arvore.adicionarNo(13);
		
		assertEquals(13, arvore.getRaiz().getValor());
	}
	
	@Test
	void deveAdicionarQuandoVariosElementos() {
		arvore = builder.montaArvoreVazia();
		
		arvore.adicionarNo(15);
		arvore.adicionarNo(16);
		arvore.adicionarNo(5);
		arvore.adicionarNo(20);
		arvore.adicionarNo(23);
		
		assertEquals(15, arvore.getRaiz().getValor());
		assertEquals(16, arvore.getRaiz().getDireito().getValor());
		assertEquals(5, arvore.getRaiz().getEsquerdo().getValor());
	}
	
	@Test
	void deveRemoverQuandoVariosElementos() {
		arvore = builder.montaArvoreVazia();
		
		arvore.adicionarNo(15);
		arvore.adicionarNo(16);
		arvore.adicionarNo(5);
		arvore.adicionarNo(20);
		arvore.adicionarNo(23);
		arvore.adicionarNo(12);
		arvore.adicionarNo(3);
		arvore.adicionarNo(18);
		arvore.adicionarNo(10);
		arvore.adicionarNo(6);
		arvore.adicionarNo(7);
	
		arvore.removerNoPorValor(5);
		
		assertEquals(15, arvore.getRaiz().getValor());
		assertEquals(6, arvore.getRaiz().getEsquerdo().getValor());
	}
	
	@Test
	public void testeImpressaoPosOrdemRaizUmFilhoDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		assertEquals("1 3 7 5 ", arvore.imprimirPosOrdem());
	}
	
	@Test
	public void testeImpressaoPosOrdemCheiaDoisNiveis() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		
		assertEquals("1 4 3 6 8 7 5 ", arvore.imprimirPosOrdem());
	}
	
	@Test
	@DisplayName("IN ORDER - RAIZ _ UM DIREITO _ DOIS ESQUERDO")
	public void testeImpressaoInOrdemRaizUmFilhoDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		assertEquals("1 3 5 7 ", arvore.imprimirInOrdem());
	}
	
	@Test
	@DisplayName("IN ORDER - DOIS NIVEIS")
	public void testeImpressaoInOrdemCheiaDoisNiveis() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		
		assertEquals("1 3 4 5 6 7 8 ", arvore.imprimirInOrdem());
	}
	
	@Test
	@DisplayName("PRE ORDER - RAIZ _ UM DIREITO _ DOIS ESQUERDO")
	public void testeImpressaoPreOrdemRaizUmFilhoDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		assertEquals("5 3 1 7 ", arvore.imprimirPreOrdem());
	}
	
	@Test
	@DisplayName("PRE ORDER - DOIS NIVEIS")
	public void testeImpressaoPreOrdemCheiaDoisNiveis() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		
		assertEquals("5 3 1 4 7 6 8 ", arvore.imprimirPreOrdem());
	}
	
}