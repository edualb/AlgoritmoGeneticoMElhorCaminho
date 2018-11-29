package Avaliacao;

import java.util.List;

import Cromossomo.Cromossomo;
import Labirinto.PercorrerLabirinto;

public class Avaliacao {
	
	public static void Avaliar(Cromossomo cromossomo) {
		PercorrerLabirinto.PassosLabirinto(cromossomo);
	}
	
	public static Cromossomo buscaMelhorCromossomo(List<Cromossomo> listaCromossomo) {
		Cromossomo melhorCromossomo = listaCromossomo.get(0);
		
		for (Cromossomo cromossomo : listaCromossomo) {
			if (cromossomo.getAvaliacao() < melhorCromossomo.getAvaliacao()) {
				melhorCromossomo = cromossomo;
			}
		}
		
		return melhorCromossomo;
	}
	
}
