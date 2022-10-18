package entidades;

import java.util.ArrayList;

public class Quarto {

	private int numeroQuarto;
	private int alocacaoQuarto;
	private int classificacaoQuarto;
	private String andarQuarto;
	private double diariaQuarto;
	private Funcionario funcionario;


	
	public Quarto (int numeroQuarto, int classificacaoQuarto, String andarQuarto) {
		
		this.numeroQuarto = numeroQuarto;
		this.classificacaoQuarto = classificacaoQuarto;
		this.andarQuarto = andarQuarto;
		
		if (classificacaoQuarto == 1) {
			this.diariaQuarto = 50;
			this.alocacaoQuarto = 1;
		}
		else if (classificacaoQuarto == 2) {
			this.diariaQuarto = 100;
			this.alocacaoQuarto = 2;
		}
		else if (classificacaoQuarto == 3) {
			this.diariaQuarto = 200;
			this.alocacaoQuarto = 4;
		}
		else if (classificacaoQuarto == 4) {
			this.diariaQuarto = 400;
			this.alocacaoQuarto = 10;
		}
		else if (classificacaoQuarto == 5) {
			this.diariaQuarto = 800;
			this.alocacaoQuarto = 4;
		}
		else {
			this.diariaQuarto = 0;
		}
		
	}
	
	
	// getters e setters
	
