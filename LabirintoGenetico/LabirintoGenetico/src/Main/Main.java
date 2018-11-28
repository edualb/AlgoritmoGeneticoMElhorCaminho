package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Avaliacao.Avaliacao;
import Cromossomo.Cromossomo;
import Labirinto.GeraLabirinto;

public class Main {
	
	private static Scanner scanner;
	private static Cromossomo melhorCromossomo = null;
	static int labirinto[][];

	public static void main(String[] args) {
		labirinto = GeraLabirinto.geraLabirinto();
		scanner = new Scanner(System.in);
		
		System.out.println("*****************Algoritmo Gen�tico*****************");
		System.out.println("**                                                **");
		System.out.println("** Tipo de CrossOver: De ponto;                   **");
		System.out.println("** Taxa de CrossOver: 0,7;                        **");
		System.out.println("** Tipo de muta��o: Cl�ssica;                     **");
		System.out.println("** Taxa de muta��o: 0,2;                          **");
		System.out.println("** Aptid�o: Avalia��o;                            **");
		System.out.println("**                                                **");
		System.out.println("** Sele��o: - Inicializa��o alea�ria              **");
		System.out.println("**          - Elitismo                            **");
		System.out.println("**          - Torneio                             **");
		System.out.println("**                                                **");
		System.out.println("****************************************************");
		
		System.out.println("Informe o n�mero da popula��o:");
		int populacao = scanner.nextInt();
		
		System.out.println("Informe o n�mero de gera��o:");
		int geracao = scanner.nextInt();
		
		for(int i = 0 ; i < geracao ; i++) {
			List<Cromossomo> geracaoLista = new ArrayList<Cromossomo>();
			for (int j = 0 ; j < populacao ; j++) {
				Cromossomo cromossomo = new Cromossomo(labirinto);
				//imprimeLabirinto(cromossomo.getLabirinto());
				//Avaliacao.Avaliar(cromossomo);
				geracaoLista.add(cromossomo);
				/*view.setCromossomo(cromossomo);
				view.calculaCromossomo();
				melhorAvalicao = cromossomo.getAvaliacao();
				geracaoLista.add(cromossomo);*/
			}
			
			for (Cromossomo cromossomo : geracaoLista) {
				System.out.println(cromossomo.getCromossomo());
				System.out.println(cromossomo.getAvaliacao());
				//System.out.println(cromossomo.getAvaliacao());
				//imprimeLabirinto(cromossomo.getLabirinto());
			}

			/*for (Cromossomo cromossomo : geracaoLista) {
				/*if (cromossomo.getAvaliacao() < melhorAvalicao) {
					melhorCromossomo = cromossomo;
				}*/
			//}
			
			/*view.setCromossomo(melhorCromossomo);
			view.calculaCromossomo();*/
			
			//System.out.println("******************** GERA��O " + i + " ********************");
			/*System.out.println(" Cromossomo: " + melhorCromossomo.getCromossomo());
			System.out.println(" avaliacao: " + melhorCromossomo.getAvaliacao());*/
			System.out.println("***********************************************************");
			System.out.println("");
		}
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

}
