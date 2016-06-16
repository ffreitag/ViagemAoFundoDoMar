package com.buscape;
import com.buscape.DirecaoEnum;

public class Submarine {
	static int coordX = 0;
	static int coordY = 0;
	static int coordZ = 0;
	static DirecaoEnum dirSubmarine = DirecaoEnum.NORTE;
	static Character chaComando = 'X';

	public static void movimento(Character chaMovimento) {
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
	
	public static void main(String[] args) {
		String strResultado = "";
		String strComandos = "";
			
		if (args[0] != null && !args[0].equals("")) {
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
		} else {
			System.out.println("Sem argumentos");
		}
	}
}
