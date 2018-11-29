package Torneio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Avaliacao.Avaliacao;
import Cromossomo.Cromossomo;

public class Torneio {

	public static Cromossomo torneio(List<Cromossomo> lista)
	{
		List<Cromossomo> listaEscolhidos = new ArrayList<>();	
		
		int posicaoCromossomoPrimeiro = -1;
		int posicaoCromossomoSegundo = -1;
		
		if(lista.size() > 0)
		{
			posicaoCromossomoPrimeiro = Cromossomo.getRandomNumberInRange(0, lista.size()-1);
			posicaoCromossomoSegundo = Cromossomo.getRandomNumberInRange(0, lista.size()-1);

			listaEscolhidos.add(lista.get(posicaoCromossomoPrimeiro));
			listaEscolhidos.add(lista.get(posicaoCromossomoSegundo));
				
		}
				
		return Avaliacao.buscaMelhorCromossomo(listaEscolhidos);
	}
}
