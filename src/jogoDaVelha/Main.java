package jogoDaVelha;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		String[][] grade = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
		
		String simbolo = "";
		int vez = 0;
		boolean venceu = false;
		boolean empate = false;
		while (!venceu && !empate) {
			
			simbolo = Sistema.checarVez(vez);
			
			System.out.printf("---Vez do jogador %s---\n\n", simbolo);
			System.out.println(Sistema.gradeFormatada(grade));
			
			String opcao = "";
			do {
				System.out.print("Digite a coordenada de sua preferência: ");
				opcao = entrada.nextLine().strip(); 
			} while ((!Sistema.opcaoPresente(grade, opcao))
					 || (opcao.equals("X") || opcao.equals("O")));
			
			Sistema.inserirSimbolo(grade, opcao, simbolo);
			venceu = Sistema.checarVenceu(grade, simbolo);
			empate = Sistema.checarEmpate(grade);
			
			vez++;
		}
		
		System.out.println(Sistema.gradeFormatada(grade));
		System.out.println(empate ? "!O jogo deu Velha!" : "!Jogador " + simbolo + " venceu!");
		
		entrada.close();
	}
}
