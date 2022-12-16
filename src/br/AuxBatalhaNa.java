package br;

public class AuxBatalhaNa {
	//Cria e retorna um tabuleiro char vazio
	public static char[][] tabuleiro(int lin, int col) {
		char[][] tabuleiro = new char[lin][col];
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				tabuleiro[i][j]=' ';
			}
		}
		return tabuleiro;
	}
	//Imprime um tabuleiro
	public static void imprimirTabuleiro(char [][] tabuleiro) {
		String linha="---------------------------------------";
		System.out.println( "0  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
		for (int i = 0; i < tabuleiro.length; i++) {
			System.out.println(linha);
			System.out.print(i);
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if(j<9) {
				System.out.print(tabuleiro[i][j]+" | ");}
				else {
				System.out.print(tabuleiro[i][j]+" |");
				}
			}
			System.out.println();
		}
		System.out.println(linha);
	}
	//Recebe o tabuleiro marcado e o vazio, verifica se o jogador acertou e retorna o tabuleiro marcado com X em caso de acerto, ou ~ em caso de erro
	public static char[][] verificandoAcerto(char [][]tabuleiroJogador, char[][] tabuleiroMarcado,byte linha,byte coluna) {
		if(tabuleiroMarcado[linha][coluna]=='X') {
			tabuleiroJogador[linha][coluna]='X';
		}else {
			tabuleiroJogador[linha][coluna]='~';
		}
		return tabuleiroJogador;
	}
	//Preenche a tabela escolhendo um modelo aleatoriamente
	public static char[][] preencimento(int modelo) {
		char [][] tabuleiro = tabuleiro(10, 10);
		switch (modelo) {
		case 0:
			//prenchendo o porta avião
			for (int i = 0; i < 5; i++) {
				tabuleiro[i][3]= 'X';
			}
			//preenchendo navio tanque
			for (int i = 3; i < 7; i++) {
				tabuleiro[8][i]= 'X';
			}
			//preenchendo contratorpedeiro
			for (int i = 6; i < 9; i++) {
				tabuleiro[2][i]= 'X';
			}
			//preenchendo submarino
			for (int i = 5; i < 7; i++) {
				tabuleiro[i][4]= 'X';
			}
			break;
		case 1:
			//prenchendo o porta avião
			for (int i = 0; i < 5; i++) {
				tabuleiro[i][7]= 'X';
			}
			//preenchendo navio tanque
			for (int i = 3; i < 7; i++) {
				tabuleiro[8][i]= 'X';
			}
			//preenchendo contratorpedeiro
			for (int i = 6; i < 9; i++) {
				tabuleiro[6][i]= 'X';
			}
			//preenchendo submarino
			for (int i = 5; i < 7; i++) {
				tabuleiro[i][2]= 'X';
			}
			break;
		case 2:
			//prenchendo o porta avião
			for (int i = 3; i < 8; i++) {
				tabuleiro[5][i]= 'X';
			}
			//preenchendo navio tanque
			for (int i = 5; i < 9; i++) {
				tabuleiro[i][0]= 'X';
			}
			//preenchendo contratorpedeiro
			for (int i = 6; i < 9; i++) {
				tabuleiro[8][i]= 'X';
			}
			//preenchendo submarino
			for (int i = 0; i < 2; i++) {
				tabuleiro[i][8]= 'X';
			}
			break;
		}
		return tabuleiro;
		
	}
	
	//Mostra o ganhador
	public static void ganhador(int acertosJogador1,int acertosJogador2) {
		if (acertosJogador1>acertosJogador2) {
			System.out.println("Jogador 1 Ganhou");
		}else
			System.out.println("Jogador 2 Ganhou");
	}
}
