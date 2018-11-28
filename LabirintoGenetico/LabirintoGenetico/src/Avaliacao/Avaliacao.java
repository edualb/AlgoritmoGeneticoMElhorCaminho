package Avaliacao;

import Cromossomo.Cromossomo;
import Labirinto.PercorrerLabirinto;

public class Avaliacao {
	
	public static void Avaliar(Cromossomo cromossomo) {
		PercorrerLabirinto.PassosLabirinto(cromossomo);
	}
	
}
