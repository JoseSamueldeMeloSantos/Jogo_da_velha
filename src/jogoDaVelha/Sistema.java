package jogoDaVelha;

public class Sistema {
	
	static String gradeFormatada(String[][] grade) {
		
		String novaGrade = String.format("	%-2s|%-2s|%-2s \n"
							 	   	   + "	--+--+-- \n"
							           + "	%-2s|%-2s|%-2s \n"
							           + "	--+--+-- \n"
							           + "	%-2s|%-2s|%-2s \n"
							           , grade[0][0], grade[0][1], grade[0][2]
							           , grade[1][0], grade[1][1], grade[1][2]
							           , grade[2][0], grade[2][1], grade[2][2]);
		 
		return novaGrade;
	}
	
	
	static String checarVez(int vez) {
		
		if (vez % 2 == 0) {
			return "X";
		} else {
			return "O";
		}
	}
	
	
	static boolean opcaoPresente(String[][] grade, String opcao) {
		
		for (int linha = 0; linha < grade.length; linha++) {
			for (int coluna = 0; coluna < grade[linha].length; coluna++) {
				
				if (opcao.equals(grade[linha][coluna])) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	static void inserirSimbolo(String[][] grade, String opcao, String simbolo) {
		
		for (int linha = 0; linha < grade.length; linha++) {
			for (int coluna = 0; coluna < grade[linha].length; coluna++) {
				
				if (opcao.equals(grade[linha][coluna])) {
					grade[linha][coluna] = simbolo;
				}
			}
		}
	}
	
	
	static boolean checarVenceu(String[][] grade, String simbolo) {
		
		int quantSimbolo = 0;
		//para checar na horizontal
		for (int linha = 0; linha < grade.length; linha++) {
			
			quantSimbolo = 0;
			for (int coluna = 0; coluna < grade[linha].length; coluna++) {
				
				if (grade[linha][coluna].equals(simbolo)) {
					quantSimbolo++;
				}
			}
			
			if(quantSimbolo == 3) {
				return true;
			}
		}
		
		
		//para chegar na vertical
		for (int coluna = 0; coluna < grade.length; coluna++) {
			
			quantSimbolo = 0;
			for (int linha = 0; linha < grade[coluna].length; linha++) {
				
				if (grade[linha][coluna].equals(simbolo)) {
					quantSimbolo++;
				}
			}
			
			if (quantSimbolo == 3) {
				return true;
			}
		}
		
		//para checar a diagonal principal
		quantSimbolo = 0;
		for (int i = 0; i < grade.length; i++) {
			
			if (grade[i][i].equals(simbolo)) {
				quantSimbolo++;
			}
		}
		
		if (quantSimbolo == 3) {
			return true;
		}
		
		
		//para checar a diagonal secundaria
		quantSimbolo = 0;
		int tamanhoMatriz = grade.length;
		for (int linha = 0; linha < tamanhoMatriz; linha++) {
			
			if (grade[linha][tamanhoMatriz - linha - 1].equals(simbolo)) {
				quantSimbolo++;
			}
		}
		
		if (quantSimbolo == 3) {
			return true;
		}
		
		//caso nada seja vedadeiro
		return false;
	}
	
	
	static boolean checarEmpate(String[][] grade) {
		
		int quantNumeros = 0;
		int numeroTeste = 1;
		for (int linha = 0; linha < grade.length; linha++) {
			for (int coluna = 0; coluna < grade[linha].length; coluna++) {
				
				if (grade[linha][coluna].equals("" + numeroTeste)) {
					quantNumeros++;
				}
				
				numeroTeste++;
			}
		}
		
		if (quantNumeros == 0) {
			return true;
		} else {
			return false;
		}
	}
}
