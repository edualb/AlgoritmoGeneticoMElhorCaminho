package Labirinto;

import Cromossomo.Cromossomo;

public class PercorrerLabirinto {

	static int passos = 0;
	static int[][] labirinto;
	static int individuoX = 0, individuoY = 0;
	public static void PassosLabirinto(Cromossomo cromossomo) {
		
		passos = 0;
		Boolean continua = true;
		labirinto = cromossomo.getLabirinto();
		
		while (continua) {
			
			for (String no : cromossomo.getCromossomo()) {
				
				for (int  linha = 0 ; linha < labirinto.length ; linha++) {
					for (int coluna = 0 ; coluna < labirinto[0].length ; coluna++) {
						if (labirinto[linha][coluna] == 7) {
							individuoX = coluna;
							individuoY = linha;
						}
					}
				}
				
				continua = labirinto[GeraLabirinto.getFimY()][GeraLabirinto.getFimX()] == 7 || labirinto[GeraLabirinto.getFimY()][GeraLabirinto.getFimX()] == 2? false : true;
				
				if (continua) {
					if (!no.equals("001001")) {
						int destinoX = Integer.parseInt(no.substring(0, 3));
						int destinoY = Integer.parseInt(no.substring(3, 6));
						
						while(labirinto[destinoY][destinoX] == 5) {
							if (individuoX < destinoX && labirinto[individuoY][individuoX+1] != 1 && labirinto[individuoY][individuoX+1] != 2) {

								andaParaDireita();
								cromossomo.setLabirinto(labirinto);
								
							} else if (individuoY < destinoY && labirinto[individuoY+1][individuoX] != 1 && labirinto[individuoY+1][individuoX] != 2) {
								
								andaParaBaixo();
								cromossomo.setLabirinto(labirinto);
								
							} else if(individuoX > destinoX && labirinto[individuoY][individuoX-1] != 1 && labirinto[individuoY][individuoX-1] != 2) {
								
								andaParaTras();
								cromossomo.setLabirinto(labirinto);
								
							} else if(individuoY > destinoY && labirinto[individuoY-1][individuoX] != 1 && labirinto[individuoY-1][individuoX] != 2) {
								
								andaParaCima();
								cromossomo.setLabirinto(labirinto);
								
							} else if (individuoX == destinoX && individuoY < destinoY) {
								
								if (labirinto[individuoY][individuoX+1] != 1 && labirinto[individuoY][individuoX+1] != 2) {
									andaParaDireita();
									labirinto[individuoY][individuoX-1] = 2;
								} else {
									andaParaTras();
									labirinto[individuoY][individuoX+1] = 2;
								}

								cromossomo.setLabirinto(labirinto);
								
							} else if (individuoX == destinoX && individuoY > destinoY) {
								
								if (labirinto[individuoY][individuoX-1] != 1 && labirinto[individuoY][individuoX-1] != 2) {
									andaParaTras();
									labirinto[individuoY][individuoX+1] = 2;
								} else {
									andaParaDireita();
									labirinto[individuoY][individuoX-1] = 2;
								}
								
								cromossomo.setLabirinto(labirinto);
								
							} else if (individuoY == destinoY && individuoX < destinoX) {
								
								if (labirinto[individuoY+1][individuoX] != 1 && labirinto[individuoY+1][individuoX] != 2) {
									andaParaBaixo();
									labirinto[individuoY-1][individuoX] = 2;
								} else {
									andaParaCima();
									labirinto[individuoY+1][individuoX] = 2;
								}

								cromossomo.setLabirinto(labirinto);
								
							} else if (individuoY == destinoY && individuoX > destinoX) {
								
								if (labirinto[individuoY-1][individuoX] != 1 && labirinto[individuoY-1][individuoX] != 2) {
									andaParaCima();
									labirinto[individuoY+1][individuoX] = 2;
								} else {
									andaParaBaixo();
									labirinto[individuoY-1][individuoX] = 2;
								}

								cromossomo.setLabirinto(labirinto);
								
							} else if (
									(labirinto[individuoY][individuoX-1] == 1 || labirinto[individuoY][individuoX-1] == 2)
									&& (labirinto[individuoY-1][individuoX] == 1 || labirinto[individuoY-1][individuoX] == 2)
									&& (labirinto[individuoY+1][individuoX] == 1 || labirinto[individuoY+1][individuoX] == 2)){
								
								andaParaDireita();
								labirinto[individuoY][individuoX-1] = 2;
								cromossomo.setLabirinto(labirinto);

							} else if (
									(labirinto[individuoY][individuoX+1] == 1 || labirinto[individuoY][individuoX+1] == 2)
									&& (labirinto[individuoY-1][individuoX] == 1 || labirinto[individuoY-1][individuoX] == 2)
									&& (labirinto[individuoY+1][individuoX] == 1 || labirinto[individuoY+1][individuoX] == 2)){
								
								andaParaTras();
								labirinto[individuoY][individuoX+1] = 2;
								cromossomo.setLabirinto(labirinto);
								
							} else if (
									(labirinto[individuoY][individuoX+1] == 1 || labirinto[individuoY][individuoX+1] == 2)
									&& (labirinto[individuoY-1][individuoX] == 1 || labirinto[individuoY-1][individuoX] == 2)
									&& (labirinto[individuoY][individuoX-1] == 1 || labirinto[individuoY][individuoX-1] == 2)){
								
								andaParaBaixo();
								labirinto[individuoY-1][individuoX] = 2;
								cromossomo.setLabirinto(labirinto);
								
							} else if (
									(labirinto[individuoY][individuoX+1] == 1 || labirinto[individuoY][individuoX+1] == 2)
									&& (labirinto[individuoY+1][individuoX] == 1 || labirinto[individuoY+1][individuoX] == 2)
									&& (labirinto[individuoY][individuoX-1] == 1 || labirinto[individuoY][individuoX-1] == 2)){
								
								andaParaCima();
								labirinto[individuoY+1][individuoX] = 2;
								cromossomo.setLabirinto(labirinto);
								
							} else {
								labirinto = limpaCaminhosPercorridosLabirinto(labirinto);
							}
							
						}
						
					}
					
				}

			}

		}
		cromossomo.setAvaliacao(passos);
		
	}
	