	public int getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public int getAlocacaoQuarto() {
		return alocacaoQuarto;
	}
	public void setAlocacaoQuarto(int alocacaoQuarto) {
		this.alocacaoQuarto = alocacaoQuarto;
	}
	public String getClassificacaoQuarto() {
		
		String descricaoQuarto = null;
		
		if (this.classificacaoQuarto == 1) {
			descricaoQuarto = "Quarto Solteiro, com apenas uma cama e banheiro, 1 pessoa";
		}
		else if (this.classificacaoQuarto == 2) {
			descricaoQuarto = "Quarto Casal, com uma cama de casal e banheiro, 2 pessoas";
		}
		else if (this.classificacaoQuarto == 3) {
			descricaoQuarto = "Quarto Família, com uma cama de casal e duas de solteiro, 4 pessoas";
		}
		else if (this.classificacaoQuarto == 4) {
			descricaoQuarto = "Quarto Hospedagem, com duas camas de casal, três de solteiro e colchões, \n "
					+ "6 ou mais pessoas";
		}
		else if (this.classificacaoQuarto == 5) {
			descricaoQuarto = "Quarto Deluxe, com cama de casal e duas de solteiro, hidromassagem e etc, \n"
					+ "4 pessoas";
		}
		else {
			descricaoQuarto = "Bug no sistema, chefia";
		}
		
		return descricaoQuarto;
	}
	public void setClassificacaoQuarto(int classificacaoQuarto) {
		this.classificacaoQuarto = classificacaoQuarto;
	}
	public String getAndarQuarto() {
		return andarQuarto;
	}
	public void setAndarQuarto(String andarQuarto) {
		this.andarQuarto = andarQuarto;
	}
	public double getDiariaQuarto() {
		return diariaQuarto;
	}
	public void setDiariaQuarto(double diariaQuarto) {
		this.diariaQuarto = diariaQuarto;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	
	
	// other functions
	
	
	// caso static necessário para pegar quartos fixos
	public static ArrayList<Quarto> getListaQuartos() {
		ArrayList<Quarto> listaQuartos = new ArrayList<Quarto>();
		
		Quarto Quarto101 = new Quarto (101, 1, "1");
		Quarto Quarto102 = new Quarto (102, 1, "1");
		Quarto Quarto103 = new Quarto (103, 1, "1");
		Quarto Quarto104 = new Quarto (104, 1, "1");
		Quarto Quarto105 = new Quarto (105, 1, "1");
		Quarto Quarto106 = new Quarto (106, 1, "1");
		Quarto Quarto107 = new Quarto (107, 1, "1");
		Quarto Quarto108 = new Quarto (108, 1, "1");
		Quarto Quarto109 = new Quarto (109, 1, "1");
		Quarto Quarto110 = new Quarto (110, 1, "1");
		Quarto Quarto201 = new Quarto (201, 2, "2");
		Quarto Quarto202 = new Quarto (202, 2, "2");
		Quarto Quarto203 = new Quarto (203, 2, "2");
		Quarto Quarto204 = new Quarto (204, 2, "2");
		Quarto Quarto205 = new Quarto (205, 2, "2");
		Quarto Quarto206 = new Quarto (206, 2, "2");
		Quarto Quarto207 = new Quarto (207, 2, "2");
		Quarto Quarto208 = new Quarto (208, 2, "2");
		Quarto Quarto209 = new Quarto (209, 2, "2");
		Quarto Quarto210 = new Quarto (210, 2, "2");
		Quarto Quarto301 = new Quarto (301, 3, "3");
		Quarto Quarto302 = new Quarto (302, 3, "3");
		Quarto Quarto303 = new Quarto (303, 3, "3");
		Quarto Quarto304 = new Quarto (304, 3, "3");
		Quarto Quarto305 = new Quarto (305, 3, "3");
		Quarto Quarto306 = new Quarto (306, 3, "3");
		Quarto Quarto307 = new Quarto (307, 3, "3");
		Quarto Quarto308 = new Quarto (308, 3, "3");
		Quarto Quarto309 = new Quarto (309, 3, "3");
		Quarto Quarto310 = new Quarto (310, 3, "3");
		Quarto Quarto401 = new Quarto (401, 4, "4");
		Quarto Quarto402 = new Quarto (402, 4, "4");
		Quarto Quarto403 = new Quarto (403, 4, "4");
		Quarto Quarto404 = new Quarto (404, 4, "4");
		Quarto Quarto405 = new Quarto (405, 4, "4");
		Quarto Quarto406 = new Quarto (406, 4, "4");
		Quarto Quarto407 = new Quarto (407, 4, "4");
		Quarto Quarto408 = new Quarto (408, 4, "4");
		Quarto Quarto409 = new Quarto (409, 4, "4");
		Quarto Quarto410 = new Quarto (410, 4, "4");
		Quarto Quarto501 = new Quarto (501, 5, "5");
		Quarto Quarto502 = new Quarto (502, 5, "5");
		Quarto Quarto503 = new Quarto (503, 5, "5");
		Quarto Quarto504 = new Quarto (504, 5, "5");
		Quarto Quarto505 = new Quarto (505, 5, "5");
		Quarto Quarto506 = new Quarto (506, 5, "5");
		Quarto Quarto507 = new Quarto (507, 5, "5");
		Quarto Quarto508 = new Quarto (508, 5, "5");
		Quarto Quarto509 = new Quarto (509, 5, "5");
		Quarto Quarto510 = new Quarto (510, 5, "5");
		
		listaQuartos.add(Quarto101);
		listaQuartos.add(Quarto102);
		listaQuartos.add(Quarto103);
		listaQuartos.add(Quarto104);
		listaQuartos.add(Quarto105);
		listaQuartos.add(Quarto106);
		listaQuartos.add(Quarto107);
		listaQuartos.add(Quarto108);
		listaQuartos.add(Quarto109);
		listaQuartos.add(Quarto110);
		listaQuartos.add(Quarto201);
		listaQuartos.add(Quarto202);
		listaQuartos.add(Quarto203);
		listaQuartos.add(Quarto204);
		listaQuartos.add(Quarto205);
		listaQuartos.add(Quarto206);
		listaQuartos.add(Quarto207);
		listaQuartos.add(Quarto208);
		listaQuartos.add(Quarto209);
		listaQuartos.add(Quarto210);
		listaQuartos.add(Quarto301);
		listaQuartos.add(Quarto302);
		listaQuartos.add(Quarto303);
		listaQuartos.add(Quarto304);
		listaQuartos.add(Quarto305);
		listaQuartos.add(Quarto306);
		listaQuartos.add(Quarto307);
		listaQuartos.add(Quarto308);
		listaQuartos.add(Quarto309);
		listaQuartos.add(Quarto310);
		listaQuartos.add(Quarto401);
		listaQuartos.add(Quarto402);
		listaQuartos.add(Quarto403);
		listaQuartos.add(Quarto404);
		listaQuartos.add(Quarto405);
		listaQuartos.add(Quarto406);
		listaQuartos.add(Quarto407);
		listaQuartos.add(Quarto408);
		listaQuartos.add(Quarto409);
		listaQuartos.add(Quarto410);
		listaQuartos.add(Quarto501);
		listaQuartos.add(Quarto502);
		listaQuartos.add(Quarto503);
		listaQuartos.add(Quarto504);
		listaQuartos.add(Quarto505);
		listaQuartos.add(Quarto506);
		listaQuartos.add(Quarto507);
		listaQuartos.add(Quarto508);
		listaQuartos.add(Quarto509);
		listaQuartos.add(Quarto510);
		
		return listaQuartos;
	}
	
}
