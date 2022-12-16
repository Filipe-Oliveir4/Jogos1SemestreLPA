package br;

import java.util.Random;
import java.util.Scanner;

public class Jogos {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		byte escolha;
		do {
		//Imprime o menu no console	
		System.out.println("Qual Jogo você quer jogar?\n"
				+ "1 - Jogo da Forca\n"
				+ "2 - Batalha Naval\n"
				+ "3 - Jogo da Velha\n"
				+ "4 - Qual a operação?\n"
				+ "0 - Sair");
		//Captura a escolha de jogo do usuário
		escolha=ent.nextByte();
		switch (escolha) {
		case 1: {
			int contErros=0,letrasAcertadas=0;
			String tentativa="", palavra,letrasTentadas="" ;
			System.out.println("Bem vindo ao jogo da Forca.");
			System.out.println("1 - Escolher a palavra "
					+ "\n2 - Palavra aleatória?");		
			//Pede ao usuário para inserir uma palavra, ou retorna uma palavra aleatória
			palavra = AuxJogoForca.palavraAleatoria(ent.nextInt());
			AuxJogoForca.descerInicio();
			//retorna um vetor de de strings "*" do tamanho da palavra. 
			String[] palavraAsterisco = AuxJogoForca.nomeEmAsterisco(palavra);
			//exibe o tamanho da palavra
			System.out.println("A palavra tem "+palavra.length()+" letras");
			do{
				//pergunta ao usuário a letra tentada
				tentativa=AuxJogoForca.tentativa();
				//Verifica se a entrada do usuário está válida
				if(letrasTentadas.contains(tentativa)==false&&tentativa.length()==1) {
					//inseri numa String a letra tentada pra não deixar ser inserida novamente
					letrasTentadas+=tentativa;
					//Verifica se a letra tentada tem na palavra
					if(palavra.contains(tentativa)) {
						//Passa a letra tentada para a função acertou
						AuxJogoForca.acertou(tentativa);
						//Substitui no vetor de String o "*" pela letra tentada
						for (int i = 0; i < palavraAsterisco.length; i++) {
							if(palavra.substring(i,i+1).equals(tentativa)) {
								palavraAsterisco[i]=palavra.substring(i,i+1);
								letrasAcertadas++;
							}
						}
					}else {
						AuxJogoForca.errou(tentativa);
						contErros++;
					}
					AuxJogoForca.imprimirForca(contErros);
					AuxJogoForca.imprimirVetorString(palavraAsterisco);
					AuxJogoForca.descer3();
				}else {
					AuxJogoForca.entradaErrada(tentativa.length());
					AuxJogoForca.descer3();
				}
			//Verifica se o a contagem de erros é menor que o limite e se os acertos são menores que o tamanho da palavra
			}while(contErros<6&&letrasAcertadas<palavra.length());
			//Mostra se o jogador ganhou ou perdeu
			AuxJogoForca.finalDoJogo(contErros, palavra);
			break;
		}
		case 2:{
			byte linha,coluna,acertosJogador1=0,acertosJogador2=0;
			//Cria uma variável para alterar entre o primeiro e segundo 
			boolean jogador1=true;
			Random rd = new Random();
			//Cria duas tabelas vazias
			char[][] tabuleiro1= AuxBatalhaNa.tabuleiro(10, 10);
			char[][] tabuleiro2= AuxBatalhaNa.tabuleiro(10, 10);
			//Cria duas tabelas marcadas
			char[][] tabuleiroMarcado1 = AuxBatalhaNa.preencimento(rd.nextInt(3));
			char[][] tabuleiroMarcado2 = AuxBatalhaNa.preencimento(rd.nextInt(3));
			do {
				//Verifica se é a vez do primeiro jogador
				if (jogador1) {
					//pega a linha do disparo
					System.out.println("Vez do jogador1"
							+ "\nQual a linha do disparo?");
					linha=ent.nextByte();
					//pega a coluna do disparo
					System.out.println("Qual a coluna do disparo");
					coluna=ent.nextByte();
					//Confere na tabela marcada se o jogador acertou e marca no tabuleiro vazio a resposta
					tabuleiro1=AuxBatalhaNa.verificandoAcerto(tabuleiro1, tabuleiroMarcado1, linha, coluna);
					if (tabuleiro1[linha][coluna]=='X') {
						System.out.println("Você acertou!!!");
						acertosJogador1++;
					}else {
						System.out.println("Você errou!!!");
					}
					AuxBatalhaNa.imprimirTabuleiro(tabuleiro1);
					jogador1=false;
				}else {
					//Pega a linha do disparo
					System.out.println("Vez do jogador2"
							+ "\nQual a linha do disparo?");
					linha=ent.nextByte();
					//Pega a colina do disparo
					System.out.println("Qual a coluna do disparo");
					coluna=ent.nextByte();
					//Confere na tabela marcada se o jogador acertou e marca no tabuleiro vazio a resposta
					tabuleiro1=AuxBatalhaNa.verificandoAcerto(tabuleiro2, tabuleiroMarcado2, linha, coluna);
					if (tabuleiro1[linha][coluna]=='X') {
						System.out.println("Você acertou!!!");
						acertosJogador2++;
					}else {
						System.out.println("Você errou!!!");
					}
					AuxBatalhaNa.imprimirTabuleiro(tabuleiro2);
					jogador1=true;
				}
			//verifica se algum dos jogadores acertou todas as embarcações	
			}while(acertosJogador1<14 && acertosJogador2<14);
			AuxBatalhaNa.ganhador(acertosJogador1, acertosJogador2);
			break;
		}
		case 3:{
			AuxJogoDaVelha jogo = new AuxJogoDaVelha();
			String posicao;
			int validacao = 0, Jogadas = 0;
			
			while (true) {//------------------------
				System.out.println("---------- JOGO DA VELHA -------");
				System.out.println("\n");
				jogo.Mostrar();
				
				do {//inicia jogador 1...............................
					System.out.print("Jogador 1, informe uma posição: ");
					posicao = ent.next();
					while(!jogo.Valido(posicao)) {
						System.out.println("Jogada inválida, tente novamente");
						System.out.print("Jogador 1, informe uma posição");
						posicao = ent.next();
						validacao = 0;
					}
					jogo.Jogada(posicao, "X");
					validacao = 1;
					
				}while(validacao == 0);//Fim jogador 1..............................
				
				Jogadas++;
				validacao = 0;
				jogo.Mostrar();
				if(!jogo.Ganhador(Jogadas).equals("null")) {
					break;
				}
				
				do {//inicia jogador 2...............................
					System.out.print("Jogador 2, informe uma posição: ");
					posicao = ent.next();
					while(!jogo.Valido(posicao)) {
						System.out.println("Jogada inválida, tente novamente");
						System.out.print("Jogador 2, informe uma posição");
						posicao = ent.next();
						validacao = 0;
					}
					jogo.Jogada(posicao, "O");
					validacao = 1;
					
				}while(validacao == 0);//Fim jogador 2..............................
				
				Jogadas ++;
				validacao = 0;
				jogo.Mostrar();
				if(!jogo.Ganhador(Jogadas).equals("null")) {
					break;
				}
				
			}//-----------------------------------------------------------------------
			System.out.println("Resultado: "+ jogo.Ganhador(Jogadas));
			break;
		}
		case 4:{
		int escolha1=6,opEscolhida;
		String operacao="";
		double numFinal =0;
		AuxQualOperacao.explicandoRegras();
	    //Pede ao jogador o primeiro número
		double num1 = AuxQualOperacao.escolhendoNum(1);
		//Pede ao jogador o segundo número
		double num2 = AuxQualOperacao.escolhendoNum(2);
		//Cria um número aleatório
		Random rd = new Random();
		int numAleatorio= rd.nextInt(4);
		//Seleciona uma operação aleatoriamente e executa a operação
		switch (numAleatorio) {
		case 0:
			escolha1=0;
			operacao="Subtração";
			numFinal=num1-num2;
			break;
		case 1:
			escolha1=1;
			operacao="Adição";
			numFinal=num1+num2;
			break;
		case 2:
			escolha1=2;
			operacao="Multiplicação";
			numFinal=num1*num2;
			break;
		case 3:
			escolha1=3;
			operacao="Divisão";
			numFinal=num1/num2;
			break;			
		};
		//Exibe o número resultado da operação
		System.out.println("O número é: "+numFinal+" \n"
				+ "Qual operação ocorreu?");
		//Captura a operação-resposta do usuário
		opEscolhida=ent.nextInt();
		//Verifica se o usuário acertou
		if (escolha1==opEscolhida) {
			System.out.println("Parabéns, você acertou!!!");
		}else {
			System.out.println("Você errou. A operação era "+operacao+"!");
		}}
		case 0:
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + escolha);
		}
		} while (escolha!=0);
		System.out.println("Obrigado por jogar!!!");
	}

}
