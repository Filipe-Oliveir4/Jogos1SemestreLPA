package br;

import java.util.Scanner;

public class AuxQualOperacao {
	//Função pede a o usuário um número e retorna ele ao jogo
	public static double escolhendoNum(int num) {
		Scanner ent = new Scanner(System.in);
		System.out.println("Insira o "+num+"º número");
		double numEscolhido = ent.nextDouble() ;
		return numEscolhido;
	}
	//Essa função mostra na tela as regras do jogo e como deve ser feita a resposta
	public static void explicandoRegras() {
		System.out.println("O objetivo do jogo é adivinhar qual operação aconteceu com dois números.\n"
				+ "A resposta deve ser:\n"
				+ "0 - Subtração\n"
				+ "1 - Adição\n"
				+ "2 - Multiplicação\n"
				+ "3 - Divisão.");
		System.out.println("Observação: A operação ocorreu da seguinte forma:\n"
				+ "1º + | - | / |*  2º.\n");
	}
}
