package Torneio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Avaliacao.Avaliacao;
import Cromossomo.Cromossomo;

public class Torneio {

	
	private static int geraValorAleatorio(int tamanho) 
	{
		Random valorAleatorio = new Random();
		
		return valorAleatorio.nextInt(tamanho);
	}
	
	public static Cromossomo torneio(List<Cromossomo> lista)
	{
		List<Cromossomo> listaEscolhidos = new ArrayList<>();	
		
		int posicaoCromossomoPrimeiro = -1;
		int posicaoCromossomoSegundo = -1;
		
		if(lista.size() > 0)
		{
			posicaoCromossomoPrimeiro = geraValorAleatorio(lista.size());
			posicaoCromossomoSegundo = geraValorAleatorio(lista.size());

			listaEscolhidos.add(lista.get(posicaoCromossomoPrimeiro));
			listaEscolhidos.add(lista.get(posicaoCromossomoSegundo));
				
		}
				
		return Avaliacao.buscaMelhorCromossomo(listaEscolhidos);
	}
}
