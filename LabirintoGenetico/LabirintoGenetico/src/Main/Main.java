package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Avaliacao.Avaliacao;
import Cromossomo.Cromossomo;
import Crossover.Crossover;
import Labirinto.GeraLabirinto;
import Torneio.Torneio;

public class Main {
	
	private static Scanner scanner;
	private static Cromossomo melhorCromossomo = null;
	static int labirinto[][];

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
			
			if (i == 0) {
				for (int j = 0 ; j < populacao ; j++) {
					Cromossomo cromossomo = new Cromossomo(labirinto);
					geracaoLista.add(cromossomo);
				}
			} else {
				geracaoLista.add(melhorCromossomo);
				for (int j = 1 ; j < populacao ; j++) {
					Cromossomo cromossomo = new Cromossomo(labirinto);
					geracaoLista.add(cromossomo);
				}
			}
			
			melhorCromossomo = Avaliacao.buscaMelhorCromossomo(geracaoLista);
			
			List<Cromossomo> listaVencedores = new ArrayList<>();
			
			int quantidadeTorneio = -1;
			
			do {
				quantidadeTorneio = Cromossomo.getRandomNumberInRange(1, populacao);
			}
			while( quantidadeTorneio % 2 != 0 );
			  
			
			for( int torneio = 0; torneio < quantidadeTorneio; torneio++)
			{
				listaVencedores.add(Torneio.torneio(geracaoLista));
			}
			
						
			for (Cromossomo cromossomo : geracaoLista) {
				System.out.println(cromossomo.getCromossomo());
				System.out.println(cromossomo.getAvaliacao());
			}*/
			
			/*System.out.println("******************** GERAÇÃO " + i + " ********************");
			System.out.println(" Cromossomo: " + melhorCromossomo.getCromossomo());
			System.out.println(" avaliacao: " + melhorCromossomo.getAvaliacao());
			System.out.println("***********************************************************");
			System.out.println("");*/
		}
	}

}
