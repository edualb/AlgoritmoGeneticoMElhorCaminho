package Torneio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Avaliacao.Avaliacao;
import Cromossomo.Cromossomo;

public class Torneio {

	public static Cromossomo torneio(List<Cromossomo> lista)
	{
		List<Cromossomo> listaEscolhidos = new ArrayList<Cromossomo>();	
		
		int posicaoCromossomoPrimeiro;
		int posicaoCromossomoSegundo;
		
		if(!lista.isEmpty())
		{
			posicaoCromossomoPrimeiro = Cromossomo.getRandomNumberInRange(0, lista.size() - 1);
			posicaoCromossomoSegundo = Cromossomo.getRandomNumberInRange(0, lista.size() - 1);
			
			while(lista.get(posicaoCromossomoPrimeiro) == lista.get(posicaoCromossomoSegundo)) {
				posicaoCromossomoPrimeiro = Cromossomo.getRandomNumberInRange(0, lista.size() - 1);
				posicaoCromossomoSegundo = Cromossomo.getRandomNumberInRange(0, lista.size() - 1);
			}
			
			listaEscolhidos.add(lista.get(posicaoCromossomoPrimeiro));
			listaEscolhidos.add(lista.get(posicaoCromossomoSegundo));
				
		}
				
		return Avaliacao.buscaMelhorCromossomo(listaEscolhidos);
	}
}
