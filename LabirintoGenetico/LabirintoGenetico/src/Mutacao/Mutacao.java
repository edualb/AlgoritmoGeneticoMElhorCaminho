package Mutacao;

import java.util.Random;

import Cromossomo.Cromossomo;
import Labirinto.GeraLabirinto;

public class Mutacao {

	public static void mutacaoCromossomo(Cromossomo cromossomo) {
		Double taxaMutacao = 0.2;
		
		for (int i = 1 ; i < cromossomo.getCromossomo().size()-1 ; i++) {
			Double resultadoMutacao = (double) (getRandomNumberInRange(0, 100));
			if (resultadoMutacao/100 < taxaMutacao) {
				String novoNo = cromossomo.montaGene(GeraLabirinto.getFimX(), GeraLabirinto.getFimY());
				cromossomo.getCromossomo().remove(i);
				cromossomo.getCromossomo().add(i, novoNo);
			}
		}
		
		cromossomo.preparaNovoCenario();

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
