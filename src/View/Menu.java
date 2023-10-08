package View;

import java.util.Scanner;

import Model.ArvoreBinariaBusca;

public class Menu {

	private int opcaoSelecionada;
	private Scanner leitor;
	private ArvoreBinariaBusca abb;

	public Menu() {
		opcaoSelecionada = 0;
		leitor = new Scanner(System.in);
		abb = new ArvoreBinariaBusca();
	}

	public void inicializarPrograma() {
		do {
			try {
				imprimirMenu();
				pegarOpcaoSelecionada();
				verificarOpcaoSelecionada();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch(Exception e) {
				e.printStackTrace();
			}
		} while (opcaoSelecionada != 9);
	}

	private void imprimirMenu() {
		System.out.println("\n|| MENU ABB ||");
		System.out.println("1 - Inserir novo nó");
		System.out.println("2 - Buscar por nó");
		System.out.println("3 - Excluir nó");
		System.out.println("4 - Altura da árvore");
		System.out.println("5 - Profundidade do nó");
		System.out.println("6 - Subnós da árvore");
		System.out.println("7 - Imprimir árvore");
		System.out.println("8 - Realizar carga inicial de nós");
		System.out.println("9 - Sair\n");
	}

	private void pegarOpcaoSelecionada() {
		System.out.print("Selecione uma opção: ");
		opcaoSelecionada = leitor.nextInt();
	}

	private void verificarOpcaoSelecionada() {
		switch (opcaoSelecionada) {
		case 1:
			opcaoUm();
			break;
		case 2:
			opcaoDois();
			break;
		case 3:
			opcaoTres();
			break;
		case 4:
			opcaoQuatro();
			break;
		case 5:
			opcaoCinco();
			break;
		case 6:
			opcaoSeis();
			break;
		case 7:
			opcaoSete();
			break;
		case 8:
			opcaoOito();
			break;
		case 9:
			opcaoNove();
			break;
		default:
			System.out.println("\n// Selecione uma opção válida\n");
			break;
		}
	}

	private int pegarValorNo() {
		System.out.print("Digite o valor do nó: ");
		return leitor.nextInt();
	}

	private void opcaoUm() {
		abb.adicionarNo(pegarValorNo());
		System.out.println("\nNó adicionado com sucesso!\n");
	}

	private void opcaoDois() {
		int valor = pegarValorNo();
		System.out
				.println("Nó " + valor + (abb.contemNoPorValor(valor) ? "" : " não") + " foi encontrado na árvore!\n");
	}

	private void opcaoTres() {
		int valor = pegarValorNo();

		if (abb.contemNoPorValor(valor)) {
			abb.removerNoPorValor(valor);
			System.out.println("O nó " + valor + " removido com sucesso!\n");
		} else {
			System.out.println("O nó " + valor + " não foi encontrado na árvore!\n");
		}
	}

	private void opcaoQuatro() {
		System.out.println("Altura da árvore: " + abb.getAlturaDaArvore() + "\n");
	}

	private void opcaoCinco() {
		int valor = pegarValorNo();

		if (abb.contemNoPorValor(valor)) {
			System.out.println("O nó de valor " + valor + " possui profundidade "
					+ abb.getProfundidadeDoNo(abb.getNoArvorePorValor(valor)) + "\n");
		} else {
			System.out.println("O nó " + valor + " não foi encontrado na árvore!\n");
		}
	}

	private void opcaoSeis() {
		System.out.println("A árvore possui " + abb.getQuantidadeNosDoSubNo(abb.getRaiz()) + " subnós\n");
	}

	private void opcaoSete() {
		int opcaoImpressao = 0;

		System.out.println("1 - PreOrder");
		System.out.println("2 - InOrder");
		System.out.println("3 - PosOrder");
		System.out.println("4 - Voltar");
		System.out.println("Selecione uma opção de impressão: ");
		opcaoImpressao = leitor.nextInt();

		switch (opcaoImpressao) {
		case 1:
			System.out.println(abb.imprimirPreOrdem());
			break;
		case 2:
			System.out.println(abb.imprimirInOrdem());
			break;
		case 3:
			System.out.println(abb.imprimirPosOrdem());
			break;
		case 4:
			System.out.println("Voltando ...\n");
			break;
		default:
			opcaoSete();
			break;
		}
	}

	private void opcaoOito() {
		abb.gerarCargaDoisMilNos();
		System.out.println("Carga realizada com sucesso!\n");
	}

	private void opcaoNove() {
		System.out.println("Saindo...");
		leitor.close();
	}
}