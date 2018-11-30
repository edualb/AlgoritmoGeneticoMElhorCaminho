package Crossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Cromossomo.Cromossomo;

public class Crossover {

	public static void CrossOverDeUmPonto(Cromossomo primeiroCromossomo, Cromossomo segundoCromossomo) {
		Double taxaCrossOver = 0.7;
		Double resultadoCrossOver = (double) (getRandomNumberInRange(0, 100));
		int pontoCrossOver = getRandomNumberInRange(1, 6);
		List<String> cromossomoC1 = new ArrayList<String>();
		List<String> cromossomoC2 = new ArrayList<String>();
		
		if (resultadoCrossOver/100 < taxaCrossOver) {
			for (int i = 0 ; i < pontoCrossOver ; i++) {
				cromossomoC1.add(primeiroCromossomo.getCromossomo().get(i));
				cromossomoC2.add(segundoCromossomo.getCromossomo().get(i));
			}
			
			for (int i = pontoCrossOver ; i < primeiroCromossomo.getCromossomo().size() ; i++) {
				cromossomoC1.add(segundoCromossomo.getCromossomo().get(i));
				cromossomoC2.add(primeiroCromossomo.getCromossomo().get(i));
			}
			
			primeiroCromossomo.setCromossomo(cromossomoC1);
			segundoCromossomo.setCromossomo(cromossomoC2);
			
			primeiroCromossomo.preparaNovoCenario();
			segundoCromossomo.preparaNovoCenario();
		}
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
