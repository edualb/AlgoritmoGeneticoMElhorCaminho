package Cromossomo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Avaliacao.Avaliacao;
import Labirinto.GeraLabirinto;


public class Cromossomo {
	
	private int [][] labirinto;
	private List<String> cromossomo = new ArrayList<String>();
	private int avaliacao;
	
	public Cromossomo() {}
	
	public Cromossomo(int [][] labirinto, List<String> cromossomo, int avaliacao) {
		this.setAvaliacao(avaliacao);
		this.setLabirinto(labirinto);
		this.setCromossomo(cromossomo);
	}
	
	public Cromossomo(int[][] labirinto) {
		this.labirinto = this.limpaNosLabirinto(labirinto);
		
		String primeiroGene = completeToLeft(String.valueOf(GeraLabirinto.getInicioX()), '0', 3) + completeToLeft(String.valueOf(GeraLabirinto.getInicioY()), '0', 3);
		cromossomo.add(primeiroGene);
		
		for (int i = 1 ; i < 6 ; i++) {
			cromossomo.add(montaGene(GeraLabirinto.getFimX(), GeraLabirinto.getFimY()));
		}
		
		String ultimoGene = completeToLeft(String.valueOf(GeraLabirinto.getFimX()), '0', 3) + completeToLeft(String.valueOf(GeraLabirinto.getFimY()), '0', 3);
		cromossomo.add(ultimoGene);
		
		Avaliacao.Avaliar(this);

	}
	
	public int[][] getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(int[][] labirinto) {
		this.labirinto = labirinto;
	}

	public List<String> getCromossomo() {
		return cromossomo;
	}

	public void setCromossomo(List<String> cromossomo) {
		this.cromossomo = cromossomo;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String montaGene(int fimX, int fimY) {
		int geraX = getRandomNumberInRange(1, fimX - 1);
		int geraY = getRandomNumberInRange(1, fimY - 1);
		
		do {
			geraX = getRandomNumberInRange(1, fimX - 1);
			geraY = getRandomNumberInRange(1, fimY - 1);
		} while (this.labirinto[geraY][geraX] == 1 
					|| this.labirinto[geraY][geraX] == 5 
					|| geraX == 1
					||geraY == 1);
		
		this.labirinto[geraY][geraX] = 5;
		
		String x = completeToLeft(String.valueOf(geraX), '0', 3);
		String y = completeToLeft(String.valueOf(geraY), '0', 3);

		return x + y;
	}
	
	
	//http://www.guj.com.br/t/inserir-zeros-a-esquerda/70374
	public static String completeToLeft(String value, char c, int size) {
		String result = value;
		while (result.length() < size) {
			result = c + result;
		}
		return result;
	}
	
	//https://www.mkyong.com/java/java-generate-random-integers-in-a-range/
	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	private int[][] limpaNosLabirinto(int[][] labirinto) {
		for (int  linha = 0 ; linha < labirinto.length ; linha++) {
			for (int coluna = 0 ; coluna < labirinto[0].length ; coluna++) {
				if (labirinto[linha][coluna] == 5 || labirinto[linha][coluna] == 2) {
					labirinto[linha][coluna] = 0;
				}
			}
		}
		
		labirinto[1][1] = 7;
		labirinto[10][10] = 5;
		
		return labirinto;
	}

	public void preparaNovoCenario() {
		this.labirinto = this.limpaNosLabirinto(labirinto);
		
		for (int i = 1 ; i < 6 ; i++) {
			int valorX = Integer.parseInt(this.getCromossomo().get(i).substring(0, 3));
			int valorY = Integer.parseInt(this.getCromossomo().get(i).substring(3, 6));
			
			for (int  linha = 0 ; linha < labirinto.length ; linha++) {
				for (int coluna = 0 ; coluna < labirinto[0].length ; coluna++) {
					if (coluna == valorX || linha == valorY) {
						labirinto[linha][coluna] = 5;
					}
				}
			}
		}
		
		Avaliacao.Avaliar(this);
	
	}
}
