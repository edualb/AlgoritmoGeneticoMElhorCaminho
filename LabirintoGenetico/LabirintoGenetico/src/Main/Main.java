package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Avaliacao.Avaliacao;
import Cromossomo.Cromossomo;
import Crossover.Crossover;
import Labirinto.GeraLabirinto;
import Mutacao.Mutacao;
import Torneio.Torneio;

public class Main {
	
	private static Scanner scanner;
	private static Cromossomo melhorCromossomo = null;
	static int labirinto[][];
	static List<Cromossomo> proximaGeracaoLista = new ArrayList<Cromossomo>();

	public static void main(String[] args) {
		labirinto = GeraLabirinto.geraLabirinto();
		scanner = new Scanner(System.in);
		
		System.out.println("*****************Algoritmo Genético*****************");
		System.out.println("**                                                **");
		System.out.println("** Tipo de CrossOver: De ponto;                   **");
		System.out.println("** Taxa de CrossOver: 0,7;                        **");
		System.out.println("** Tipo de mutação: Clássica;                     **");
		System.out.println("** Taxa de mutação: 0,2;                          **");
		System.out.println("** Aptidão: Avaliação;                            **");
		System.out.println("**                                                **");
		System.out.println("** Seleção: - Inicialização aleaória              **");
		System.out.println("**          - Elitismo                            **");
		System.out.println("**          - Torneio                             **");
		System.out.println("**                                                **");
		System.out.println("****************************************************");
		
		System.out.println("Informe o número da população:");
		int populacao = scanner.nextInt();
		
		System.out.println("Informe o número de geração:");
		int geracao = scanner.nextInt();
		
		for(int i = 0 ; i < geracao ; i++) {
			List<Cromossomo> geracaoLista = new ArrayList<Cromossomo>();
			List<Cromossomo> listaTorneio = new ArrayList<Cromossomo>();
			
			if (i == 0) {
				for (int j = 0 ; j < populacao ; j++) {
					Cromossomo cromossomo = new Cromossomo(labirinto);
					geracaoLista.add(cromossomo);
				}
			} else {

				for (Cromossomo cromossomo : proximaGeracaoLista) {
					geracaoLista.add(cromossomo);
				}
				
				int tamanhoNovaGeracao = geracaoLista.size();
				proximaGeracaoLista.clear();

				for (int j = tamanhoNovaGeracao ; j < populacao ; j++) {
					Cromossomo cromossomo = new Cromossomo(labirinto);
					geracaoLista.add(cromossomo);
				}

			}
			
			melhorCromossomo = Avaliacao.buscaMelhorCromossomo(geracaoLista);
			
			System.out.println("**************************** GERAÇÃO " + i + " *****************************");
			System.out.println(" Cromossomo: " + melhorCromossomo.getCromossomo());
			System.out.println(" avaliacao(quantidade de passos): " + melhorCromossomo.getAvaliacao());
			System.out.println("*********************************************************************");
			System.out.println("");
			
			proximaGeracaoLista.add(new Cromossomo(melhorCromossomo.getLabirinto(),
													melhorCromossomo.getCromossomo(),
													melhorCromossomo.getAvaliacao()));
			  
			for( int torneio = 0; torneio < 2; torneio++) {
				listaTorneio.add(Torneio.torneio(geracaoLista));
			}
			
			for (int quantidadeCrossOver = 0 ; quantidadeCrossOver < listaTorneio.size() ; quantidadeCrossOver += 2) {
				Cromossomo primeiroCromossomo = listaTorneio.get(quantidadeCrossOver);
				Cromossomo segundoCromossomo = listaTorneio.get(quantidadeCrossOver+1);
				
				Crossover.CrossOverDeUmPonto(primeiroCromossomo, segundoCromossomo);
				
				Mutacao.mutacaoCromossomo(primeiroCromossomo);
				Mutacao.mutacaoCromossomo(segundoCromossomo);
				
				proximaGeracaoLista.add(primeiroCromossomo);
				proximaGeracaoLista.add(segundoCromossomo);
			}
			
		}
	}

}
