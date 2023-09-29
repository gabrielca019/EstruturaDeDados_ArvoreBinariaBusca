package Controller;

import java.util.List;

import Model.ArvoreBinariaBusca;

public class Principal {

	public static void main(String[] args) {
		ArvoreBinariaBusca abb = new ArvoreBinariaBusca();
		
		List<String> Nos = abb.gerarCargaDoisMilNos();
		for(String no : Nos)
			System.out.println(no);
	}

}