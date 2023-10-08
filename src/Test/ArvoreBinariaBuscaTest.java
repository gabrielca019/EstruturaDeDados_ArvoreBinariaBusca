package Test;

import static org.junit.Assert.assertThrows;
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

@DisplayName("Testes de ArvoreBinariaBusca")
class ArvoreBinariaBuscaTest {

	private ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
	private ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder();

	@BeforeEach
	void inicializarArvore() {
		arvore = new ArvoreBinariaBusca();
	}

	@Test
	@DisplayName("Está vazia em uma árvore vazia")
	void deveRetornarEhVaziaSemRaiz() {
		assertTrue(arvore.arvoreEstaVazia());
	}

	@Test
	@DisplayName("Não está vazia em uma árvore com raiz")
	void deveRetornarNaoEhVaziaComRaiz() {
		No noUm = new No(1, null, null);
		arvore.setRaiz(noUm);

		assertFalse(arvore.arvoreEstaVazia());
	}

	@Test
	@DisplayName("Quantidade de sub nós de uma árvore vazia")
	void deveRetornarQuantidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.getQuantidadeNos());
	}

	@Test
	@DisplayName("Quantidade de sub nós de uma árvore somente com raiz")
	void deveRetornarQuantidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(1, arvore.getQuantidadeNos());
	}

	@Test
	@DisplayName("Quantidade de sub nós de uma árvore com elementos")
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
	@DisplayName("Altura de uma árvore vazia")
	void deveRetornarAlturaSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.getAlturaDaArvore());
	}

	@Test
	@DisplayName("Altura de uma árvore somente raiz")
	void deveRetornarAlturaSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(0, arvore.getAlturaDaArvore());
	}

	@Test
	@DisplayName("Altura de uma árvore com elementos")
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
	@DisplayName("Altura de um sub nó de uma árvore com elementos")
	void deveRetornarAlturaSubNosComElementos() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		No noTres = arvore.getRaiz().getEsquerdo();

		assertEquals(1, arvore.getAlturaDoNo(noTres));
	}

	@Test
	@DisplayName("Profundidade de um sub nó de uma árvore vazia")
	void deveRetornarProfundidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.getProfundidadeDoNo(noRef));
	}

	@Test
	@DisplayName("Profundidade de uma sub nó de uma árvore somente raiz")
	void deveRetornarProfundidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.getProfundidadeDoNo(noRef));
	}

	@Test
	@DisplayName("Profundidade de sub nós de uma árvore com elementos")
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
	@DisplayName("Retornar null ao pesquisar nó de uma árvore vazia")
	void deveRetornarNullSePegarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertNull(arvore.getNoArvorePorValor(20));
	}

	@Test
	@DisplayName("Retornar null ao pesquisar nó de uma árvore com elementos")
	void deveRetornarNullSePegarNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertNull(arvore.getNoArvorePorValor(20));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertNull(arvore.getNoArvorePorValor(20));
	}

	@Test
	@DisplayName("Retornar notNull ao pesquisar nó de uma árvore somente raiz")
	void deveRetornarNoSePegarRaiz() {
		arvore = builder.montaArvoreSoRaiz();

		No noRetornado = arvore.getNoArvorePorValor(5);

		assertNotNull(noRetornado);
		assertEquals(5, noRetornado.getValor());
	}

	@Test
	@DisplayName("Retornar notNull ao pesquisar nó de uma árvore com elementos")
	void deveRetornarNoSePegarOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();

		No noRetornado = arvore.getNoArvorePorValor(3);

		assertNotNull(noRetornado);
		assertEquals(3, noRetornado.getValor());
	}

	@Test
	@DisplayName("Não contém nó em uma árvore vazia")
	void deveRetornarFalseContemArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertFalse(arvore.contemNoPorValor(20));
	}

	@Test
	@DisplayName("Não contem nó em uma árvore com elementos")
	void deveRetornarFalseContemNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertFalse(arvore.contemNoPorValor(20));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertFalse(arvore.contemNoPorValor(20));
	}

	@Test
	@DisplayName("Contem nó em uma árvore só com a raiz")
	void deveRetornarTrueContemSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertTrue(arvore.contemNoPorValor(5));
	}

	@Test
	@DisplayName("Conter nó em uma árvore com elementos")
	void deveRetornarNoComtemOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertTrue(arvore.contemNoPorValor(3));
		assertTrue(arvore.contemNoPorValor(4));
		assertTrue(arvore.contemNoPorValor(1));
	}
	
	@Test
	@DisplayName("Adicionar nó em uma árvore vazia")
	void deveAdicionarNaRaizQuandoVazia() {
		arvore = builder.montaArvoreVazia();
		
		arvore.adicionarNo(13);
		
		assertEquals(13, arvore.getRaiz().getValor());
	}
	
	@Test
	@DisplayName("Adicionar nó em uma árvore com elementos")
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
	@DisplayName("Throws ao tentar remover nó de uma árvore vazia")
	void deveRemoverQuandoNenhumElemento() {
		arvore = builder.montaArvoreVazia();
		
		assertThrows(IllegalArgumentException.class, () -> arvore.removerNoPorValor(2));
	}
	
	@Test
	@DisplayName("Remover nó da árvore somente com raiz")
	void deveRemoverQuandoUmElemento() {
		arvore = builder.montaArvoreVazia();
		
		arvore.adicionarNo(3);
		
		arvore.removerNoPorValor(3);
		
		assertNull(arvore.getRaiz());
	}
	
	@Test
	@DisplayName("Remover nó da árvore com dois níveis cheios")
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
	@DisplayName("Remover nó da árvore raiz com filho esquerdo e direito")
	void deveRemoverQuandoSomenteRaizDoisFilhos() {
		arvore = builder.montaArvoreVazia();
		
		arvore.adicionarNo(15);
		arvore.adicionarNo(16);
		arvore.adicionarNo(5);
	
		arvore.removerNoPorValor(15);
		
		assertEquals(16, arvore.getRaiz().getValor());
		assertEquals(5, arvore.getRaiz().getEsquerdo().getValor());
	}
	
	@Test
	@DisplayName("Remover nó da árvore com elementos mas somente um filho esquerdo")
	void deveRemoverQuandoSomenteFilhoEsquerdo() {
		arvore = builder.montaArvoreVazia();
		
		arvore.adicionarNo(15);
		arvore.adicionarNo(16);
		arvore.adicionarNo(5);
		arvore.adicionarNo(3);
	
		arvore.removerNoPorValor(5);
		
		assertEquals(15, arvore.getRaiz().getValor());
		assertEquals(3, arvore.getRaiz().getEsquerdo().getValor());
	}
	
	@Test
	@DisplayName("Remover raiz da árvore com elementos")
	void deveRemoverQuandoSomenteFilhoDireito() {
		arvore = builder.montaArvoreVazia();
		
		arvore.adicionarNo(15);
		arvore.adicionarNo(16);
		arvore.adicionarNo(5);
		arvore.adicionarNo(20);
	
		arvore.removerNoPorValor(16);
		
		assertEquals(15, arvore.getRaiz().getValor());
		assertEquals(20, arvore.getRaiz().getDireito().getValor());
	}
	
	@Test
	@DisplayName("Imprimir em POS ORDER árvore com um filho direito e dois esquerdos")
	public void testeImpressaoPosOrdemRaizUmFilhoDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		assertEquals("1 3 7 5 ", arvore.imprimirPosOrdem());
	}
	
	@Test
	@DisplayName("Imprimir em POS ORDER árvore cheio dois niveis")
	public void testeImpressaoPosOrdemCheiaDoisNiveis() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		
		assertEquals("1 4 3 6 8 7 5 ", arvore.imprimirPosOrdem());
	}
	
	@Test
	@DisplayName("Imprimir em IN ORDER árvore com um filho direito e dois esquerdos")
	public void testeImpressaoInOrdemRaizUmFilhoDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		assertEquals("1 3 5 7 ", arvore.imprimirInOrdem());
	}
	
	@Test
	@DisplayName("Imprimir em IN ORDER árvore cheio dois niveis cheios")
	public void testeImpressaoInOrdemCheiaDoisNiveis() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		
		assertEquals("1 3 4 5 6 7 8 ", arvore.imprimirInOrdem());
	}
	
	@Test
	@DisplayName("Imprimir em PRE ORDER árvore com um filho direito e dois esquerdos")
	public void testeImpressaoPreOrdemRaizUmFilhoDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		assertEquals("5 3 1 7 ", arvore.imprimirPreOrdem());
	}
	
	@Test
	@DisplayName("Imprimir em PRE ORDER árvore com dois níveis cheios")
	public void testeImpressaoPreOrdemCheiaDoisNiveis() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		
		assertEquals("5 3 1 4 7 6 8 ", arvore.imprimirPreOrdem());
	}
	
	@Test
	@DisplayName("Throws ao tentar remover todos nós de uma arvore vazia")
	public void testeRemoverTodosNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		
		assertThrows(IllegalArgumentException.class, () -> arvore.removerTodosNos());
	}
	
	@Test
	@DisplayName("Remover todos os nós da árvore que contém apenas a raiz")
	public void testeRemoverTodosNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		
		assertEquals("5 ", arvore.imprimirPreOrdem());
		
		arvore.removerTodosNos();
		
		assertThrows(IllegalArgumentException.class, () -> arvore.removerTodosNos());
	}
}