package Controller;

import java.util.List;

import Model.ArvoreBinariaBusca;

public class Principal {

	public static void main(String[] args) {
		ArvoreBinariaBusca abb = new ArvoreBinariaBusca();
		
		List<Integer> Nos = abb.gerarCargaDoisMilNos();
		for(Integer no : Nos)
			System.out.println(no);
	}

}