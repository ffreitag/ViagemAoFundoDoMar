package com.buscape;
import com.buscape.DirecaoEnum;

/**
 * Classe responsavel para processar os dados recebidos e efetua a movimentacao do submarino
 * @author Fernando Freitag
 * @Since  16/06/2026
 */
public class Submarine {
	// Definicao das variaveis
	static int coordX = 0;
	static int coordY = 0;
	static int coordZ = 0;
	static DirecaoEnum dirSubmarine = DirecaoEnum.NORTE;
	static Character chaComando = 'X';
	
	// Metodo responsavel por fazer a movimentacao do submarino
	public static void movimento(Character chaMovimento) {
		// Se o movimento solicitado for 'R' para girar para a direita
		if (chaMovimento == 'R') {
			switch (dirSubmarine) {
				case NORTE : dirSubmarine = DirecaoEnum.LESTE;
							break;
				case LESTE : dirSubmarine = DirecaoEnum.SUL;
							break;
				case SUL : dirSubmarine = DirecaoEnum.OESTE;
							break;
				case OESTE : dirSubmarine = DirecaoEnum.NORTE;
							break;
			}
		}

		// Se o movimento solicitado for 'L' para girar para a esquerda
		if (chaMovimento == 'L') {
			switch (dirSubmarine) {
				case NORTE : dirSubmarine = DirecaoEnum.OESTE;
							break;
				case OESTE : dirSubmarine = DirecaoEnum.SUL;
							break;
				case SUL : dirSubmarine = DirecaoEnum.LESTE;
							break;
				case LESTE : dirSubmarine = DirecaoEnum.NORTE;
							break;
			}
		}
		
		// Se o movimento solicitado for 'M' para avancar na direcao que o submarino esta
		if (chaMovimento == 'M') {
			switch (dirSubmarine) {
				case NORTE : coordY++;
							break;
				case SUL : coordY--;
							break;
				case LESTE : coordX++;
							break;
				case OESTE : coordX--;
							break;
			}
		}
	}
	
	/*]
	 * Metodo principal
	 * Paramentros: Deverá ser informada uma String que contenha os comandos a serem executados pelo submarimo
	 */
	public static void main(String[] args) {
		String strResultado = "";
		String strComandos = "";
		
		// Verifica se foi preenchido o parametro
		if (args.length  > 0) {
			if (args[0] != null && !args[0].equals("")) {
				// Recupera a String que foi passada no primeiro parametro                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
				strComandos = args[0];
				for(int x = 0; x <= strComandos.length()-1; x++){
					chaComando = strComandos.charAt(x);
					switch (chaComando) {
						case 'U' : coordZ++;
									break;
						case 'D' : coordZ--;
									break;
						case 'L' : movimento('L');
									break;
						case 'R' : movimento('R');
									break;
						case 'M' : movimento('M');
									break;
					}
						
				}
				strResultado = coordX + ", " + coordY + ", " + coordZ + ", " + dirSubmarine.getDescricao();
				System.out.print(strResultado);
			}
		} else {
			System.out.println("**********************************************");
			System.out.println("* Programa Viagem ao Fundo do Mar            *");
			System.out.println("* Versao 0.1 - 16/06/2016                    *");
			System.out.println("* Desenvolvido por Fernando Freitag          *");
			System.out.println("**********************************************");
			System.out.println("* Não foi informado o parametro com os coman-*");
			System.out.println("* dos que o submarino devera executar.       *");
			System.out.println("* Exemplo: RMMLMMMDDLL                       *");
			System.out.println("*                                            *");
			System.out.println("**********************************************");
		}
	}
}
