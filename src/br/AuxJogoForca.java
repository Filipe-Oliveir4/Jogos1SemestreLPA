package br;

import java.util.Random;
import java.util.Scanner;

public class AuxJogoForca {
	static Scanner ent = new Scanner(System.in);
	//Essa função faz a impressão dos bonecos de acordo com a quantidade de erros
	public static void imprimirForca(int numErros) {
		String[] linhaDaForca= new String[7];
		linhaDaForca[0] = "|---|\n"
				+ "| \n"
				+ "| \n"
				+ "| \n"
				+ "-------" ;
		linhaDaForca[1]="|---|\n"
				+ "|   0\n"
				+ "| \n"
				+ "| \n"
				+ "-------";
		linhaDaForca[2]="|---|\n"
				+ "|   0\n"
				+ "|   |\n"
				+ "|  \n"
				+ "-------";
		linhaDaForca[3]="|---|\n"
				+ "|   0\n"
				+ "|  <|\n"
				+ "|  \n"
				+ "-------";
		linhaDaForca[4]="|---|\n"
				+ "|   0\n"
				+ "|  <|>\n"
				+ "|  \n"
				+ "-------";
		linhaDaForca[5]="|---|\n"
				+ "|   0\n"
				+ "|  <|>\n"
				+ "|  / \n"
				+ "-------";
		linhaDaForca[6]="|---|\n"
				+ "|   0\n"
				+ "|  <|>\n"
				+ "|  / \\\n"
				+ "-------";
		System.out.println(linhaDaForca[numErros]);

	}
	//Essa função retorna um vetor de Strings preenchido com "*", que serão subsstituidos pelas letras acertadas
	public static String[] nomeEmAsterisco(String nome) {
		String []nomeAsterisco=new String[nome.length()];
		for (int i = 0; i < nome.length(); i++) {
			if(nome.substring(i,i+1).equals(" ")) {
				nomeAsterisco[i]=" ";
			}else {
				nomeAsterisco[i]="*";
			}
		}
		return nomeAsterisco;
	}
	//Função simples para imprimir uma string
	public static void imprimirString(String nome) {
		System.out.println(nome);
	}
	//Função para descer o console várias linhas
	public static void descerInicio() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	//Função para imprimir um vetor de String
	public static void imprimirVetorString(String[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i]);
		}
		System.out.println();
	}
	//Função para descer 3 linhas no console
	public static void descer3() {
		System.out.println("\n\n");
	}
	//Imprime na tela uma mensagem casa a palavra contenha a letra
	public static void acertou(String tentativa) {
		System.out.println("A palavra tem "+tentativa);
	}
	//Imprime na tela uma mensagem caso a palavra não contenha a letra
	public static void errou(String tentativa) {
		System.out.println("A palavra não tem "+tentativa);
	}
	//Imprime mensagem de erro caso a pessoa insira a entradada com mais de uma letra, ou uma letra já tentada
	public static void entradaErrada(int tamanho) {
		if(tamanho>1) {
			System.out.println("A tentativa tem mais de uma letra");
		}else
			System.out.println("Essa letra já foi tentada");
	}
	//Solicita ao usuário uma tentativa de letra
	public static String tentativa() {
		Scanner ent = new Scanner(System.in);
		System.out.println("Qual letra você quer tentar?");
		String tentativa=ent.next().toLowerCase();
		return tentativa;
	}
	//Mostra se o usuário ganhou o jogo ou não
	public static void finalDoJogo(int erros,String palavra) {
		if(erros<6) {
			System.out.println("PARABÉNS, VOCÊ GANHOU O JOGO");
		}else {
			System.out.println("Infelizmente você perdeu, a palavra era: "+palavra);
		}			
	}
	//Solicita ao usuário uma palavra e retorna a palavra, ou retorna uma palavra aleatória
	public static String palavraAleatoria(int escolha) {
		String palavra = "";
		switch (escolha) {
		case 1:
			System.out.println("Informe uma palavra.\n"
					+ "OBS: A palavra não pode ser composta. Escreva a palavra sem acento.");
			palavra = ent.next();
			break;

		case 2:
			String []palavraAleatoria= {
					"manteiga","brasil","hexa","copa","computador"
					,"gliter","rojao","loja","hidratado","ventilador",
					"roupa","camisa","sandalia","perfume","bermuda",
					"funcionario","chefe","lixo","capacete","moto",
			};
			Random rd = new Random();
			palavra=palavraAleatoria[rd.nextInt(palavraAleatoria.length-1)];
			break;
		default:
			System.out.println("Tente novamente, digitando 1 ou 2");
			break;
		}

		return palavra.toLowerCase();
	}
	
}
