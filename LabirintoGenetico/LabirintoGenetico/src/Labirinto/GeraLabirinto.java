package Labirinto;

import java.util.Random;
import java.util.Scanner;

/*
 * Individuo = 7,
 * N�s do labirinto = 5
 * Paredes do labirinto = 1
 * armadilha = 2
 */
public class GeraLabirinto {
	
	private static Scanner scanner;
	private static int [][] labirinto = new int[202][202];
	private static int inicioY;
	private static int inicioX;
	private static int fimY;
	private static int fimX;

	public static int[][] getLabirinto() {
		return labirinto;
	}
	
	public static void setLabirinto(int[][] labirinto) {
		GeraLabirinto.labirinto = labirinto;
	}

	public static int getInicioY() {
		return inicioY;
	}

	public static void setInicioY(int inicioY) {
		GeraLabirinto.inicioY = inicioY;
	}

	public static int getInicioX() {
		return inicioX;
	}

	public static void setInicioX(int inicioX) {
		GeraLabirinto.inicioX = inicioX;
	}

	public static int getFimY() {
		return fimY;
	}

	public static void setFimY(int fimY) {
		GeraLabirinto.fimY = fimY;
	}

	public static int getFimX() {
		return fimX;
	}

	public static void setFimX(int fimX) {
		GeraLabirinto.fimX = fimX;
	}

	public static int[][] geraLabirinto() {
		inicioX = 1;
		inicioY = 1;
		scanner = new Scanner(System.in);
		
		System.out.println("Inserira as coordenadas da sa�da x e y: ");
		fimX = scanner.nextInt();
		fimY = scanner.nextInt();
		
		labirinto[1][1] = 7;
		labirinto[fimY][fimX] = 5;
		
		for (int  linha = 0 ; linha < labirinto.length ; linha++) {
			for (int coluna = 0 ; coluna < labirinto[0].length ; coluna++) {
				if (linha == 0 || coluna == 0 || linha == 201 || coluna == 201) {
					labirinto[linha][coluna] = 1;
				} else if (labirinto[linha][coluna] != 5 && labirinto[linha][coluna] != 7) {
					labirinto[linha][coluna] = 0;
				}
			}
		}
		
		for (int i = 0 ; i < 10 ; i++) {
			int geraX = getRandomNumberInRange(0, 201);
			int geraY = getRandomNumberInRange(0, 201);
			
			while (labirinto[geraY][geraX] != 7 && labirinto[geraY][geraX] != 5 && labirinto[geraY][geraX] != 1 && geraX != 1 && geraY != 1) {
				labirinto[geraY][geraX] = 1;
			}
		}
		
		return labirinto;
		
	}
	
	//https://www.mkyong.com/java/java-generate-random-integers-in-a-range/
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
