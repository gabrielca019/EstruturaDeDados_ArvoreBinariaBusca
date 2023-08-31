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

@DisplayName("Teste unitários da classe ArvoreBinariaBusca")
class ArvoreBinariaTest {

	private ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
	private ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder();

	@BeforeEach
	void inicializarArvore() {
		arvore = new ArvoreBinariaBusca();
	}

	@Test
	@DisplayName("Arvore vazia")
	void deveRetornarEhVaziaSemRaiz() {
		assertTrue(arvore.arvoreEstaVazia());
	}

	@Test
	@DisplayName("Arvore possui raiz")
	void deveRetornarNaoEhVaziaComRaiz() {
		No noUm = new No(1, null, null);
		arvore.setRaiz(noUm);

		assertFalse(arvore.arvoreEstaVazia());
	}

	@Test
	@DisplayName("Quantidade de sub nós - arvore vazia")
	void deveRetornarQuantidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.getQuantidadeNos());
	}

	@Test
	@DisplayName("Quantidade de sub nós - arvore só raiz")
	void deveRetornarQuantidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(1, arvore.getQuantidadeNos());
	}

	@Test
	@DisplayName("Quantidade de sub nós - arvore com elementos")
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
	@DisplayName("Altura da arvore - arvore vazia")
	void deveRetornarAlturaSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.getAlturaDaArvore());
	}

	@Test
	@DisplayName("Altura da arvore - arvore só raiz")
	void deveRetornarAlturaSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(0, arvore.getAlturaDaArvore());
	}

	@Test
	@DisplayName("Altura da arvore - arvore com elementos")
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
	@DisplayName("Altura sub nós - arvore com elementos")
	void deveRetornarAlturaSubNosComElementos() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		No noTres = arvore.getRaiz().getEsquerdo();

		assertEquals(1, arvore.getAlturaDoNo(noTres));
	}

	@Test
	@DisplayName("Profundidade sub nós - arvore vazia")
	void deveRetornarProfundidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.getProfundidadeDoNo(noRef));
	}

	@Test
	@DisplayName("Profundidade sub nós - arvore só raiz")
	void deveRetornarProfundidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.getProfundidadeDoNo(noRef));
	}

	@Test
	@DisplayName("Profundidade sub nós - arvore com elementos")
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
	@DisplayName("Get valor do nó - arvore vazia")
	void deveRetornarNullSePegarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertNull(arvore.getNoArvorePorValor(20));
	}

	@Test
	@DisplayName("Get valor do nó - valor inexistente na arvore")
	void deveRetornarNullSePegarNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertNull(arvore.getNoArvorePorValor(20));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertNull(arvore.getNoArvorePorValor(20));
	}

	@Test
	@DisplayName("Get valor do nó - arvore só raiz e valor existente")
	void deveRetornarNoSePegarRaiz() {
		arvore = builder.montaArvoreSoRaiz();

		No noRetornado = arvore.getNoArvorePorValor(5);

		assertNotNull(noRetornado);
		assertEquals(5, noRetornado.getValor());
	}

	@Test
	@DisplayName("Get valor do nó - arvore com elementos e valor existente")
	void deveRetornarNoSePegarOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();

		No noRetornado = arvore.getNoArvorePorValor(3);

		assertNotNull(noRetornado);
		assertEquals(3, noRetornado.getValor());
	}

	@Test
	@DisplayName("Contem nó - arvore vazia")
	void deveRetornarFalseContemArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertFalse(arvore.contem(20));
	}

	@Test
	@DisplayName("Contem nó - arvore com elementos e no inexistente")
	void deveRetornarFalseContemNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertFalse(arvore.contem(20));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertFalse(arvore.contem(20));
	}

	@Test
	@DisplayName("Contem nó - arvore só raiz e valor existente")
	void deveRetornarTrueContemSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertTrue(arvore.contem(5));
	}

	@Test
	@DisplayName("Contem nó - arvore com elementos e valores existentes")
	void deveRetornarNoComtemOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertTrue(arvore.contem(3));
		assertTrue(arvore.contem(4));
		assertTrue(arvore.contem(1));
	}
	
	@Test
	@DisplayName("Adicionar nó - arvore vazia")
	void deveAdicionarNaRaizQuandoVazia() {
		arvore = builder.montaArvoreVazia();
		
		arvore.adicionarNo(13);
		
		assertEquals(13, arvore.getRaiz().getValor());
	}
	
	@Test
	@DisplayName("Adicionar nó - arvore com elementos")
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
	@DisplayName("Remover nó - arvore com elementos")
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
	@DisplayName("Imprimir - Pos ordem - um filho direito dois esquerdos")
	public void testeImpressaoPosOrdemRaizUmFilhoDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		assertEquals("1 3 7 5 ", arvore.imprimirPosOrdem());
	}
	
	@Test
	@DisplayName("Imprimir - Pos ordem - cheio dois niveis")
	public void testeImpressaoPosOrdemCheiaDoisNiveis() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		
		assertEquals("1 4 3 6 8 7 5 ", arvore.imprimirPosOrdem());
	}
	
	@Test
	@DisplayName("Imprimir - In ordem - um filho direito dois esquerdos")
	public void testeImpressaoInOrdemRaizUmFilhoDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		assertEquals("1 3 5 7 ", arvore.imprimirInOrdem());
	}
	
	@Test
	@DisplayName("Imprimir - In order - cheio dois niveis")
	public void testeImpressaoInOrdemCheiaDoisNiveis() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		
		assertEquals("1 3 4 5 6 7 8 ", arvore.imprimirInOrdem());
	}
	
	@Test
	@DisplayName("Imprimir - Pre ordem - um filho direito dois esquerdos")
	public void testeImpressaoPreOrdemRaizUmFilhoDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		assertEquals("5 3 1 7 ", arvore.imprimirPreOrdem());
	}
	
	@Test
	@DisplayName("Imprimir - Pre ordem - cheio dois niveis")
	public void testeImpressaoPreOrdemCheiaDoisNiveis() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		
		assertEquals("5 3 1 4 7 6 8 ", arvore.imprimirPreOrdem());
	}
	
}