	public static void andaParaDireita() {
		labirinto[individuoY][individuoX] = 0;
		labirinto[individuoY][individuoX+1] = 7;
		
		if (labirinto[individuoY][individuoX+2] == 1 && labirinto[individuoY+1][individuoX+1] == 1) {
			labirinto[individuoY][individuoX] = 7;
			labirinto[individuoY][individuoX+1] = 2;
		} else {
			individuoX += 1;
		}
		passos++;

	}
	
	public static void andaParaBaixo() {
		labirinto[individuoY][individuoX] = 0;
		labirinto[individuoY+1][individuoX] = 7;
		
		if (labirinto[individuoY+2][individuoX] == 1 && labirinto[individuoY+1][individuoX-1] == 1) {
			labirinto[individuoY][individuoX] = 7;
			labirinto[individuoY+1][individuoX] = 2;
		} else {
			individuoY += 1;
		}
		passos++;

	}
	
	public static void andaParaTras() {
		labirinto[individuoY][individuoX] = 0;
		labirinto[individuoY][individuoX-1] = 7;
		
		if (labirinto[individuoY][individuoX-2] == 1 && labirinto[individuoY-1][individuoX-1] == 1) {
			labirinto[individuoY][individuoX] = 7;
			labirinto[individuoY][individuoX-1] = 2;
		} else {
			individuoX -= 1;
		}
		passos++;

	}
	
	public static void andaParaCima() {
		labirinto[individuoY][individuoX] = 0;
		labirinto[individuoY-1][individuoX] = 7;
		
		if (labirinto[individuoY-2][individuoX] == 1 && labirinto[individuoY-1][individuoX+1] == 1) {
			labirinto[individuoY][individuoX] = 7;
			labirinto[individuoY-1][individuoX] = 2;
		} else {
			individuoY -= 1;
		}
		passos++;

	}
	
	private static void imprimeLabirinto(int[][] labirinto) {
		for (int l = 0; l < labirinto.length; l++)  {  
			for (int c = 0; c < labirinto[0].length; c++)     { 
				System.out.print(labirinto[l][c] + " ");
	       	}  
	       	System.out.println(" ");
		}
		System.out.println("                                                                                                 ");
		System.out.println("*************************************************************************************************");
		System.out.println("*************************************************************************************************");
		System.out.println("                                                                                                 ");
	}

	private static int[][] limpaCaminhosPercorridosLabirinto(int[][] labirinto) {
		for (int  linha = 0 ; linha < labirinto.length ; linha++) {
			for (int coluna = 0 ; coluna < labirinto[0].length ; coluna++) {
				if (labirinto[linha][coluna] == 2) {
					labirinto[linha][coluna] = 0;
				}
			}
		}
		
		return labirinto;
	}
}
