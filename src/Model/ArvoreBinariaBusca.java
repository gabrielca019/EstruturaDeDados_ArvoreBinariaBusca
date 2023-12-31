package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ArvoreBinariaBusca {

	private static final String OPERACAO_INVALIDA_ARVORE_VAZIA = "Operacao Invalida: arvore vazia";
	private No raiz;

	public ArvoreBinariaBusca() {
		raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public boolean arvoreEstaVazia() {
		return raiz == null;
	}

	public int getQuantidadeNos() {
		return getQuantidadeNosDoSubNo(raiz);
	}

	public int getQuantidadeNosDoSubNo(No noReferencia) {
		if (noReferencia == null)
			return 0;
		else
			return 1 + getQuantidadeNosDoSubNo(noReferencia.getEsquerdo())
					+ getQuantidadeNosDoSubNo(noReferencia.getDireito());
	}

	public int getAlturaDoNo(No noReferencia) {
		if (arvoreEstaVazia())
			return 0;
		else
			return getAlturaDoSubNo(noReferencia) - 1;
	}

	private int getAlturaDoSubNo(No noReferencia) {
		if (noReferencia == null)
			return 0;

		int alturaDireita = getAlturaDoSubNo(noReferencia.getDireito());
		int alturaEsquerda = getAlturaDoSubNo(noReferencia.getEsquerdo());

		return 1 + Math.max(alturaDireita, alturaEsquerda);
	}

	public int getAlturaDaArvore() {
		return getAlturaDoNo(raiz);
	}

	public int getProfundidadeDoNo(No noReferencia) {
		if (arvoreEstaVazia())
			return 0;
		else
			return getProfundidadeDoNoAteRaiz(raiz, noReferencia) - 1;
	}

	private int getProfundidadeDoNoAteRaiz(No noReferencia, No noBuscado) {
		if (noReferencia == null) {
			return 0;
		} else {
			if (noBuscado.getValor() == noReferencia.getValor()) {
				return 1;
			}

			if (noBuscado.getValor() < noReferencia.getValor()) {
				return 1 + getProfundidadeDoNoAteRaiz(noReferencia.getEsquerdo(), noBuscado);
			} else {
				return 1 + getProfundidadeDoNoAteRaiz(noReferencia.getDireito(), noBuscado);
			}
		}
	}

	public No getNoArvorePorValor(int valorBuscado) {
		return buscaValorNoReferenciaSeusDescendentes(valorBuscado, raiz);
	}

	private No buscaValorNoReferenciaSeusDescendentes(int valorBuscado, No noReferencia) {
		if (noReferencia == null)
			return null;

		if (valorBuscado == noReferencia.getValor())
			return noReferencia;

		if (valorBuscado < noReferencia.getValor())
			return buscaValorNoReferenciaSeusDescendentes(valorBuscado, noReferencia.getEsquerdo());
		else
			return buscaValorNoReferenciaSeusDescendentes(valorBuscado, noReferencia.getDireito());
	}

	public boolean contemNoPorValor(int valorBuscado) {
		return buscaValorNoReferenciaSeusDescendentes(valorBuscado, raiz) != null;
	}

	public void adicionarNo(int valorNoAdicionado) {
		if (arvoreEstaVazia())
			this.raiz = new No(valorNoAdicionado, null, null);
		else
			insereNovoNoArvoreRercursivamente(raiz, valorNoAdicionado);
	}

	public void insereNovoNoArvoreRercursivamente(No noReferencia, int valorNoAcionado) {
		if (noReferencia != null) {
			if (valorNoAcionado < noReferencia.getValor()) {
				if (noReferencia.getEsquerdo() == null) {
					No novoNo = new No(valorNoAcionado, null, null);
					noReferencia.setEsquerdo(novoNo);
				} else {
					insereNovoNoArvoreRercursivamente(noReferencia.getEsquerdo(), valorNoAcionado);
				}
			} else {
				if (noReferencia.getDireito() == null) {
					No novoNo = new No(valorNoAcionado, null, null);
					noReferencia.setDireito(novoNo);
				} else {
					insereNovoNoArvoreRercursivamente(noReferencia.getDireito(), valorNoAcionado);
				}
			}
		}
	}

	public void removerNoPorValor(int valorRemovido) {
		if (arvoreEstaVazia())
			throw new IllegalArgumentException(OPERACAO_INVALIDA_ARVORE_VAZIA);
		else
			raiz = removerNoArvoreRecursivamente(raiz, valorRemovido);
	}

	private No removerNoArvoreRecursivamente(No noReferencia, int valorRemovido) {
		if (noReferencia == null)
			return null;

		if (valorRemovido == noReferencia.getValor()) {
			if (noReferencia.ehFolha()) {
				return null;
			} else if (soFilhoDireito(noReferencia)) {
				return noReferencia.getDireito();
			} else if (soFilhoEsquerdo(noReferencia)) {
				return noReferencia.getEsquerdo();
			} else {
				int menorValor = getMenorValor(noReferencia.getDireito());
				noReferencia.setValor(menorValor);
				noReferencia.setDireito(removerNoArvoreRecursivamente(noReferencia.getDireito(), menorValor));
				return noReferencia;
			}
		}

		if (valorRemovido < noReferencia.getValor())
			noReferencia.setEsquerdo(removerNoArvoreRecursivamente(noReferencia.getEsquerdo(), valorRemovido));
		else
			noReferencia.setDireito(removerNoArvoreRecursivamente(noReferencia.getDireito(), valorRemovido));

		return noReferencia;
	}

	private boolean soFilhoDireito(No noReferencia) {
		return ((noReferencia.getDireito() != null) && (noReferencia.getEsquerdo() == null));
	}

	private boolean soFilhoEsquerdo(No noReferencia) {
		return ((noReferencia.getDireito() == null) && (noReferencia.getEsquerdo() != null));
	}

	private int getMenorValor(No noReferencia) {
		if (noReferencia.getEsquerdo() == null)
			return noReferencia.getValor();
		else
			return getMenorValor(noReferencia.getEsquerdo());
	}

	public String imprimirPosOrdem() {
		if (arvoreEstaVazia())
			throw new IllegalArgumentException(OPERACAO_INVALIDA_ARVORE_VAZIA);
		else
			return imprimirPosOrdemRecursividade(this.raiz);
	}

	private String imprimirPosOrdemRecursividade(No noReferencia) {
		String sequenciaImpressao = "";

		if (noReferencia != null) {
			sequenciaImpressao += imprimirPosOrdemRecursividade(noReferencia.getEsquerdo());
			sequenciaImpressao += imprimirPosOrdemRecursividade(noReferencia.getDireito());
			sequenciaImpressao += String.valueOf(noReferencia.getValor()) + " ";
		}

		return sequenciaImpressao;
	}

	public String imprimirInOrdem() {
		if (arvoreEstaVazia())
			throw new IllegalArgumentException(OPERACAO_INVALIDA_ARVORE_VAZIA);
		else
			return imprimirInOrdemRecursividade(this.raiz);
	}

	private String imprimirInOrdemRecursividade(No noReferencia) {
		String sequenciaImpressao = "";

		if (noReferencia != null) {
			sequenciaImpressao += imprimirInOrdemRecursividade(noReferencia.getEsquerdo());
			sequenciaImpressao += String.valueOf(noReferencia.getValor()) + " ";
			sequenciaImpressao += imprimirInOrdemRecursividade(noReferencia.getDireito());
		}

		return sequenciaImpressao;
	}

	public String imprimirPreOrdem() {
		if (arvoreEstaVazia())
			throw new IllegalArgumentException(OPERACAO_INVALIDA_ARVORE_VAZIA);
		else
			return imprimirPreOrdemRecursividade(this.raiz);
	}

	private String imprimirPreOrdemRecursividade(No noReferencia) {
		String sequenciaImpressao = "";

		if (noReferencia != null) {
			sequenciaImpressao += String.valueOf(noReferencia.getValor()) + " ";
			sequenciaImpressao += imprimirPreOrdemRecursividade(noReferencia.getEsquerdo());
			sequenciaImpressao += imprimirPreOrdemRecursividade(noReferencia.getDireito());
		}

		return sequenciaImpressao;
	}

	// Exercicio 8: apagar todos os nos
	public void removerTodosNos() {
		raiz = removerTodosNosRecursivos(raiz);
	}

	// Exercício 8: Recursao do removerAll
	private No removerTodosNosRecursivos(No noReferencia) {
		if (noReferencia != null) {
			removerTodosNosRecursivos(noReferencia.getEsquerdo());
			removerTodosNosRecursivos(noReferencia.getDireito());
		}
		return null;
	}

	// Exercicio 8: ler txt com 2000+ itens e inserir na árvore
	public void gerarCargaDoisMilNos() {
		this.removerTodosNos();

		BufferedReader buffRead = null;
		String linha = "";

		try {
			buffRead = new BufferedReader(new FileReader("DoisMilNos.txt"));

			while ((linha = buffRead.readLine()) != null) {
				if (linha != null) {
					this.adicionarNo(Integer.parseInt(linha));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				buffRead.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}